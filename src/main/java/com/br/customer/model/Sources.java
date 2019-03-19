package com.br.customer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sources  implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7194478407337816429L;
	
	private String title;
	private String slug;
	private String url;
	private int crawl_rate;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}
	
	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the crawl_rate
	 */
	public int getCrawl_rate() {
		return crawl_rate;
	}
	
	/**
	 * @param crawl_rate the crawl_rate to set
	 */
	public void setCrawl_rate(int crawl_rate) {
		this.crawl_rate = crawl_rate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sources [title=" + title + ", slug=" + slug + ", url=" + url + ", crawl_rate=" + crawl_rate + "]";
	}
	

}
