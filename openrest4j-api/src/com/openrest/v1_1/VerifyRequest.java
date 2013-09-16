package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifyRequest extends Request {
	public static final String TYPE = "verify";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public VerifyRequest() {}
    
    public VerifyRequest(String token) {
    	this.token = token;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String token;
}