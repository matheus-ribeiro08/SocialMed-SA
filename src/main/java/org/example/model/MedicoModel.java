package org.example.model;

import org.example.enums.TipoUsuario;

import java.time.LocalDate;

public class MedicoModel extends UsuarioModel{

    private long idMedico;
    private String especialidadeMedico;

    public MedicoModel(long idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario,
                       String telefoneUsuario, String cpfUsuario, TipoUsuario tipoUsuario, long idMedico, String especialidadeMedico) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
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
