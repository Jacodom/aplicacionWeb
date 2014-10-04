package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private String idUsuario;

	@Column(name="clave_usuario")
	private String claveUsuario;

	@Column(name="email_usuario")
	private String emailUsuario;

	@Column(name="estado_usuario")
	private byte estadoUsuario;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	//bi-directional many-to-many association to Grupo
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Grupo> grupos=new ArrayList<Grupo>();

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public byte getEstadoUsuario() {
		return this.estadoUsuario;
	}

	public void setEstadoUsuario(byte estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}	
	
	public void addGrupo(Grupo grupo){
		this.grupos.add(grupo);
	}
}