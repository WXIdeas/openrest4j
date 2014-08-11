package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddInventoryRequest extends Request {
	public static final String TYPE = "add_inventory";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AddInventoryRequest() {}
    
    public AddInventoryRequest(String accessToken, String organizationId, Inventory inventory) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.inventory = inventory;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Inventory inventory;
}
