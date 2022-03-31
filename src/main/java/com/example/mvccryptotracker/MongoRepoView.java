package com.example.mvccryptotracker;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MongoRepoView extends MongoRepository<Crypto, String> {
	public List<Crypto> findAll();

	@Query("{name : ?0}")
	List<Crypto> getCryptoByname(String name);

	String deleteByName(String name);
}
