package Bautista.Mascotas.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascotas implements Serializable {
    @Id
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "caracteristicas")
    private String caracteristicas;

    public Mascotas(int id, String tipo, String nombre, String caracteristicas) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
    }

    public Mascotas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}