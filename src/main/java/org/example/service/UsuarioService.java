package org.example.service;

import org.example.dao.MedicoDAO;
import org.example.dao.PacienteDAO;
import org.example.dao.SecretarioDAO;
import org.example.dao.UsuarioDAO;
import org.example.enums.TipoUsuario;
import org.example.exception.CpfInvalido;
import org.example.exception.EmailInvalido;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;
import org.example.model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO;
    private final MedicoDAO medicoDAO;
    private final SecretarioDAO secretarioDao;
    private final PacienteDAO pacienteDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        this.medicoDAO = new MedicoDAO();
        this.secretarioDao = new SecretarioDAO();
        this.pacienteDAO = new PacienteDAO();
    }

    public UsuarioModel login(String cpf, String senha){
        try {
            return usuarioDAO.login(cpf, senha);
        }catch (Exception e){
            throw new RuntimeException("Erro ao realiazar!");
        }
    }

    public boolean cadastrarUsuario(UsuarioModel usuario){
        validarUsuario(usuario);

        if(usuarioDAO.existeCpf(usuario.getCpfUsuario()) != null){
            throw new RuntimeException("Cpf ja foi cadastrado");
        }
        if(usuarioDAO.existeEmail(usuario.getEmailUsuario()) != null){
            throw new RuntimeException("O email ja foi cadastrado");
        }

        return usuarioDAO.cadastrarUsuario(usuario);
    }


    public UsuarioModel buscarPorCpf(String cpf){
        if(cpf == null || cpf.trim().isEmpty()){
            throw new RuntimeException("Cpf nao pode ser vazio");
        }

        return usuarioDAO.buscarPorCpf(cpf);
    }

    public UsuarioModel buscarPorEmail(String email){
        if(email == null || email.trim().isEmpty()){
            throw new RuntimeException("Email nao pode ser vazio");
        }
        return usuarioDAO.buscarPorEmail(email);
    }

    public UsuarioModel buscarPorId(int id){
        if(id <= 0){
            throw new RuntimeException("Id invalido");
        }

        return usuarioDAO.buscarPorId(id);
    }

    public List<MedicoModel> listarMedicos(){
        return medicoDAO.listarTodosMedicos();
    }

    public MedicoModel buscarMedicoPorId(int id){
        if(id <= 0){
            throw new RuntimeException("Id invalido");
        }

        return medicoDAO.buscarPorId(id);
    }

    public List<SecretarioModel> listarSecretarios(){
        return secretarioDao.listarTodosSecretarios();
    }

    public SecretarioModel buscarSecretarioPorId(int id){
        if(id <= 0){
            throw new RuntimeException("Id invalido");
        }

        return secretarioDao.buscarPorId(id);
    }

    public List<PacienteModel> listarTodos(){
        return pacienteDAO.listarTodosPacientes();
    }

    public PacienteModel buscarPacientePorCpf(String cpf){
        if(cpf == null || cpf.trim().isEmpty()){
            throw new RuntimeException("Cpf nao pode ser vazio");
        }

        return pacienteDAO.buscarPorCpf(cpf);
    }

    public List<UsuarioModel> buscarUsuariosPorTipo(TipoUsuario tipo){
        List<UsuarioModel> todos = usuarioDAO.listarTodos();
        List<UsuarioModel> filtrados = new ArrayList<>();

        for(UsuarioModel usuario: todos){
            if(usuario.getTipoUsuario() == tipo){
                filtrados.add(usuario);
            }
        }

        return filtrados;
    }

    private void validarUsuario(UsuarioModel usuario){
        if(usuario == null){
            throw new RuntimeException("Usuario nao pode ser nulo");
        }
        if(usuario.getNomeUsuario() == null || usuario.getNomeUsuario().trim().isEmpty()){
            throw new RuntimeException("O nome é obrigatorio");
        }
        if(usuario.getCpfUsuario() == null || usuario.getCpfUsuario().trim().isEmpty()){
            throw new RuntimeException("O Cpf é obrigatorio");
        }
        if(usuario.getCpfUsuario().length() != 11){
            throw new RuntimeException("Cpf deve ter 11 digitos");
        }
        if(usuario.getEmailUsuario() == null || usuario.getEmailUsuario().trim().isEmpty()){
            throw new RuntimeException("O email é obrigatorio");
        }
        if(usuario.getSenhaUsuario() == null || usuario.getSenhaUsuario().trim().isEmpty()){
            throw new RuntimeException("Senha é obrigatoria");
        }
    }
}