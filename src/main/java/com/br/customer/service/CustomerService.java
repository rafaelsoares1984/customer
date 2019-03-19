package com.br.customer.service;

import java.util.List;

import com.br.customer.entity.Customer;
import com.br.customer.entity.CustomerAttributes;

/**
 * @author Rafael Soares
 *
 */

public interface CustomerService {

	void updateCustomer(Customer customer);

	void deleteCustomer(Long customereId);

	Customer getCustomer(Long customereId);

	CustomerAttributes saveCustomer(Customer customer);

	List<Customer> retrieveCustomers();

}
