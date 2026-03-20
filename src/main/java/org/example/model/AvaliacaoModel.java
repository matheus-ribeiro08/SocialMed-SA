package org.example.model;

import java.time.LocalDate;
import java.util.Date;

public class AvaliacaoModel {
    private int idAvaliacao;
    private double notaAvaliacao;
    private String comentariosAvaliacao;
    private LocalDate dataPublicacao;
    private int idMedico;

    public AvaliacaoModel(int idAvaliacao, double notaAvaliacao, String comentariosAvaliacao, LocalDate dataPublicacao, int idMedico) {
        this.idAvaliacao = idAvaliacao;
        this.notaAvaliacao = notaAvaliacao;
        this.comentariosAvaliacao = comentariosAvaliacao;
        this.dataPublicacao = dataPublicacao;
        this.idMedico = idMedico;
    }

    public AvaliacaoModel() {

    }

    public long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public String getComentariosAvaliacao() {
        return comentariosAvaliacao;
    }

    public void setComentariosAvaliacao(String comentariosAvaliacao) { this.comentariosAvaliacao = comentariosAvaliacao; }

    public LocalDate getDataPublicacao() { return dataPublicacao; }

    public void setDataPublicacao(LocalDate dataPublicacao) { this.dataPublicacao = dataPublicacao; }

    public int getIdMedico() { return idMedico; }

    public void setIdMedico(int idMedico) { this.idMedico = idMedico; }
}
