package com.identific.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.identific.model.Localidade;

public interface LocalidadeRepository extends CrudRepository<Localidade, Long>{
	List<Localidade> findByIdLike(Long id);
}
