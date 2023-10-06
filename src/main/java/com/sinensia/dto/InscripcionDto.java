package com.sinensia.dto;

import java.util.Objects;

public class InscripcionDto {

    private int idInscripcion;
    private String nombreEstudiante;
    private int edad;
    private int idCurso;
    private int calificaciones;
    
    public InscripcionDto() {
    }

	public InscripcionDto(String nombreEstudiante, int edad, int idCurso, int calificaciones) {
		super();
		this.nombreEstudiante = nombreEstudiante;
		this.edad = edad;
		this.idCurso = idCurso;
		this.calificaciones = calificaciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calificaciones, edad, idCurso, idInscripcion, nombreEstudiante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscripcionDto other = (InscripcionDto) obj;
		return calificaciones == other.calificaciones && edad == other.edad && idCurso == other.idCurso
				&& idInscripcion == other.idInscripcion && Objects.equals(nombreEstudiante, other.nombreEstudiante);
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(int calificaciones) {
		this.calificaciones = calificaciones;
	}

	@Override
	public String toString() {
		return "InscripcionDto [idInscripcion=" + idInscripcion + ", nombreEstudiante=" + nombreEstudiante + ", edad="
				+ edad + ", idCurso=" + idCurso + ", calificaciones=" + calificaciones + "]";
	}
	
	
}
