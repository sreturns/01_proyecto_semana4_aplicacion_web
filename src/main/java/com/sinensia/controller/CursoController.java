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

/**
 * Nuestra clase @Controller desde la cual controlamos las peticiones enviadas
 * desde el cliente
 * 
 * @author Sergio
 * @see com.sinensia.service.CursoServiceImpl
 * @see com.sinensia.service.CursoService
 */
@Controller
public class CursoController {

	/**
	 * Inyectamos nuestro @Service
	 */
	@Autowired
	private CursoService service;

	/**
	 * 
	 * @param nombre
	 * @param model
	 * @return
	 */
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

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/disponibles")
	public String mostrarCursosDisponibles(Model model) {
		List<CursoDto> cursosDisponibles = service.getIfAvailable();
		model.addAttribute("listaCursos", cursosDisponibles);
		model.addAttribute("mostrarTodos", false); // No mostrar todos los cursos
		return "index.html";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/curso/form")
	public String inscripcionForm(Model model) {
		model.addAttribute("cursoDto", new CursoDto());
		return "form_curso.html";
	}

	/**
	 * 
	 * @param curso
	 * @return
	 */
	@PostMapping("/curso/form")
	public String save(@ModelAttribute CursoDto curso) {
		service.save(curso);
		return "redirect:/";
	}

}
