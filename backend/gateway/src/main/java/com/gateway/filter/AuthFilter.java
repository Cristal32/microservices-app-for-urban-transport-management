package com.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import com.gateway.util.JwtUtil;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config>{
	
	@Autowired
	private RouteValidator validator;
	
	@Autowired
	private JwtUtil jwtUtil;

	// Constructor
	public AuthFilter() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange,chain)->{
			
			// Here we specify the logic of the request
			if(validator.isSecured.test(exchange.getRequest())) {
				
				// Check if header doesn't contain token
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing authorization header!");
				}
				
				// If token exists in header, fetch that header
				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				
				// Remove the first part which contains "Bearer"
				if(authHeader != null && authHeader.startsWith("Bearer")){
					authHeader = authHeader.substring(7);
				}
				
				try {
					// REST call to Auth service
//					template.getForObject("http://localhost:8085/api/auth/validateToken?token" + authHeader, String.class);
					jwtUtil.validateToken(authHeader);
				}catch(Exception e) {
					System.out.println("Can't call auth service to validate token");
					throw new RuntimeException("Unauthorized access to auth service");
				}
			}
			return chain.filter(exchange);
		});
	}
	
	public static class Config{
		
	}
}
