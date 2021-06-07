package com.lowes.urlshortener.service;

import org.springframework.stereotype.Service;

@Service
public class BaseConversion {

    private static final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] allowedCharacters = allowedString.toCharArray();
    private int base = allowedCharacters.length;

    public String encode(String input){
    	String output="";
    	for(int i=0;i<input.length();i=i+3) {
    		if(i<30) {
    			output=output+((char)(input.charAt(i)+2));
    		}
    	}
    	
		return output;  
    }
}
