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

	@Column(name="fecha_auditoria")
	private Date fechaAuditoria;
	
	public Date getFechaAuditoria() {
		return this.fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	//bi-directional one-to-many association to Usuario
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Usuario usuario;
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario=usuario;
	}

	//bi-directional many-to-one association to Formulario
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Formulario formulario;
	
	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	//bi-directional many-to-one association to Grupo
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Grupo grupo;
	
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	//bi-directional many-to-one association to Permiso
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Permiso permiso;
	
	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Perfil() {
	}

}