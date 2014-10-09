package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the formularios database table.
 * 
 */
@Entity
@Table(name="formularios")
@NamedQuery(name="Formulario.findAll", query="SELECT f FROM Formulario f")
public class Formulario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_formulario")
	private String idFormulario;

	public String getIdFormulario() {
		return this.idFormulario;
	}

	public void setIdFormulario(String idFormulario) {
		this.idFormulario = idFormulario;
	}
	
	@Column(name="descripcion_formulario")
	private String descripcionFormulario;

	public String getDescripcionFormulario() {
		return this.descripcionFormulario;
	}

	public void setDescripcionFormulario(String descripcionFormulario) {
		this.descripcionFormulario = descripcionFormulario;
	}
	
	@Column(name="estado_formulario")
	private boolean estadoFormulario;
	
	public boolean getEstadoFormulario() {
		return this.estadoFormulario;
	}

	public void setEstadoFormulario(boolean estadoFormulario) {
		this.estadoFormulario = estadoFormulario;
	}

	@Column(name="nombre_formulario")
	private String nombreFormulario;

	public String getNombreFormulario() {
		return this.nombreFormulario;
	}

	public void setNombreFormulario(String nombreFormulario) {
		this.nombreFormulario = nombreFormulario;
	}
	
	//bi-directional many-to-one association to Modulo
	@ManyToOne
	private Modulo modulo;
	
	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	//bi-directional many-to-many association to Permiso
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Permiso> permisos= new HashSet<Permiso>();

	Set<Permiso> getPermisos() {
		return this.permisos;
	}

	void setPermisos(HashSet<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	public void addPermiso(Permiso permiso){
		this.permisos.add(permiso);
	}
	
	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="formulario")
	private Set<Perfil> perfiles= new HashSet<Perfil>();

	Set<Perfil> getPerfiles() {
		return this.perfiles;
	}

	void setPerfiles(HashSet<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public void addPerfil(Perfil perfil) {
		this.perfiles.add(perfil);
	}

	public void removePerfil(Perfil perfil) {
		this.perfiles.remove(perfil);
	}
	
	public Formulario() {
	}

}