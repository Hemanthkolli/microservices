package com.ecm.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {
	@Autowired
	LoginServiceImpl loginsServicesImpl;
	@Autowired
	CRMService crmService;
	@Autowired
	DeviceServiceImpl deviceImpl;
	@Autowired
	AddDeviceACSServiceImpl addDeviceAcs;
	@Autowired
	DevicesGroupServiceImpl devicesGroup; 
	@Autowired
	UserServiceImpl userServiceImpl;
	
	
	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public LoginServiceImpl getLoginsServicesImpl() {
		return loginsServicesImpl;
	}

	public CRMService getCrmService() {
		return crmService;
	}

	public void setCrmService(CRMService crmService) {
		this.crmService = crmService;
	}

	public void setLoginsServicesImpl(LoginServiceImpl loginsServicesImpl) {
		this.loginsServicesImpl = loginsServicesImpl;
	}

	public DeviceServiceImpl getDeviceImpl() {
		return deviceImpl;
	}

	public void setDeviceImpl(DeviceServiceImpl deviceImpl) {
		this.deviceImpl = deviceImpl;
	}
	
	public DevicesGroupServiceImpl getDevicesGroup() {
		return devicesGroup;
	}

	public void setDevicesGroup(DevicesGroupServiceImpl devicesGroup) {
		this.devicesGroup = devicesGroup;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addCustomer(@RequestBody Customer customer) {
		System.out.println("....");
		return getLoginsServicesImpl().register(customer);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {

		String email = user.getUserName();
		String password = user.getPassword();
		System.out.println("login method");
		return getUserServiceImpl().validateUser(email, password);
	}

	@RequestMapping(value = "/addDeviceCrm", method = RequestMethod.POST)
	public String addDeviceDetails(@RequestBody CustomerRelationshipMgmt crmgmt) throws Exception {

		return getCrmService().addCRMDeviceDetails(crmgmt);
	}

	@RequestMapping(value = "/devicesCRM", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,List<CustomerRelationshipMgmt>> searchDevices(@RequestBody CustomerRelationshipMgmt crmgmt)
			throws Exception {
		String invoiceNumber = crmgmt.getInvoiceNumber();
		String ecmLicenseKey = crmgmt.getEcmLicenseKey();
		String serialNum =crmgmt.getSerial();
		return getCrmService().getDevicesList(invoiceNumber, ecmLicenseKey,serialNum);
	} 

	@RequestMapping(value = "/registerDevices", method = RequestMethod.POST)
	public String addDevices(@RequestBody Device device) throws Exception {

		return getDeviceImpl().addDevice(device);
	}
	@RequestMapping(value = "/registerDevicesACS", method = RequestMethod.POST)
	public void addDevicesACS(@RequestBody String devices) throws Exception {

		addDeviceAcs.addDeviceACS(devices);
	}
	
	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	public  Map<String,List<Device>> getDevicesEcm() throws Exception {

		return getDeviceImpl().getAllDevices();
	}
	
	@RequestMapping(value = "/addGroup", method = RequestMethod.POST)
	public String addGroupDeviceDetails(@RequestBody DevicesGroup device) throws Exception {
		return getDevicesGroup().addGroupDevices(device);

	}

	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	public Map<String, List<DevicesGroup>> getGroupsDeviceDetails() throws Exception {
		return getDevicesGroup().getAllGroupsDevices();

	} 
}
