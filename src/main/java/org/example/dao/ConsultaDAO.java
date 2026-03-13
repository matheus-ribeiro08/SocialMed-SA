package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ConsultaModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    public boolean cadastrarConsulta(ConsultaModel consulta){
        String sql = " INSERT INTO Consultas (id_Hospital, local_Consulta, id_Paciente, id_Medico, horario_Consulta) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, consulta.getIdHospital());
            stmt.setString(2, consulta.getLocalEndereco());
            stmt.setInt(3, consulta.getIdPaciente());
            stmt.setInt(4, consulta.getIdMedico());
            stmt.setTimestamp(5, Timestamp.valueOf(consulta.getHorarioConsulta()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e){
            System.err.println("Erro ao cadastrar consultas: " + e.getMessage());
            return false;
        }
    }

    public List<ConsultaModel> listarConsultas(){
        List<ConsultaModel> consultas = new ArrayList<>();

        String sql = "SELECT * FROM Consultas";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                ConsultaModel consulta = new ConsultaModel(
                        rs.getInt("id_Consultas"),
                        rs.getInt("id_Hospital"),
                        rs.getString("local_Consulta"),
                        rs.getInt("id_Paciente"),
                        rs.getInt("id_Medico"),
                        rs.getTimestamp("horario_Consulta").toLocalDateTime()
                );

                consultas.add(consulta);
            }

        } catch (SQLException e){
            System.err.println("Erro ao listar consultas: " + e.getMessage());
        }
        return consultas;
    }
}
