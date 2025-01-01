package com.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.gateway.exception.ApiException;
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
	    return ((exchange, chain) -> {

	        // Check if the request is secured
	        if (validator.isSecured.test(exchange.getRequest())) {

	            // Check if the Authorization header is missing
	            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
	                throw new ApiException("Missing Authorization header!", HttpStatus.BAD_REQUEST);
	            }

	            // Fetch the Authorization header
	            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

	            // Verify the Bearer token format
	            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	                throw new ApiException("Invalid Authorization header format!", HttpStatus.BAD_REQUEST);
	            }

	            // Extract the token
	            String token = authHeader.substring(7);

	            try {
	                // Validate the token (either via REST call or directly with jwtUtil)
	                jwtUtil.validateToken(token);
	            } catch (Exception e) {
	                throw new ApiException("Invalid or expired token!", HttpStatus.UNAUTHORIZED);
	            }
	        }

	        // Continue with the request processing
	        return chain.filter(exchange);
	    });
	}
	
	public static class Config{}
}
