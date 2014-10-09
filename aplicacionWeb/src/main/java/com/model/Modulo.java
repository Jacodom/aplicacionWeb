package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


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

	@Column(name="descripcion_modulo")
	private String descripcionModulo;

	//bi-directional many-to-one association to Formulario
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="modulo")
	private List<Formulario> formularios=new ArrayList<Formulario>();

	public Modulo() {
	}

	public String getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}

	public String getDescripcionModulo() {
		return this.descripcionModulo;
	}

	public void setDescripcionModulo(String descripcionModulo) {
		this.descripcionModulo = descripcionModulo;
	}

	public List<Formulario> getFormularios() {
		return this.formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}

	public void addFormulario(Formulario formulario) {
		this.formularios.add(formulario);
	}

	public void removeFormulario(Formulario formulario) {
		this.formularios.remove(formulario);
	}

}