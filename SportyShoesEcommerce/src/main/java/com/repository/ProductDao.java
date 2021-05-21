package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.beans.Products;

public interface ProductDao extends CrudRepository<Products, Integer>{

}
