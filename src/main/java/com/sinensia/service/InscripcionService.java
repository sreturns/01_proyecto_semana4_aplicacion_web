package com.sinensia.service;

import java.util.List;

import com.sinensia.dto.InscripcionDto;

public interface InscripcionService {

    List<InscripcionDto> getAll();

    List<InscripcionDto> save(InscripcionDto inscripcionDto);

    List<InscripcionDto> getByCourse(String nombreCurso);
	
}
