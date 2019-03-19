package com.br.customer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAditional implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2777203311869274017L;
	
	private int id;
	private int client_id;
	private String status;
	private Attributes data;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the client_id
	 */
	public int getClient_id() {
		return client_id;
	}
	
	/**
	 * @param client_id the client_id to set
	 */
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the data
	 */
	public Attributes getData() {
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(Attributes data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerAditional [id=" + id + ", client_id=" + client_id + ", status=" + status + ", data=" + data
				+ "]";
	} 
	
}