package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ConsultaModel;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    public boolean cadastrarConsulta(ConsultaModel consulta) {
        String sql = " INSERT INTO Consultas (id_Hospital, local_Consulta, id_Paciente, id_Medico, horario_Consulta) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, consulta.getIdHospital());
            stmt.setString(2, consulta.getLocalEndereco());
            stmt.setInt(3, consulta.getIdPaciente());
            stmt.setInt(4, consulta.getIdMedico());
            stmt.setTimestamp(5, Timestamp.valueOf(consulta.getHorarioConsulta()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar consultas: " + e.getMessage());
            return false;
        }
    }

    public List<ConsultaModel> listarConsultas() {
        List<ConsultaModel> consultas = new ArrayList<>();

        String sql = "SELECT * FROM Consultas";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
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

        } catch (SQLException e) {
            System.err.println("Erro ao listar consultas: " + e.getMessage());
        }
        return consultas;
    }

    public List<ConsultaModel> listarConsultasPorPaciente(int idPaciente) {
        List<ConsultaModel> consultasAtivasPaciente = new ArrayList<>();

        String sql = "SELECT * FROM Consultas WHERE id_Paciente = ? AND status_Consulta = 'CONFIRMADA' ORDER BY horario_Consulta ASC";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, idPaciente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ConsultaModel consulta = new ConsultaModel(
                            rs.getInt("id_Consultas"),
                            rs.getInt("id_Hospital"),
                            rs.getString("local_Consulta"),
                            rs.getInt("id_Paciente"),
                            rs.getInt("id_Medico"),
                            rs.getTimestamp("horario_Consulta").toLocalDateTime()
                    );
                    consultasAtivasPaciente.add(consulta);
                }

            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar Consultas Ativas");
        }
        return consultasAtivasPaciente;
    }
    public List<ConsultaModel> listarConsultasPorMedico(int idMedico)
    {
        List<ConsultaModel> consultaMedicos = new ArrayList<>();

        String sql = "SELECT * FROM Consultas WHERE id_Medico = ? AND status_Consulta = 'CONFIRMADA' ORDER BY horario_Consulta ASC";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idMedico);

            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    ConsultaModel consulta = new ConsultaModel(
                            rs.getInt("id_Consulta"),
                            rs.getInt("id_Hospital"),
                            rs.getString("local_Consulta"),
                            rs.getInt("id_Paciente"),
                            rs.getInt("id_Medico"),
                            rs.getTimestamp("horario_Consulta").toLocalDateTime()
                    );
                    consultaMedicos.add(consulta);
                }
            }
        } catch (SQLException e)
        {
            System.err.println("Erro ao listar Consultas Ativas por Medicos.");
        }
        return consultaMedicos;
    }

    public boolean deletarConsulta(int idConsulta) {
        String sql = "DELETE FROM Consultas WHERE id_Consultas = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idConsulta);
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar consulta: " + e.getMessage());
            return false;
        }
    }
    public List<ConsultaModel> historicoDeConsultasMedico(int idMedico)
    {
        List<ConsultaModel> historicoConsultas = new ArrayList<>();

        String sql = "SELECT * FROM Consultas WHERE id_medico = ? ORDER BY horario_Consulta DESC";
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idMedico);

            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    ConsultaModel consulta = new ConsultaModel(
                            rs.getInt("id_Consultas"),
                            rs.getInt("id_Hospital"),
                            rs.getString("local_Consulta"),
                            rs.getInt("id_Paciente"),
                            rs.getInt("id_Medico"),
                            rs.getTimestamp("horario_Consulta").toLocalDateTime()
                    );
                    historicoConsultas.add(consulta);
                }
            }
        } catch (SQLException e)
        {
            System.err.println("Erro ao exibir historico de Consulta");
        }
        return historicoConsultas;
    }

    public ConsultaModel buscarPorId(int idConsulta){
        String sql = "SELECT * FROM Consultas WHERE id_Consultas = ?";
        ConsultaModel consulta = null;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idConsulta);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    consulta = new ConsultaModel(
                            rs.getInt("id_Consultas"),
                            rs.getInt("id_Hospital"),
                            rs.getString("local_Consulta"),
                            rs.getInt("id_Paciente"),
                            rs.getInt("id_Medico"),
                            rs.getTimestamp("horario_consulta").toLocalDateTime()
                    );
                }
            }

        }catch (SQLException e){
            System.err.println("Erro ao buscar consulta por Id");
        }
        return consulta;
    }

    public List<ConsultaModel> buscarProximasConsultas(){
        List<ConsultaModel> proximasConsultas = new ArrayList<>();

        String sql = "SELECT * FROM Consultas WHERE horario_Consulta >= NOW() ORDER BY horario_Consulta ASC";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                ConsultaModel consulta = new ConsultaModel(
                        rs.getInt("id_Consultas"),
                        rs.getInt("id_Hospital"),
                        rs.getString("local_Consulta"),
                        rs.getInt("id_Paciente"),
                        rs.getInt("id_Medico"),
                        rs.getTimestamp("horario_Consulta").toLocalDateTime()
                );
                proximasConsultas.add(consulta);
            }

        }catch (SQLException e){
            System.err.println("Erro ao buscar proximas consultas");
        }

        return proximasConsultas;
    }

    public boolean atualizarHorario(int idConsulta, LocalDateTime novoHorario) {
    }
}
