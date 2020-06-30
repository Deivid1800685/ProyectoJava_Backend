package com.fcfm.ProyectoJavaBack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name = "materia")
public class Materia {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotBlank
	 @Column(unique = true)
	 private String nombreMateria;
	 @NotNull
	 @Column(unique = true)
	 private int clave;
	 @NotBlank
	 private String estatus;
	
	 public Materia() {}
	 
	 public Materia(String nomnreMateria, int clave, String estatus) {
		 this.nombreMateria = nombreMateria;
		 this.clave = clave;
		 this.estatus = estatus;
	 }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	 
	 
	 
}
