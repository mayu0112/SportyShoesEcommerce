package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Products {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="item")
	private String item;
	
	@Column(name="category")
	private String category;
	
	@Column(name="price")
	private int price;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Products(String item, String category, int price) {
		super();
		this.item = item;
		this.category = category;
		this.price = price;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Products [item=" + item + ", category=" + category + ", price=" + price + "]";
	}
	
	
	

}
