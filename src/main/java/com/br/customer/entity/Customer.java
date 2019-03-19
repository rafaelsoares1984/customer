package com.br.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Rafael Soares
 *
 */

@Entity
@Table(name="CUSTOMER" )
public class Customer implements Serializable{

	 /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6881361879850639471L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private Long id;
	
	@NotNull 
	@Column(name="NAME",nullable=false) 
	private String name;
	
	@NotNull 
	@Column(name="AGE",nullable=false) 
	private Integer age;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"name\":\"" + name + "\", \"age\":" + age + "}";
	}

	public Customer() {
	}
	
	public Customer(Long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

}
