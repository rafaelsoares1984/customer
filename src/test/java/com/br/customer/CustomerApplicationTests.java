package com.br.customer;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.customer.controller.CustomerRestController;
import com.br.customer.entity.Customer;
import com.br.customer.repository.CustomerRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureWebMvc
public class  CustomerApplicationTests {

    @LocalServerPort
	 int randomServerPort;

	@Autowired
	private TestRestTemplate restTemplate;   
	

	//long id = customerService.n;

	@InjectMocks
	private CustomerRestController customerController;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
    @Test
    public void testAddCustomerSuccess() throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/";
        URI uri = new URI(baseUrl);
       
        Customer customer = new Customer(null, "testJuit",99);
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);     
 
        HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
          
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }    
    
    @Test
    public void testAddCustomeWithCustomerNullFailure() throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/";
        URI uri = new URI(baseUrl);
        Customer customer = new Customer();
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);     
 
        HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        Assert.assertEquals(500, result.getStatusCodeValue());
        
    }
    
    @Test
    public void testListCustomerSuccess () throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/";
        URI uri = new URI(baseUrl);
         
        ResponseEntity<String> result = this.restTemplate.getForEntity(uri, String.class);
       
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("testJuit"));
    }

    @Test
    public void testListCustomerWithIDStringFailure () throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/dfsdfsd";
        URI uri = new URI(baseUrl);
         
        ResponseEntity<String> result = this.restTemplate.getForEntity(uri, String.class);
        
        //Verify request succeed
        Assert.assertEquals(400, result.getStatusCodeValue());
    }

    @Test
    public void testListCustomerWithIDZeroFailure () throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/0";
        URI uri = new URI(baseUrl);
         
        ResponseEntity<String> result = this.restTemplate.getForEntity(uri, String.class);
        
        //Verify request succeed
        Assert.assertEquals(500, result.getStatusCodeValue());
    }
    
    @Test
    public void testListCustomerWithIDSuccess () throws URISyntaxException
    {

    	final Customer customerId =  customerRepository.findByCustomerId("testJuit","99");
    	
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/"+customerId.getId();
        URI uri = new URI(baseUrl);
        
        ResponseEntity<String> result = this.restTemplate.getForEntity(uri, String.class);
         
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("testJuit"));
    }
    
    @Test
    public void testUpdateCustomerSuccess() throws Exception {
    	
    	final Customer customerId =  customerRepository.findByCustomerId("testJuit","99");
    	
	    final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/"+customerId.getId();
	    URI uri = new URI(baseUrl);
    	
		Customer customer = new Customer(2l, "testJuit", 55);
		HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer);
		 
		// execute
		ResponseEntity<Void> responseEntity = restTemplate.exchange(uri, 
		HttpMethod.PUT, 
		  requestEntity, 
		  Void.class);
		 
		// verify
		int status = responseEntity.getStatusCodeValue();
		assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
    }
    
    @Test
    public void testUpdateCustomerFailure() throws Exception {

	      final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/0";
	      URI uri = new URI(baseUrl);
  	
		  Customer customer = new Customer(0l, "testJuit", 99);
		  HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer);
		 
		  // execute
		  ResponseEntity<Void> responseEntity = restTemplate.exchange(uri, 
		  HttpMethod.PUT, 
		  requestEntity, 
		  Void.class);
		 
		  // verify
		  int status = responseEntity.getStatusCodeValue();
		  assertEquals("Incorrect Response Status", HttpStatus.INTERNAL_SERVER_ERROR.value(), status);
  }

  @Test
  public void testZDeleteCustomerSuccess() throws Exception {
		
	  	final Customer customerId =  customerRepository.findByCustomerId("testJuit","55");
	  
	    final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/"+customerId.getId();
	    URI uri = new URI(baseUrl);
    	
		HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customerId);
		 
		// execute
		ResponseEntity<Void> responseEntity = restTemplate.exchange(uri, 
		HttpMethod.DELETE, 
		  requestEntity, 
		  Void.class);
		 
		  // verify
		int status = responseEntity.getStatusCodeValue();
		assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
    }
    
    @Test
    public void testZDeleteCustomerFailure() throws Exception {

	      final String baseUrl = "http://localhost:"+randomServerPort+"/api/customer/0";
	      URI uri = new URI(baseUrl);
  	
		  Customer customer = new Customer();
		  HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer);
		 
		  // execute
		  ResponseEntity<Void> responseEntity = restTemplate.exchange(uri, 
		  HttpMethod.DELETE, 
		  requestEntity, 
		  Void.class);
		 
		  // verify
		  int status = responseEntity.getStatusCodeValue();
		  assertEquals("Incorrect Response Status", HttpStatus.INTERNAL_SERVER_ERROR.value(), status);
  }
    
}
