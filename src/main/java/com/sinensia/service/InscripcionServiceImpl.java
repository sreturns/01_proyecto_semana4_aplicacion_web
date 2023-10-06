package com.sinensia.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinensia.dto.InscripcionDto;

@Service
public class InscripcionServiceImpl implements InscripcionService {

	@Autowired
	RestTemplate template;

	private static final String URL_CONNECTION_INSCRIPCION = "http://localhost:9090/inscripcion";

	@Override
	public List<InscripcionDto> getAll() {
		return Arrays.asList(template.getForObject(URL_CONNECTION_INSCRIPCION, InscripcionDto[].class));
	}

	@Override
	public List<InscripcionDto> save(InscripcionDto inscripcionDto) {
		template.postForLocation(URL_CONNECTION_INSCRIPCION, inscripcionDto);

		return getAll();
	}

	@Override
	public List<InscripcionDto> getByCourse(String nombreCurso) {
		return Arrays.asList(template.getForObject(URL_CONNECTION_INSCRIPCION + "/" + nombreCurso, InscripcionDto[].class));
	}

}
