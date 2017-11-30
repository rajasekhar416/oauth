package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.persistance.Userrepositoryimpl;

@Service
public class usrdetails implements UserDetailsService {

	
	@Autowired
	Userrepositoryimpl uimpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		User user=uimpl.findByName(username);
		Authorities auth=new Authorities();
		auth.setAuthority(user.getRole());
		
		List<GrantedAuthority> authal=new ArrayList<GrantedAuthority>();
		authal.add(auth);
		user.setAuthorities(authal);
		System.out.println("username "+user.toString());
		return user;
	}
	
	
}
