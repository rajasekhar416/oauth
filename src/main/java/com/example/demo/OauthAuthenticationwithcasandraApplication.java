package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
@EnableCassandraRepositories("com.example.persistance")
public class OauthAuthenticationwithcasandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthAuthenticationwithcasandraApplication.class, args);
	}
	
	@Autowired
	UserDetailsService uservice;
	
	@Autowired
    public void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
		auth.userDetailsService(uservice);
		//System.out.println(uservice.toString());
    }
	
}
