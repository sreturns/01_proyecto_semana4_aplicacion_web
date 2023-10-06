package com.sinensia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinensia.dto.CursoDto;
import com.sinensia.service.CursoService;

import io.micrometer.common.util.StringUtils;

@Controller
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping("/")
	public String mainPage(@RequestParam(name = "search", required = false) String nombre, Model model) {
	    if (StringUtils.isNotBlank(nombre)) {
	        CursoDto resultado = service.getByName(nombre);
	        model.addAttribute("si", true);
	        model.addAttribute("resultado", resultado);
	        return "index.html";
	    }
		model.addAttribute("listaCursos", service.getAll());
		model.addAttribute("mostrarTodos", true);
		return "index.html";
	}

	@GetMapping("/disponibles")
	public String mostrarCursosDisponibles(Model model) {
		List<CursoDto> cursosDisponibles = service.getIfAvailable();
		model.addAttribute("listaCursos", cursosDisponibles);
		model.addAttribute("mostrarTodos", false); // No mostrar todos los cursos
		return "index.html";
	}

	@GetMapping("/curso/form")
	public String inscripcionForm(Model model) {
		model.addAttribute("cursoDto", new CursoDto());
		return "form_curso.html";
	}

	@PostMapping("/curso/form")
	public String save(@ModelAttribute CursoDto curso) {
		service.save(curso);
		return "redirect:/";
	}

}
