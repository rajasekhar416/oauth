package com.example.persistance;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.example.demo.User;


public interface Userrepositoryimpl extends CassandraRepository<User> {

	
	 @Query("SELECT * FROM employe WHERE name=?0 ALLOW FILTERING")
	 User findByName(String name);
}
