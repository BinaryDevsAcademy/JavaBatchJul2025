package com.ec.entites;

import java.sql.Date;

public class Product {
	private int product_id;
	private Users seller_id;
	private String product_name;
	private String description;
	private double price;
	private int stock;
	private Date created_at;
	private Date update_at;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Users getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Users seller_id) {
		this.seller_id = seller_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", seller_id=" + seller_id + ", product_name=" + product_name
				+ ", description=" + description + ", price=" + price + ", stock=" + stock + ", created_at="
				+ created_at + ", update_at=" + update_at + "]";
	}
	
	
}
