package com.example.demo;

import org.springframework.security.core.GrantedAuthority;


public class Authorities implements GrantedAuthority {

	
	private String authority;
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
	
	@Override
	public String toString() {
		return "Authorities [authority=" + authority + "]";
	}


}
