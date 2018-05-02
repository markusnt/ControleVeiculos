package com.identific.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.identific.model.Condutor;
import com.identific.model.Localidade;
import com.identific.repository.LocalidadeRepository;

@Controller
@RequestMapping("/localidade")
public class LocalidadeController {

	private LocalidadeRepository localidadeRepository;
	
    public LocalidadeController(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("localidades", localidadeRepository.findAll());
		return "localidade/listar";
	}
	
	@GetMapping("/editar")
	public String edit(Model model, @RequestParam Long id) {
		model.addAttribute("localidade", localidadeRepository.findAll());
		return "localidade/formulario";
	}

	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("localidade", new Localidade());
		return "localidade/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Localidade localidade, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "localidade/formulario";
		}
		localidadeRepository.save(localidade);
		return "localidade/listar";
		}
	
	@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam Long id) {
		model.addAttribute("localidade", new Condutor());
		model.addAttribute("localidades", localidadeRepository.findByIdLike(id));
		return "localidade/listar";
	}
	
}
