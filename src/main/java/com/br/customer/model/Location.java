package com.br.customer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable  {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7502193434617773382L;
	
	private Long id;
	private String weather_state_name;
	private String weather_state_abbr;
	private String wind_direction_compass;
	private String created;
	private String applicable_date;
	private Long min_temp;
	private Long max_temp;
	private Long the_temp;
	private Long wind_speed;
	private Long wind_direction;
	private Long air_pressure;
	private int humidity;
	private Long visibility;
	private int predictability;
	
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
	 * @return the weather_state_name
	 */
	public String getWeather_state_name() {
		return weather_state_name;
	}
	
	/**
	 * @param weather_state_name the weather_state_name to set
	 */
	public void setWeather_state_name(String weather_state_name) {
		this.weather_state_name = weather_state_name;
	}
	
	/**
	 * @return the weather_state_abbr
	 */
	public String getWeather_state_abbr() {
		return weather_state_abbr;
	}
	
	/**
	 * @param weather_state_abbr the weather_state_abbr to set
	 */
	public void setWeather_state_abbr(String weather_state_abbr) {
		this.weather_state_abbr = weather_state_abbr;
	}
	
	/**
	 * @return the wind_direction_compass
	 */
	public String getWind_direction_compass() {
		return wind_direction_compass;
	}
	
	/**
	 * @param wind_direction_compass the wind_direction_compass to set
	 */
	public void setWind_direction_compass(String wind_direction_compass) {
		this.wind_direction_compass = wind_direction_compass;
	}
	
	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}
	
	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	
	/**
	 * @return the applicable_date
	 */
	public String getApplicable_date() {
		return applicable_date;
	}
	
	/**
	 * @param applicable_date the applicable_date to set
	 */
	public void setApplicable_date(String applicable_date) {
		this.applicable_date = applicable_date;
	}
	
	/**
	 * @return the min_temp
	 */
	public Long getMin_temp() {
		return min_temp;
	}
	
	/**
	 * @param min_temp the min_temp to set
	 */
	public void setMin_temp(Long min_temp) {
		this.min_temp = min_temp;
	}
	
	/**
	 * @return the max_temp
	 */
	public Long getMax_temp() {
		return max_temp;
	}
	
	/**
	 * @param max_temp the max_temp to set
	 */
	public void setMax_temp(Long max_temp) {
		this.max_temp = max_temp;
	}
	
	/**
	 * @return the the_temp
	 */
	public Long getThe_temp() {
		return the_temp;
	}
	
	/**
	 * @param the_temp the the_temp to set
	 */
	public void setThe_temp(Long the_temp) {
		this.the_temp = the_temp;
	}
	
	/**
	 * @return the wind_speed
	 */
	public Long getWind_speed() {
		return wind_speed;
	}
	
	/**
	 * @param wind_speed the wind_speed to set
	 */
	public void setWind_speed(Long wind_speed) {
		this.wind_speed = wind_speed;
	}
	
	/**
	 * @return the wind_direction
	 */
	public Long getWind_direction() {
		return wind_direction;
	}
	
	/**
	 * @param wind_direction the wind_direction to set
	 */
	public void setWind_direction(Long wind_direction) {
		this.wind_direction = wind_direction;
	}
	
	/**
	 * @return the air_pressure
	 */
	public Long getAir_pressure() {
		return air_pressure;
	}
	
	/**
	 * @param air_pressure the air_pressure to set
	 */
	public void setAir_pressure(Long air_pressure) {
		this.air_pressure = air_pressure;
	}
	
	/**
	 * @return the humidity
	 */
	public int getHumidity() {
		return humidity;
	}
	
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	/**
	 * @return the visibility
	 */
	public Long getVisibility() {
		return visibility;
	}
	
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Long visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the predictability
	 */
	public int getPredictability() {
		return predictability;
	}

	/**
	 * @param predictability the predictability to set
	 */
	public void setPredictability(int predictability) {
		this.predictability = predictability;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [id=" + id + ", weather_state_name=" + weather_state_name + ", weather_state_abbr="
				+ weather_state_abbr + ", wind_direction_compass=" + wind_direction_compass + ", created=" + created
				+ ", applicable_date=" + applicable_date + ", min_temp=" + min_temp + ", max_temp=" + max_temp
				+ ", the_temp=" + the_temp + ", wind_speed=" + wind_speed + ", wind_direction=" + wind_direction
				+ ", air_pressure=" + air_pressure + ", humidity=" + humidity + ", visibility=" + visibility
				+ ", predictability=" + predictability + "]";
	}

	
}