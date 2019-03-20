package com.br.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.customer.entity.Attribute;

@Repository
public interface CustomerAttributeRepository extends JpaRepository<Attribute,Long> {


}


