package com.sinensia.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinensia.dto.CursoDto;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	RestTemplate template;

	private final String URL_CONNECTION = "http://localhost:8080/curso";

	@Override
	public CursoDto getByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CursoDto> getIfAvailable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CursoDto> getAll() {
		return Arrays.asList(template.getForObject(URL_CONNECTION, CursoDto[].class));
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
	public List<CursoDto> save(CursoDto curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CursoDto> getListType(Boolean avaiables) {
		// TODO Auto-generated method stub
		return null;
	}

}
