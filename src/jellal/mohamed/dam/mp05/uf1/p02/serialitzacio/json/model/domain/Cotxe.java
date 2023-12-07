package jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.domain;

import java.io.Serializable;

public class Cotxe implements Serializable {

    private static final long serialVersionUID = 1L;

    private String matricula;
    private String marca;
    private String model;
    private String numeroBastidor;

    public Cotxe() {
    }

    public Cotxe(String matricula, String marca, String model, String numeroBastidor) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.numeroBastidor = numeroBastidor;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumeroBastidor() {
        return numeroBastidor;
    }

    public void setNumeroBastidor(String numeroBastidor) {
        this.numeroBastidor = numeroBastidor;
    }

    @Override
    public String toString() {
        return "Cotxe [matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", numeroBastidor=" + numeroBastidor + "]";
    }
}
