package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.productRepository;
@Service
public class ProductService {
	@Autowired
	private productRepository productrepo;
	
	public Product addorupdate(Product product) {
		return productrepo.save(product);
	}
	public boolean deletebyid(int id) {
		productrepo.deleteById(id);
		return true;
	}
	public List<Product> getAll(){
		return productrepo.findAll();
		}
	public Optional<Product> getbyid(int id) {
		return productrepo.findById(id);
	}
	public List<Product> findpaginated(int pageNo,int pageSize){
		Pageable paging=PageRequest.of(pageNo, pageSize);
		Page<Product>pageresult=productrepo.findAll(paging);
		return pageresult.toList();
	}
}
