package com.example.Service;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.DTO.UserDto;
import com.example.Dao.userdao;
import com.example.Entity.UserPojo;

@Service
public class userservice {
	@Autowired
	private userdao ud;
	@Autowired
	private ModelMapper modelMapper;
	
	
	public ResponseEntity<UserDto> save(UserPojo up)
	{
		ud.save(up);
	UserDto ud=	modelMapper.map(up, UserDto.class);
	return new ResponseEntity<UserDto>(ud,HttpStatus.OK);
	}
	
	public ResponseEntity<String> deletebyid(int userid)
	{
		UserPojo m=ud.findById(userid).get();
		ud.delete(m);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteall()
	{
		ud.deleteAll();
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}	
	public ResponseEntity<UserDto> getbyid(int userid) throws Exception
	{
		Optional<UserPojo> dt= ud.findById(userid);
		UserPojo us=dt.get();
		UserDto ud=modelMapper.map(us, UserDto.class);
	    if (us.getOp() != null) {
	        ud.setOrderid(us.getOp().getOrderid());
	        ud.setOrderdate(us.getOp().getOrderdate());
	        ud.setOrderstatus(us.getOp().getOrderstatus());
	        ud.setShippingdate(us.getOp().getShippingdate());
	        ud.setDeliverydate(us.getOp().getDeliverydate());
	    }
		return new ResponseEntity<UserDto>(ud,HttpStatus.OK);
	}
	
	public ResponseEntity<List<UserDto>> getall()
	{
		
		List<UserPojo> k= ud.findAll();
		UserDto[] c=	modelMapper.map(k, UserDto[].class);
		List<UserDto> l=Arrays.asList(c);
		return new ResponseEntity<List<UserDto>>(l,HttpStatus.OK);
	}
	
//	public UserDto converttodto(UserPojo us)
//	{
//		UserDto ud=new UserDto();
//		ud.setUserid(us.getUserid());
//		ud.setFirstname(us.getFirstname());
//		ud.setLastname(us.getLastname());
//		ud.setAccountstatus(us.getAccountstatus());
//		ud.setUserrole(us.getUserrole());
//		ud.setDeliverydate(us.getOp().getDeliverydate());
//		ud.setOrderid(us.getOp().getOrderid());
//		ud.setOrderdate(us.getOp().getOrderdate());
//		ud.setOrderstatus(us.getOp().getOrderstatus());
//		ud.setShippingdate(us.getOp().getShippingdate());
//		return ud;
//
//	}
	
}
