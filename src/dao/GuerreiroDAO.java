package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Guerreiro;

public class GuerreiroDAO {

    public void cadastrarGuerreiro(Guerreiro gVO) {
        try {
            Connection con = Conexao.getConexao();
            // id - nome - olho - cabelo - pele - sexo - pontosDeVida - armamento -
            // planoDeFuga
            String sql = "insert into pessoa values " + "(null, ?, ?, ?, ?, ?, ?, ?, null)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gVO.getNome());
            pst.setString(2, gVO.getOlho());
            pst.setString(3, gVO.getCabelo());
            pst.setString(4, gVO.getPele());
            pst.setBoolean(5, gVO.isSexo());
            pst.setInt(6, gVO.getPontosDeVida());
            pst.setString(7, gVO.getArmamento());
            pst.execute();
            System.out.println("Guerreiro cadastrado com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Guerreiro.\n" + e.getMessage());
        }
    }

    public ArrayList<Guerreiro> getGuerreiros() {
        ArrayList<Guerreiro> guerreiros = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa " + "where armamento is not null " + "and planoDeFuga is null";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Guerreiro guerreiro = new Guerreiro();
                guerreiro.setId(rs.getInt("id"));
                guerreiro.setNome(rs.getString("nome"));
                guerreiro.setOlho(rs.getString("olho"));
                guerreiro.setCabelo(rs.getString("cabelo"));
                guerreiro.setPele(rs.getString("pele"));
                guerreiro.setSexo(rs.getBoolean("sexo"));
                guerreiro.setPontosDeVida(rs.getInt("pontosDeVida"));
                guerreiro.setArmamento(rs.getString("armamento"));
                guerreiros.add(guerreiro);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar guerreiro.\n" + e.getMessage());
        }
        return guerreiros;
    }

    public Guerreiro getGuerreiroByNome(String nome) {
        Guerreiro g = new Guerreiro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                g.setOlho(rs.getString("olho"));
                g.setCabelo(rs.getString("cabelo"));
                g.setPele(rs.getString("pele"));
                g.setSexo(rs.getBoolean("sexo"));
                g.setPontosDeVida(rs.getInt("pontosDeVida"));
                g.setArmamento(rs.getString("armamento"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar guerreiro.\n" + e.getMessage());
        }
        return g;
    }

    public Guerreiro getGuerreiroById(int id) {
        Guerreiro g = new Guerreiro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            // Percorrer resultSet
            while (rs.next()) {
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                g.setOlho(rs.getString("olho"));
                g.setCabelo(rs.getString("cabelo"));
                g.setPele(rs.getString("pele"));
                g.setSexo(rs.getBoolean("sexo"));
                g.setPontosDeVida(rs.getInt("pontosDeVida"));
                g.setArmamento(rs.getString("armamento"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar guerreiro.\n" + e.getMessage());
        }
        return g;
    }

    public void atualizarGuerreiro(Guerreiro gVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, "
                    + "olho = ?, "
                    + "cabelo = ?, "
                    + "pele = ?, "
                    + "armamento = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gVO.getNome());
            pst.setString(2,gVO.getOlho());
            pst.setString(3, gVO.getCabelo());
            pst.setString(4, gVO.getPele());
            pst.setString(5,gVO.getArmamento());
            pst.setInt(6, gVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar guerreiro.\n" + e.getMessage());
        }
    }

    public boolean deletarGuerreiro(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar guerreiro.\n" + e.getMessage());
        }
        return true;
    }
}
