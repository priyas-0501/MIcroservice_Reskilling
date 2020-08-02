
package com.ibm.poc.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.poc.dto.ConversionExchangeDTO;

//@FeignClient(name= "currency-conversion-service" ,url="localhost:8100") 
@FeignClient(name = "currency-conversion-service")
@RibbonClient(name = "currency-conversion-service")

public interface ConversionExchangeServiceProxy {

	@GetMapping(path = "/conversion/{countryCode}", produces = "application/json")
	public ConversionExchangeDTO getConversionFactorFeign(@PathVariable("countryCode") String countrycode);

}
