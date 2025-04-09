package com.product.dao;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.product.Exception.ProductNotFoundException;
import com.product.entity.productpojo;

@Component
public class productdao {
	@Autowired
	private JdbcTemplate jt;
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<Object> save(productpojo pp)
	{
		try
		{
		System.out.println("I am in DAO class");
	int rows=	jt.update("insert into product.productpojo (pid,pname,pprice,pquantity,status) values (?,?,?,?,?)",pp.getPid(),pp.getPname(),pp.getPprice(),pp.getPquantity(),pp.getStatus());
	System.out.println("no of rows effected--->"+rows);
	return new ResponseEntity<Object>(pp, HttpStatus.CREATED);
		}
		catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Object>("Duplicate entry", HttpStatus.CONFLICT);
		}
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<String> update(int pid,double pprice,double pquantity,String status)
	{
		try
		{
		System.out.println("I am in DAO class");
		int rows=jt.update("update product.productpojo set pprice=?,pquantity=?,status=? where pid=?",pprice,pquantity,status,pid);
		System.out.println("no of rows effected--->"+rows);
		}catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("Operation is Unsuccessful",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Updated",HttpStatus.OK);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<String> delete(int pid) throws ProductNotFoundException
	{
		try
		{
		int rows=jt.update("delete from product.productpojo where pid=?",pid);
		if(rows==0)
		{
			throw new ProductNotFoundException("Product ID " + pid + " does not exist");
		}
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}catch(Exception e)
		{
			throw new ProductNotFoundException("Product ID " + pid + " does not exist");
		}	
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
		public ResponseEntity<String>deletebyname(String pname) throws ProductNotFoundException
		{
			try
			{
			int rows=jt.update("delete from product.productpojo where pname=?",pname);
			if(rows==0)
			{
				throw new ProductNotFoundException("Product Name " + pname + " does not exist");
			}
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
			}
			catch (Exception e) {
				throw new ProductNotFoundException("Product Name " + pname + " does not exist");
			}
		}
//System.out.println("------------------------------------------------------------------------------------------------------------");
		public ResponseEntity<productpojo> getbyid(int pid) throws ProductNotFoundException {
		    productpojo pp = null;
		    try {
		        System.out.println("I am in DAO class");
		        pp = jt.queryForObject("select * from product.productpojo where pid=?", 
		                new BeanPropertyRowMapper<>(productpojo.class), pid);
		        
		        return new ResponseEntity<>(pp, HttpStatus.OK);
		        
		    } catch (Exception ex) {
		        // Handle the case when no result is found
		        throw new ProductNotFoundException("Product ID " + pid + " does not exist");
		    }
		}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<productpojo> getbyname(String pname) throws ProductNotFoundException
	{
		productpojo pp=null;
		try
		{
		System.out.println("I am in DAO class");
		 pp=jt.queryForObject("select * from product.productpojo where pname=?",new BeanPropertyRowMapper<>(productpojo.class),pname);
		 return new ResponseEntity<productpojo>(pp,HttpStatus.OK);
		}
		catch (Exception e)  {
			throw new ProductNotFoundException("Product Name " + pname + " does not exist");
		}
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<productpojo>> getbyprice(double pprice) throws ProductNotFoundException
	{
		List<productpojo> pp=null;
		try
		{
		System.out.println("I am in DAO class");
		pp=jt.query("select * from product.productpojo where pprice<=?", new BeanPropertyRowMapper(productpojo.class),pprice);
		if(pp.isEmpty())
		{
			throw new ProductNotFoundException("No products found");
		}
		return new ResponseEntity<List<productpojo>>(pp,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ProductNotFoundException("No product found");
		}
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<productpojo>> getbyavailability(String status) throws ProductNotFoundException
	{
		List<productpojo> pp=null;
		try
		{
		System.out.println("I am in DAO class");
		 pp=jt.query("select * from product.productpojo where status=?", new BeanPropertyRowMapper(productpojo.class),status);
		 if(pp.isEmpty())
			{
				throw new ProductNotFoundException("No products found");
			}
		 return new ResponseEntity<List<productpojo>>(pp,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ProductNotFoundException("No product found");
		}
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<Object> getprice(String pname) throws ProductNotFoundException
	{
		Double productprice=0.0;
		try
		{
		 productprice=jt.queryForObject("select pprice from product.productpojo where pname=?",new Object[] {pname},Double.class);
		 if (productprice == null) {
	            throw new ProductNotFoundException("Product not found");
	        }
		 return new  ResponseEntity<Object>(productprice,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ProductNotFoundException("No product found");
		}
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<String>> specifiedproducts(double pquantity) throws ProductNotFoundException
	{
		List<String> products=null;
		try {
		System.out.println("I am in DAO class");
		products=jt.queryForList("select pname from product.productpojo where pquantity<=?",new Object[] {pquantity},String.class);
		if(products.isEmpty())
		{
			throw new ProductNotFoundException("No products found");
		}
		return new ResponseEntity<List<String>>(products,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ProductNotFoundException("No products found");
		}
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<String>> specifiedproducts1(double pprice) throws ProductNotFoundException
	{
		List<String> products=null;
		try {
		System.out.println("I am in DAO class");
		products=jt.queryForList("select pname from product.productpojo where pprice>=?",new Object[] {pprice},String.class);
		if(products.isEmpty())
		{
			throw new ProductNotFoundException("No products found");
		}
		return new ResponseEntity<List<String>>(products,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ProductNotFoundException("No products found");
		}
		
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<List<productpojo>> getall() throws ProductNotFoundException
	{
		List<productpojo> pp=null;
		try
		{
		System.out.println("I am in DAO class");
		pp=jt.query("select * from product.productpojo",new BeanPropertyRowMapper<>(productpojo.class));		
		if(pp.isEmpty())
		{
			throw new ProductNotFoundException("No products found");
		}
		return new ResponseEntity<List<productpojo>>(pp,HttpStatus.OK);	
		}catch (Exception e) {
			throw new ProductNotFoundException("No products found");
		}
		
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<Boolean> IsproductAvailable(String pname) throws ProductNotFoundException
	{
		try {
		System.out.println("I am in DAO class");
		String product=	jt.queryForObject("select status from product.productpojo where pname=?",new Object[] {pname},String.class);
		if(product!=null)
		{
			if(product.equals("Available"))
			{
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
			else
			{
				return  new ResponseEntity<Boolean>(false,HttpStatus.EXPECTATION_FAILED);
			}
		}else
		{
			  throw new ProductNotFoundException("Product Name " + pname + " does not exist");
		}
		} catch (Exception e) {
			return  new ResponseEntity<Boolean>(false,HttpStatus.EXPECTATION_FAILED);
		}
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public ResponseEntity<Double> getProductQuantity(String pname) throws ProductNotFoundException
	{
		Double ProductQuantity=0.0;
		try {
			ProductQuantity=jt.queryForObject("select pquantity from product.productpojo where pname=?", new Object[] {pname},Double.class);
			if (ProductQuantity<=0 | ProductQuantity == null) {
	            throw new ProductNotFoundException("Product not found");
	        }
		 return new  ResponseEntity<Double>(ProductQuantity,HttpStatus.OK);
		} catch (Exception e) {
			throw new ProductNotFoundException("Product not found");
		}
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");

}
