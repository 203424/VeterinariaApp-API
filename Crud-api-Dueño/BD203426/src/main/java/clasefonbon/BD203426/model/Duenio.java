package clasefonbon.BD203426.model;

import javax.persistence.*;


@Entity
public class Duenio {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDuenio;

    @Column
    private String nombreDuenio;

    @Column
    private String direccion;

    @Column
    private int numTelefono;

    @Column
    private int cantMascotas;

    public Duenio(int id_duenio, String nombre_duenio, String direccion, int num_telefono, int cant_mascotas){
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

    public int getNumTelefono() {
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

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }
}
