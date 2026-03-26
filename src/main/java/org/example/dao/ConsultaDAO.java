package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ConsultaModel;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    public int cadastrarConsulta(ConsultaModel consulta) {
        String sql = " INSERT INTO Consultas (id_Hospital, local_Consulta, id_Paciente, id_Medico, horario_Consulta) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setInt(1, consulta.getIdHospital());
            stmt.setString(2, consulta.getLocalEndereco());
            stmt.setInt(3, consulta.getIdPaciente());
            stmt.setInt(4, consulta.getIdMedico());
            stmt.setTimestamp(5, Timestamp.valueOf(consulta.getHorarioConsulta()));

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0)
            {
                try(ResultSet rs = stmt.getGeneratedKeys())
                {
                    if(rs.next())
                    {
                        int idGerado = rs.getInt(1);
                        consulta.setIdConsulta(idGerado);

                        return idGerado;
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar consultas: " + e.getMessage());
        }
        return -1;
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

        String sql = "SELECT * FROM Consultas WHERE id_Paciente = ? ORDER BY horario_Consulta ASC";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);

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
            System.err.println("Erro ao listar Consultas do Paciente: " + e.getMessage());
        }
        return consultasAtivasPaciente;
    }

    public List<ConsultaModel> listarConsultasPorMedico(int idMedico) {
        List<ConsultaModel> consultaMedicos = new ArrayList<>();


        String sql = "SELECT * FROM Consultas WHERE id_Medico = ? ORDER BY horario_Consulta ASC";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMedico);

            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    ConsultaModel consulta = new ConsultaModel(
                            rs.getInt("id_Consultas"),
                            rs.getInt("id_Hospital"),
                            rs.getString("local_Consulta"),
                            rs.getInt("id_Paciente"),
                            rs.getInt("id_Medico"),
                            rs.getTimestamp("horario_Consulta").toLocalDateTime()
                    );
                    consultaMedicos.add(consulta);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar Consultas por Medicos: " + e.getMessage());
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

    public List<ConsultaModel> historicoDeConsultasPaciente(int idPaciente)
    {
        List<ConsultaModel> historicoConsultas = new ArrayList<>();

        String sql = "SELECT * FROM Consultas WHERE id_Paciente = ? ORDER BY horario_Consulta DESC";
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idPaciente);

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

    public List<ConsultaModel> listarConsultasPorMedicoEData(int idMedico, LocalDate data)throws SQLException{

        String sql = "SELECT * FROM Consultas WHERE id_Medico = ? AND DATE(horario_Consulta) = ?";
        List<ConsultaModel> consultas = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, idMedico);
            stmt.setDate(2, java.sql.Date.valueOf(data));
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    consultas.add(extrairConsulta(rs));
                }
        }
        }
        return consultas;
    }

    public ConsultaModel extrairConsulta(ResultSet rs) throws SQLException{
        int idConsulta = rs.getInt("id_Consultas");
        int idHospital = rs.getInt("id_Hospital");
        String localConsulta = rs.getString("local_Consulta");
        int idPaciente = rs.getInt("id_Paciente");
        int idMedico = rs.getInt("id_Medico");
        LocalDateTime horario = rs.getTimestamp("horario_Consulta").toLocalDateTime();

        return new ConsultaModel(idConsulta, idHospital, localConsulta, idPaciente, idMedico, horario);
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

    public boolean atualizarHorario(int idConsulta, LocalDateTime novoHorario) throws SQLException
    {
        String sql = "UPDATE Consultas SET horario_Consulta = ? WHERE id_Consulta = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(novoHorario));
            stmt.setInt(2, idConsulta);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e)
        {
            System.err.println("Erro ao atualizar horario da consulta");
            throw e;
        }
    }
}
