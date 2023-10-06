package com.sinensia.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinensia.dto.InscripcionDto;

/**
 * Nuestra clase @Service
 * 
 * @see com.sinensia.service.InscripcionService
 * @see com.sinensia.controller.InscripcionController
 */
@Service
public class InscripcionServiceImpl implements InscripcionService {

	/**
	 * Inyectamos nuestro RestTemplate
	 */
	@Autowired
	RestTemplate template;

	private static final String URL_CONNECTION_INSCRIPCION = "http://localhost:9090/inscripcion";

	/**
	 * 
	 * @return List
	 */
	@Override
	public List<InscripcionDto> getAll() {
		return Arrays.asList(template.getForObject(URL_CONNECTION_INSCRIPCION, InscripcionDto[].class));
	}

	/**
	 * 
	 * @param inscripcionDto
	 * @return List
	 */
	@Override
	public List<InscripcionDto> save(InscripcionDto inscripcionDto) {
		template.postForLocation(URL_CONNECTION_INSCRIPCION, inscripcionDto);

		return getAll();
	}

	/**
	 * 
	 * @param nombreCurso
	 * @return List
	 */
	@Override
	public List<InscripcionDto> getByCourse(String nombreCurso) {
		return Arrays
				.asList(template.getForObject(URL_CONNECTION_INSCRIPCION + "/" + nombreCurso, InscripcionDto[].class));
	}

}
