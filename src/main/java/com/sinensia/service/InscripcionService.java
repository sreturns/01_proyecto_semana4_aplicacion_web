package com.sinensia.service;

import java.util.List;

import com.sinensia.dto.InscripcionDto;

/**
 * 
 *@see com.sinensia.service.InscripcionServiceImpl
 */
public interface InscripcionService {

    List<InscripcionDto> getAll();

    List<InscripcionDto> save(InscripcionDto inscripcionDto);

    List<InscripcionDto> getByCourse(String nombreCurso);
	
}
