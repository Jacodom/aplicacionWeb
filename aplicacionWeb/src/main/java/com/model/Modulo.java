package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the modulos database table.
 * 
 */
@Entity
@Table(name="modulos")
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_modulo")
	private String idModulo;

	@Column(name="descripcion_modulo")
	private String descripcionModulo;

	//bi-directional many-to-one association to Formulario
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="modulo")
	private Set<Formulario> formularios=new HashSet<Formulario>();

	public String getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}

	public String getDescripcionModulo() {
		return this.descripcionModulo;
	}

	public void setDescripcionModulo(String descripcionModulo) {
		this.descripcionModulo = descripcionModulo;
	}
	
	Set<Formulario> getFormularios() {
		return this.formularios;
	}

	void setFormularios(HashSet<Formulario> formularios) {
		this.formularios = formularios;
	}

	public void addFormulario(Formulario formulario) {
		this.formularios.add(formulario);
	}

	public void removeFormulario(Formulario formulario) {
		this.formularios.remove(formulario);
	}
	
	public Modulo() {
	}
	
	//hascode() and equals() implementations
		@Override
		public boolean equals(Object objeto){
			if (this == objeto) return true;
	        if ( !(objeto instanceof Modulo) ) return false;

	        final Modulo modulo = (Modulo) objeto;

	        if ( !modulo.getIdModulo().equals( this.getIdModulo() ) ) return false;
	        if ( !modulo.getDescripcionModulo().equals( this.getDescripcionModulo() ) ) return false;

	        return true;
		} 
		
		@Override
		public int hashCode(){
			int result;
	        result = this.getIdModulo().hashCode();
	        result = 100 * result + this.getDescripcionModulo().hashCode();
	        return result;
		}

}