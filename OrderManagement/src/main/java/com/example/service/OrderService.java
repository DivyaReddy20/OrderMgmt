package com.example.service;

import com.example.entity.CustomerInfo;

public interface OrderService {
	public CustomerInfo updateCustomerInfo(CustomerInfo customer);
	public boolean getCustomerInfo(Integer customerId);
	public CustomerInfo displayOneInfo(Integer customerId);
}
