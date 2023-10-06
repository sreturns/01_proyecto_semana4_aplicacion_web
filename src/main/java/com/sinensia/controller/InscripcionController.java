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

@Controller
public class InscripcionController {

	@Autowired
	private InscripcionService service;

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

	@GetMapping("/inscripcion/form")
	public String inscripcionForm(Model model) {
		model.addAttribute("inscripcionDto", new InscripcionDto());
		return "form.html";
	}

	@PostMapping("inscripcion/form")
	public String save(@ModelAttribute InscripcionDto inscripcion) {
		service.save(inscripcion);
		return "redirect:/inscripcion";
	}

	@GetMapping("/estudiante")
	public String inscripcionMainPage(Model model) {
		model.addAttribute("listaEstudiantes", service.getAll());

		return "estudiante.html";
	}
}
