package com.sinensia.service;

import java.util.List;

import com.sinensia.dto.CursoDto;

/**
 * 
 *@see com.sinensia.service.CursoServiceImpl
 */
public interface CursoService {

	CursoDto getByName(String nombre);

	List<CursoDto> getIfAvailable();
	
	List<CursoDto> getAll();

	List<CursoDto> deleteById(int idCurso);

	void update(CursoDto curso);

	List<CursoDto> save(CursoDto curso);

	public List<CursoDto> getListType(Boolean avaiables);
	
}
