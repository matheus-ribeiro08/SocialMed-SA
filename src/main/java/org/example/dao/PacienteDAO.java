package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.PacienteModel;

import java.sql.*;

public class PacienteDAO
{
    public boolean cadastrarPaciente(PacienteModel paciente) throws SQLException {
        String sqlUsuario = "INSERT INTO Usuario (nome_Usuario, email_Usuario, senha_Usuario, telefone_Usuario, cpf_Usuario) VALUES (?, ?, ?, ?, ?)";
        String sqlPaciente = "INSERT INTO Paciente (id_Usuario, endereco_Paciente) VALUES (?, ?)";

        Connection conn = null;

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, paciente.getNomeUsuario());
                stmt.setString(2, paciente.getEmailUsuario());
                stmt.setString(3, paciente.getSenhaUsuario());
                stmt.setString(4, paciente.getTelefoneUsuario());
                stmt.setString(5, paciente.getCpfUsuario());

                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idUsuarioGerado = rs.getInt(1);

                        try (PreparedStatement stmtP = conn.prepareStatement(sqlPaciente)) {
                            stmtP.setInt(1, idUsuarioGerado);
                            stmtP.setString(2, paciente.getEnderecoPaciente());
                            stmtP.executeUpdate();
                        }

                    } else {
                        throw new SQLException("Falha a criar Usuario");
                    }
                }
            }
            conn.commit();
            return true;

        } catch (SQLException e)
        {
            if(conn != null)
            {
                try
                {
                    conn.rollback();
                }
                catch (SQLException ex)
                {
                    System.err.println("Erro ao dar rollback: " + ex.getMessage());
                }
            }
            System.err.println("Erro ao cadastrar paciente: " + e.getMessage());
            return false;
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.setAutoCommit(true);
                    conn.close();
                }
                catch (SQLException e)
                {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}

