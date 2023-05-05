package com.example.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Categories;
import com.example.demo.service.CategoriesService;
@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	@Autowired
	private CategoriesService cservice;
	@GetMapping
	public List<Categories> getAll(){
		return cservice.getAll();
	}
	@GetMapping("/{id}")
	public Optional<Categories> getById(@PathVariable int id) {
		return cservice.getbyid(id);
	}
	@PostMapping
	public Categories add(@RequestBody Categories country) {
		return cservice.addorupdate(country);
	}
	@PutMapping("/{id}")
	public Categories update(@PathVariable int id,@RequestBody Categories cat) {
		cat.setCountryid(id);
		return cservice.addorupdate(cat);
	}
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		return cservice.deletebyid(id);
	}
	@GetMapping("/{pageNo}/{pageSize}")
	public List<Categories>getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return cservice.findpaginated(pageNo, pageSize);
}
}