package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.SecretarioModel;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class MedicoDAO
{
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

                medico.setIdUsuario(rs.getInt("id_Usuario"));
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

    public MedicoModel buscarPorId (int idMedico)
    {
        MedicoModel medico = null;

        String sql = "SELECT u.*, m.id_Medico, m.especialidade_medico " +
                "FROM Medico m " +
                "INNER JOIN Usuario u ON m.id_Usuario = u.id_Usuario " +
                "WHERE m.id_Medico = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idMedico);

            try (ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    medico = new MedicoModel();
                    medico.setIdUsuario(rs.getInt("id_Usuario"));
                    medico.setIdMedico(rs.getInt("id_Medico"));
                    medico.setNomeUsuario(rs.getString("nome_usuario"));
                    medico.setEmailUsuario(rs.getString("email_Usuario"));
                    medico.setSenhaUsuario(rs.getString("senha_Usuario"));
                    medico.setTelefoneUsuario(rs.getString("telefone_Usuario"));
                    medico.setCpfUsuario(rs.getString("cpf_Usuario"));
                    medico.setEspecialidadeMedico(rs.getString("especialidade_medico"));

                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao buscar medico por ID");
        }
        return medico;
    }
}
