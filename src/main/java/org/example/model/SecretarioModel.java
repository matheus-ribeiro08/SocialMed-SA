package org.example.model;

import org.example.enums.TipoUsuario;

import java.time.LocalDate;

public class SecretarioModel extends UsuarioModel{

    private long idSecretario;
    private String turnoTrabalhadoSecretario;

    public SecretarioModel(long idUsuario, String nomeUsuario, String emailUsuario,
                           String senhaUsuario, String telefoneUsuario, String cpfUsuario, TipoUsuario tipoUsuario, long idSecretario, String turnoTrabalhadoSecretario) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
        this.idSecretario = idSecretario;
        this.turnoTrabalhadoSecretario = turnoTrabalhadoSecretario;
    }

    public long getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(long idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getTurnoTrabalhadoSecretario() {
        return turnoTrabalhadoSecretario;
    }

    public void setTurnoTrabalhadoSecretario(String turnoTrabalhadoSecretario) {
        this.turnoTrabalhadoSecretario = turnoTrabalhadoSecretario;
    }
}
