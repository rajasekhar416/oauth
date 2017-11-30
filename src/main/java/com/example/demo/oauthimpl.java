package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class oauthimpl extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	/*@Autowired
	private UserDetailsService udetails;*/
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
		
		
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
/*		clients.inMemory().withClient("gigy").secret("secret").accessTokenValiditySeconds(30)
				.scopes("read", "write").authorizedGrantTypes("password", "refresh_token","authorization_code").resourceIds("oauth2_resource");
*/		
		
clients.inMemory().withClient("client-token").authorizedGrantTypes("client-credentials", "password","refresh_token").authorities("ROLE_CLIENT", "ROLE_ANDROID_CLIENT")
.scopes("read", "write", "trust")
.resourceIds("oauth2-resource")
.accessTokenValiditySeconds(5000)
.secret("client-secret").refreshTokenValiditySeconds(50000);


	}
	
	@Override
    public void configure(
      AuthorizationServerSecurityConfigurer oauthServer) 
      throws Exception {
        oauthServer
          .tokenKeyAccess("permitAll()")
          .checkTokenAccess("isAuthenticated()")
          .allowFormAuthenticationForClients();
    }
 
	
	
	

}
