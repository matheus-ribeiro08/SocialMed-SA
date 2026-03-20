package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ProntuarioModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO
{
    public  boolean cadastrarProntuario(ProntuarioModel prontuario) {
        String sql = "INSERT INTO Prontuario (id_Paciente, id_Medico, id_Consultas, diagnosticos, sintomas, prescricao_Medica, observacoes, data_Registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, prontuario.getIdPaciente());
            stmt.setInt(2, prontuario.getIdMedico());
            stmt.setInt(3, prontuario.getIdConsulta());

            stmt.setString(4, prontuario.getDiagnostico());
            stmt.setString(5, prontuario.getSintomas());
            stmt.setString(6, prontuario.getPrescricaoMedica());
            stmt.setString(7, prontuario.getObservacoes());
            stmt.setTimestamp(8, Timestamp.valueOf(prontuario.getDataRegistro()));

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao cadastrar o Prontuario");
        }
        return false;
    }

    public List<ProntuarioModel> listarProntuarios(int idPaciente)
    {
        List<ProntuarioModel> prontuarios = new ArrayList<>();

        String sql = "SELECT * FROM Prontuario WHERE id_Paciente = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idPaciente);

            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    ProntuarioModel prontuarioModel = new ProntuarioModel();

                    prontuarioModel.setIdProntuario(rs.getInt("id_Prontuario"));
                    prontuarioModel.setIdPaciente(rs.getInt("id_Paciente"));
                    prontuarioModel.setIdMedico(rs.getInt("id_Medico"));
                    prontuarioModel.setDiagnostico(rs.getString("diagnosticos"));
                    prontuarioModel.setSintomas(rs.getString("sintomas"));
                    prontuarioModel.setPrescricaoMedica(rs.getString("prescrica_Medica"));
                    prontuarioModel.setObservacoes((rs.getString("observacao")));

                    Timestamp dataBanco = rs.getTimestamp("data_Registro");
                    if(dataBanco != null)
                    {
                        prontuarioModel.setDataRegistro(dataBanco.toLocalDateTime());
                    }
                    prontuarios.add(prontuarioModel);
                }
            }
        } catch (SQLException e)
        {
            System.err.println("Erro ao listar Prontuarios");
        }
        return prontuarios;
    }
}
