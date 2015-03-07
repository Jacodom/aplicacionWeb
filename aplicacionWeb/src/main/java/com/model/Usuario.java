package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Collections;
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
	@Column(name="id_usuario",unique=true,updatable=false)
	private String idUsuario;

	@Column(name="clave_usuario")
	private String claveUsuario;

	@Column(name="email_usuario")
	private String emailUsuario;

	@Column(name="estado_usuario")
	private boolean estadoUsuario;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	//bi-directional many-to-many association to Grupo
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Grupo> grupos=new HashSet<Grupo>();


	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="usuario")
	private Set<Perfil> perfiles= new HashSet<Perfil>();
	
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

	public boolean getEstadoUsuario() {
		return this.estadoUsuario;
	}

	public void setEstadoUsuario(boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Set<Grupo> getGrupos() {
		return this.grupos;
	}
	
	//grupos visibles
	public Set<Grupo>getColeccionGrupos(){
		return Collections.unmodifiableSet(grupos);
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}	
	
	public void addGrupo(Grupo grupo){
		this.grupos.add(grupo);
	}
	
	public void delGrupo(Grupo grupo){
		this.grupos.remove(grupo);
	}
	
	public Usuario() {
	}

	Set<Perfil> getPerfiles(){
		return this.perfiles;
	}
	
	void setPerfiles(HashSet<Perfil> perfiles){
		this.perfiles=perfiles;
	}
	
	public void addPerfil(Perfil perfil){
		this.perfiles.add(perfil);
	}
	
	
	//hascode() and equals() implementations
	@Override
	public boolean equals(Object objeto){
		if (this == objeto) return true;
        if ( !(objeto instanceof Usuario) ) return false;

        final Usuario usuario = (Usuario) objeto;

        if ( !usuario.getIdUsuario().equals( this.getIdUsuario() ) ) return false;
        if ( !usuario.getEmailUsuario().equals( this.getEmailUsuario() ) ) return false;

        return true;
	} 
	
	@Override
	public int hashCode(){
		int result;
        result = this.getEmailUsuario().hashCode();
        result = 100 * result + this.getIdUsuario().hashCode();
        return result;
	}
	
	
}