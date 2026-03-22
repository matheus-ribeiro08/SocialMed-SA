package org.example.service.secretario;

import org.example.dao.*;
import org.example.exception.SecretarioException;
import org.example.model.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SecretarioService {
    private final SecretarioDAO secretarioDAO;
    private final ConsultaDAO consultaDAO;
    private final PacienteDAO pacienteDAO;
    private final MedicoDAO medicoDAO;
    private final HospitalDAO hospitalDAO;
    private final UsuarioDAO usuarioDAO;

    public SecretarioService() {
        this.secretarioDAO = new SecretarioDAO();
        this.consultaDAO = new ConsultaDAO();
        this.pacienteDAO = new PacienteDAO();
        this.medicoDAO = new MedicoDAO();
        this.hospitalDAO = new HospitalDAO();
        this.usuarioDAO = new UsuarioDAO();

    }

    public SecretarioService(SecretarioDAO secretarioDAO, ConsultaDAO consultaDAO,
                             PacienteDAO pacienteDAO, MedicoDAO medicoDAO,
                             HospitalDAO hospitalDAO, UsuarioDAO usuarioDAO) {
        this.secretarioDAO = secretarioDAO;
        this.consultaDAO = consultaDAO;
        this.pacienteDAO = pacienteDAO;
        this.medicoDAO = medicoDAO;
        this.hospitalDAO = hospitalDAO;
        this.usuarioDAO = usuarioDAO;
    }

    public SecretarioModel buscarPorId(int idSecretario) throws SQLException, SecretarioException {
        if (idSecretario <= 0) {
            throw new SecretarioException("ID do secretário inválido");
        }

        SecretarioModel secretario = secretarioDAO.buscarPorId(idSecretario);
        if (secretario == null) {
            throw new SecretarioException("Secretario não encontrado");
        }
        return secretario;
    }

    public SecretarioModel buscarPorIdUsuario(int idUsuario) throws SQLException, SecretarioException {
        if (idUsuario <= 0) {
            throw new SecretarioException("ID do usuario invalido");
        }

        SecretarioModel secretario = secretarioDAO.buscarPorIdUsuario(idUsuario);
        if (secretario == null) {
            throw new SecretarioException("Secretario não encontrado para o usuario informado");
        }
        return secretario;
    }

    public List<SecretarioModel> listarTodosSecretarios() throws SQLException {
        return secretarioDAO.listarTodosSecretarios();
    }

    public boolean atualizarSecretario(SecretarioModel secretario) throws SQLException, SecretarioException {
        if (secretario == null) {
            throw new SecretarioException("Secretario não pode ser nulo");
        }
        if (secretario.getIdSecretario() <= 0) {
            throw new SecretarioException("ID do secretario inválido");
        }

        validarSecretarioExistente(secretario.getIdSecretario());

        return secretarioDAO.atualizarSecretario(secretario);
    }

    public boolean cadastrarPaciente(PacienteModel paciente) throws SecretarioException, SQLException {
        if (paciente == null) {
            throw new SecretarioException("Paciente não pode ser nulo");
        }

        validarPaciente(paciente);

        String cpfExistente = usuarioDAO.existeCpf(paciente.getCpfUsuario());
        if (cpfExistente != null) {
            throw new SecretarioException("CPF já cadastrado no sistema");
        }

        String emailExiste = usuarioDAO.existeEmail(paciente.getEmailUsuario());
        if (emailExiste != null) {
            throw new SecretarioException("Email já cadastrado no sistema");
        }

        return pacienteDAO.cadastrarPaciente(paciente);
    }

    public PacienteModel buscarPacientePorId(int idPaciente) throws SQLException, SecretarioException {
        if (idPaciente <= 0) {
            throw new SecretarioException("ID do paciente invalido");
        }

        PacienteModel paciente = pacienteDAO.buscarPorId(idPaciente);
        if (paciente == null) {
            throw new SecretarioException("Paciente não encontrado");
        }
        return paciente;
    }

    public PacienteModel buscarPacientePorCpf(String cpf) throws SQLException, SecretarioException {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new SecretarioException("CPF não informado");
        }

        PacienteModel pacienteModel = pacienteDAO.buscarPorCpf(cpf);
        if (pacienteModel == null) {
            throw new SecretarioException("Paciente não encontrado com CPF: " + cpf);
        }
        return pacienteModel;
    }

    public List<PacienteModel> listarTodosPacientes() throws SQLException {
        return pacienteDAO.listarTodosPacientes();
    }

    public boolean atualizarPaciente(PacienteModel paciente) throws SQLException, SecretarioException {
        if (paciente == null) {
            throw new SecretarioException("Paciente não pode ser nulo");
        }
        if (paciente.getIdPaciente() <= 0) {
            throw new SecretarioException("ID do paciente invalido");
        }

        validarPacienteExistente(paciente.getIdPaciente());

        return pacienteDAO.atualizarPaciente(paciente);
    }

    public boolean removerPaciente(int idPaciente) throws SQLException, SecretarioException {
        if (idPaciente <= 0) {
            throw new SecretarioException("ID do paciente invalido");
        }

        validarPacienteExistente(idPaciente);

        List<ConsultaModel> consultasFuturas = consultaDAO.listarConsultasPorPaciente(idPaciente);
        LocalDateTime agora = LocalDateTime.now();
        boolean temConsultaFutura = consultasFuturas.stream()
                .anyMatch(c -> c.getHorarioConsulta().isAfter(agora));

        if (temConsultaFutura) {
            throw new SecretarioException("Não é possivel remover paciente com consulta futuras agendada");

        }
        return pacienteDAO.removerPaciente(idPaciente);
    }

    public List<MedicoModel> listarTodosMedicos() throws SQLException {
        return medicoDAO.listarTodosMedicos();
    }

    public MedicoModel buscarMedicoPorId(int idMedico) throws SQLException, SecretarioException {
        if (idMedico <= 0) {
            throw new SecretarioException("ID do médico inválido");
        }

        MedicoModel medico = medicoDAO.buscarPorId(idMedico);
        if (medico == null) {
            throw new SecretarioException("Médico não encontrado");
        }
        return medico;
    }

    public List<MedicoModel> listarMedicosPorEspecialidade(String especialidade) throws SQLException {
        if (especialidade == null || especialidade.trim().isEmpty()) {
            return listarTodosMedicos();
        }

        List<MedicoModel> todos = medicoDAO.listarTodosMedicos();
        return todos.stream()
                .filter(m -> m.getEspecialidadeMedico() != null &&
                        m.getEspecialidadeMedico().toLowerCase().contains(especialidade.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void agendarConsulta(ConsultaModel consulta) throws SQLException, SecretarioException {
        validarConsulta(consulta);

        MedicoModel medico = medicoDAO.buscarPorId(consulta.getIdMedico());
        if (medico == null) {
            throw new SecretarioException("Médico não encontrado");
        }

        PacienteModel paciente = pacienteDAO.buscarPorId(consulta.getIdPaciente());
        if (paciente == null) {
            throw new SecretarioException("Paciente não encontrado");
        }

        HospitalModel hospital = hospitalDAO.buscarPorId(consulta.getIdHospital());
        if (hospital == null) {
            throw new SecretarioException("Hospital não encontrado");
        }

        if (!isMedicoDisponivel(consulta.getIdMedico(), consulta.getHorarioConsulta())) {
            throw new SecretarioException("Médico não disponível neste horário");
        }

        if (isPacienteOcupado(consulta.getIdPaciente(), consulta.getHorarioConsulta())) {
            throw new SecretarioException("Paciente já possui uma consulta agendada neste horário");
        }

        boolean cadastrado = consultaDAO.cadastrarConsulta(consulta);
        if (!cadastrado) {
            throw new SecretarioException("Erro ao cadastrar consulta");
        }
    }

    public boolean cancelarConsulta(int idConsulta) throws SQLException, SecretarioException {
        if (idConsulta <= 0) {
            throw new SecretarioException("ID da consulta invalido");
        }

        ConsultaModel consulta = consultaDAO.buscarPorId(idConsulta);
        if (consulta == null) {
            throw new SecretarioException("Consulta não encontrada");
        }

        if (consulta.getHorarioConsulta().isBefore(LocalDateTime.now())) {
            throw new SecretarioException("Não é possível cancelar uma consulta que já passou");
        }

        return consultaDAO.deletarConsulta(idConsulta);
    }

    public boolean reagendarConsulta(int idConsulta, LocalDateTime novoHorario) throws SQLException, SecretarioException {
        if (idConsulta <= 0) {
            throw new SecretarioException("ID da consulta inválido");
        }
        if(novoHorario == null)
        {
            throw new SecretarioException("Novo horario não informado");
        }
        if(novoHorario.isBefore(LocalDateTime.now()))
        {
            throw new SecretarioException("Nao é possivel reagendar para uma data ou hora passada");
        }

        ConsultaModel consultaModel = consultaDAO.buscarPorId(idConsulta);
        if(consultaModel == null)
        {
            throw new SecretarioException("Consulta não encontrada");
        }

        if(!isMedicoDisponivel(consultaModel.getIdConsulta(), novoHorario))
        {
            throw new SecretarioException("Médico não disponivel neste horario");
        }

        if(!isPacienteOcupado(consultaModel.getIdPaciente(), novoHorario))
        {
            throw new SecretarioException("Paciente ja possui uma consulta agendada nesse horario");
        }

        return consultaDAO.atualizarHorario(idConsulta, novoHorario);
    }

    public List<ConsultaModel> listarConsultasPorPaciente(int idPaciente) throws SQLException, SecretarioException {
        if (idPaciente <= 0) {
            throw new SecretarioException("ID do paciente inválido");
        }
        return consultaDAO.listarConsultasPorPaciente(idPaciente);
    }

    public List<ConsultaModel> listarConsultasPorMedico(int idMedico) throws SQLException, SecretarioException {
        if (idMedico <= 0) {
            throw new SecretarioException("ID do médico inválido");
        }
        return consultaDAO.listarConsultasPorMedico(idMedico);
    }

    public List<ConsultaModel> listarTodasConsultas() throws SQLException {
        return consultaDAO.listarConsultas();
    }

    public List<ConsultaModel> buscarProximasConsultas() throws SQLException {
        return consultaDAO.buscarProximasConsultas();
    }

    public List<ConsultaModel> buscarConsultaPorPeriodo(LocalDateTime inicio, LocalDateTime fim) throws SQLException
    {
        if(inicio == null || fim == null)
        {
            throw new SecretarioException("Periodo nao informado");
        }
        if(inicio.isAfter(fim))
        {
            throw new SecretarioException("Data de inicio não pode ser posterior a data de fim");
        }

        List<ConsultaModel> todas = consultaDAO.listarConsultas();
        return todas.stream()
                .filter(c -> !c.getHorarioConsulta().isBefore(inicio) && !c.getHorarioConsulta().isAfter(fim))
                .collect(Collectors.toList());
    }

    public List<HospitalModel> listarHospitais() throws SQLException {
        return hospitalDAO.listarHospitais();
    }

    private void validarSecretarioExistente(int idSecretario) throws SecretarioException {
        if (idSecretario <= 0) {
            throw new SecretarioException("ID do secretário inválido");
        }

        SecretarioModel secretario = secretarioDAO.buscarPorId(idSecretario);
        if (secretario == null) {
            throw new SecretarioException("Secretário não encontrado");
        }
    }

    private void validarPacienteExistente(int idPaciente) throws SecretarioException {
        if (idPaciente <= 0) {
            throw new SecretarioException("ID do paciente inválido");
        }

        PacienteModel paciente = pacienteDAO.buscarPorId(idPaciente);
        if (paciente == null) {
            throw new SecretarioException("Paciente não encontrado");
        }
    }

    private void validarPaciente(PacienteModel paciente) throws SecretarioException {
        if (paciente.getNomeUsuario() == null || paciente.getNomeUsuario().trim().isEmpty()) {
            throw new SecretarioException("Nome do paciente é obrigatório");
        }
        if (paciente.getEmailUsuario() == null || paciente.getEmailUsuario().trim().isEmpty()) {
            throw new SecretarioException("Email do paciente é obrigatório");
        }
        if (!paciente.getEmailUsuario().contains("@")) {
            throw new SecretarioException("Email inválido");
        }
        if (paciente.getSenhaUsuario() == null || paciente.getSenhaUsuario().trim().isEmpty()) {
            throw new SecretarioException("Senha é obrigatória");
        }
        if (paciente.getCpfUsuario() == null || paciente.getCpfUsuario().trim().isEmpty()) {
            throw new SecretarioException("CPF é obrigatorio");
        }
        if (paciente.getCpfUsuario().length() != 11) {
            throw new SecretarioException("CPF deve conter 11 dígitos");
        }
        if (paciente.getTelefoneUsuario() == null || paciente.getTelefoneUsuario().trim().isEmpty()) {
            throw new SecretarioException("Telefone é obrigatório");
        }
        if (paciente.getEnderecoPaciente() == null || paciente.getEnderecoPaciente().trim().isEmpty()) {
            throw new SecretarioException("Endereço é obrigatório");
        }
    }

    private void validarConsulta(ConsultaModel consulta) throws SecretarioException {
        if (consulta == null) {
            throw new SecretarioException("Consulta não pode ser nula");
        }
        if (consulta.getIdPaciente() <= 0) {
            throw new SecretarioException("ID do paciente inválido");
        }
        if (consulta.getIdMedico() <= 0) {
            throw new SecretarioException("ID do médico inválido");
        }
        if (consulta.getIdHospital() <= 0) {
            throw new SecretarioException("ID do hospital inválido");
        }
        if (consulta.getLocalEndereco() == null || consulta.getLocalEndereco().trim().isEmpty()) {
            throw new SecretarioException("Endereço do hospital não informado");
        }
        if (consulta.getHorarioConsulta() == null) {
            throw new SecretarioException("Horário da consulta não informado");
        }
        if (consulta.getHorarioConsulta().isBefore(LocalDateTime.now())) {
            throw new SecretarioException("Não é possível agendar consultas no passado");
        }
    }

    private boolean isMedicoDisponivel(int idMedico, LocalDateTime horario) throws SQLException {
        List<ConsultaModel> consultas = consultaDAO.listarConsultasPorMedico(idMedico);
        return consultas.stream()
                .noneMatch(c -> c.getHorarioConsulta().equals(horario));
    }

    private boolean isPacienteOcupado(int idPaciente, LocalDateTime horario) throws SQLException {
        List<ConsultaModel> consultas = consultaDAO.listarConsultasPorPaciente(idPaciente);
        return consultas.stream()
                .anyMatch(c -> c.getHorarioConsulta().equals(horario));
    }

}
