package org.example.service.medico;

import org.example.dao.*;
import org.example.model.MedicoModel;

import java.sql.SQLException;

public class MedicoService {

    private final MedicoDAO medicoDAO;
    private final ConsultaDAO consultaDAO;
    private final ProntuarioDAO prontuarioDAO;
    private final UsuarioDAO usuarioDAO;
    private final PacienteDAO pacienteDAO;

    private MedicoService(){
        this.medicoDAO = new MedicoDAO();
        this.consultaDAO = new ConsultaDAO();
        this.prontuarioDAO = new ProntuarioDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.pacienteDAO = new PacienteDAO();
    }

    public MedicoService(MedicoDAO medicoDAO, ConsultaDAO consultaDAO, ProntuarioDAO prontuarioDAO, UsuarioDAO usuarioDAO, PacienteDAO pacienteDAO) {
        this.medicoDAO = medicoDAO;
        this.consultaDAO = consultaDAO;
        this.prontuarioDAO = prontuarioDAO;
        this.usuarioDAO = usuarioDAO;
        this.pacienteDAO = pacienteDAO;
    }

    public MedicoModel buscarPorIdUsuario(int idUsuario) throws SQLException{
        if(idUsuario <= 0){

        }
    }

}
