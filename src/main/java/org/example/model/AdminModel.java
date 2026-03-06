package org.example.model;

import java.time.LocalDate;

public class AdminModel extends UsuarioModel{

    private long idAdmin;
    private String senhaEspecial;

    public AdminModel(long idUsuario, String nomeUsuario, LocalDate dataNascimentoUsuario, String emailUsuario,
                      String senhaUsuario, String telefoneUsuario, String cpfUsuario, long idAdmin, String senhaEspecial) {
        super(idUsuario, nomeUsuario, dataNascimentoUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario);
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
