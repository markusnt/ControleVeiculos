package com.identific.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.identific.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, String>{
	List<Veiculo> findByPlacaLike(String placa);
}
