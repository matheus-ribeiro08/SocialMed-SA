package org.example.model;

public class SecretarioModel {

    private long idSecretario;
    private String turnoTrabalhadoSecretario;

    public SecretarioModel(long idSecretario, String turnoTrabalhadoSecretario) {
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
