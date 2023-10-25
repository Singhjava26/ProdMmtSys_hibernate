package com.hibernate.PMS.ProdMmtSys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Prod_table")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private long p_id;
	
	@Column(name="Name")
	private String p_name;
	
	@Column(name="Brand")
	private String p_brand;
	
	@Column(name="Category")
	private String p_category;
	
	@Column(name="Price")
	private long p_price;
	
	@Column(name="Quantity")
	private long p_quantity;

	public long getP_id() {
		return p_id;
	}

	public void setP_id(long p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_brand() {
		return p_brand;
	}

	public void setP_brand(String p_brand) {
		this.p_brand = p_brand;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public long getP_price() {
		return p_price;
	}

	public void setP_price(long p_price) {
		this.p_price = p_price;
	}

	public long getP_quantity() {
		return p_quantity;
	}

	public void setP_quantity(long p_quantity) {
		this.p_quantity = p_quantity;
	}
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product( String p_name, String p_brand, String p_category, long p_price, long p_quantity) {
		super();
		
		this.p_name = p_name;
		this.p_brand = p_brand;
		this.p_category = p_category;
		this.p_price = p_price;
		this.p_quantity = p_quantity;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_brand=" + p_brand + ", p_category=" + p_category
				+ ", p_price=" + p_price + ", p_quantity=" + p_quantity + "]";
	}
	
	
	

}