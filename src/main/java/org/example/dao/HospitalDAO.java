package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.HospitalModel;

import javax.xml.transform.Result;
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

    public HospitalModel buscarPorId(int idHospital)
    {
        HospitalModel hospitalModel = null;

        String sql = "SELECT * FROM Hospital WHERE id_Hospital = ?";


        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idHospital);

            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    hospitalModel = new HospitalModel(
                            rs.getInt("id_Hospital"),
                            rs.getString("CNPJ_Hospital"),
                            rs.getString("endereco_Hospital"),
                            rs.getInt("quantidade_Pessoas"),
                            rs.getString("nome_Hospital"),
                            rs.getInt("quantidadeSalas_Hospital"),
                            rs.getString("agenda_Hospital")
                    );
                }
            }
        }
        catch (SQLException e )
        {
            System.err.println("Erro ao buscar hospital por ID");
        }
        return hospitalModel;
    }

    public List<HospitalModel> buscarHospitaisPorMedico(int idMedico) throws SQLException{
        String sql = "SELECT h. * FROM Hospital h" +
                "INNER JOIN Medico_Hospital mh ON h.id_Hospital = mh.id_Hospital" +
                "WHERE mh.id_Medico = ?";

        List<HospitalModel> hospitais = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMedico);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()){
                    hospitais.add(extrairHospital(rs));
                }
            }

        }
        return hospitais;
    }

    private HospitalModel extrairHospital(ResultSet rs) throws SQLException{
        HospitalModel hospital = new HospitalModel();
        hospital.setIdHospital(rs.getInt("id_Hospital"));
        hospital.setCnpjHospital(rs.getString("CNPJ_Hospital"));
        hospital.setEnderecoHospital(rs.getString("endereco_Hospital"));
        hospital.setQuantPessoasHospital(rs.getInt("quantidade_Pessoas"));
        hospital.setNomeHospital(rs.getString("nome_Hospital"));
        hospital.setQuantidadeSalasHopital(rs.getInt("quantidadeSalas_Hospital"));
        //hospital.setAgendaHospital();
        //Ainda nao implementado no banco
        return hospital;

    }

}
