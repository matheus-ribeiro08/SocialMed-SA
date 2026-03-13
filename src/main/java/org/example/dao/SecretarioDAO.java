package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.ConsultaModel;

import java.awt.desktop.SystemEventListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SecretarioDAO {
    public boolean confirmarConsulta(int idConsulta){
        String sql = "UPDATE Consultas SET status_Consulta = ? WHERE id_Consultas = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, "CONFIRMADA");
            stmt.setInt(2, idConsulta);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        }catch (SQLException e){
            System.err.println("Erro ao confirmar consulta: " +e.getMessage());
            return false;
        }
    }

    public boolean cancelarConsulta(int idConsulta){
        String sql = "UPDATE consultas SEt status_Consulta = ? WHERE id_Consultas = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, "CANCELADA");
            stmt.setInt(2, idConsulta);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas < 0;

        } catch (SQLException e){
            System.err.println("Erro ao cancelar consulta: " + e.getMessage());
            return false;
        }
    }
}
