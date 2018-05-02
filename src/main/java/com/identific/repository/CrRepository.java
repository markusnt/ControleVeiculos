package com.identific.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.identific.model.Cr;

public interface CrRepository extends CrudRepository<Cr, Long>{
	List<Cr> findByIdLike(Long id);
}

