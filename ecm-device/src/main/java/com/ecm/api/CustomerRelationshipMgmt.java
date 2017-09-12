package com.ecm.api;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CRM")
public class CustomerRelationshipMgmt {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="serial", unique=true)
	private String serial;
	private String routerKey;
	private String invoiceNumber;
	private String ecmLicenseKey;
    private String deviceModelNumber;
	private String oui;
	private Date ledDate;;
	private String licenseExpiryDate;
	private String productClass;
	
	public String getRouterKey() {
		return routerKey;
	}
	public void setRouterKey(String routerKey) {
		this.routerKey = routerKey;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getEcmLicenseKey() {
		return ecmLicenseKey;
	}
	public void setEcmLicenseKey(String ecmLicenseKey) {
		this.ecmLicenseKey = ecmLicenseKey;
	}
	
	public String getDeviceModelNumber() {
		return deviceModelNumber;
	}
	public void setDeviceModelNumber(String deviceModelNumber) {
		this.deviceModelNumber = deviceModelNumber;
	}
	public Date getLedDate() {
		return ledDate;
	}
	public void setLedDate(Date ledDate) {
		this.ledDate = ledDate;
	}
	public String getLicenseExpiryDate() {
		return licenseExpiryDate;
	}
	public void setLicenseExpiryDate(String licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getOui() {
		return oui;
	}
	public void setOui(String oui) {
		this.oui = oui;
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	
	
}
