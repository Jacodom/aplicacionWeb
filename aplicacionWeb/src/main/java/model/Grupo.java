package model;

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
	private List<Perfile> perfiles;

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

	public List<Perfile> getPerfiles() {
		return this.perfiles;
	}

	public void setPerfiles(List<Perfile> perfiles) {
		this.perfiles = perfiles;
	}

	public Perfile addPerfile(Perfile perfile) {
		getPerfiles().add(perfile);
		perfile.setGrupo(this);

		return perfile;
	}

	public Perfile removePerfile(Perfile perfile) {
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