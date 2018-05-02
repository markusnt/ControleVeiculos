package com.identific.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.identific.model.Condutor;
import com.identific.model.Cr;
import com.identific.repository.CrRepository;

@Controller
@RequestMapping("/cr")
public class CrController {

	private CrRepository crRepository;
	
    public CrController(CrRepository crRepository) {
        this.crRepository = crRepository;
    }
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("crs", crRepository.findAll());
		return "cr/listar";
	}
	
	@GetMapping("/editar")
	public String edit(Model model, @RequestParam Long id) {
		model.addAttribute("cr", crRepository.findAll());
		return "cr/formulario";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("cr", new Cr());
		return "cr/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cr cr, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "cr/formulario";
		}
		crRepository.save(cr);
		return "cr/listar";
		}
	
	@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam Long id) {
		model.addAttribute("cr", new Condutor());
		model.addAttribute("crs", crRepository.findByIdLike(id));
		return "cr/listar";
	}
	
}
