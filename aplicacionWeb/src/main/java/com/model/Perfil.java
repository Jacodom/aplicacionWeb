package com.model;

import java.io.Serializable;

import javax.persistence.*;


import java.util.Date;


/**
 * The persistent class for the perfiles database table.
 * 
 */
@Entity
@Table(name="perfiles")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_perfil")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;

	@Column(name="fecha_auditoria")
	private Date fechaAuditoria;

	//bi-directional one-to-many association to Usuario
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Usuario usuario;

	//bi-directional many-to-one association to Formulario
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Formulario formulario;

	//bi-directional many-to-one association to Grupo
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Grupo grupo;

	//bi-directional many-to-one association to Permiso
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Permiso permiso;

	public int getIdPerfil() {
		return this.idPerfil;
	}

	private String accion;
	
	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Date getFechaAuditoria() {
		return this.fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario=usuario;
	}

	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Perfil() {
	}
	
	//hascode() and equals() implementations
	@Override
	public boolean equals(Object objeto){
		if (this == objeto) return true;
        if ( !(objeto instanceof Perfil) ) return false;

        final Perfil perfil = (Perfil) objeto;

        if ( perfil.getIdPerfil()!=this.getIdPerfil() ) return false;

        return true;
	} 
	
	@Override
	public int hashCode(){
		int result;
        result = getIdPerfil();
        return result;
	}

}