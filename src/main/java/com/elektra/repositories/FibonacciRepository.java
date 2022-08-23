package com.elektra.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elektra.models.FibonacciModel;

@Repository
	public interface FibonacciRepository extends CrudRepository<FibonacciModel, Long> {
	

}
