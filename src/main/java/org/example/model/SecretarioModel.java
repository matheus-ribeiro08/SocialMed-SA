package org.example.model;

import java.time.LocalDate;

public class SecretarioModel extends UsuarioModel{

    private long idSecretario;
    private String turnoTrabalhadoSecretario;

    public SecretarioModel(long idUsuario, String nomeUsuario, LocalDate dataNascimentoUsuario, String emailUsuario,
                           String senhaUsuario, String telefoneUsuario, String cpfUsuario, long idSecretario, String turnoTrabalhadoSecretario) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario);
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
