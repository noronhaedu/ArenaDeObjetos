package arenadeobjetos;

import java.util.ArrayList;
import java.util.Scanner;

import model.Guerreiro;
import model.Ladrao;
import model.Pessoa;
import servicos.GuerreiroServicos;
import servicos.LadraoServicos;
import servicos.ServicosFactory;
import servicos.VitimaServicos;
import view.Principal;

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
        /*System.out.println("-- Arena de Objetos --");
        do {
            menuP();
            subMenuP(opMP);
        } while (opMP != 0);*/
        Principal janelaPrincipal = new Principal();
        janelaPrincipal.setVisible(true);
    }// fim main

    public static void menuP() {// menu principal

        String menu = "1 - Criar Personagem"
                + "\n2 - Listar Personagens"
                + "\n3 - Teste Guerreiro"
                + "\n4 - Teste Ladrão"
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

                // TESTE VÍTIMA
                System.out.println("-- Vitimas do Banco de Dados --");
                VitimaServicos vs = ServicosFactory.getVitimaServicos();
                System.out.println(vs.listaVitimas().toString());

                // teste de read
                System.out.println("-- Teste de busca por nome --");
                System.out.println(vs.buscaVitimaByNome("%Eduardo%").toString());

                // teste de update
                System.out.println("-- Teste de update: vítima Eduardo --");
                Pessoa vUp = vs.buscaVitimaByNome("%Eduardo%");// busca a vítima
                vUp.setCabelo("Preto");// atualizada a cor do cabelo
                vs.atualizarVitima(vUp);
                System.out.println("Vítima atualizada com sucesso!");
                System.out.println(vs.buscaVitimaByNome("%Eduardo%").toString());

                // teste de delete
                System.out.println("-- Test de delete: vítima Ana --");
                int id = vs.buscaVitimaByNome("%Ana%").getId();
                // executa atualização mp banco
                if (vs.deletarVitima(id)) {
                    System.out.println("Vítima deletada!");
                } else {
                    System.out.println("Vítima não deletada!");
                }
                // FIM TESTE VÍTIMA

                break;
            case 3:
                // TESTE GUERREIRO
                System.out.println("-- Guerreiros do Banco de Dados --");
                GuerreiroServicos gs = ServicosFactory.getGuerreiroServicos();
                System.out.println(gs.listaGuerreiros().toString());

                System.out.println("-- Teste de busca por nome --");
                System.out.println(gs.buscaGuerreiroByNome("%Mariana%").toString());

                System.out.println("-- Teste de update: guerreira Mariana --");
                Guerreiro gUp = gs.buscaGuerreiroByNome("%Mariana%");
                gUp.setCabelo("Loiro");
                gs.atualizarGuerreiro(gUp);
                System.out.println("Guerreiro atualizado com sucesso!");
                System.out.println(gs.buscaGuerreiroByNome("%Mariana%").toString());

                System.out.println("-- Test de delete: guerreira --");
                int idg = gs.buscaGuerreiroByNome("%Marilia%").getId();
                if (gs.deletarGuerreiro(idg)) {
                    System.out.println("Guerreiro deletado com sucesso!");
                } else {
                    System.out.println("Erro ao deletar guerreiro.");
                }
                // FIM TESTE GUERREIRO
                break;
            case 4:
                // TESTE LADRÃO
                System.out.println("-- Ladrões do Banco de Dados --");
                LadraoServicos ls = ServicosFactory.getLadraoServicos();
                System.out.println(ls.listaLadroes().toString());

                System.out.println("-- Teste de busca por nome --");
                System.out.println(ls.buscaLadraoByNome("%Mariana%").toString());

                // FIM TESTE LADRÃO
                break;
            case 0:
                System.out.println("Arena de Objetos encerrada pelo usuário!");
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
                break;
        }// fim switch-case

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
                GuerreiroServicos gs = ServicosFactory.getGuerreiroServicos();
                gs.cadastrarGuerreiro(g);
                break;
            case 2:
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
                System.out.print("Informe o plano de fuga: ");
                l.setPlanoDeFuga(ler.nextLine());
                ladroes.add(l);
                LadraoServicos ls = ServicosFactory.getLadraoServicos();
                ls.cadastrarLadrao(l);
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