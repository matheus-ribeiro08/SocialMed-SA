package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsultaModel {

    private long idConsulta;
    private int idHospital;
    private String localEndereco;
    private int idPaciente;
    private int idMedico;
    private LocalDateTime horarioConsulta;

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getLocalEndereco() {
        return localEndereco;
    }

    public void setLocalEndereco(String localEndereco) {
        this.localEndereco = localEndereco;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public LocalDateTime getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(LocalDateTime horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public ConsultaModel(long idConsulta, int idHospital, String localEndereco, int idPaciente, int idMedico, LocalDateTime horarioConsulta) {
        this.idConsulta = idConsulta;
        this.idHospital = idHospital;
        this.localEndereco = localEndereco;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.horarioConsulta = horarioConsulta;
    }


}
