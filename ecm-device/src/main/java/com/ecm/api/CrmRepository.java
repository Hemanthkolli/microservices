package com.ecm.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CrmRepository extends CrudRepository<CustomerRelationshipMgmt, String> {

	List<CustomerRelationshipMgmt> findAllByInvoiceNumberAndEcmLicenseKey(String invoiceNumber, String ecmLicenseKey);

	List<CustomerRelationshipMgmt> findAllBySerialAndEcmLicenseKey(String serial, String ecmLicenseKey);

	CustomerRelationshipMgmt findBySerial(String Serial);

}
