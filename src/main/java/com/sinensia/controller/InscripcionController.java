package com.sinensia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinensia.dto.InscripcionDto;
import com.sinensia.service.InscripcionService;

import io.micrometer.common.util.StringUtils;

/**
 * Nuestra clase @Controller desde la cual controlamos las peticiones enviadas
 * desde el cliente
 * 
 * @author Sergio
 * @see com.sinensia.service.InscripcionServiceImpl
 * @see com.sinensia.service.InscripcionService
 */
@Controller
public class InscripcionController {

	/**
	 * Inyectamos nuestra clase @Service
	 */
	@Autowired
	private InscripcionService service;

	/**
	 * 
	 * @param nombre
	 * @param model
	 * @return
	 */
	@GetMapping("/inscripcion")
	public String inscripcionMainPage(@RequestParam(name = "search", required = false) String nombre, Model model) {
		if (StringUtils.isNotBlank(nombre)) {
			List<InscripcionDto> listaInscripcionesPorCurso = service.getByCourse(nombre);
			model.addAttribute("si", true);
			model.addAttribute("listaInscripcionesPorCurso", listaInscripcionesPorCurso);
			System.out.println(listaInscripcionesPorCurso.toString());
			return "inscripcion.html";
		}

		model.addAttribute("listaInscripciones", service.getAll());
		model.addAttribute("mostrarTodos", true); // Ajuste aquí
		return "inscripcion.html";

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/inscripcion/form")
	public String inscripcionForm(Model model) {
		model.addAttribute("inscripcionDto", new InscripcionDto());
		return "form.html";
	}

	/**
	 * 
	 * @param inscripcion
	 * @return
	 */
	@PostMapping("inscripcion/form")
	public String save(@ModelAttribute InscripcionDto inscripcion) {
		service.save(inscripcion);
		return "redirect:/inscripcion";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/estudiante")
	public String inscripcionMainPage(Model model) {
		model.addAttribute("listaEstudiantes", service.getAll());

		return "estudiante.html";
	}
}
