package com.lowes.urlshortener.controller;

import java.io.UnsupportedEncodingException;

import java.net.URISyntaxException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowes.urlshortener.model.URLModel;
import com.lowes.urlshortener.service.URLService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UrlShortenerController {
	
	@Autowired
	URLService urlService;
	
	@PostMapping(path = "/save")
	public ResponseEntity<URLModel> saveFullUrl(@RequestBody URLModel url) throws UnsupportedEncodingException, URISyntaxException{
		
		System.out.println(url.getFullUrl());
		URLModel encoded=urlService.save(url);
		return new ResponseEntity<URLModel>(encoded, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/{shortUrl}")
	public ResponseEntity<JSONObject> getOriginalUrl(@PathVariable String shortUrl){
		String fullUrl=urlService.getOriginalUrl(shortUrl);
		
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("fullurl", fullUrl);
		return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
	}
}
