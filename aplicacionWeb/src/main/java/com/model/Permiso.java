package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the permisos database table.
 * 
 */
@Entity
@Table(name="permisos")
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permiso")
	private String idPermiso;

	@Column(name="descripcion_permiso")
	private String descripcionPermiso;

	//bi-directional many-to-many association to Formulario
	@ManyToMany(mappedBy="permisos")
	private List<Formulario> formularios=new ArrayList<Formulario>();

	//bi-directional many-to-one association to Perfiles
	@OneToMany(mappedBy="permiso")
	private List<Perfil> perfiles =  new ArrayList<Perfil>();

	public Permiso() {
	}

	public String getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(String idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getDescripcionPermiso() {
		return this.descripcionPermiso;
	}

	public void setDescripcionPermiso(String descripcionPermiso) {
		this.descripcionPermiso = descripcionPermiso;
	}

	public List<Formulario> getFormularios() {
		return this.formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}

	public List<Perfil> getPerfiles() {
		return this.perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public void addPerfil(Perfil perfil) {
		this.perfiles.add(perfil);
	}

	public void removePerfil(Perfil perfil) {
		this.perfiles.remove(perfil);
	}

}