package org.example.model;

import java.time.LocalDate;

public class PacienteModel extends UsuarioModel{

    private long idPaciente;
    private String enderecoPaciente;

    public PacienteModel(long idUsuario, String nomeUsuario, LocalDate dataNascimentoUsuario, String emailUsuario, String senhaUsuario,
                         String telefoneUsuario, String cpfUsuario, long idPaciente, String enderecoPaciente) {
        super(idUsuario, nomeUsuario, dataNascimentoUsuario, emailUsuario, senhaUsuario, telefoneUsuario, cpfUsuario);
        this.idPaciente = idPaciente;
        this.enderecoPaciente = enderecoPaciente;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEnderecoPaciente() {
        return enderecoPaciente;
    }

    public void setEnderecoPaciente(String enderecoPaciente) {
        this.enderecoPaciente = enderecoPaciente;
    }

}
