package com.verizon.sdr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.sdr.model.State;

@Repository
public interface StateRepo extends JpaRepository<State, Long>{

	
}
