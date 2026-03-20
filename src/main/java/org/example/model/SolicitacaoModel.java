package org.example.model;

import java.time.LocalDate;

public class SolicitacaoModel {

    private int id;
    private MedicoModel medico;
    private PacienteModel paciente;
    private LocalDate dataAbertura;
    private LocalDate dataFechamento;

    public SolicitacaoModel(int id, MedicoModel medico, PacienteModel paciente, LocalDate dataAbertura, LocalDate dataFechamento) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
}
