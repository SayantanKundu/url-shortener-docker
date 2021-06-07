package com.lowes.urlshortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class URLModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fullUrl;
	
	private String shortUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public URLModel(Long id, String fullUrl, String shortUrl) {
		super();
		this.id = id;
		this.fullUrl = fullUrl;
		this.shortUrl = shortUrl;
	}

	@Override
	public String toString() {
		return "URLModel [id=" + id + ", fullUrl=" + fullUrl + ", shortUrl=" + shortUrl + "]";
	}
	
	
	
}
