package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.SecretarioModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SecretarioDAO {
    public boolean confirmarConsulta(int idConsulta){
        String sql = "UPDATE Consultas SET status_Consulta = ? WHERE id_Consultas = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, "CONFIRMADA");
            stmt.setInt(2, idConsulta);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        }catch (SQLException e){
            System.err.println("Erro ao confirmar consulta: " +e.getMessage());
            return false;
        }
    }

    public boolean cancelarConsulta(int idConsulta) {
        String sql = "UPDATE consultas SEt status_Consulta = ? WHERE id_Consultas = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "CANCELADA");
            stmt.setInt(2, idConsulta);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas < 0;

        } catch (SQLException e) {
            System.err.println("Erro ao cancelar consulta: " + e.getMessage());
            return false;
        }
    }

    public List<SecretarioModel> listarTodosSecretarios()
    {
        List<SecretarioModel> secretarios = new ArrayList<>();
        String sql = "SELECT u.*, s.id_Secretario, s.turno_Secretario FROM Secretario s INNER JOIN Usuario u ON s.id_Usuario = u.id_Usuario";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                SecretarioModel secretario = new SecretarioModel();

                secretario.setIdUsuario(rs.getInt("id_Usuario"));
                secretario.setNomeUsuario(rs.getString("nome_usuario"));
                secretario.setEmailUsuario(rs.getString("email_Usuario"));
                secretario.setSenhaUsuario(rs.getString("senha_Usuario"));
                secretario.setTelefoneUsuario(rs.getString("telefone_Usuario"));
                secretario.setCpfUsuario(rs.getString("cpf_Usuario"));

                secretario.setIdSecretario(rs.getInt("id_Secretario"));
                secretario.setTurnoTrabalhadoSecretario(rs.getString("turno_Secretario"));

                secretarios.add(secretario);
            }
        }catch (SQLException e)
        {
            System.err.println("Erro: " + e.getMessage());
        }
        return secretarios;
    }

    public SecretarioModel buscarPorId (int idSecretario)
    {
        SecretarioModel secretario = null;

        String sql = "SELECT u.*, s.id_Secretario, s.turno_Secretario " +
                "FROM Secretario s " +
                "INNER JOIN Usuario u ON s.id_Usuario = u.id_Usuario " +
                "WHERE s.id_Secretario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idSecretario);

            try (ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    secretario = new SecretarioModel();
                    secretario.setIdUsuario(rs.getInt("id_Usuario"));
                    secretario.setIdSecretario(rs.getInt("id_Secretario"));
                    secretario.setNomeUsuario(rs.getString("nome_usuario"));
                    secretario.setEmailUsuario(rs.getString("email_Usuario"));
                    secretario.setSenhaUsuario(rs.getString("senha_Usuario"));
                    secretario.setTelefoneUsuario(rs.getString("telefone_Usuario"));
                    secretario.setCpfUsuario(rs.getString("cpf_Usuario"));
                    secretario.setTurnoTrabalhadoSecretario(rs.getString("turno_Secretario"));

                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao buscar secretario por ID");
        }
        return secretario;
    }

    public boolean atualizarSecretario(SecretarioModel secretario) throws  SQLException {
        String sqlUsuario = "UPDATE Usuario SET nome_Usuario = ?, email_Usuario = ?, senha_Usuario = ?, telefone_Usuario = ? WHERE id_Usuario = ?";
        String sqlSecretario = "UPDATE Secretario SET turno_Secretario  = ? WHERE id_Secretario = ?";

        Connection conn = null;


        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sqlUsuario)) {
                stmt.setString(1, secretario.getNomeUsuario());
                stmt.setString(2, secretario.getEmailUsuario());
                stmt.setString(3, secretario.getSenhaUsuario());
                stmt.setString(4, secretario.getTelefoneUsuario());
                stmt.setInt(5, secretario.getIdUsuario());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Usuario nao encontrado para atualização");
                }

            }

            try (PreparedStatement stmt = conn.prepareStatement(sqlSecretario)) {
                stmt.setString(1, secretario.getTurnoTrabalhadoSecretario());
                stmt.setInt(2, secretario.getIdSecretario());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Secretario nao encontrado para atualização");
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.err.println("Erro ao dar rollback!");
                }
            }
            System.err.println("Erro ao atualizar secretario");
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexao");
                }
            }
        }
    }

    public boolean removerSecretario(int idSecretario) throws SQLException{
        String sqlBuscarIdUsuario = "SELECT id_Usuario FROM Secretario WHERE id_Secretario = ?";
        String sqlRemoverSecretario = "DELETE FROM Secretario WHERE id_Secretario = ?";
        String sqlRemoverUsuario = "DELETE FROM Usuario WHERE id_Usuario = ?";

        Connection conn = null;
        Integer idUsuario = null;

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try(PreparedStatement stmt = conn.prepareStatement(sqlBuscarIdUsuario)){
                stmt.setInt(1 , idSecretario);
                try(ResultSet rs = stmt.executeQuery()) {
                    if(rs.next()){
                        idUsuario = rs.getInt("id_Usuario");
                    }else {
                        throw new SQLException("Secretario nao encontrado");
                    }

                }
            }

            try(PreparedStatement stmt  = conn.prepareStatement(sqlRemoverSecretario)) {
                stmt.setInt(1, idSecretario);
                int linhasAfetadas = stmt.executeUpdate();
                if(linhasAfetadas == 0){
                    throw new SQLException("Erro ao remover secretario");
                }
            }

            try(PreparedStatement stmt  = conn.prepareStatement(sqlRemoverUsuario)) {
                stmt.setInt(1, idUsuario);
                int linhasAfetadas = stmt.executeUpdate();
                if(linhasAfetadas == 0){
                    throw new SQLException("Erro ao remover usuario");
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.err.println("Erro ao dar rollback!");
                }
            }
            System.err.println("Erro ao remover secretario");
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexao");
                }
            }
        }
    }

    public SecretarioModel buscarPorIdUsuario(int idUsuario) {
        return null;
    }
}
