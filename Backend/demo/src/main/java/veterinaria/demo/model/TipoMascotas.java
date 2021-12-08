package veterinaria.demo.model;



import javax.persistence.*;

@Entity
@Table(name = "tipo_mascota")
public class TipoMascotas  {
    @Id
    @Column(name = "id_tipo_mascota")
    private int idTipoMascota;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "raza")
    private String raza;


    public TipoMascotas(int id, String raza, String tipo) {
        this.idTipoMascota = id;
        this.raza = raza;
        this.tipo = tipo;

    }
    
    public TipoMascotas() {
    }

    public int getIdTipoMascota() {
        return idTipoMascota;
    }

    public void setIdTipoMascota(int idTipoMascota) {
        this.idTipoMascota = idTipoMascota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }



}