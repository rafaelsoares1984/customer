package com.br.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.customer.entity.Customer;
import com.br.customer.entity.Attribute;
import com.br.customer.repository.CustomerAttributeRepository;
import com.br.customer.repository.CustomerRepository;
import com.br.customer.service.CustomerAttributeService;
import com.br.customer.service.CustomerService;
import com.br.customer.util.AtritbuteUtil;

/**
 * @author Rafael Soares
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService,CustomerAttributeService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAttributeRepository customerAttributeRepository;
	
	private AtritbuteUtil attributesUtil = new AtritbuteUtil();
	
	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer); 
		
	}
	
	public void deleteCustomer(Long customereId) {
		Customer Customer = this.getCustomer(customereId);
		List<Attribute> custAttribRepository = customerAttributeRepository.findAll();
		for (Attribute custAttrib: custAttribRepository) {
			if( custAttrib.getCustomer().equals(Customer)){
				customerAttributeRepository.deleteById(custAttrib.getId());
				break;
			}
		}		
	}
	
	public Customer getCustomer(Long customereId) {
		Optional<Customer> optCust = customerRepository.findById(customereId);
		return optCust.get();
	}
	
	public Attribute saveCustomer(Customer customer,String ip) {
		customerRepository.save(customer);
		Attribute customerAttributes =  this.saveCustomerAttributes(attributesUtil.AdtionalInfo(customer,ip));
		
		return customerAttributes;
		
	}

	public List<Customer> retrieveCustomers() {
		List <Customer> customers = customerRepository.findAll();
		return customers;
	}
	
	public Long findCustomerId(String name,String age) {
		Customer customer = customerRepository.findByCustomerId(name,age);
		return customer.getId();
	}
	
	public Attribute saveCustomerAttributes(Attribute customer) {
		Attribute result = null;
		if (!customer.equals(null)) {
			result = customerAttributeRepository.save(customer);
		}
		return result;
	}

}