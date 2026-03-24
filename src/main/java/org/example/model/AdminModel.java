package org.example.model;

import org.example.enums.TipoUsuario;

import java.time.LocalDate;

public class AdminModel extends UsuarioModel{

    private int idAdmin;
    private String senhaEspecial;

    public AdminModel(int idUsuario, String nomeUsuario, TipoUsuario tipoUsuario, String emailUsuario,
                      String senhaUsuario, String telefoneUsuario, String cpfUsuario, int idAdmin, String senhaEspecial) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
        this.idAdmin = idAdmin;
        this.senhaEspecial = senhaEspecial;
    }

    public AdminModel() {
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getSenhaEspecial() {
        return senhaEspecial;
    }

    public void setSenhaEspecial(String senhaEspecial) {
        this.senhaEspecial = senhaEspecial;
    }

}
