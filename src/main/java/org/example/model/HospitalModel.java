package org.example.model;

public class HospitalModel {

    private int idHospital;
    private String cnpjHospital;
    private String enderecoHospital;
    private int quantPessoasHospital;
    private String nomeHospital;
    private int quantidadeSalasHopital;
    private String agendaHospital;

    public HospitalModel(int idHospital, String cnpjHospital, String enderecoHospital, int quantPessoasHospital,
                         String nomeHospital, int quantidadeSalasHopital, String agendaHospital) {
        this.idHospital = idHospital;
        this.cnpjHospital = cnpjHospital;
        this.enderecoHospital = enderecoHospital;
        this.quantPessoasHospital = quantPessoasHospital;
        this.nomeHospital = nomeHospital;
        this.quantidadeSalasHopital = quantidadeSalasHopital;
        this.agendaHospital = agendaHospital;
    }

    public HospitalModel(){

    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getCnpjHospital() {
        return cnpjHospital;
    }

    public void setCnpjHospital(String cnpjHospital) {
        this.cnpjHospital = cnpjHospital;
    }

    public String getEnderecoHospital() {
        return enderecoHospital;
    }

    public void setEnderecoHospital(String enderecoHospital) {
        this.enderecoHospital = enderecoHospital;
    }

    public int getQuantPessoasHospital() {
        return quantPessoasHospital;
    }

    public void setQuantPessoasHospital(int quantPessoasHospital) {
        this.quantPessoasHospital = quantPessoasHospital;
    }

    public String getNomeHospital() {
        return nomeHospital;
    }

    public void setNomeHospital(String nomeHospital) {
        this.nomeHospital = nomeHospital;
    }

    public int getQuantidadeSalasHopital() {
        return quantidadeSalasHopital;
    }

    public void setQuantidadeSalasHopital(int quantidadeSalasHopital) {
        this.quantidadeSalasHopital = quantidadeSalasHopital;
    }

    public String getAgendaHospital() {
        return agendaHospital;
    }

    public void setAgendaHospital(String agendaHospital) {
        this.agendaHospital = agendaHospital;
    }
}
