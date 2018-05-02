package com.identific.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.identific.model.Condutor;
import com.identific.model.Veiculo;
import com.identific.repository.VeiculoRepository;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

	private VeiculoRepository veiculoRepository;
	
    public VeiculoController(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("veiculos", veiculoRepository.findAll());
		return "veiculo/listar";
	}
	
	@GetMapping("/editar")
	public String edit(Model model, @RequestParam Long id) {
		model.addAttribute("veiculo", veiculoRepository.findAll());
		return "veiculo/formulario";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("veiculo", new Veiculo());
		return "veiculo/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Veiculo veiculo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "veiculo/formulario";
		}
		veiculoRepository.save(veiculo);
		return "veiculo/listar";
		}
	
	@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam String placa) {
		model.addAttribute("veiculo", new Condutor());
		model.addAttribute("veiculos", veiculoRepository.findByPlacaLike("%" + placa + "%"));
		return "veiculo/listar";
	}
	
}