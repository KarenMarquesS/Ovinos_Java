package org.example.Repositorio;

import org.example.InfraEstrutura.ConexaoBancoDados;
import org.example.Modelo.T_Manejo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

public class ManejoRepositorio implements RepositorioBase<T_Manejo>{


    @Override
    public void Adicionar(T_Manejo manejo) {

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "INSERT INTO T_Manejo (id_cordeiro, n_brinco, data_manejo, grau_do_famacha, vermifugo_oral," +
                    "vermifugo_muscular, vermifugo_venoso, nome_vermifugo, presenca_bicheira, nome_medicamento) VALUES" +
                    " (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, manejo.getId_cordeiro());
            stmt.setInt(2, manejo.getN_brinco());
            stmt.setDate(3, new java.sql.Date (manejo.getData_manejo().getTime()));
            stmt.setInt(4, manejo.getGrau_famacha());
            stmt.setString(5, manejo.getVermifugo_oral());
            stmt.setString(6, manejo.getVermifugo_muscular());
            stmt.setString(7, manejo.getVermifugo_venoso());
            stmt.setString(8, manejo.getNome_vermifugo());
            stmt.setString(9, manejo.getPresenca_bicheira());
            stmt.setString(10, manejo.getNome_medicamento());
            stmt.executeUpdate();

            conn.close();
            stmt.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void UpDate(T_Manejo manejo) {

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "UPDATE T_Manejo SET data_manejo=?, grau_do_famacha=?, vermifugo_oral=?, vermifugo_muscular=?, " +
                    "vermifugo_venoso=?, nome_vermifugo=?, presenca_bicheira=?, nome_medicamento=? WHERE n_brinco=?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setDate(1, new java.sql.Date (manejo.getData_manejo().getTime()));
            stmt.setInt(2, manejo.getGrau_famacha());
            stmt.setString(3, manejo.getVermifugo_oral());
            stmt.setString(4, manejo.getVermifugo_muscular());
            stmt.setString(5, manejo.getVermifugo_venoso());
            stmt.setString(6, manejo.getNome_vermifugo());
            stmt.setString(7, manejo.getPresenca_bicheira());
            stmt.setString(8, manejo.getNome_medicamento());
            stmt.setInt(9, manejo.getN_brinco());
            stmt.executeUpdate();

            conn.close();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<T_Manejo> GetByBrinco(int n_brinco) {
        Optional<T_Manejo> manejo = Optional.empty();

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "SELECT * FROM T_Manejo WHERE n_brinco = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, n_brinco);

            try (ResultSet rs = stmt.executeQuery()){

                if (rs.next()){
                    Date data_manejo = rs.getDate("data_manejo");
                    int grau_famacha = rs.getInt("grau_famacha");
                    String vermifugo_oral = rs.getString("vermifugo_oral");
                    String vermifugo_muscular = rs.getString("vermifugo_muscular");
                    String vermifugo_venoso = rs.getString("vermifugo_venoso");
                    String presenca_bicheira = rs.getString("presenca_bicheira");
                    String nome_medicamento = rs.getString("nome_medicamento");

                    manejo = Optional.of(new T_Manejo (data_manejo, grau_famacha, vermifugo_oral, vermifugo_muscular,
                        vermifugo_venoso,  presenca_bicheira, nome_medicamento));
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return manejo;
    }


    @Override
    public void Delete(int n_brinco) {
        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "DELTE FROM T_Manejo WHERE n_brinco=? ";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, n_brinco);
            stmt.executeUpdate();

            stmt.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
