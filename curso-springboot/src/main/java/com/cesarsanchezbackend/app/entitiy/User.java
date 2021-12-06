package com.cesarsanchezbackend.app.entitiy;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name = "users")
public class User  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -917306463281045439L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int idDuenio;
	
	@Column
	private String idTipoMascota;
	
	@Column
	private String nombre;

	@Column
	private String fechaIngreso;

	@Column
	private String motivoIngreso;
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setIdDuenio(int idDuenio) {
		this.idDuenio = idDuenio;
	}

	public int getIdDuenio() {
		return idDuenio;
	}

	public void setIdTipoMascota(String idTipoMascota) {
		this.idTipoMascota = idTipoMascota;
	}

	public String getIdTipoMascota() {
		return idTipoMascota;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setMotivoIngreso(String motivoIngreso) {
		this.motivoIngreso = motivoIngreso;
	}

	public String getMotivoIngreso() {
		return motivoIngreso;
	}
	
	

}
