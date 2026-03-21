package org.example.model;

import org.example.enums.TipoUsuario;

import java.time.LocalDate;

public class MedicoModel extends UsuarioModel{

    private int idMedico;
    private String especialidadeMedico;

    public MedicoModel(int idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario,
                       String telefoneUsuario, String cpfUsuario, TipoUsuario tipoUsuario, int idMedico, String especialidadeMedico) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
        this.idMedico = idMedico;
        this.especialidadeMedico = especialidadeMedico;
    }

    public MedicoModel(String nomeUsuario, String emailUsuario, String senhaUsuario, String telefoneUsuario, String cpfUsuario,
                       TipoUsuario tipoUsuario, String especialidadeMedico) {
        super(nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
        this.especialidadeMedico = especialidadeMedico;
    }

    public MedicoModel(String nomeUsuario, String emailUsuario, String senhaUsuario, String telefoneUsuario, String cpfUsuario, String especialidadeMedico) {
        super(nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario);
        this.especialidadeMedico = especialidadeMedico;
    }

    public MedicoModel(){

    }


    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }
}
