package com.sinensia.dto;

import java.util.Objects;

/**
 * Clase que utilizamos para mapear nuestro recurso del microservicio Curso
 * 
 * @see com.sinensia.service.CursoService
 * @see com.sinensia.service.CursoServiceImpl
 * @see com.sinensia.controller.CursoController
 */
public class CursoDto {

	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;
	private String disponibilidad;
	private int plazas;

	public CursoDto() {
	}

	/**
	 * 
	 * @param nombre
	 * @param duracion
	 * @param precio
	 * @param disponibilidad
	 * @param plazas
	 */
	public CursoDto(String nombre, int duracion, double precio, String disponibilidad, int plazas) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
		this.plazas = plazas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disponibilidad, duracion, idCurso, nombre, plazas, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoDto other = (CursoDto) obj;
		return Objects.equals(disponibilidad, other.disponibilidad) && duracion == other.duracion
				&& idCurso == other.idCurso && Objects.equals(nombre, other.nombre) && plazas == other.plazas
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return "CursoDto [idCurso=" + idCurso + ", nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio
				+ ", disponibilidad=" + disponibilidad + ", plazas=" + plazas + "]";
	}

}
