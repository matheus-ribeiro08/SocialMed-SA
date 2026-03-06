package org.example.model;

import java.time.LocalDate;

public class MedicoPaciente extends UsuarioModel{

    private long idMedico;
    private String especialidadeMedico;

    public MedicoPaciente(long idUsuario, String nomeUsuario, LocalDate dataNascimentoUsuario, String emailUsuario, String senhaUsuario,
                          String telefoneUsuario, String cpfUsuario, long idMedico, String especialidadeMedico) {
        super(idUsuario, nomeUsuario, dataNascimentoUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario);
        this.idMedico = idMedico;
        this.especialidadeMedico = especialidadeMedico;
    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }
}
