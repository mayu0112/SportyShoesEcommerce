package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Products;
import com.beans.Users;
import com.repository.ProductDao;

@Service
public class ProductRepository {
	
	@Autowired
	private ProductDao productDao;
	
	public void addProduct(String item, String category, int price) {
		System.out.println("Product ADD Reached");
		productDao.save(new Products(item, category, price));
	}
	
	public List<Products> listProducts(){
		System.out.println("Product LIST Reached");
		List al = (ArrayList<Products>) productDao.findAll();
		System.out.println("List of Products: " + al);
		return al;
	}
	
	public boolean deleteProduct(int id) {
		Optional<Products> product = productDao.findById(id);
		System.out.println("Deleted Product: " + product);
	
        if (product.isPresent()){
       	 	System.out.println("Product info Deleted");
       	 	productDao.deleteById(id);
            return true;
        }
        else {
       	 return false; 
        }
	         
	}

}
