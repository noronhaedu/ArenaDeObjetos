package model;

public class Ladrao extends Pessoa {
    private String planoDeFuga;

    public Ladrao() {
    }

    public Ladrao(int id, String nome, String cabelo, String olho, String pele, boolean sexo, int pontosDeVida,
            String planoDeFuga) {
        super(id, nome, cabelo, olho, pele, sexo, pontosDeVida);
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
        return "Ladrao [planoDeFuga=" + planoDeFuga + ", fugir()=" + fugir() + ", getId()=" + getId() + ", roubar()="
                + roubar() + ", getNome()=" + getNome() + ", getCabelo()=" + getCabelo() + ", getOlho()=" + getOlho()
                + ", getPele()=" + getPele() + ", isSexo()=" + isSexo() + ", getPontosDeVida()=" + getPontosDeVida()
                + "]";
    }

    public String fugir() {
        return "Dar no pé!";
    }

    public String roubar() {
        return "Arrastão!";
    }
}
