package com.ibm.poc.service;

import com.ibm.poc.dto.ConversionExchangeDTO;

public interface ConversionExchangservice {

	
	ConversionExchangeDTO getCurrencyBycountrycode(String countrycode,double amount);
	ConversionExchangeDTO getCurrencyBycountrycodeFeign(double factor,double amount);
}
