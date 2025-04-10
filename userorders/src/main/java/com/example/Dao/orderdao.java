package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.OrderPojo;

@Repository
public interface orderdao extends  JpaRepository<OrderPojo, Integer>{

}
