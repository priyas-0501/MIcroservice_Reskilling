package com.ibm.poc.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ibm.poc.dto.ConversionExchangeDTO;

import com.ibm.poc.entity.ConversionFactorEntity;
import com.ibm.poc.repository.ConversionFactorRepository;

@Service
public class ConversionFactorServiceImpl implements ConversionExchangservice {
	
	
	ConversionFactorRepository  repo;
	
	@Autowired
	public ConversionFactorServiceImpl(ConversionFactorRepository repo) {
		
		this.repo = repo;
	}



	@Override
	public ConversionExchangeDTO getCurrencyBycountrycode(String countrycode, double amount) {
		// TODO Auto-generated method stub
		ConversionFactorEntity entity = repo.findBycountryCode(countrycode);     
        //if(userEntity == null) throw new UsernameNotFoundException("User not found");
       
		ConversionExchangeDTO dto = new ModelMapper().map(entity, ConversionExchangeDTO.class);
		System.out.println(entity.getCountryfactor());
        System.out.println(entity.getCountryfactor()*amount);
		 dto.setConversionamount(entity.getCountryfactor()*amount);
		return dto;
	}
	
	@Override
	public ConversionExchangeDTO getCurrencyBycountrycodeFeign(double factor , double amount) {
		// TODO Auto-generated method stub
		//ConversionFactorEntity entity = repo.findBycountryCode(countrycode);     
        //if(userEntity == null) throw new UsernameNotFoundException("User not found");
       
		ConversionExchangeDTO dto = new ConversionExchangeDTO();
        
		 dto.setConversionamount(factor*amount);
		return dto;
	}
	}
	

