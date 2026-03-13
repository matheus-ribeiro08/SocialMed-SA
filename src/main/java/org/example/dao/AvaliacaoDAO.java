package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.AvaliacaoModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {
    public boolean cadastrarAvaliacao(AvaliacaoModel avaliacao){
        String sql = "INSERT INTO AvaliacaoMedico (id_Medico, nota_Avaliacao, comentarios_Avaliacao, data_Publicacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, avaliacao.getIdMedico());
            stmt.setDouble(2, avaliacao.getNotaAvaliacao());
            stmt.setString(3, avaliacao.getComentariosAvaliacao());
            stmt.setDate(4, Date.valueOf(avaliacao.getDataPublicacao()));

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        avaliacao.setIdAvaliacao(rs.getInt(1));
                    }
                }
                return true;
            } else {
                return false;
            }
        }catch (SQLException e){
            System.err.println("Erro ao cadastrar avaliação: " + e.getMessage());
            return false;
        }
    }

    public List<AvaliacaoModel> listarAvaliacoesPorMedico(int idMedico) {

        List<AvaliacaoModel> avaliacoes = new ArrayList<>();
        String sql = "SELECT * FROM AvaliacaoMedico WHERE id_Medico = ? ORDER BY data_Publicacao DESC";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMedico);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    AvaliacaoModel avaliacao = new AvaliacaoModel();
                    avaliacao.setIdAvaliacao(rs.getInt("id_Avaliacao"));
                    avaliacao.setIdMedico(rs.getInt("id_Medico"));
                    avaliacao.setNotaAvaliacao(rs.getInt("nota_Avaliacao"));
                    avaliacao.setComentariosAvaliacao(rs.getString("comentarios_Avaliacao"));
                    avaliacao.setDataPublicacao(rs.getDate("data_Publicacao").toLocalDate());

                    avaliacoes.add(avaliacao);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar avaliações: " + e.getMessage());
        }

        return avaliacoes;
    }
}
