package com.verizon.sdcd.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.verizon.sdcd.model.Item;
@Repository
public interface ItemCassandraRepository extends CassandraRepository<Item, Integer>{

}
