package com.example.Controller;

import java.util.List;

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

import com.example.DTO.UserDto;
import com.example.Entity.UserPojo;
import com.example.Service.userservice;


@RestController
@RequestMapping("user")
public class usercontroller {

	@Autowired
	private userservice us;
	@PostMapping("save")
	public ResponseEntity<UserDto> save( @RequestBody UserPojo up)
	{
		return us.save(up);
	}
	@DeleteMapping("deletebyid/{userid}")
	public ResponseEntity<String> deletebyid(@PathVariable int userid)
	{
		
		return us.deletebyid(userid);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<String> delete()
	{
		return us.deleteall();
	}
	
	@GetMapping("getbyid/{userid}")
	public ResponseEntity<UserDto> getbyid(@PathVariable int userid) throws Exception
	{
		return us.getbyid(userid);
	}
	@GetMapping("getall")
	public ResponseEntity<List<UserDto>> getall()
	{
		
		return us.getall();
		
	}
}
