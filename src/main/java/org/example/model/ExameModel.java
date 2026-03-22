package org.example.model;

import java.time.LocalDateTime;

public class ExameModel {

    private int idExame;
    private int idMedico;
    private int idPaciente;
    private String tipoExame;
    private String observacoes;
    private LocalDateTime dataSolicitacao;
    private String status;

    public ExameModel(){
        this.dataSolicitacao = LocalDateTime.now();
        this.status = "SOLICITADO";
    }

    public ExameModel(int idMedico, int idPaciente, String tipoExame, String observacoes, LocalDateTime dataSolicitacao, String status) {
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.tipoExame = tipoExame;
        this.observacoes = observacoes;
        this.dataSolicitacao = LocalDateTime.now();
        this.status = "SOLICITADO";
    }

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Exame [" + idExame + "] " + tipoExame + " - " + status;
    }
}
