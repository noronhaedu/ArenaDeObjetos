package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Ladrao;

public class LadraoDAO {
    public void cadastrarLadrao(Ladrao lVO) {
        try {
            Connection con = Conexao.getConexao();
            // id - nome - olho - cabelo - pele - sexo - pontosDeVida - armamento -
            // planoDeFuga
            String sql = "insert into pessoa values " + "(null, ?, ?, ?, ?, ?, ?, null, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getNome());
            pst.setString(2, lVO.getOlho());
            pst.setString(3, lVO.getCabelo());
            pst.setString(4, lVO.getPele());
            pst.setBoolean(5, lVO.isSexo());
            pst.setInt(6, lVO.getPontosDeVida());
            pst.setString(7, lVO.getPlanoDeFuga());
            pst.execute();
            System.out.println("Ladrão cadastrado com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Ladrão.\n" + e.getMessage());
        }
    }

    public ArrayList<Ladrao> getLadroes() {
        ArrayList<Ladrao> ladroes = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa " + "where armamento is null " + "and planoDeFuga is not null";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Ladrao ladrao = new Ladrao();
                ladrao.setId(rs.getInt("id"));
                ladrao.setNome(rs.getString("nome"));
                ladrao.setOlho(rs.getString("olho"));
                ladrao.setCabelo(rs.getString("cabelo"));
                ladrao.setPele(rs.getString("pele"));
                ladrao.setSexo(rs.getBoolean("sexo"));
                ladrao.setPontosDeVida(rs.getInt("pontosDeVida"));
                ladrao.setPlanoDeFuga(rs.getString("planoDeFuga"));
                ladroes.add(ladrao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar ladrão.\n" + e.getMessage());
        }
        return ladroes;
    }

    public Ladrao getLadraoByNome(String nome) {
        Ladrao l = new Ladrao();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setOlho(rs.getString("olho"));
                l.setCabelo(rs.getString("cabelo"));
                l.setPele(rs.getString("pele"));
                l.setSexo(rs.getBoolean("sexo"));
                l.setPontosDeVida(rs.getInt("pontosDeVida"));
                l.setPlanoDeFuga(rs.getString("planoDeFuga"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar ladrão.\n" + e.getMessage());
        }
        return l;
    }
    
        public Ladrao getLadraoById(int id) {
        Ladrao l = new Ladrao();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            // Percorrer resultSet
            while (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setOlho(rs.getString("olho"));
                l.setCabelo(rs.getString("cabelo"));
                l.setPele(rs.getString("pele"));
                l.setSexo(rs.getBoolean("sexo"));
                l.setPontosDeVida(rs.getInt("pontosDeVida"));
                l.setPlanoDeFuga(rs.getString("planoDeFuga"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar ladrão.\n" + e.getMessage());
        }
        return l;
    }

    public void atualizarLadrao(Ladrao lVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, "
                    + "olho = ?, "
                    + "cabelo = ?, "
                    + "pele = ?, "
                    + "planoDeFuga = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getNome());
            pst.setString(2,lVO.getOlho());
            pst.setString(3, lVO.getCabelo());
            pst.setString(4, lVO.getPele());
            pst.setString(5,lVO.getPlanoDeFuga());
            pst.setInt(6, lVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar ladrão.\n" + e.getMessage());
        }
    }

    public boolean deletarLadrao(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar ladrão.\n" + e.getMessage());
        }
        return true;
    }
}
