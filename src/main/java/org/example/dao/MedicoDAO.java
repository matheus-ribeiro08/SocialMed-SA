package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ConsultaModel;

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
}
