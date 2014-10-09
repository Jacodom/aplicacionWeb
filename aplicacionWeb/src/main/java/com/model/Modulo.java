package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the modulos database table.
 * 
 */
@Entity
@Table(name="modulos")
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_modulo")
	private String idModulo;
	
	public String getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}

	@Column(name="descripcion_modulo")
	private String descripcionModulo;
	
	public String getDescripcionModulo() {
		return this.descripcionModulo;
	}

	public void setDescripcionModulo(String descripcionModulo) {
		this.descripcionModulo = descripcionModulo;
	}

	//bi-directional many-to-one association to Formulario
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="modulo")
	private Set<Formulario> formularios=new HashSet<Formulario>();

	Set<Formulario> getFormularios() {
		return this.formularios;
	}

	void setFormularios(HashSet<Formulario> formularios) {
		this.formularios = formularios;
	}

	public void addFormulario(Formulario formulario) {
		this.formularios.add(formulario);
	}

	public void removeFormulario(Formulario formulario) {
		this.formularios.remove(formulario);
	}
	
	public Modulo() {
	}

}