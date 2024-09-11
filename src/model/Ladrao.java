package model;

public class Ladrao extends Pessoa {
    private String planoDeFuga;

    public Ladrao() {
    }

    public Ladrao(String nome, String cabelo, String olho, String pele, boolean sexo, String planoDeFuga) {
        super(nome, cabelo, olho, pele, sexo);
        this.planoDeFuga = planoDeFuga;
    }

    public String getPlanoDeFuga() {
        return planoDeFuga;
    }

    public void setPlanoDeFuga(String planoDeFuga) {
        this.planoDeFuga = planoDeFuga;
    }

    @Override
    public String toString() {
        return "Ladrao [planoDeFuga = " + getPlanoDeFuga() + ", nome = "
                + getNome() + ", cabelo = " + getCabelo() + ", olho = " + getOlho() + ", pele = " + getPele()
                + ", sexo = " + isSexo() + ", pontosDeVida = " + getPontosDeVida() + "]";
    }

    public String fugir() {
        return "Dar no pé!";
    }

    public String roubar() {
        return "Arrastão!";
    }
}
