package veterinaria.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota{

	@Id
	private Long idMascota;
	
	@Column
	private int idDuenio;
	
	@Column
	private String tipo;

	@Column
	private int idTipoMascota;
	
	@Column
	private String nombre;

	@Column
	private String fechaIngreso;

	@Column
	private String motivoIngreso;
	
	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdDuenio(int idDuenio) {
		this.idDuenio = idDuenio;
	}

	public int getIdDuenio() {
		return idDuenio;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
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
	public int getIdTipoMascota() {
		return idTipoMascota;
	}
	public void setIdTipoMascota(int idTipoMascota) {
		this.idTipoMascota = idTipoMascota;
	}

}