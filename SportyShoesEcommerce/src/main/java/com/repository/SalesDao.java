package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.beans.Sales;


public interface SalesDao extends CrudRepository<Sales, Integer>{

}
