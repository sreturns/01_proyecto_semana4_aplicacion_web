package com.sinensia.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinensia.dto.CursoDto;

/**
 * Nuestra clase @Servicio
 * 
 * @see com.sinensia.service.CursoService
 * @see com.sinensia.controller.CursoController
 */
@Service
public class CursoServiceImpl implements CursoService {

	/**
	 * Inyectamos el RestTemplate
	 */
	@Autowired
	RestTemplate template;

	private final String URL_CONNECTION = "http://localhost:8080/curso";

	/**
	 * 
	 * @param nombre
	 */
	@Override
	public CursoDto getByName(String nombre) {
		return template.getForObject(URL_CONNECTION + "/" + nombre, CursoDto.class);
	}

	/**
	 * 
	 * @return List
	 */
	@Override
	public List<CursoDto> getIfAvailable() {
		return Arrays.asList(template.getForObject(URL_CONNECTION + "?avaiables=true", CursoDto[].class));
	}

	/**
	 * 
	 * @return List
	 */
	@Override
	public List<CursoDto> getAll() {
		return Arrays.asList(template.getForObject(URL_CONNECTION, CursoDto[].class));
	}
	
	/**
	 * 
	 * @return List
	 */
	@Override
	public List<CursoDto> save(CursoDto curso) {
		template.postForLocation(URL_CONNECTION, curso);

		return getAll();
	}

	@Override
	public List<CursoDto> deleteById(int idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CursoDto curso) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CursoDto> getListType(Boolean avaiables) {
		// TODO Auto-generated method stub
		return null;
	}

}
