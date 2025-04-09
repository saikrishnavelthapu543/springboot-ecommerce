package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Exception.ProductNotFoundException;
import com.product.entity.productpojo;
import com.product.service.productservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("productdetails")
public class productcontroller<personpojo> {
	@Autowired
	private productservice ps;
	@RequestMapping("/")
	public String greet()
	{
		return "WELCOME TO ENTERPRICE PROJECT";
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@PostMapping("save")
	public ResponseEntity<Object>  save(@Valid @RequestBody productpojo pp)
	{
		System.out.println("I am in CONTROLLER class");
		return ps.save(pp);
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@RequestMapping("update/{pid}/{pprice}/{pquantity}/{status}")
	public ResponseEntity<String> update(@PathVariable int pid,
		@PathVariable	double pprice,
		@PathVariable	double pquantity,
		@PathVariable	String status)
	{
		System.out.println("I am in CONTROLLER class");
		return ps.update(pid, pprice, pquantity, status);
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@DeleteMapping("delete/{pid}")
	public  ResponseEntity<String> delete(@PathVariable int pid) throws ProductNotFoundException
	{
		System.out.println("I am in CONTROLLER class");
		return ps.delete(pid);	
	}
//System.out.println("------------------------------------------------------------------------------------------------------------")
	@DeleteMapping("deletebyname/{pname}")
	public ResponseEntity<String>  deletebyname(@PathVariable String pname) throws ProductNotFoundException
	{
		System.out.println("I am in CONTROLLER  class");
		return ps.deletebyname(pname);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
@RequestMapping("getbyid/{pid}")
	public ResponseEntity<productpojo> getbyid(@PathVariable  int pid) throws ProductNotFoundException
	{
		return ps.getbyid(pid);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@RequestMapping("getprice/{pname}")
	public ResponseEntity<Object> getprice(@PathVariable  String pname) throws ProductNotFoundException
	{
		System.out.println("I am in CONTROLLER class");
	   return ps.getprice(pname);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@RequestMapping("getbyname/{pname}")
	public ResponseEntity<productpojo> getbyname(@PathVariable  String pname) throws ProductNotFoundException
	{
		System.out.println("I am in CONTROLLER class");
	   return ps.getbyname(pname);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@RequestMapping("getproducts/{pquantity}")
	public ResponseEntity<List<String>> specifiedproducts(@PathVariable double pquantity) throws ProductNotFoundException
	{
		System.out.println("I am in CONTROLLER class");
	   return ps.specifiedproducts(pquantity);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@RequestMapping("getproducts1/{pprice}")
	public ResponseEntity<List<String>> specifiedproducts1(@PathVariable double pprice) throws ProductNotFoundException
	{
		System.out.println("I am in CONTROLLER class");
	   return ps.specifiedproducts1(pprice);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@RequestMapping("getbyprice/{pprice}")
	public ResponseEntity<List<productpojo>> getbyprice(@PathVariable double pprice) throws ProductNotFoundException
	{
		System.out.println("I am in CONTROLLER class");
	   return ps.getabyprice(pprice);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@RequestMapping("getbyavailability/{status}")
	public ResponseEntity<List<productpojo>> getbyavailability(@PathVariable String status) throws ProductNotFoundException
	{
		System.out.println("I am in CONTROLLER class");
	   return ps.getbyavailability(status);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
		@RequestMapping("getall")
		public ResponseEntity<List<productpojo>> getall() throws ProductNotFoundException
		{
			System.out.println("I am in CONTROLLER class");
		   return ps.getall();
		}
//System.out.println("------------------------------------------------------------------------------------------------------------");
		@RequestMapping("IsproductAvailable/{pname}")
		public ResponseEntity<Boolean> IsproductAvailable(@PathVariable String pname) throws ProductNotFoundException
		{
			System.out.println("I am in CONTROLLER class");
			return ps.IsproductAvailable(pname);
		}
//System.out.println("------------------------------------------------------------------------------------------------------------");
		@RequestMapping("getProductQuantity/{pname}")
		public ResponseEntity<Double> getProductQuantity(@PathVariable String pname) throws ProductNotFoundException
		{
			System.out.println("I am in CONTROLLER class");
			return ps.getProductQuantity(pname);
		}
		
		
}
