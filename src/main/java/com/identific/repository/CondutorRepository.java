package com.identific.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.identific.model.Condutor;


public interface CondutorRepository extends CrudRepository<Condutor, Long>{
	List<Condutor> findByCnhLike(Long cnh);
}