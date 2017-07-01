package com.springBootPackage.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springBootPackage.domain.ObjetArchiver;

public interface FdjRepository extends MongoRepository<ObjetArchiver, String>{

}
