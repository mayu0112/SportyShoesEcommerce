package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sales")
public class Sales {
	
	@Id
	@Column(name="salesid")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int salesid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="item")
	private String item;
	
	@Column(name="category")
	private String category;
	
	@Column(name="price")
	private int price;
	
	@Column(name="saledate")
	private Date saledate;


	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getSaledate() {
		return saledate;
	}

	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}

	@Override
	public String toString() {
		return "SalesReport [salesid=" + salesid + ", username=" + username + ", item=" + item + ", category="
				+ category + ", price=" + price + ", saledate=" + saledate + "]";
	}

	public Sales(String username, String item, String category, int price, Date saledate) {
		super();
		this.username = username;
		this.item = item;
		this.category = category;
		this.price = price;
		this.saledate = saledate;
	}

	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
