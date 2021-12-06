package veterinaria.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMedicamento;
    private String nombreMed;
    private String sustanciaAct;

    public Inventario(int idMedicamento, String nombreMed, String sustanciaAct){
        super();
        this.idMedicamento=idMedicamento;
        this.nombreMed=nombreMed;
        this.sustanciaAct=sustanciaAct;
    }


    public Inventario() {

    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public String getSustanciaAct() {
        return sustanciaAct;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public void setNombreMed(String nombreMed){
        this.nombreMed = nombreMed;
    }

    public void setSustanciaAct(String sustanciaAct){
        this.sustanciaAct = sustanciaAct;
    }
}
