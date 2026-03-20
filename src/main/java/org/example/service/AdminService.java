package org.example.service;

import com.mysql.cj.conf.HostInfo;
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

    public AdminService() {
        this.adminDAO = new AdminDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.medicoDAO = new MedicoDAO();
        this.secretarioDAO = new SecretarioDAO();
        this.pacienteDAO = new PacienteDAO();
        this.consultaDAO = new ConsultaDAO();
    }

    // ==================== Métodos de Médicos ====================

   public boolean criarMedico(AdminModel admin, MedicoModel medico){
        validarAdmin(admin);

        if(usuarioDAO.existeCpf(medico.getCpfUsuario()) != null){
            throw new RuntimeException("Cpf ja cadastrado");
        }

        return adminDAO.cadastrarMedico(medico);
   }

   public boolean atualizarMedico(AdminModel admin, MedicoModel medico){
        validarAdmin(admin);
        validarMedicoExistente(medico.getIdMedico());

        return medicoDAO.atualizar(medico);
   }

   public boolean removerMedico(AdminModel admin, long idMedico){
        validarAdmin(admin);
        validarMedicoExistente(idMedico);

        return medicoDao.remover(idMedico);
   }

    // ==================== Métodos de Secretarios ====================

    public boolean criarSecretario(AdminModel admin, SecretarioModel secretario){
        validarAdmin(admin);

        if(usuarioDAO.existeCpf(secretario.getCpfUsuario()) != null){
            throw new RuntimeException("Cpf ja cadastrado");
        }

        return adminDAO.cadastrarSecretario(secretario);
    }

    public boolean atualizarSecretario(AdminModel admin, SecretarioModel secretario){
        validarAdmin(admin);
        validarSecretarioExistente(secretario.getIdUsuario());

        return secretarioDAO.atualizar(secretario);
    }

    public boolean removerSecretario(AdminModel admin, int idSecretario){
        validarAdmin(admin);
        validarMedicoExistente(idSecretario);

        return secretarioDAO.remover();
    }

        // ==================== Métodos de Usuários ====================

    public boolean atualizarUsuario(AdminModel admin, UsuarioModel usuario) {
        validarAdmin(admin);

        return usuarioDAO.atualizar(usuario);
    }

    // ==================== Métodos de Hospital ====================

    public boolean adicionarHospital(AdminModel admin, HospitalModel hospital){
        validarAdmin(admin);

        return adminDAO.adicionarHospital(hospital);
    }

    // ==================== Métodos de Validação ====================

    private void validarAdmin(AdminModel admin){
        if (admin == null){
            throw new RuntimeException("Admin não autentificado!");
        }
    }

    private void validarUsuarioExistente(long id){
        if(id <= 0){
            throw new RuntimeException("Usuario não autentificado!");
        }
    }

    private void validarMedicoExistente(int id){
        if(id <= 0){
            throw new RuntimeException("Id de medico invalido!");
        }

        MedicoModel medico = medicoDAO.buscarPorId(id);
        if(medico == null){
            throw new RuntimeException("Medico não autentificado!");
        }
    }

    private void validarSecretarioExistente(int id){
        if(id <= 0){
            throw new RuntimeException("Id de secretario invalido!");
        }

        SecretarioModel secretario = secretarioDAO.buscarPorId(id);
        if(secretario == null){
            throw new RuntimeException("Medico não autentificado!");
        }
    }



}
