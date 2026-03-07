package org.example.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioModel {

    private long idUsuario;
    private String nomeUsuario;
    private LocalDate dataNascimentoUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private String telefoneUsuario;
    private String cpfUsuario;

    public UsuarioModel(long idUsuario, String nomeUsuario, LocalDate dataNascimentoUsuario, String emailUsuario,
                        String senhaUsuario, String telefoneUsuario, String cpfUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.dataNascimentoUsuario = dataNascimentoUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.cpfUsuario = cpfUsuario;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDate getDataNascimentoUsuario() {
        return dataNascimentoUsuario;
    }

    public void setDataNascimentoUsuario(String dataStr) { // 👈 Recebe String
        this.dataNascimentoUsuario = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }
    
    public void setId(int idUsuario){this.idUsuario = idUsuario;}
}
