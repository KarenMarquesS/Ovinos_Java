package org.example.Repositorio;

import org.example.InfraEstrutura.ConexaoBancoDados;
import org.example.Modelo.T_Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;


public class RegistroRepositorio implements RepositorioBase<T_Registro>  {

    @Override
    public void Adicionar(T_Registro registro) {

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "INSERT INTO T_Registro (id_cordeiro, mae_brinco, data_Nascimento, peso_Nascimento, raca) " +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, registro.getId_cordeiro());
            stmt.setInt(2, registro.getMae_brinco());
            stmt.setDate(3, new java.sql.Date(registro.getData_Nascimento().getTime()));
            stmt.setDouble(4, registro.getPeso_Nascimento());
            stmt.setString(5, registro.getRaca());

            stmt.close();
            conn.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void UpDate(T_Registro registro) {

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "UPDATE T_Peso SET mae_brinco=?, data_nascimento=?, peso_nascimento=?, raca=?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, registro.getMae_brinco());
            stmt.setDate(2, new java.sql.Date (registro.getData_Nascimento().getTime()));
            stmt.setString(3, registro.getRaca());
            stmt.executeUpdate();

            conn.close();
            stmt.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<T_Registro> GetByBrinco(int n_brinco) {
        return Optional.empty();
    }


    @Override
    public void Delete(int n_brinco) {
        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "DELTE FROM T_Registro WHERE n_brinco=? ";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, n_brinco);

            stmt.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}
