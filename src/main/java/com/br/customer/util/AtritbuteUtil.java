package com.br.customer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.br.customer.entity.Customer;
import com.br.customer.entity.Attribute;
import com.br.customer.model.Climate;
import com.br.customer.model.CustomerAttribute;
import com.br.customer.model.CustomerLocation;
import com.br.customer.model.Location;

public class AtritbuteUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(AtritbuteUtil.class);
	
	private final String GEOLOCALIZATION = "https://ipvigilante.com/%s";
	private final String CLIMATE = "https://www.metaweather.com/api/location/search/?lattlong=%s,%s";
	private final String LOCATION = "https://www.metaweather.com/api/location/%s/";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	public Attribute  AdtionalInfo(Customer customer,String ip) {
		 
		 Attribute adtional = new Attribute(null, null, null, null, null);
		 String geoLocale = null;
		 if (ip.equals("127.0.0.1")) {
			 ip = getIP();
		 }
		try { 
			geoLocale = String.format(GEOLOCALIZATION,ip);
			adtional.setCustomer(customer);			
			adtional.setIp(ip);
			logger.info("Call URL="+geoLocale+" method GET");
			CustomerAttribute aditionalInfo = restTemplate.getForObject(geoLocale, CustomerAttribute.class);
			if (!aditionalInfo.equals(null)) { 
				String Lat = aditionalInfo.getData().getLatitude();
			 	String Log = aditionalInfo.getData().getLongitude();
			 	Location location = Climate(Log,Lat);
			 	adtional.setTempMax(location.getMax_temp());	
			 	adtional.setTempMin(location.getMin_temp());
			}
		}catch (HttpClientErrorException e) {
			logger.error(String.format("URL=%s - %s", geoLocale ,e.getMessage()));
		}
		return adtional;
	        
	}
	
	public Location Climate (String log,String lat) {
		logger.info("Call URL="+String.format(CLIMATE,lat,log)+" method GET");
		Climate[] climates = restTemplate.getForObject(String.format(CLIMATE,lat,log), Climate[].class);
		Climate climate =  climates[0];
		logger.info("Call URL="+String.format(LOCATION,climate.getWoeid())+" method GET");
		CustomerLocation locations = restTemplate.getForObject(String.format(LOCATION,climate.getWoeid()), CustomerLocation.class);
		
		Location location =  locations.getConsolidated_weather()[0];	 
		return location;
		 
	}
	
	public String getIP() {
    	String urlString = "http://checkip.dyndns.com/";
    	String newData = null;
		try{
    		URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Request-Method",    "GET");
			con.setDoInput(true);
			con.setDoOutput(false);
			logger.info("Call URL="+urlString+" method GET");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			newData =  br.readLine();
			newData =  newData.substring(newData.indexOf(':')+2,newData.indexOf(':')+16);
			br.close();
			con.disconnect();
		}catch(IOException ioe){
			logger.error(String.format("URL=%s - %s", urlString ,ioe.getMessage()));
		}
		return newData;
	}
	
	
}