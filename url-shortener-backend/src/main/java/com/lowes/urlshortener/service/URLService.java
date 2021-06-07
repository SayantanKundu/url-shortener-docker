package com.lowes.urlshortener.service;


import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.lowes.urlshortener.model.URLModel;
import com.lowes.urlshortener.repository.URLRepository;

@Service
public class URLService {

	@Autowired
	URLRepository urlRepository;
	
	@Autowired
	BaseConversion baseConversion;
	
	@Value("${shortener.url.host}")
	private String shortenerHostPath;
	
	public URLModel save(URLModel url) throws UnsupportedEncodingException, URISyntaxException {
		String fullUrl=url.getFullUrl();
		URI uri=new URI(fullUrl);

//		System.out.println("Req query="+uri.getPath());
		String path=uri.getPath().substring(1,uri.getPath().length());
		
		String shortPath=baseConversion.encode(path);
		
//		String method=uri.getScheme();
//		String host=uri.getHost();
//		String port=String.valueOf(uri.getPort());
//		
//		String shortUri="";
//		if(method!=null) {
//			shortUri+=method+"://";
//		}else {
//			shortUri+="http://";
//		}
//		if(host!=null) {
//			shortUri+=host;
//		}
//		
//		shortUri+=":8080/"+shortPath;
		
		url.setShortUrl(shortPath);
		
		URLModel entity=urlRepository.save(url);
		
		entity.setShortUrl(shortenerHostPath+entity.getShortUrl());
		
		return entity;
		
	}

	public String getOriginalUrl(String shortUrl) {
		return urlRepository.getOriginalUrl(shortUrl);
	}
}
