package org.example.model;

import java.time.LocalDate;

public class MedicoModel extends UsuarioModel{

    private long idMedico;
    private String especialidadeMedico;

    public MedicoModel(long idUsuario, String nomeUsuario, LocalDate dataNascimentoUsuario, String emailUsuario, String senhaUsuario,
                       String telefoneUsuario, String cpfUsuario, long idMedico, String especialidadeMedico) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario);
        this.idMedico = idMedico;
        this.especialidadeMedico = especialidadeMedico;
    }

    public MedicoModel(){

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
