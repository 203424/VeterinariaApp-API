package Bautista.tipoMascota.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tipoMascota")
public class TipoMascota {
    @Id
    @Column
    private String tipoMascota;

    @Column
    private String caracteristicas;

    public TipoMascota(String tipoMascota, String caracteristicas) {
        this.tipoMascota = tipoMascota;
        this.caracteristicas = caracteristicas;
    }

    public TipoMascota() {

    }

    public String getTipoMascota() {
        return this.tipoMascota;
    }

    public void settipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getCaracteristicas() {
        return this.caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}