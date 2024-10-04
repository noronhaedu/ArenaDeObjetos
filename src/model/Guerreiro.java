package model;

public class Guerreiro extends Pessoa {
    private String armamento;

    public Guerreiro() {
    }

    public Guerreiro(int id, String nome, String cabelo, String olho, String pele, boolean sexo, int pontosDeVida,
            String armamento) {
        super(id, nome, cabelo, olho, pele, sexo, pontosDeVida);
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
        return "Guerreiro [armamento=" + armamento + ", getId()=" + getId() + ", getNome()=" + getNome()
                + ", getCabelo()=" + getCabelo() + ", getOlho()=" + getOlho() + ", getPele()=" + getPele()
                + ", isSexo()=" + isSexo() + ", getPontosDeVida()=" + getPontosDeVida() + "]";
    }

    public void atacar() {
        this.dano(10);
    }
}
