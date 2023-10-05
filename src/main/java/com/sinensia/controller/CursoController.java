package com.sinensia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sinensia.service.CursoService;

@Controller
public class CursoController {

	@Autowired
	private CursoService service;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("listaCursos", service.getAll());
		System.out.println(service.getAll().toString());
		return "index.html";
	}
	
}
