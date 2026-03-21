package org.example.model;

import org.example.enums.TipoUsuario;

import java.time.LocalDate;

public class SecretarioModel extends UsuarioModel{

    private int idSecretario;
    private String turnoTrabalhadoSecretario;

    public SecretarioModel(int idUsuario, String nomeUsuario, String emailUsuario,
                           String senhaUsuario, String telefoneUsuario, String cpfUsuario, TipoUsuario tipoUsuario, int idSecretario, String turnoTrabalhadoSecretario) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
        this.idSecretario = idSecretario;
        this.turnoTrabalhadoSecretario = turnoTrabalhadoSecretario;
    }

    public SecretarioModel(String nomeUsuario, String emailUsuario, String senhaUsuario, String telefoneUsuario, String cpfUsuario,
                       TipoUsuario tipoUsuario, String turnoTrabalhadoSecretario) {
        super(nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
        this.turnoTrabalhadoSecretario = turnoTrabalhadoSecretario;
    }


    public SecretarioModel(){

    }

    public int getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(int idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getTurnoTrabalhadoSecretario() {
        return turnoTrabalhadoSecretario;
    }

    public void setTurnoTrabalhadoSecretario(String turnoTrabalhadoSecretario) {
        this.turnoTrabalhadoSecretario = turnoTrabalhadoSecretario;
    }
}
