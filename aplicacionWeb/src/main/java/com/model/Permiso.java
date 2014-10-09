package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


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

	public String getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(String idPermiso) {
		this.idPermiso = idPermiso;
	}
	
	@Column(name="descripcion_permiso")
	private String descripcionPermiso;

	public String getDescripcionPermiso() {
		return this.descripcionPermiso;
	}

	public void setDescripcionPermiso(String descripcionPermiso) {
		this.descripcionPermiso = descripcionPermiso;
	}
	
	//bi-directional many-to-many association to Formulario
	@ManyToMany(mappedBy="permisos")
	private Set<Formulario> formularios=new HashSet<Formulario>();

	Set<Formulario> getFormularios() {
		return this.formularios;
	}

	void setFormularios(HashSet<Formulario> formularios) {
		this.formularios = formularios;
	}
	
	public void addFormulario(Formulario formulario){
		this.formularios.add(formulario);
		formulario.addPermiso(this);
	}
	
	//bi-directional many-to-one association to Perfiles
	@OneToMany(mappedBy="permiso")
	private Set<Perfil> perfiles =  new HashSet<Perfil>();

	
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
	
	public Permiso() {
	}
	
	//hascode() and equals() implementations
	@Override
	public boolean equals(Object objeto){
		if (this == objeto) return true;
        if ( !(objeto instanceof Permiso) ) return false;

        final Permiso permiso = (Permiso) objeto;

        if ( !permiso.getIdPermiso().equals( this.getIdPermiso() ) ) return false;
        if ( !permiso.getDescripcionPermiso().equals( this.getDescripcionPermiso() ) ) return false;

        return true;
	} 
	
	@Override
	public int hashCode(){
		int result;
        result = this.getIdPermiso().hashCode();
        result = 100 * result + this.getDescripcionPermiso().hashCode();
        return result;
	}

}