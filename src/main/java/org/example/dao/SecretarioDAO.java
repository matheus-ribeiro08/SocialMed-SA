package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;

import java.awt.desktop.SystemEventListener;
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
}
