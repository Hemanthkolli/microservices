package com.ecm.api;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CRMService {
	private CustomerRelationshipMgmt crm =null;
	@Autowired
	CrmRepository crmRepository;
	
	public String addCRMDeviceDetails(CustomerRelationshipMgmt crmdd)throws Exception {

		    crm = new CustomerRelationshipMgmt();
		    
		    crm.setDeviceModelNumber(crmdd.getDeviceModelNumber());
		    crm.setOui(crmdd.getOui());
		    crm.setSerial(crmdd.getSerial());
		     crm.setProductClass(crmdd.getProductClass());
		    crm.setEcmLicenseKey(crmdd.getEcmLicenseKey());
		    crm.setInvoiceNumber(crmdd.getInvoiceNumber());
		    crm.setRouterKey(crmdd.getRouterKey());
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		   crm.setLedDate(sdf.parse(crmdd.getLicenseExpiryDate()));
		    
		    crmRepository.save(crm);
	
		System.out.println("saved data sucessfully");
		return "device added successfully";
	}
	
	
	Map<String,List<CustomerRelationshipMgmt>> getDevicesList(String invoiceNumber, String ecmLicenseKey, String serial){
		Map<String,List<CustomerRelationshipMgmt>> map=new HashMap<>();
		if(serial!=null){
			List<CustomerRelationshipMgmt> serialNum=crmRepository.findAllBySerialAndEcmLicenseKey(serial, ecmLicenseKey);
			map.put("Devices",serialNum);
			return  map;

		}else {
			List<CustomerRelationshipMgmt> invoiceNum=crmRepository.findAllByInvoiceNumberAndEcmLicenseKey(invoiceNumber, ecmLicenseKey);
			map.put("Devices",invoiceNum);
			return  map;

		}
	
}
}
