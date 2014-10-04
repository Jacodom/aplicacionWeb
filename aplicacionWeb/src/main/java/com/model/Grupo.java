package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupos database table.
 * 
 */
@Entity
@Table(name="grupos")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_grupo")
	private String idGrupo;

	@Column(name="descripcion_grupo")
	private String descripcionGrupo;

	@Column(name="estado_grupo")
	private byte estadoGrupo;

	//bi-directional many-to-one association to Perfile
	@OneToMany(mappedBy="grupo")
	private List<Perfil> perfiles;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="grupos")
	private List<Usuario> usuarios;

	public Grupo() {
	}

	public String getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getDescripcionGrupo() {
		return this.descripcionGrupo;
	}

	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}

	public byte getEstadoGrupo() {
		return this.estadoGrupo;
	}

	public void setEstadoGrupo(byte estadoGrupo) {
		this.estadoGrupo = estadoGrupo;
	}

	public List<Perfil> getPerfiles() {
		return this.perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public Perfil addPerfile(Perfil perfile) {
		getPerfiles().add(perfile);
		perfile.setGrupo(this);

		return perfile;
	}

	public Perfil removePerfile(Perfil perfile) {
		getPerfiles().remove(perfile);
		perfile.setGrupo(null);

		return perfile;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}