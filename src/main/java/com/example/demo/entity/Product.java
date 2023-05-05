package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="state_table")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stateid;
	private String stateName;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String stateName) {
		super();
		this.stateName = stateName;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
}
