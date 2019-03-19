package com.br.customer.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="CUSTOMER_ATTRIBUTES")
public class CustomerAttributes  implements Serializable {

	 /**
	 *  Serial Version UID 
	 */
	private static final long serialVersionUID = -2811065891911104579L;

	@Id
	 @GeneratedValue(strategy= GenerationType.SEQUENCE)
	 @Column(name = "CUSTOMER_ATTRIBUTE_ID")
	 private Long id;
     
	 @OneToOne(cascade = { CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval = true) 
     @JoinColumn(name = "CUSTOMER_ID") 
	 private Customer customer;
	 
	 @Column(name="IP") 

	 private String ip;
	 @Column(name="TEMPERATURE_MAX")
	
	 private Long tempMax;
	 
	 @Column(name="TEMPERATURE_MIN")
	 private Long tempMin;
	
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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the tempMax
	 */
	public Long getTempMax() {
		return tempMax;
	}

	/**
	 * @param tempMax the tempMax to set
	 */
	public void setTempMax(Long tempMax) {
		this.tempMax = tempMax;
	}

	/**
	 * @return the tempMin
	 */
	public Long getTempMin() {
		return tempMin;
	}

	/**
	 * @param tempMin the tempMin to set
	 */
	public void setTempMin(Long tempMin) {
		this.tempMin = tempMin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerAttributes [id=" + id + ", customer=" + customer + ", ip=" + ip + ", tempMax=" + tempMax
				+ ", tempMin=" + tempMin + "]";
	}

	public CustomerAttributes() {
	}
	
	public CustomerAttributes(Long id, Customer customer, String ip, Long tempMax, Long tempMin) {
		super();
		this.id = id;
		this.customer = customer;
		this.ip = ip;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
	}
	
}