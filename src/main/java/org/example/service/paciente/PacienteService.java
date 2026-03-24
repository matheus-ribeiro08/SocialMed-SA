package org.example.service.paciente;

import org.example.dao.PacienteDAO;
import org.example.model.PacienteModel;

import java.sql.SQLException;

public class PacienteService {

    private final PacienteDAO pacienteDAO;

    public PacienteService(){
        this.pacienteDAO = new PacienteDAO();
    }

    public PacienteService(PacienteDAO pacienteDAO){
        this.pacienteDAO = pacienteDAO;
    }

    public PacienteModel buscarPorCpf(String cpf){
        if(cpf == null || cpf.trim().isEmpty()){
            throw new IllegalArgumentException("Cpf nao pode ser vazio");
        }

        try {
            return pacienteDAO.buscarPorCpf(cpf);
        }catch (Exception e){
            throw new RuntimeException("Erro ao buscar paciente por cpf");
        }
    }

    public  PacienteModel buscarDetalhe(int idUsuario)
    {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO();
            return pacienteDAO.buscarDetalhePorIdUsuario(idUsuario);
        } catch (SQLException e)
        {
            System.out.println("Erro ao carregar perfil");
            return null;
        }
    }


    public PacienteModel buscarPorId(int idPaciente){
        if(idPaciente <= 0){
            throw new IllegalArgumentException("Id invalido");
        }

        try {
            return pacienteDAO.buscarPorId(idPaciente);
        }catch (Exception e){
            throw new RuntimeException("Erro ao buscar paciente por id");
        }
    }

    public boolean cadastrar(PacienteModel paciente){
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente nao pode ser nulo");
        }

        validarPaciente(paciente);

        PacienteModel existente = buscarPorCpf(paciente.getCpfUsuario());
        if(existente != null){
            throw new IllegalArgumentException("Ja existe um paciente cadastrado com esse cpf");
        }

        try {
            return pacienteDAO.cadastrarPaciente(paciente);
        }catch (Exception e){
            throw new IllegalArgumentException("Erro ao realizar cadastro");
        }
    }

    public boolean atualizar(PacienteModel paciente){
        if(paciente == null || paciente.getIdPaciente() <= 0){
            throw new IllegalArgumentException("Paciente invalido");
        }

        validarPaciente(paciente);

        try {
            return pacienteDAO.atualizarPaciente(paciente);
        }catch (Exception e){
            throw new RuntimeException("Erro ao atualizar paciente");
        }
    }

    public boolean remover(int idPaciente){
        if(idPaciente <= 0){
            throw new IllegalArgumentException("Id invalido");
        }

        try {
            return pacienteDAO.removerPaciente(idPaciente);
        }catch (Exception e){
            throw new RuntimeException("Erro ao remover paciente");
        }
    }

    private void validarPaciente(PacienteModel paciente){
        if(paciente.getNomeUsuario() == null || paciente.getNomeUsuario().trim().isEmpty()){
            throw new IllegalArgumentException("Nome do paciente é obrigatorio");
        }

        if(paciente.getCpfUsuario() == null || paciente.getCpfUsuario().trim().isEmpty()){
            throw new IllegalArgumentException("Cpf do paciente é obrigatorio");
        }

        if(!validarCpf(paciente.getCpfUsuario())){
            throw new IllegalArgumentException("Cpf invalido");
        }

        if(paciente.getEmailUsuario() != null && paciente.getEmailUsuario().isEmpty()){
            if(!validarEmail(paciente.getEmailUsuario())){
                throw new IllegalArgumentException("Email invalido");
            }
        }

        if(paciente.getEnderecoPaciente() == null || paciente.getEnderecoPaciente().trim().isEmpty()){
            throw new IllegalArgumentException("Endereço invalido");
        }
    }

    public boolean validarCpf(String cpf){
        if(cpf == null){
            return false;
        }
        cpf = cpf.replace("[^0-9]", "");
        return cpf.length() == 11;
    }

    public boolean validarEmail(String email){
        if(email == null){
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }



}
