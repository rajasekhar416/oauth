package com.example.demo;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class requestresource extends ResourceServerConfigurerAdapter{

	
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/v2/**").authenticated()
            .antMatchers("/check").hasAuthority("admin");
        
       
           /* .and()
            .formLogin().permitAll();*/
           
    }
}
