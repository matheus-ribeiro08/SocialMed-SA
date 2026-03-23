package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ProntuarioModel;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO
{
    public  boolean cadastrarProntuario(ProntuarioModel prontuario) {
        String sql = "INSERT INTO Prontuario (id_Paciente, id_Medico, id_Consultas, diagnosticos, sintomas, prescricao_Medica, observacoes, data_Registro) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1, prontuario.getIdPaciente());
            stmt.setInt(2, prontuario.getIdMedico());

            Integer idconsulta = prontuario.getIdConsulta();
            if (idconsulta != null && idconsulta > 0){
                stmt.setInt(3, prontuario.getIdConsulta());
            }else {
                stmt.setNull(3, Types.INTEGER);
            }

            stmt.setString(4, prontuario.getDiagnostico());
            stmt.setString(5, prontuario.getSintomas());
            stmt.setString(6, prontuario.getPrescricaoMedica());
            stmt.setString(7, prontuario.getObservacoes());
            stmt.setTimestamp(8, Timestamp.valueOf(prontuario.getDataRegistro()));

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas > 0){
                try(ResultSet rs = stmt.getGeneratedKeys()) {
                    if(rs.next()){
                        prontuario.setIdProntuario(rs.getInt(1));
                    }
                }
            }
            return linhasAfetadas > 0;
        }catch (SQLException e)
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
                    prontuarioModel.setPrescricaoMedica(rs.getString("prescricao_Medica"));
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

    public List<ProntuarioModel> listarProntuariosPorMedico(int idMedico)
    {
        List<ProntuarioModel> prontuarios = new ArrayList<>();
        String sql = "SELECT * FROM Prontuario WHERE id_Medico = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idMedico);

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
                    prontuarioModel.setPrescricaoMedica(rs.getString("prescricao_Medica"));
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
            System.err.println("Erro ao listar Prontuarios por Medico");
        }
        return prontuarios;
    }

    public ProntuarioModel buscarPorConsulta(int idConsulta)
    {
        String sql = "SELECT * FROM Prontuario WHERE id_Consultas = ?";
        ProntuarioModel prontuario = null;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idConsulta);

            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    prontuario = new ProntuarioModel();
                    prontuario.setIdProntuario(rs.getInt("id_Prontuario"));
                    prontuario.setIdPaciente(rs.getInt("id_Paciente"));
                    prontuario.setIdMedico(rs.getInt("id_Medico"));
                    prontuario.setIdConsulta(rs.getInt("id_Consultas"));
                    prontuario.setDiagnostico(rs.getString("diagnostico"));
                    prontuario.setSintomas(rs.getString("sintomas"));
                    prontuario.setPrescricaoMedica(rs.getString("prescricao_Medica"));
                    prontuario.setObservacoes(rs.getString("observacoes"));

                    Timestamp dataBanco = rs.getTimestamp("data_Registro");
                    if (dataBanco != null) {
                        prontuario.setDataRegistro(dataBanco.toLocalDateTime());
                    }
                }
            }
        } catch (SQLException e)
        {
            System.err.println("Erro ao buscar prontuario por consulta");
        }
        return prontuario;
    }

    public boolean atualizarProntuario(ProntuarioModel prontuarioModel)
    {
        String sql = "UPDATE Prontuario SET diagnostico = ?, sintomas = ?, prescricao_Medica = ?, observacoes = ? WHERE id_Prontuario= ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, prontuarioModel.getDiagnostico());
            stmt.setString(2, prontuarioModel.getSintomas());
            stmt.setString(3, prontuarioModel.getPrescricaoMedica());
            stmt.setString(4, prontuarioModel.getObservacoes());
            stmt.setInt(5, prontuarioModel.getIdProntuario());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.err.println("Erro ao atualizar prontuarios");
            return false;
        }
    }

    public List<ProntuarioModel> listarTodosProntuarios()
    {
        List<ProntuarioModel> listaProntuarios = new ArrayList<>();
        String sql = "SELECT * FROM Prontuarios";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while (rs.next())
            {
                ProntuarioModel prontuario = new ProntuarioModel();
                prontuario.setIdProntuario(rs.getInt("id_Prontuario"));
                prontuario.setIdPaciente(rs.getInt("id_Paciente"));
                prontuario.setIdMedico(rs.getInt("id_Medico"));
                prontuario.setIdConsulta(rs.getInt("id_Consultas"));
                prontuario.setDiagnostico(rs.getString("diagnostico"));
                prontuario.setSintomas(rs.getString("sintomas"));
                prontuario.setPrescricaoMedica(rs.getString("prescricao_Medica"));
                prontuario.setObservacoes(rs.getString("observacoes"));

                Timestamp dataBanco = rs.getTimestamp("data_Registro");
                if(dataBanco != null)
                {
                    prontuario.setDataRegistro(dataBanco.toLocalDateTime());
                }
                listaProntuarios.add(prontuario);
            }
        } catch (SQLException e)
        {
            System.err.println("Erro ao listar todos os prontuarios");
        }
        return listaProntuarios;
    }

    public ProntuarioModel buscarPorPaciente(int idPaciente)
    {
        String sql = "SELECT * FROM Prontuario WHERE id_Paciente = ? ORDER BY data_Registro DESC LIMIT 1";
        ProntuarioModel prontuario = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    prontuario = new ProntuarioModel();

                    prontuario.setIdProntuario(rs.getInt("id_Prontuario"));
                    prontuario.setIdPaciente(rs.getInt("id_Paciente"));
                    prontuario.setIdMedico(rs.getInt("id_Medico"));
                    prontuario.setIdConsulta(rs.getInt("id_Consultas"));
                    prontuario.setDiagnostico(rs.getString("diagnostico"));
                    prontuario.setSintomas(rs.getString("sintomas"));
                    prontuario.setPrescricaoMedica(rs.getString("prescricao_Medica"));
                    prontuario.setObservacoes(rs.getString("observacoes"));

                    Timestamp dataBanco = rs.getTimestamp("data_Registro");
                    if (dataBanco != null) {
                        prontuario.setDataRegistro(dataBanco.toLocalDateTime());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o prontuário mais recente do paciente: " + e.getMessage());
        }

        return prontuario;
    }
}
