package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.HospitalModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO
{
    public List<HospitalModel> listarHospitais() {
        List<HospitalModel> hospitais = new ArrayList<>();
        String sql = "SELECT * FROM Hospital";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HospitalModel hospital = new HospitalModel(
                        rs.getInt("id_Hospital"),
                        rs.getString("CNPJ_Hospital"),
                        rs.getString("endereco_Hospital"),
                        rs.getInt("quantidade_Pessoas"),
                        rs.getString("nome_Hospital"),
                        rs.getInt("quantidadeSalas_Hospital"),
                        rs.getString("agenda_Hospital")
                );
                hospitais.add(hospital);
            }
        } catch (SQLException e) {}
        return hospitais;
    }


}
