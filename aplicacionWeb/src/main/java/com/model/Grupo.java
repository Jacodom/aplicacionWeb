package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


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
	
	public String getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}

	@Column(name="descripcion_grupo")
	private String descripcionGrupo;
	
	public String getDescripcionGrupo() {
		return this.descripcionGrupo;
	}

	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}

	@Column(name="estado_grupo")
	private boolean estadoGrupo;
	
	public boolean getEstadoGrupo() {
		return this.estadoGrupo;
	}

	public void setEstadoGrupo(Boolean estadoGrupo) {
		this.estadoGrupo = estadoGrupo;
	}

	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="grupo")
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
	
	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="grupos")
	private Set<Usuario> usuarios= new HashSet<Usuario>();
	
	Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	void setUsuarios(HashSet<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void addUsuario(Usuario usuario){
		this.usuarios.add(usuario);
		usuario.addGrupo(this);
	}
	
	public void delUsuario(Usuario usuario){
		this.usuarios.remove(usuario);
		usuario.delGrupo(this);
	}
	

	public Grupo() {
	}
	
	//hascode() and equals() implementations
		@Override
		public boolean equals(Object objeto){
			if (this == objeto) return true;
	        if ( !(objeto instanceof Grupo) ) return false;

	        final Grupo grupo = (Grupo) objeto;

	        if ( !grupo.getIdGrupo().equals( this.getIdGrupo() ) ) return false;
	        if ( !grupo.getDescripcionGrupo().equals( this.getDescripcionGrupo() ) ) return false;

	        return true;
		} 
		
		@Override
		public int hashCode(){
			int result;
	        result = this.getIdGrupo().hashCode();
	        result = 100 * result + this.getDescripcionGrupo().hashCode();
	        return result;
		}

}