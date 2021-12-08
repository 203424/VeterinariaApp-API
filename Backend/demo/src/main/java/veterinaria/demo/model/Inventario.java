package veterinaria.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario{

    @Id
    private Long idMedicamento;

    @Column
    private String nombreMed;

    @Column
    private String sustanciaAct;
   

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public String getSustanciaAct() {
        return sustanciaAct;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public void setNombreMed(String nombreMed){
        this.nombreMed = nombreMed;
    }

    public void setSustanciaAct(String sustanciaAct){
        this.sustanciaAct = sustanciaAct;
    }
}
