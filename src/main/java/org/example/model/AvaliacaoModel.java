package org.example.model;

public class AvaliacaoModel {
    private long idAvaliacao;
    private double notaAvaliacao;
    private String comentariosAvaliacao;

    public AvaliacaoModel(long idAvaliacao, double notaAvaliacao, String comentariosAvaliacao) {
        this.idAvaliacao = idAvaliacao;
        this.notaAvaliacao = notaAvaliacao;
        this.comentariosAvaliacao = comentariosAvaliacao;
    }

    public long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(long idAvaliacao) {
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

    public void setComentariosAvaliacao(String comentariosAvaliacao) {
        this.comentariosAvaliacao = comentariosAvaliacao;
    }
}
