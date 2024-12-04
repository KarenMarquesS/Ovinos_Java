package org.example.Repositorio;

import org.example.InfraEstrutura.ConexaoBancoDados;
import org.example.Modelo.T_Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;


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
        } catch(Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void UpDate(T_Registro registro) {

    }

    @Override
    public void Delete(int id) {
        try{
            Connection conn = ConexaoBancoDados.getConnection();
            String query = "DELTE FROM T_Registro WHERE id=? ";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
