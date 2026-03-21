package org.example.model;

import org.example.enums.TipoUsuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioModel {

    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private String telefoneUsuario;
    private String cpfUsuario;
    private TipoUsuario tipoUsuario;

    public UsuarioModel(int idUsuario,String nomeUsuario, String emailUsuario,String senhaUsuario, String telefoneUsuario, String cpfUsuario, TipoUsuario tipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.cpfUsuario = cpfUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioModel(){

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioModel(String nomeUsuario, String emailUsuario, String senhaUsuario, String telefoneUsuario, String cpfUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.cpfUsuario = cpfUsuario;
    }

    public UsuarioModel(String nomeUsuario, String emailUsuario, String senhaUsuario,
                        String telefoneUsuario, String cpfUsuario, TipoUsuario tipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.cpfUsuario = cpfUsuario;
        this.tipoUsuario = tipoUsuario;
    }
}
