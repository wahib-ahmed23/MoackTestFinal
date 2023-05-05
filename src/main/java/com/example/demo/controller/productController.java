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

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
@RestController
@RequestMapping("/api/products")
public class productController {
	@Autowired
	private ProductService pservice;
	@GetMapping
	public List<Product> getAll(){
		return pservice.getAll();
	}
	@GetMapping("/{id}")
	public Optional<Product> getById(@PathVariable int id) {
		return pservice.getbyid(id);
	}
	@PostMapping
	public Product add(@RequestBody Product p) {
		return pservice.addorupdate(p);
	}
	@PutMapping("/{id}")
	public Product update(@PathVariable int id,@RequestBody Product p) {
		p.setStateid(id);
		return pservice.addorupdate(p);
	}
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		return pservice.deletebyid(id);
	}
	@GetMapping("/{pageNo}/{pageSize}")
	public List<Product> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return pservice.findpaginated(pageNo, pageSize);
}
}
