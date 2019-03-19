package com.br.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.customer.entity.Customer;

/**
 * @author Rafael Soares
 *
 */
@Repository
public interface CustomerRepository   extends JpaRepository<Customer,Long> {

    @Query(value="SELECT * FROM CUSTOMER C WHERE c.NAME = ?1 AND C.AGE = ?2",nativeQuery=true)
    Customer findByCustomerId(String name, String age);
	
}
