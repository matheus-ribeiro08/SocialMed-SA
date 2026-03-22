package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ExameModel;
import org.example.model.HospitalModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExameDAO {

    public boolean cadastrar(ExameModel exame){
        String sql = "INSERT INTO Exame (id_Medico, id_Paciente, tipo_Exame, observacoes_Exame, data_Solicitacao, status_Exame" + "VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, exame.getIdMedico());
            stmt.setInt(2, exame.getIdPaciente());
            stmt.setString(3, exame.getTipoExame());
            stmt.setString(4, exame.getObservacoes());
            stmt.setTimestamp(5, Timestamp.valueOf(exame.getDataSolicitacao()));
            stmt.setString(6, exame.getStatus());

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0){
                try(ResultSet rs = stmt.getGeneratedKeys()) {
                    if(rs.next()){
                        exame.setIdExame(rs.getInt(1));
                    }
                }
                return true;
            }
            return false;
        }catch (SQLException e){
            System.err.println("Erro ao cadastrar exame");
            return false;
        }
    }


    public ExameModel buscarPorId(int idExame)
    {
        String sql = "SELECT * FROM Exame WHERE id_Exame = ?";
        ExameModel exame = null;


        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idExame);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    exame = extrairExame(rs);
                }
            }

        }catch (SQLException e )
        {
            System.err.println("Erro ao buscar exame por ID");
        }
        return exame;
    }

    public List<ExameModel> listarPorPacientes(int idPaciente){
        List<ExameModel> exames = new ArrayList<>();
        String sql = "SELECT * FROM Exame WHERE id_Paciente = ? ORDER BY data_Solicitacao DESC";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);

            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    exames.add(extrairExame(rs));
                }

            }

        }catch (SQLException e){
            System.err.println("Erro ao listar exames");
        }
        return exames;
    }

    public List<ExameModel> listarPorMedicos(int idMedico){
        List<ExameModel> exames = new ArrayList<>();
        String sql = "SELECT * FROM Exame WHERE id_Medico = ? ORDER BY data_Solicitacao DESC";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMedico);

            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    exames.add(extrairExame(rs));
                }

            }

        }catch (SQLException e){
            System.err.println("Erro ao listar exames");
        }
        return exames;
    }

    public List<ExameModel> listarExamesPendentes(int idMedico){
        List<ExameModel> exames = new ArrayList<>();
        String sql = "SELECT * FROM Exame WHERE status_Exame = 'SOLICITADO' ORDER BY data_Solicitacao ASC";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                exames.add(extrairExame(rs));
            }

        }catch (SQLException e){
            System.err.println("Erro ao listar exames");
        }
        return exames;
    }

    public boolean atualizarStatus(int idExame, String status){
        String sql = "UPDATE Exame SET status_Exame = ? WHERE id_Exame = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, status);
            stmt.setInt(2, idExame);

            return stmt.executeUpdate() > 0;

        }catch (SQLException e){
            System.err.println("Erro ao atualizar status");
            return false;
        }
    }

    public boolean cancelarConsulta(int idExame){
        return atualizarStatus(idExame, "CANCELADO");
    }

    public boolean deletar(int idExame) {
        String sql = "DELETE FROM Exame WHERE id_Exame = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idExame);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Exame: " + e.getMessage());
            return false;
        }
    }

    private ExameModel extrairExame(ResultSet rs) throws SQLException{

        ExameModel exame = new ExameModel();

        exame.setIdExame(rs.getInt("id_Exame"));
        exame.setIdMedico(rs.getInt("id_Medico"));
        exame.setIdPaciente(rs.getInt("id_Paciente"));
        exame.setTipoExame(rs.getString("tipo_Exame"));
        exame.setObservacoes(rs.getString("observacoes_Exame"));

        Timestamp dataSolicitacao = rs.getTimestamp("data_Solicitacao");
        if(dataSolicitacao != null){
            exame.setDataSolicitacao(dataSolicitacao.toLocalDateTime());
        }

        exame.setStatus(rs.getString("status_Exame"));

        return exame;

    }






}
