package com.br.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.customer.entity.Customer;
import com.br.customer.entity.CustomerAttributes;
import com.br.customer.exception.NotFoundException;
import com.br.customer.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

/**
 * @author Rafael Soares
 *
 */

@RestController
@Api(value = "Customer")
public class CustomerRestController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
	
	@Autowired(required=true)
	 private final CustomerService customerService;
	
	CustomerRestController(CustomerService customerService){
		this.customerService = customerService;
	}
	
	
	 @ApiOperation(value = "Get list of all customers")
	 @ApiResponses({
	        @ApiResponse(code = 201, response = Customer.class, message = "List"),
	        @ApiResponse(code = 404, message = "There is no customer", response = ApiResponse.class)})
	 @GetMapping("/api/customer")
	 public List<Customer> getCustomers() {
		 logger.info("Call api /api/customer method GET");
		 List<Customer> customers = customerService.retrieveCustomers();
		 logger.info("Customer : "+ customers);
		 return customers;
	 }
	 
	@ApiOperation(value = "Get the customer by id")
	@ApiResponses({
	        @ApiResponse(code = 200, response = Customer.class, message = "List"),
	        @ApiResponse(code = 400, message = "Customer id invalid", response = ApiResponse.class),
	        @ApiResponse(code = 404, message = "Customer not found", response = ApiResponse.class)})
	@GetMapping("/api/customer/{customerId}")
	public Customer getCustomer(@PathVariable(name="customerId") Long customereId)  throws Exception{
		logger.info("Call api /api/customer/"+customereId+") method GET");
		Customer customer = customerService.getCustomer(customereId);
		
		if (!customer.equals(null)) {
			return customerService.getCustomer(customereId);
		}else {
			throw new NotFoundException(com.br.customer.model.ApiResponse.ERROR, "Customer " + customereId + " not found");
		}
	 }
	 
	 @ApiOperation(value = "Add Customer")
	@ApiResponses({
        @ApiResponse(code = 201, response = CustomerAttributes.class, message = "Customer")})
	 @PostMapping("/api/customer")
	 @ResponseHeader(responseContainer=MediaType.APPLICATION_JSON_VALUE)
	 public CustomerAttributes saveCustomer(@RequestBody Customer customer){
		 logger.info("Call api /api/customer/ body("+customer.toString()+") method POST");
		 return customerService.saveCustomer(customer);
	 }
	 
	 @ApiOperation(value = "Delete Customer by id")
	 @DeleteMapping("/api/customer/{customerId}")
	 public void deleteCustomer(@PathVariable(name="customerId")Long customereId){
		  customerService.deleteCustomer(customereId);
		  logger.info("Customer deleted with customerId="+customereId+" method DELETE");
	 } 
	 
	 @ApiOperation(value = "Update Customer by id")
	 @ApiResponses({
	        @ApiResponse(code = 200, response = Customer.class, message = "Customer"),
	        @ApiResponse(code = 404, message = "Customer not found", response = ApiResponse.class)})
	 @PutMapping("/api/customer/{customerId}")
	 public void updateCustomer(@RequestBody Customer customer,
	   @PathVariable(name="customerId")Long customereId){
		 Customer cus = customerService.getCustomer(customereId);
	  if(cus != null){
		  logger.info("Call api /api/customer/"+customereId+" body("+customer.toString()+") method PUT");
		  cus.setAge(customer.getAge());
		  cus.setName(customer.getName());
		  customerService.updateCustomer(cus);
	  }
	  logger.info("Customer updated with customerId="+customereId+" method PUT");
	 }
	 
}