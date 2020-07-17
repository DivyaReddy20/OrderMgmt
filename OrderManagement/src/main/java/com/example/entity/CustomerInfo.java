package com.example.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Customer_data")
public class CustomerInfo implements Serializable {
	
	@Id
	private Integer customerId;
	@Column(length=20)
	private String customerName;
	@Column(length=10)
	private long phoneNo;
	@Column(length=20)
	private String streetAddress;
	@Column(length=10)
	private String city;
	@Column(length=10)
	private String zipCode;
	@Column(length=10)
	private String country;
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "orderId")
	private OrderInfo order;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

	
	public CustomerInfo(Integer customerId, String customerName, long phoneNo, String streetAddress, String city,
			String zipCode, String country, OrderInfo order) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.streetAddress = streetAddress;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.order = order;
	}
	
	public String customerInfo() {
		return " [customerId=" + customerId + ", customerName=" + customerName + ", phoneNo=" + phoneNo
				+ ", streetAddress=" + streetAddress + ", city=" + city + ", zipCode=" + zipCode + ", country="
				+ country + ", order=" + order + "]";
	}
	public  CustomerInfo(){
		
	}
}