package org.example.Modelo;

import java.util.Date;

public class T_Registro extends EntidadeBase{

    private int id_cordeiro;
    private int mae_brinco;
    private Date data_Nascimento;
    private double peso_Nascimento;
    private String raca;

    public T_Registro() {
    }

    public T_Registro(int id_cordeiro) {
        super(id_cordeiro);
    }

    public T_Registro(int id_cordeiro, int mae_brinco, Date data_Nascimento, double peso_Nascimento, String raca) {
        this.id_cordeiro = id_cordeiro;
        this.mae_brinco = mae_brinco;
        this.data_Nascimento = data_Nascimento;
        this.peso_Nascimento = peso_Nascimento;
        this.raca = raca;
    }

    public T_Registro(int id_cordeiro, int id_cordeiro1, int mae_brinco, Date data_Nascimento, double peso_Nascimento, String raca) {
        super(id_cordeiro);
        this.id_cordeiro = id_cordeiro1;
        this.mae_brinco = mae_brinco;
        this.data_Nascimento = data_Nascimento;
        this.peso_Nascimento = peso_Nascimento;
        this.raca = raca;
    }

    @Override
    public int getId_cordeiro() {
        return id_cordeiro;
    }

    @Override
    public void setId_cordeiro(int id_cordeiro) {
        this.id_cordeiro = id_cordeiro;
    }

    public int getMae_brinco() {
        return mae_brinco;
    }

    public void setMae_brinco(int mae_brinco) {
        this.mae_brinco = mae_brinco;
    }

    public Date getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public double getPeso_Nascimento() {
        return peso_Nascimento;
    }

    public void setPeso_Nascimento(double peso_Nascimento) {
        this.peso_Nascimento = peso_Nascimento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id_cordeiro=" + id_cordeiro +
                ", mae_brinco=" + mae_brinco +
                ", data_Nascimento=" + data_Nascimento +
                ", peso_Nascimento=" + peso_Nascimento +
                ", raca='" + raca + '\'' +
                ", id_cordeiro=" + id_cordeiro +
                '}';
    }
}
