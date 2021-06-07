package com.lowes.urlshortener.repository;

import com.lowes.urlshortener.model.URLModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URLModel, Long> {

	@Query(value="SELECT DISTINCT full_url FROM urlmodel where short_url=?1",nativeQuery = true)
	public String getOriginalUrl(String shortUrl);
}
