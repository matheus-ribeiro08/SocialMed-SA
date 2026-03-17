package org.example.service;

import org.example.dao.ConsultaDAO;
import org.example.dao.HospitalDAO;
import org.example.dao.MedicoDAO;
import org.example.exception.ConsultaException;
import org.example.model.ConsultaModel;
import org.example.model.HospitalModel;
import org.example.model.MedicoModel;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

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
        return hospitalDAO.listarHospitais();
    }

    public MedicoModel buscarPorId(int idMedico) throws SQLException{
        if (idMedico <= 0){
            throw new IllegalArgumentException("Id do médico inválido");
        }
        return medicoDAO.buscarPorId(idMedico);
    }

    public void agendarConsulta(ConsultaModel consulta) throws ConsultaException, SQLException {

        validarConsulta(consulta);

        MedicoModel medico = medicoDAO.buscarPorId(consulta.getIdMedico());
        if(medico == null){
            throw new ConsultaException("Médico não encontrado");
        }

        if(!idMedicoDisponivel(consulta.getIdMedico(), consulta.getHorarioConsulta())){
            throw new ConsultaException("Medico não disponivel neste horario");
        }

        consultaDAO.cadastrarConsulta(consulta);
    }

    private void validarConsulta(ConsultaModel consulta) throws Exception{
        if(consulta == null){
            throw new Exception("Consulta não pode ser nula");
        }
        if(consulta.getIdPaciente() <= 0){
            throw new Exception("ID do paciente invalido");
        }
        if(consulta.getIdMedico() <= 0){
            throw new Exception("ID do medico invalido");
        }
        if(consulta.getIdHospital() <= 0){
            throw new Exception("Id do hospital invalido");
        }
        if(consulta.getLocalEndereco() == null || consulta.getLocalEndereco().trim().isEmpty()){
            throw new Exception("Endereço do hospital não informado");
        }
        if(consulta.getHorarioConsulta() == null){
            throw new Exception("Horário da consulta não informado");
        }
        if(consulta.getHorarioConsulta().isBefore(LocalDateTime.now())){
            throw new Exception("Não é possivel agendar consultas no passado");
        }
    }



}
