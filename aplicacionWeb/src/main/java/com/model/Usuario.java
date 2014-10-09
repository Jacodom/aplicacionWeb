package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


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
	
	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name="clave_usuario")
	private String claveUsuario;
	
	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	@Column(name="email_usuario")
	private String emailUsuario;
	
	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	@Column(name="estado_usuario")
	private boolean estadoUsuario;

	public boolean getEstadoUsuario() {
		return this.estadoUsuario;
	}

	public void setEstadoUsuario(boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	//bi-directional many-to-many association to Grupo
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Grupo> grupos=new HashSet<Grupo>();

	Set<Grupo> getGrupos() {
		return this.grupos;
	}

	void setGrupos(HashSet<Grupo> grupos) {
		this.grupos = grupos;
	}	
	
	public void addGrupo(Grupo grupo){
		this.grupos.add(grupo);
	}
	
	public Usuario() {
	}
	
	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="usuario")
	private Set<Perfil> perfiles= new HashSet<Perfil>();
	
	Set<Perfil> getPerfiles(){
		return this.perfiles;
	}
	
	void setPerfiles(HashSet<Perfil> perfiles){
		this.perfiles=perfiles;
	}
	
	public void addPerfil(Perfil perfil){
		this.perfiles.add(perfil);
	}
	
	
}