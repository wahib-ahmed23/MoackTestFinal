package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="country_table")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int countryid;
	private String CountryName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="new_Country_id",referencedColumnName = "countryid")
	private List<Product> states;
	
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categories(String countryName, List<Product> states) {
		super();
		CountryName = countryName;
		this.states = states;
	}
	public int getCountryid() {
		return countryid;
	}
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public List<Product> getStates() {
		return states;
	}
	public void setStates(List<Product> states) {
		this.states = states;
	}
	
	
}
