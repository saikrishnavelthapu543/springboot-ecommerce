package com.example.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Dao.orderdao;
import com.example.Entity.OrderPojo;

@Service
public class orderservice {
	@Autowired
	private orderdao od;
	
	public ResponseEntity<Object> save(OrderPojo op) throws Exception
	{
		od.save(op);
		return new ResponseEntity<Object>(op,HttpStatus.OK);
	}
	public ResponseEntity<OrderPojo> getbyid(int orderid)
	{
		Optional<OrderPojo> k= od.findById(orderid);
		return new  ResponseEntity<OrderPojo>(HttpStatus.OK);
	}
	
	public ResponseEntity<List<OrderPojo>> getall()
	{
		List<OrderPojo> k=od.findAll();
		ArrayList<List<OrderPojo>> m=new ArrayList<>();
		
		return new ResponseEntity<List<OrderPojo>>(k,HttpStatus.OK);
	}
	
	public ResponseEntity<String> deletebyid(int orderid)
	{
		OrderPojo m=od.findById(orderid).get();
		od.delete(m);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteall()
	{
		od.deleteAll();
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	
}
