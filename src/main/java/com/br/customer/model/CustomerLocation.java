package com.br.customer.model;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerLocation implements Serializable {


	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 5253777423723912606L;
	
	private Location[] consolidated_weather;
	private String time;
	private String sun_rise;
	private String sun_set;
	private String timezone_name;
	private Parent parent;
	private Sources[] sources;
	private String title;
	private String location_type;
	private int woeid;
	private String latt_long;
	private String timezone;
	
	/**
	 * @return the consolidated_weather
	 */
	public Location[] getConsolidated_weather() {
		return consolidated_weather;
	}
	
	/**
	 * @param consolidated_weather the consolidated_weather to set
	 */
	public void setConsolidated_weather(Location[] consolidated_weather) {
		this.consolidated_weather = consolidated_weather;
	}
	
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * @return the sun_rise
	 */
	public String getSun_rise() {
		return sun_rise;
	}

	/**
	 * @param sun_rise the sun_rise to set
	 */
	public void setSun_rise(String sun_rise) {
		this.sun_rise = sun_rise;
	}
	
	/**
	 * @return the sun_set
	 */
	public String getSun_set() {
		return sun_set;
	}
	
	/**
	 * @param sun_set the sun_set to set
	 */
	public void setSun_set(String sun_set) {
		this.sun_set = sun_set;
	}
	
	/**
	 * @return the timezone_name
	 */
	public String getTimezone_name() {
		return timezone_name;
	}
	
	/**
	 * @param timezone_name the timezone_name to set
	 */
	public void setTimezone_name(String timezone_name) {
		this.timezone_name = timezone_name;
	}
	
	/**
	 * @return the parent
	 */
	public Parent getParent() {
		return parent;
	}
	
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	/**
	 * @return the sources
	 */
	public Sources[] getSources() {
		return sources;
	}
	
	/**
	 * @param sources the sources to set
	 */
	public void setSources(Sources[] sources) {
		this.sources = sources;
	}
	
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
	 * @return the location_type
	 */
	public String getLocation_type() {
		return location_type;
	}
	
	/**
	 * @param location_type the location_type to set
	 */
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	
	/**
	 * @return the woeid
	 */
	public int getWoeid() {
		return woeid;
	}
	
	/**
	 * @param woeid the woeid to set
	 */
	public void setWoeid(int woeid) {
		this.woeid = woeid;
	}
	
	/**
	 * @return the latt_long
	 */
	public String getLatt_long() {
		return latt_long;
	}
	
	/**
	 * @param latt_long the latt_long to set
	 */
	public void setLatt_long(String latt_long) {
		this.latt_long = latt_long;
	}
	
	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}
	
	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerLocation [consolidated_weather=" + Arrays.toString(consolidated_weather) + ", time=" + time
				+ ", sun_rise=" + sun_rise + ", sun_set=" + sun_set + ", timezone_name=" + timezone_name + ", parent="
				+ parent + ", sources=" + Arrays.toString(sources) + ", title=" + title + ", location_type="
				+ location_type + ", woeid=" + woeid + ", latt_long=" + latt_long + ", timezone=" + timezone + "]";
	}	
}
