package com.auth.dto;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private HttpStatus status;
	private String msg;
	private LocalDateTime timestamp;
	
	// Controller
	public ErrorResponse(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
        this.timestamp = LocalDateTime.now();
    }
	
	// Getters and setters
	public HttpStatus getStatus() { return status; }
	public String getMsg() { return msg; }
	public LocalDateTime getTimeStamp() { return timestamp; }
	
	public void setStatus(HttpStatus status) { this.status = status; }
	public void setMsg(String msg) { this.msg = msg; }
	public void setTimeStamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
