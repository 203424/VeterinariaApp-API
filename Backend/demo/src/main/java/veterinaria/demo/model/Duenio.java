package veterinaria.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "duenio")
public class Duenio {

    @Id
    private int idDuenio;

    @Column
    private String nombreDuenio;

    @Column
    private String direccion;

    @Column
    private Long numTelefono;

    @Column
    private int cantMascotas;

    public Duenio(int id_duenio, String nombre_duenio, String direccion, Long num_telefono, int cant_mascotas){
        this.idDuenio = id_duenio;
        this.nombreDuenio=nombre_duenio;
        this.direccion=direccion;
        this.numTelefono=num_telefono;
        this.cantMascotas=cant_mascotas;
    }


    public Duenio() {

    }

    public String getDireccion() {
        return direccion;
    }

    public int getCantMascotas() {
        return cantMascotas;
    }

    public Long getNumTelefono() {
        return numTelefono;
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCantMascotas(int cantMascotas) {
        this.cantMascotas = cantMascotas;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public void setNumTelefono(Long numTelefono) {
        this.numTelefono = numTelefono;
    }
}
