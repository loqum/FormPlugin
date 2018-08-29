package com.fihoca.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Data;

@Data
@ManagedBean(name = "alumno")
@RequestScoped
public class AlumnoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idAlumno;
	private String nombre;
	private String apellidos;
	private String dni;

	public AlumnoBean() {

	}

	public AlumnoBean(int idAlumno, String nombre, String apellidos, String dni) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	public String add() {
		System.out.println("Entra dentro del método add");
		
		return "view";
	}
	

}
