package org.example.service;

import org.example.dao.ConsultaDAO;
import org.example.dao.HospitalDAO;
import org.example.dao.MedicoDAO;
import org.example.model.HospitalModel;
import org.example.model.MedicoModel;

import java.sql.SQLException;
import java.util.List;

public class ConsultaService {

    private ConsultaDAO consultaDAO;
    private MedicoDAO medicoDAO;
    private HospitalDAO hospitalDAO;

    public ConsultaService(){
        this.consultaDAO = new ConsultaDAO();
        this.medicoDAO = new MedicoDAO();
        this.hospitalDAO = new HospitalDAO();
    }

    public ConsultaService(ConsultaDAO consultaDAO, MedicoDAO medicoDAO, HospitalDAO hospitalDAO){
        this.consultaDAO = consultaDAO;
        this.medicoDAO = medicoDAO;
        this.hospitalDAO = hospitalDAO;
    }

    public List<HospitalModel> listarHospitais() throws SQLException{
        return hospitalDAO.listarTodos();
    }

    public List<MedicoModel> buscarPorId(int idMedico) throws SQLException{
        if (idMedico <= 0){
            throw new IllegalArgumentException("Id do médico inválido");
        }
        return medicoDAO.buscarPorId();
    }



}
