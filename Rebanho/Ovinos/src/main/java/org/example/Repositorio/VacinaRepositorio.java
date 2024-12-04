package org.example.Repositorio;

import org.example.InfraEstrutura.ConexaoBancoDados;
import org.example.Modelo.T_Peso;
import org.example.Modelo.T_Vacina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

public class VacinaRepositorio implements RepositorioBase <T_Vacina>{

    @Override
    public void Adicionar(T_Vacina vacina) {

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "INSERT INTO T_Vacina (id_cordeiro, n_brinco, data_vacina, nome_vacina) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, vacina.getId_cordeiro());
            stmt.setInt(2, vacina.getN_brinco());
            stmt.setDate(3, new java.sql.Date(vacina.getData_vacina().getTime()));
            stmt.setString(4, vacina.getNome_vacina());
            stmt.executeUpdate();

            conn.close();
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void UpDate(T_Vacina vacina) {

        try {
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "UPDATE T_Vacina SET n_brinco=?, data_vacina=?, nome_vacina=?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, vacina.getN_brinco());
            stmt.setDate(2, new java.sql.Date(vacina.getData_vacina().getTime()));
            stmt.setString(3, vacina.getNome_vacina());
            stmt.executeUpdate();

            conn.close();
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public Optional<T_Vacina> GetByBrinco(int n_brinco) {

        Optional<T_Vacina> vacina = Optional.empty();

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "SELECT * FROM T_Vacina WHERE n_brinco = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, n_brinco);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    int brinco = rs.getInt("n_brinco");
                    Date data_manejo = rs.getDate("data_manejo");
                    String nome_vacina = rs.getString("nome_vacina");

                    vacina = Optional.of(new T_Vacina(brinco, data_manejo, nome_vacina));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vacina;
    }

    @Override
    public void Delete(int n_brinco) {

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "DELTE FROM T_Vacina WHERE n_brinco=? ";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, n_brinco);

            stmt.close();

        } catch(SQLException e){
            e.printStackTrace();
        }


    }
}
