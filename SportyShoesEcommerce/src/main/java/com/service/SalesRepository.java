package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Products;
import com.beans.Sales;
import com.repository.ProductDao;
import com.repository.SalesDao;

@Service
public class SalesRepository {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private SalesDao salesDao;
	
	public void addSales(String username, int id, Date saledate) {
		System.out.println("Sales of Product ADD Reached");
		Optional<Products> product = productDao.findById(id);
	
        if (product.isPresent()){
		salesDao.save(new Sales(username, product.get().getItem(), product.get().getCategory(), product.get().getPrice(), saledate));
        }
	}
	
	public List<Sales> listSales(){
		System.out.println("Sales LIST Reached");
		List al = (ArrayList<Sales>) salesDao.findAll();
		System.out.println("List of Sales: " + al);
		return al;
	}

}
