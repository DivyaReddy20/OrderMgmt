package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.OrderDao;
import com.example.entity.CustomerInfo;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderDao dao;
	
	@Override
	public CustomerInfo updateCustomerInfo(CustomerInfo customer) {
		  return dao.save(customer);
	}
	
	@Override
	public boolean getCustomerInfo(Integer customerId) {
		 return dao.exists(customerId);
			
	}
	@Override
	public CustomerInfo displayOneInfo(Integer customerId) {
		CustomerInfo list= dao.findOne(customerId);
		return list;
	}

	
}
