package com.example.SampleEcommerce;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "product") 
public class Product {
	public Product() {
		super();
	}
	public Product(int id, int available, String brand, String category, String description, String name, double price,
			int quantity, Date releasedate) {
		super();
		this.id = id;
		this.available = available;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.releasedate = releasedate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", available=" + available + ", brand=" + brand + ", category=" + category
				+ ", description=" + description + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", releasedate=" + releasedate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int available;
	private String brand;
	private String category;
	private String description;
	private String name;
	private double price;
	private int quantity;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yy")
	private Date releasedate;
	

}
