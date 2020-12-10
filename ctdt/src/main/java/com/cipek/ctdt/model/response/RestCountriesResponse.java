package com.cipek.ctdt.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class RestCountriesResponse {
	
	public String name;
    public String region;
    public String demonym;
    
    public RestCountriesResponse() {
    	
    }
}