package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class MedicoDAO
{
    public boolean cadastrarMedico(MedicoModel medico) {
        String sqlUsuario = "INSERT INTO Usuario (nome_usuario, email_Usuario, senha_Usuario, telefone_Usuario, cpf_Usuario) VALUES (?, ?, ?, ?, ?)";
        String sqlMedico = "INSERT INTO Medico (id_Usuario, especialidade_Medico) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                stmtUsuario.setString(1, medico.getNomeUsuario());
                stmtUsuario.setString(2, medico.getEmailUsuario());
                stmtUsuario.setString(3, medico.getSenhaUsuario());
                stmtUsuario.setString(4, medico.getTelefoneUsuario());
                stmtUsuario.setString(5, medico.getCpfUsuario());
                stmtUsuario.executeUpdate();

                try (ResultSet rs = stmtUsuario.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idUsuario = rs.getInt(1);
                        try (PreparedStatement stmtMedico = conn.prepareStatement(sqlMedico)) {
                            stmtMedico.setInt(1, idUsuario);
                            stmtMedico.setString(2, medico.getEspecialidadeMedico());
                            stmtMedico.executeUpdate();
                        }
                    } else {
                        throw new SQLException("Erro: Nenhum ID gerado.");
                    }
                }
            }
            conn.commit();
            return true;

        } catch (SQLException e)
        {
            if (conn != null)
            {
                try
                {
                    conn.rollback();
                }
                catch (SQLException ex) {}
            }
            return false;
        } finally {
            if (conn != null) { try { conn.setAutoCommit(true); conn.close(); } catch (SQLException ex) {} }
        }
    }
    public List<ConsultaModel> listarConsultasPorMedico(int idMedico) {
        List<ConsultaModel> consultasMedico = new ArrayList<>();
        String sql = "SELECT * FROM Consultas WHERE id_Medico = ? ORDER BY horario_Consulta ASC";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMedico);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ConsultaModel consulta = new ConsultaModel(
                            rs.getInt("id_Consultas"),
                            rs.getInt("id_Hospital"),
                            rs.getString("local_Consulta"),
                            rs.getInt("id_Paciente"),
                            rs.getInt("id_Medico"),
                            rs.getTimestamp("horario_consultas").toLocalDateTime()

                    );
                    consulta.setIdPaciente(rs.getInt("id_Paciente"));
                    consulta.setIdMedico(rs.getInt("id_Medico"));

                    consultasMedico.add(consulta);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        return consultasMedico;
    }

    public List<MedicoModel> listarTodosMedicos()
    {
        List<MedicoModel> medicos = new ArrayList<>();
        String sql = "SELECT u.*, m.id_Medico, m.especialidade_Medico FROM Medico m INNER JOIN Usuario u ON m.id_Usuario = u.id_Usuario";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                MedicoModel medico = new MedicoModel();

                medico.setIdMedico(rs.getLong("id_Usuario"));
                medico.setNomeUsuario(rs.getString("nome_usuario"));
                medico.setEmailUsuario(rs.getString("email_Usuario"));
                medico.setSenhaUsuario(rs.getString("senha_Usuario"));
                medico.setTelefoneUsuario(rs.getString("telefone_Usuario"));
                medico.setCpfUsuario(rs.getString("cpf_Usuario"));

                medico.setIdMedico(rs.getInt("id_Medico"));
                medico.setEspecialidadeMedico(rs.getString("especialidade_medico"));

                medicos.add(medico);
            }
        }catch (SQLException e)
        {
            System.err.println("Erro: " + e.getMessage());
        }
        return medicos;
    }
}
