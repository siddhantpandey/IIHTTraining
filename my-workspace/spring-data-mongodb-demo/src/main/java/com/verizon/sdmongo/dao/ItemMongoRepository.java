package com.verizon.sdmongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verizon.sdmongo.model.Item;

public interface ItemMongoRepository extends MongoRepository<Item, Integer>{

}
