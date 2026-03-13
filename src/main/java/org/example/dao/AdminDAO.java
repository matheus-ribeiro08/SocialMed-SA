package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.MedicoModel;
import org.example.model.SecretarioModel;

import java.sql.*;

public class AdminDAO {
    public boolean cadastrarMedico(MedicoModel medico){
        String sqlUsuario = "INSERT INTO Usuario (nome_usuario, data_Nascimento, email_Usuario, senha_Usuario, telefone_Usuario, cpf_Usuario) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlMedico = "INSERT INTO Medico (id_Usuario, especialidade_Medico) VALUES (?, ?)";

        Connection conn = null;

        try{
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try(PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)){
                stmtUsuario.setString(1, medico.getNomeUsuario());
                stmtUsuario.setString(2, medico.getEmailUsuario());
                stmtUsuario.setString(3, medico.getSenhaUsuario());
                stmtUsuario.setString(4, medico.getTelefoneUsuario());
                stmtUsuario.setString(5, medico.getCpfUsuario());

                stmtUsuario.executeUpdate();

                try(ResultSet rs = stmtUsuario.getGeneratedKeys()){
                    if (rs.next()){
                        int idUsuario = rs.getInt(1);

                        try(PreparedStatement stmtMedico = conn.prepareStatement(sqlMedico)){
                            stmtMedico.setInt(1, idUsuario);
                            stmtMedico.setString(2, medico.getEspecialidadeMedico());

                            stmtMedico.executeUpdate();
                        }
                    }else {
                        throw new SQLException("Erro ao gerar ID do usuário");
                    }
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            if(conn != null){
                try{
                    conn.rollback();
                } catch (SQLException ex){}
            }

            return false;
        } finally {
            if(conn != null){
                try{
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException ex) {}
            }
        }
    }

    public boolean cadastrarSecretario(SecretarioModel secretario){
        String sqlUsuario = "INSERT INTO Usuario (nome_usuario, data_Nascimento, email_Usuario, senha_Usuario, telefone_Usuario, cpf_Usuario) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlSecretario = "INSERT INTO Secretario (id_Usuario) VALUES (?)";

        Connection conn = null;

        try{
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try(PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)){
                stmtUsuario.setString(1, secretario.getNomeUsuario());
                stmtUsuario.setString(2, secretario.getEmailUsuario());
                stmtUsuario.setString(3, secretario.getSenhaUsuario());
                stmtUsuario.setString(4, secretario.getTelefoneUsuario());
                stmtUsuario.setString(5, secretario.getCpfUsuario());

                stmtUsuario.executeUpdate();

                try(ResultSet rs = stmtUsuario.getGeneratedKeys()){
                    if(rs.next()){
                        int idUsuario = rs.getInt(1);

                        try(PreparedStatement stmtSecretario = conn.prepareStatement(sqlSecretario)){
                            stmtSecretario.setInt(1, idUsuario);
                            stmtSecretario.executeUpdate();
                        }
                    } else{
                        throw new SQLException("Erro ao gerar ID de usuário.");
                    }
                }
            }
            conn.commit();
            return true;

        } catch (SQLException e){
            if(conn != null){
                try{
                    conn.rollback();
                } catch (SQLException ex){}
            }

            return false;
        }finally {
            if(conn != null){
                try{
                    conn.setAutoCommit(true);
                    conn.close();
                }catch (SQLException ex) {}
            }
        }
    }
}
