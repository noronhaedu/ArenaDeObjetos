package model;

public class Guerreiro extends Pessoa {
    private String armamento;

    public Guerreiro() {
    }

    public Guerreiro(String nome, String cabelo, String olho, String pele, boolean sexo, String armamento) {
        super(nome, cabelo, olho, pele, sexo);
        this.armamento = armamento;
    }

    public String getArmamento() {
        return armamento;
    }

    public void setArmamento(String armamento) {
        this.armamento = armamento;
    }

    @Override
    public String toString() {
        return "Guerreiro [armamento = " + getArmamento() + ", nome = " + getNome()
                + ", cabelo = " + getCabelo() + ", olho =" + getOlho() + ", pele = " + getPele()
                + ", sexo = " + isSexo() + ", pontosDeVida = " + getPontosDeVida() + "]";
    }

    public void atacar() {
        this.dano(10);
    }
}
