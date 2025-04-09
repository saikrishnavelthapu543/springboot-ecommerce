package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.product.Exception.ProductNotFoundException;
import com.product.dao.productdao;
import com.product.entity.productpojo;

@Component
public class productservice {
	@Autowired
	private productdao pd;
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<Object>  save(productpojo pp)
	{
		System.out.println("I am in SERVICE class");
		 return pd.save(pp);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<String> update(int pid,double pprice,double pquantity,String status)
	{
		System.out.println("I am in SERVICE class");
		return pd.update(pid, pprice, pquantity, status);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public  ResponseEntity<String> delete(int pid) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.delete(pid);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
		public ResponseEntity<String>  deletebyname(String pname) throws ProductNotFoundException
		{
			System.out.println("I am in SERVICE class");
			return pd.deletebyname(pname);
		}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<productpojo> getbyid(int pid) throws ProductNotFoundException
	{
		return pd.getbyid(pid);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<Object> getprice(String pname) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.getprice(pname);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<productpojo> getbyname(String pname) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.getbyname(pname);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<productpojo>> getall() throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.getall();
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<String>> specifiedproducts(double pquantity) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.specifiedproducts(pquantity);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<String>> specifiedproducts1(double pprice) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.specifiedproducts1(pprice);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<productpojo>> getabyprice(double pprice) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.getbyprice(pprice);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<productpojo>> getbyavailability(String status) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.getbyavailability(status);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<Boolean> IsproductAvailable(String pname) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.IsproductAvailable(pname);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<Double> getProductQuantity(String pname) throws ProductNotFoundException
	{
		System.out.println("I am in SERVICE class");
		return pd.getProductQuantity(pname);
	}
	
	
}
