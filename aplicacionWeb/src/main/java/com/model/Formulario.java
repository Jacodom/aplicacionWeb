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

	@Column(name="descripcion_formulario")
	private String descripcionFormulario;

	@Column(name="estado_formulario")
	private boolean estadoFormulario;

	@Column(name="nombre_formulario")
	private String nombreFormulario;

	//bi-directional many-to-one association to Modulo
	@ManyToOne
	private Modulo modulo;

	//bi-directional many-to-many association to Permiso
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Permiso> permisos= new HashSet<Permiso>();

	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="formulario")
	private Set<Perfil> perfiles= new HashSet<Perfil>();

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
	
	public boolean getEstadoFormulario() {
		return this.estadoFormulario;
	}

	public void setEstadoFormulario(boolean estadoFormulario) {
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

	Set<Permiso> getPermisos() {
		return this.permisos;
	}

	void setPermisos(HashSet<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	public void addPermiso(Permiso permiso){
		this.permisos.add(permiso);
	}

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
	
	//hascode() and equals() implementations
		@Override
		public boolean equals(Object objeto){
			if (this == objeto) return true;
	        if ( !(objeto instanceof Formulario) ) return false;

	        final Formulario formulario = (Formulario) objeto;

	        if ( !formulario.getIdFormulario().equals( this.getIdFormulario() ) ) return false;
	        if ( !formulario.getDescripcionFormulario().equals( this.getDescripcionFormulario() ) ) return false;

	        return true;
		} 
		
		@Override
		public int hashCode(){
			int result;
	        result = this.getIdFormulario().hashCode();
	        result = 100 * result + this.getDescripcionFormulario().hashCode();
	        return result;
		}

}