package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Categories;
import com.example.demo.repository.CategoriesRepository;

@Service
public class CategoriesService {
	@Autowired
	private CategoriesRepository categoriesrepo;
	
	public Categories addorupdate(Categories country) {
		return categoriesrepo.save(country);
	}
	public boolean deletebyid(int id) {
		categoriesrepo.deleteById(id);
		return true;
	}
	public List<Categories> getAll(){
		return categoriesrepo.findAll();
		}
	public Optional<Categories> getbyid(int id) {
		return categoriesrepo.findById(id);
	}
	public List<Categories>findpaginated(int pageNo,int pageSize){
		Pageable paging=PageRequest.of(pageNo, pageSize);
		Page<Categories>pageresult=categoriesrepo.findAll(paging);
		return pageresult.toList();
	}
}
