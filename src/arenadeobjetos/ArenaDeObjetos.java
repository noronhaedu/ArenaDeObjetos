package arenadeobjetos;

import java.util.ArrayList;
import java.util.Scanner;

import model.Guerreiro;
import model.Ladrao;
import model.Pessoa;
import servicos.ServicosFactory;
import servicos.VitimaServicos;

public class ArenaDeObjetos {
    static Scanner ler = new Scanner(System.in);
    static int opMP;
    static ArrayList<Guerreiro> guerreiros = new ArrayList<>();
    static ArrayList<Ladrao> ladroes = new ArrayList<>();
    static ArrayList<Pessoa> vitimas = new ArrayList<>();

    private static int opSM;

    public static int lerInt() {
        Scanner leia = new Scanner(System.in);
        int num = 99;
        try {
            num = leia.nextInt();
        } catch (Exception e) {
            System.out.print("Tente novamente: ");
            lerInt();
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("-- Arena de Objetos --");
        do {
            menuP();
            subMenuP(opMP);
        } while (opMP != 0);
    }// fim main

    public static void menuP() {// menu principal

        String menu = "1 - Criar Personagem"
                + "\n2 - Listar Personagens"
                + "\n3 - Batalha"
                + "\n0 - Sair do Jogo"
                + "\nDigite a opção: ";

        System.out.print(menu);
        opMP = lerInt();
    }// fim menu

    public static void subMenuP(int omP) {
        System.out.println("\n-- SubMenu--");
        switch (omP) {
            case 1:
                System.out.print("1 - Guerreiro"
                        + "\n2 - Ladrão"
                        + "\n3 - Vítima"
                        + "\nDigite a opção: ");
                int opSB = lerInt();
                criarPersona(opSB);
                break;
            case 2:
                System.out.print("Lista de Personagens: ");
                System.out.println(guerreiros.toString() + "\n" + ladroes.toString() + "\n" + vitimas.toString());
                System.out.println("--Lista bonita--\n");
                for (Guerreiro g : guerreiros) {
                    System.out.println(g.getNome());
                    System.out.println("\tPontos de Vida: " + g.getPontosDeVida());
                    System.out.println("\tArmamento: " + g.getArmamento());
                    System.out.println("\tSexo: " + g.isSexo());
                    System.out.println("\tCor da pele: " + g.getPele());
                    System.out.println("\tCor dos olhos: " + g.getOlho());
                    System.out.println("\tCor do cabelo: " + g.getCabelo());
                }
                for (Ladrao l : ladroes) {
                    System.out.println(l.getNome());
                    System.out.println("\tPontos de Vida: " + l.getPontosDeVida());
                    System.out.println("\tSexo: " + l.isSexo());
                    System.out.println("\tCor da pele: " + l.getPele());
                    System.out.println("\tCor dos olhos: " + l.getOlho());
                    System.out.println("\tCor do cabelo: " + l.getCabelo());
                }
                for (Pessoa v : vitimas) {
                    System.out.println(v.getNome());
                    System.out.println("\tPontos de Vida: " + v.getPontosDeVida());
                    System.out.println("\tSexo: " + v.isSexo());
                    System.out.println("\tCor da pele: " + v.getPele());
                    System.out.println("\tCor dos olhos: " + v.getOlho());
                    System.out.println("\tCor do cabelo: " + v.getCabelo());
                }
                break;
            case 3:
                break;
            case 0:
                System.out.println("Arena de Objetos encerrada pelo usuário!");
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
                break;
        }// fim s

    }// fim void submenu

    private static void criarPersona(int opSM) {
        switch (opSM) {
            case 1:
                System.out.println("Criar Guerreiro!");
                Guerreiro g = new Guerreiro();
                System.out.print("Informe o nome do Guerreiro: ");
                g.setNome(ler.nextLine());
                System.out.print("Informe a cor do olho: ");
                g.setOlho(ler.nextLine());
                System.out.print("Informe a cor do cabelo: ");
                g.setCabelo(ler.nextLine());
                System.out.print("Informe a cor da pele: ");
                g.setPele(ler.nextLine());
                System.out.print("Informe o sexo: "
                        + "\n0 - Feminino"
                        + "\n1 - Masculino"
                        + "\nDigite aqui: ");

                int sexoInt = lerInt();
                boolean sexo;
                if (sexoInt == 0) {
                    sexo = false;// masculino
                } else {
                    sexo = true;// feminino
                }
                g.setSexo(sexo);
                System.out.print("Informe o armamento: ");
                g.setArmamento(ler.nextLine());
                guerreiros.add(g);
                break;
            case 2:
                // System.out.println(guerreiros.toString());
                System.out.println("Criar Ladrão!");
                Ladrao l = new Ladrao();
                System.out.print("Informe o nome do Ladrão: ");
                l.setNome(ler.nextLine());
                System.out.print("Informe a cor do olho: ");
                l.setOlho(ler.nextLine());
                System.out.print("Informe a cor do cabelo: ");
                l.setCabelo(ler.nextLine());
                System.out.print("Informe a cor da pele: ");
                l.setPele(ler.nextLine());
                System.out.print("Informe o sexo: "
                        + "\n0 - Feminino"
                        + "\n1 - Masculino"
                        + "\nDigite aqui: ");

                int sexoIntL = lerInt();
                boolean sexoL;
                if (sexoIntL == 0) {
                    sexo = false;// masculino
                } else {
                    sexo = true;// feminino
                }
                l.setSexo(sexo);
                ladroes.add(l);
                break;
            case 3:
                System.out.println("Criar Vítima!");
                Pessoa v = new Pessoa();
                System.out.print("Informe o nome da Vítima: ");
                v.setNome(ler.nextLine());
                System.out.print("Informe a cor do olho: ");
                v.setOlho(ler.nextLine());
                System.out.print("Informe a cor do cabelo: ");
                v.setCabelo(ler.nextLine());
                System.out.print("Informe a cor da pele: ");
                v.setPele(ler.nextLine());
                System.out.print("Informe o sexo: "
                        + "\n0 - Feminino"
                        + "\n1 - Masculino"
                        + "\nDigite aqui: ");

                int sexoIntV = lerInt();
                boolean sexoV;
                if (sexoIntV == 0) {
                    sexo = false;// masculino
                } else {
                    sexo = true;// feminino
                }
                v.setSexo(sexo);
                vitimas.add(v);// add no ArrayList
                VitimaServicos vs = ServicosFactory.getVitimaServicos(); // Instanciar Vitima Serviços
                vs.cadastrarVitima(v);// envia para o banco de dados
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
                subMenuP(opMP);
                break;
        }
    }
}