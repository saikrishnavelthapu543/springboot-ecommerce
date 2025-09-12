package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.OrderPojo;
import com.example.Service.orderservice;


@RestController
@RequestMapping("order")
public class ordercontroller {
	@Autowired
	private orderservice os;
	@PostMapping("save")
	public ResponseEntity<Object> save( @RequestBody OrderPojo op) throws Exception
	{
		os.save(op);
		return new ResponseEntity<Object>(op,HttpStatus.OK);
	}
	@DeleteMapping("deletebyid/{orderid}")
	public ResponseEntity<String> deletebyid(@PathVariable int orderid)
	{
		
		return os.deletebyid(orderid);
	}
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteall()
	{
		return os.deleteall();
	}
	@GetMapping("getbyid/{orderid}")
	public ResponseEntity<OrderPojo> getbyid(@PathVariable int orderid)
	{
		return os.getbyid(orderid);
	}
	@GetMapping("getall")
	public ResponseEntity<List<OrderPojo>> getall()
	{
		return os.getall();
				
	}
	
}
