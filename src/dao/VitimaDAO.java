package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Pessoa;

public class VitimaDAO {
    //Create
    public void cadastrarVitima(Pessoa vVO) {
        try {
            Connection con = Conexao.getConexao();
            // id - nome - olho - cabelo - pele - sexo - pontosDeVida - armamento -
            // planoDeFuga
            String sql = "insert into pessoa values " + "(null, ?, ?, ?, ?, ?, ?, null, null)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2, vVO.getOlho());
            pst.setString(3, vVO.getCabelo());
            pst.setString(4, vVO.getPele());
            pst.setBoolean(5, vVO.isSexo());
            pst.setInt(6, vVO.getPontosDeVida());
            pst.execute();
            System.out.println("Vítima cadastrada com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Pessoa.\n" + e.getMessage());
        } // fim try-catch
    }// fim cadastrar

    public ArrayList<Pessoa> getVitimas() {
        ArrayList<Pessoa> vitimas = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa " + "where armamento is null " + "and planoDeFuga is null";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            // Percorrer resultSet
            while (rs.next()) {
                Pessoa vitima = new Pessoa();
                vitima.setId(rs.getInt("id"));
                vitima.setNome(rs.getString("nome"));
                vitima.setOlho(rs.getString("olho"));
                vitima.setCabelo(rs.getString("cabelo"));
                vitima.setPele(rs.getString("pele"));
                vitima.setSexo(rs.getBoolean("sexo"));
                vitima.setPontosDeVida(rs.getInt("pontosDeVida"));
                vitimas.add(vitima);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar vítima.\n" + e.getMessage());
        }
        return vitimas;
    }

    //Read
    public Pessoa getVitimaByNome(String nome) {
        Pessoa v = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            // Percorrer resultSet
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setOlho(rs.getString("olho"));
                v.setCabelo(rs.getString("cabelo"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontosDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar vítima.\n" + e.getMessage());
        }
        return v;
    }
    
    public Pessoa getVitimaById(int id) {
        Pessoa v = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            // Percorrer resultSet
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setOlho(rs.getString("olho"));
                v.setCabelo(rs.getString("cabelo"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontosDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar vítima.\n" + e.getMessage());
        }
        return v;
    }

    //Update
    public void atualizarVitima(Pessoa vVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, "
                    + "olho = ?, "
                    + "cabelo = ?, "
                    + "pele = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2,vVO.getOlho());
            pst.setString(3, vVO.getCabelo());
            pst.setString(4, vVO.getPele());
            pst.setInt(5, vVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar vítima.\n" + e.getMessage());
        }
    }

    //Delete
    public boolean deletarVitima(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar vítima.\n" + e.getMessage());
        }
        return true;
    }
}