package equipoBD.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cita")
public class Cita  {

    

    @Id
    private Long idCita;

    @Column
    private String fechaCita;

    @Column
    private String horaCita;

    @Column
    private String servicio;
    
    @Column
    private String idDuenio;

    public String getIdDuenio() {
        return idDuenio;
    }

    public Long getIdCita() {
        return idCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public String getServicio() {
        return servicio;
    }
    public void setIdDuenio(String idDuenio) {
        this.idDuenio = idDuenio;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}
