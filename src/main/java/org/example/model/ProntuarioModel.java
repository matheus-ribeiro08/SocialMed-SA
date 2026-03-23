package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProntuarioModel
{
    private int idProntuario;
    private int idPaciente;
    private int idMedico;
    private int idConsulta;

    private String diagnostico;

    public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
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

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getPrescricaoMedica() {
        return prescricaoMedica;
    }

    public void setPrescricaoMedica(String prescricaoMedica) {
        this.prescricaoMedica = prescricaoMedica;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    private String sintomas;
    private String prescricaoMedica;
    private String observacoes;
    private LocalDateTime dataRegistro;

    public ProntuarioModel(){}

    public ProntuarioModel(int idProntuario, int idPaciente, int idMedico, int idConsulta,
                           String diagnostico, String sintomas, String prescricaoMedica,
                           String observacoes, LocalDateTime dataRegistro)
    {
        this.idProntuario = idProntuario;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idConsulta = idConsulta;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.prescricaoMedica = prescricaoMedica;
        this.observacoes = observacoes;
        this.dataRegistro = dataRegistro;
    }
    public ProntuarioModel(int idPaciente, int idMedico, int idConsulta,
                           String diagnostico, String sintomas, String prescricaoMedica,
                           String observacoes, LocalDateTime dataRegistro)
    {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idConsulta = idConsulta;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.prescricaoMedica = prescricaoMedica;
        this.observacoes = observacoes;
        this.dataRegistro = dataRegistro;
    }

    public ProntuarioModel(int idPaciente, int idMedico,
                           String diagnostico, String sintomas, String prescricaoMedica,
                           String observacoes, LocalDateTime dataRegistro)
    {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.prescricaoMedica = prescricaoMedica;
        this.observacoes = observacoes;
        this.dataRegistro = dataRegistro;
    }

}
