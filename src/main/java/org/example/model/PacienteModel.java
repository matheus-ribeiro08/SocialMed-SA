package org.example.model;

import org.example.enums.TipoUsuario;

import java.time.LocalDate;

public class PacienteModel extends UsuarioModel{

    private int idPaciente;
    private String enderecoPaciente;

    public PacienteModel(int idUsuario, String nomeUsuario, TipoUsuario tipoUsuario, String emailUsuario, String senhaUsuario,
                         String telefoneUsuario, String cpfUsuario, int idPaciente, String enderecoPaciente) {
        super(idUsuario, nomeUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario, tipoUsuario);
        this.idPaciente = idPaciente;
        this.enderecoPaciente = enderecoPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEnderecoPaciente() {
        return enderecoPaciente;
    }

    public void setEnderecoPaciente(String enderecoPaciente) {
        this.enderecoPaciente = enderecoPaciente;
    }

    public PacienteModel(){
    }

}
