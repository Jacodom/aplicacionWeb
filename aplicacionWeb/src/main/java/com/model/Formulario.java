package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	@Column(name="descripcion_formulario")
	private String descripcionFormulario;

	@Column(name="estado_formulario")
	private byte estadoFormulario;

	@Column(name="nombre_formulario")
	private String nombreFormulario;

	//bi-directional many-to-one association to Modulo
	@ManyToOne
	private Modulo modulo;

	//bi-directional many-to-many association to Permiso
	@ManyToMany
	@JoinTable(
		name="formularios_permisos"
		, joinColumns={
			@JoinColumn(name="id_formulario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_permiso")
			}
		)
	private List<Permiso> permisos;

	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="formulario")
	private List<Perfil> perfiles;

	public Formulario() {
	}

	public String getIdFormulario() {
		return this.idFormulario;
	}

	public void setIdFormulario(String idFormulario) {
		this.idFormulario = idFormulario;
	}

	public String getDescripcionFormulario() {
		return this.descripcionFormulario;
	}

	public void setDescripcionFormulario(String descripcionFormulario) {
		this.descripcionFormulario = descripcionFormulario;
	}

	public byte getEstadoFormulario() {
		return this.estadoFormulario;
	}

	public void setEstadoFormulario(byte estadoFormulario) {
		this.estadoFormulario = estadoFormulario;
	}

	public String getNombreFormulario() {
		return this.nombreFormulario;
	}

	public void setNombreFormulario(String nombreFormulario) {
		this.nombreFormulario = nombreFormulario;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<Permiso> getPermisos() {
		return this.permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public List<Perfil> getPerfiles() {
		return this.perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfiles().add(perfil);
		perfil.setFormulario(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfiles().remove(perfil);
		perfil.setFormulario(null);

		return perfil;
	}

}