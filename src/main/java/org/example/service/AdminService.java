package org.example.service;

import org.example.enums.TipoUsuario;
import org.example.model.*;
import org.example.dao.AdminDAO;
import org.example.dao.UsuarioDAO;
import org.example.dao.MedicoDAO;
import org.example.dao.SecretarioDAO;
import org.example.dao.PacienteDAO;
import org.example.dao.ConsultaDAO;
import org.example.validator.UsuarioValidator;

import java.time.LocalDateTime;
import java.util.List;

public class AdminService {
    private final AdminDAO adminDAO;
    private final UsuarioDAO usuarioDAO;
    private final MedicoDAO medicoDAO;
    private final SecretarioDAO secretarioDAO;
    private final PacienteDAO pacienteDAO;
    private final ConsultaDAO consultaDAO;
    private final UsuarioValidator usuarioValidator;

    public AdminService() {
        this.adminDAO = new AdminDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.medicoDAO = new MedicoDAO();
        this.secretarioDAO = new SecretarioDAO();
        this.pacienteDAO = new PacienteDAO();
        this.consultaDAO = new ConsultaDAO();
        this.usuarioValidator = new UsuarioVAlidator();
    }

    // ========================= CRIAÇÃO DE USUARIOS =========================//

    public void criarMedico(AdminModel admin, MedicoModel medico){
        verificarPermissaoAdmin(admin);
        usuarioValidator.validarMedico(medico);

        // Verificar se o CPF ja existe
        UsuarioModel usuarioExistente = usuarioDAO.buscarPorCpf(medico.getCpfUsuario());
        if(usuarioExistente != null){
            throw new RuntimeException("Já existe um usuário cadastrado com esse CPF!");
        }

        //Verificar se o email já existe
        if(usuarioDAO.buscarPorEmail(medico.getEmailUsuario()) != null){
            throw new RuntimeException("Já existe um usuário cadastrado com esse Email!");
        }

        long idUsuario = usuarioDAO.salvar(secretario);
        secretario.setIdUsuario(idUsuario);

        secretarioDAO.salvar(secretario);
    }

    public void criarPaciente(AdminModel admin, PacienteModel paciente){

    }

}
