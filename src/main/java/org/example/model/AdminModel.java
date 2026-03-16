package org.example.model;

import org.example.enums.TipoUsuario;

import java.time.LocalDate;

public class AdminModel extends UsuarioModel{

    private long idAdmin;
    private String senhaEspecial;

    public AdminModel(long idUsuario, String nomeUsuario, TipoUsuario tipoUsuario, String emailUsuario,
                      String senhaUsuario, String telefoneUsuario, String cpfUsuario, long idAdmin, String senhaEspecial) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
        this.idAdmin = idAdmin;
        this.senhaEspecial = senhaEspecial;
    }

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getSenhaEspecial() {
        return senhaEspecial;
    }

    public void setSenhaEspecial(String senhaEspecial) {
        this.senhaEspecial = senhaEspecial;
    }

}
