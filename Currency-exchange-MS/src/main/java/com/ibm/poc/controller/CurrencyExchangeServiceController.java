package com.ibm.poc.controller;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;


import com.ibm.poc.dto.ConversionExchangeDTO;

import com.ibm.poc.model.ConversionFactorResponseModel;

import com.ibm.poc.service.ConversionExchangservice;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
@ControllerAdvice
public class CurrencyExchangeServiceController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ConversionExchangservice service;
	@Autowired
	private ConversionExchangeServiceProxy serviceproxy;

	/*
	 * @GetMapping(value = "/{countryCode}/{amount}", produces = {
	 * MediaType.APPLICATION_JSON_VALUE }) public
	 * ResponseEntity<ConversionFactorResponseModel> convertCurrency(
	 * 
	 * @PathVariable("countryCode") String countrycode, @PathVariable("amount")
	 * double amount) {
	 * 
	 * ConversionFactorDTO dto = service.getCurrencyBycountrycode(countrycode,
	 * amount); ConversionFactorResponseModel returnValue = new
	 * ModelMapper().map(dto, ConversionFactorResponseModel.class);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(returnValue); }
	 */

	// @ExceptionHandler(value = fallbackRetriveConfiguration.class)
	@GetMapping(path = "/exchange-feign/{countryCode}/{amount}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@HystrixCommand(fallbackMethod = "fault_Error")
	public ConversionExchangeDTO convertCurrencyFeign(@PathVariable("countryCode") String countrycode,
			@PathVariable("amount") double amount) throws Exception {

		ConversionExchangeDTO dto = serviceproxy.getConversionFactorFeign(countrycode);

		dto.setCountryCode(countrycode);
		dto.setCountryfactor(dto.getCountryfactor());
		dto.setConversionamount(amount * dto.getCountryfactor());
		ConversionFactorResponseModel returnValue = new ModelMapper().map(dto, ConversionFactorResponseModel.class);
		logger.info("{}", dto);

		return dto;

	}

	public ConversionExchangeDTO fault_Error(String a, double b) {
		return new ConversionExchangeDTO("default_US", 10.0);
	}

}
