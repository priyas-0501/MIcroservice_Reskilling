package com.ibm.poc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "ConversionExchange")
public class ConversionFactorEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4807379143383297660L;

	@javax.persistence.Id
	@GeneratedValue
	private long Id;

	@Column(nullable = false, length = 2, updatable = false)
	private String countryCode;

	@Column(nullable = false)
	private double countryfactor;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getCountryfactor() {
		return countryfactor;
	}

	public void setCountryfactor(double countryfactor) {
		this.countryfactor = countryfactor;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

}
