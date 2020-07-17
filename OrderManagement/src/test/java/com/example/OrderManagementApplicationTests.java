package com.example;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.entity.CustomerInfo;

@SpringBootTest
public class OrderManagementApplicationTests {

  @Test
	public void updateInfoTest() throws URISyntaxException //test case for update Customer Info --success
	{
	RestTemplate restTemplate = new RestTemplate();
    
	final String baseUrl = "http://localhost:8091/customer/update";
	URI uri = new URI(baseUrl);
	 CustomerInfo book = new CustomerInfo();
	    book.setCustomerName("Sony");
	    book.setCity("Banglore");
	    book.setCountry("India");
	    book.setPhoneNo(8998676689l);
	    book.setStreetAddress("strt-2");
	    book.setZipCode("901232");
	    book.setCustomerId(67);
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-COM-PERSIST", "true");      
	    HttpEntity<CustomerInfo> request = new HttpEntity<>(book, headers);
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertNotNull(book);
	}
	
	

	@Test
	public void updateInfoTest1() throws URISyntaxException //test case for update Customer Info-- fail 
	{
	RestTemplate restTemplate = new RestTemplate();
	final String baseUrl = "http://localhost:8091/customer/update";
	URI uri = new URI(baseUrl);
	 CustomerInfo book = new CustomerInfo();
	    book.setCustomerName("Sony");
	    book.setCity("Banglore");
	    book.setCountry("India");
	    book.setPhoneNo(8998676689l);
	    book.setStreetAddress("strt-2");
	    book.setZipCode("901232");
	    book.setCustomerId(67);
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-COM-PERSIST", "true");      
	    HttpEntity<CustomerInfo> request = new HttpEntity<>(book, headers);  
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	    Assert.assertEquals(302, result.getStatusCodeValue());
	    Assert.assertNotNull(book);
	}
	
	
	
	
}
