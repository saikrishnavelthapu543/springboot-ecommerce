package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.UserPojo;

@Repository
public interface userdao extends JpaRepository<UserPojo,Integer> {

}
