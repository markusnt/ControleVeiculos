package com.identific.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.identific.model.Condutor;
import com.identific.repository.CondutorRepository;
import com.identific.repository.CrRepository;
import com.identific.repository.LocalidadeRepository;
import com.identific.repository.VeiculoRepository;

@Controller
@RequestMapping(value={"/condutor"})
public class CondutorController {
	
	@Autowired
	private CondutorRepository condutorRepository;
	private VeiculoRepository veiculoRepository;
	private CrRepository crRepository;
	
	
	public CondutorController(CondutorRepository condutorRepository, VeiculoRepository veiculoRepository, CrRepository crRepository) {
		this.condutorRepository = condutorRepository;
		this.veiculoRepository = veiculoRepository;
		this.crRepository = crRepository;
	}
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("condutor", new Condutor());
		model.addAttribute("condutors", condutorRepository.findAll());
		return "condutor/listar";
	}
	
	@GetMapping("/editar")
	public String edit(Model model, @RequestParam Long cnh) {
		model.addAttribute("condutor", condutorRepository.findOne(cnh));
		model.addAttribute("veiculos", veiculoRepository.findAll());
		model.addAttribute("crs", crRepository.findAll());
		return "condutor/formulario";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("condutor", new Condutor());
		model.addAttribute("veiculos", veiculoRepository.findAll());
		model.addAttribute("crs", crRepository.findAll());
		return "condutor/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Condutor condutor, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("veiculos", veiculoRepository.findAll());
			model.addAttribute("crs", crRepository.findAll());
			return "condutor/formulario";
		}
		condutorRepository.save(condutor);
		return "redirect:";
		}
	
	@GetMapping("/excluir")
	public String excluir(Model model, @RequestParam Long cnh) {
		condutorRepository.delete(cnh);
		return "redirect:/"; 
	}
	
	@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam Long cnh) {
		model.addAttribute("condutor", new Condutor());
		model.addAttribute("condutors", condutorRepository.findByCnhLike(cnh));
		return "condutor/formulario";
	}

}