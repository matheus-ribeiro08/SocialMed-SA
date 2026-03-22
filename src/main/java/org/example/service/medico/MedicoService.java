package org.example.service.medico;

import org.example.dao.*;
import org.example.exception.MedicoException;
import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.ProntuarioModel;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MedicoService {

    private final MedicoDAO medicoDAO;
    private final ConsultaDAO consultaDAO;
    private final ProntuarioDAO prontuarioDAO;
    private final UsuarioDAO usuarioDAO;
    private final PacienteDAO pacienteDAO;

    public MedicoService(){
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

    public MedicoModel buscarPorId(int idMedico) throws SQLException, MedicoException{
        if(idMedico >= 0){
            throw new MedicoException("Id do medico invalido");
        }

        MedicoModel medico = medicoDAO.buscarPorId(idMedico);
        if(medico == null){
            throw new MedicoException("Medico nao encontrado");
        }
        return medico;
    }

    public MedicoModel buscarPorIdUsuario(int idUsuario) throws SQLException, MedicoException {
        if(idUsuario <= 0){
            throw new MedicoException("Usuario nao encontrado");
        }

        MedicoModel medico = medicoDAO.buscarPorIdUsuario(idUsuario);
        if(medico == null){
            throw new MedicoException("Medico nao encontrado para o usuario informado");
        }
        return medico;
    }

    public List<MedicoModel> listarTodosMedicos() throws SQLException{
        return medicoDAO.listarTodosMedicos();
    }

    public boolean atualizarMedico(MedicoModel medico) throws SQLException, MedicoException{
        if(medico == null){
            throw new MedicoException("Medico nao pode ser nulo");
        }
        if(medico.getIdMedico() <= 0){
            throw new MedicoException("Id do medico invalido");
        }

        validarMedicoExistente(medico.getIdMedico());

        return medicoDAO.atualizarMedico(medico);
    }

    public ConsultaModel buscarConsultaPorId(int idConsulta) throws SQLException, MedicoException{
        if(idConsulta <= 0){
            throw new MedicoException("Id da consulta invalido");
        }

        ConsultaModel consulta = consultaDAO.buscarPorId(idConsulta);
        if(consulta == null){
            throw new MedicoException("Consulta nao encontrada");
        }
        return consulta;
    }

    public List<ConsultaModel> buscarProximasConsultasMedico(int idMedico, int limite) throws SQLException, MedicoException{
        validarMedicoExistente(idMedico);

        if(limite <= 0){
            throw new MedicoException("Limite invalido");
        }

        LocalDateTime agora = LocalDateTime.now();
        List<ConsultaModel> todasConsultas = consultaDAO.listarConsultasPorMedico(idMedico);

        return todasConsultas.stream().filter(c -> c.getHorarioConsulta().isAfter(agora)).limit(limite).collect(Collectors.toList());
    }

    public List<ConsultaModel> buscarHistoricoMedico(int idMedico) throws SQLException, MedicoException{

        validarMedicoExistente(idMedico);
        return consultaDAO.historicoDeConsultasMedico(idMedico);
    }

    public List<ConsultaModel> buscarHistoricoPacienteComMedico(int idPaciente, int idMedico) throws SQLException, MedicoException{

        validarMedicoExistente(idMedico);

        if(idPaciente <= 0){
            throw new MedicoException("ID do paciente invalido");
        }

        List<ConsultaModel> historico = consultaDAO.historicoDeConsultasMedico(idMedico);
        return historico.stream().filter(c -> c.getIdPaciente() == idPaciente).collect(Collectors.toList());
    }

    public List<ConsultaModel> buscarConsultasHoje(int idMedico) throws SQLException, MedicoException{

        validarMedicoExistente(idMedico);

        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime inicioData = hoje.toLocalDate().atStartOfDay();
        LocalDateTime fimDia = inicioData.plusDays(1).minusNanos(1);

        List<ConsultaModel> todosConsultas = consultaDAO.listarConsultasPorMedico(idMedico);

        return todosConsultas.stream().filter(c -> c.getHorarioConsulta().isAfter(inicioData) &&
                                                            c.getHorarioConsulta().isBefore(fimDia)).collect(Collectors.toList());
    }

    public void realizarAtendimento(MedicoModel medico, ConsultaModel consulta, String diagnostico, String prescricao,
                                    String observacoes) throws SQLException, MedicoException{
        if(medico == null){
            throw new MedicoException("Medico nao autenticado");
        }
        if(consulta == null){
            throw new MedicoException("Consulta nao pode ser nula");
        }
        if(diagnostico == null){
            throw new MedicoException("Diagnostico é obrigatorio");
        }
        if(prescricao == null || prescricao.trim().isEmpty()){
            throw new MedicoException("Prescrição é obrigatoria");
        }

        validarMedicoExistente(medico.getIdMedico());

        if(consulta.getIdMedico() != medico.getIdMedico()){
            throw new MedicoException("Esta consulta nao pertence ao medico logado");
        }

        ProntuarioModel prontuario = prontuarioDAO.buscarPorPaciente(consulta.getIdPaciente());

        if(prontuario == null){
            prontuario = new ProntuarioModel();
            prontuario.setIdPaciente(consulta.getIdPaciente());
            prontuario.setIdMedico(medico.getIdMedico());
            prontuario.setDataRegistro(LocalDateTime.now());
            prontuario.setIdConsulta(consulta.getIdConsulta());
        }

        prontuario.setDiagnostico(diagnostico);
        prontuario.setPrescricaoMedica(prescricao);
        prontuario.setObservacoes(observacoes);

        if(prontuario.getIdProntuario() == 0){
            prontuarioDAO.cadastrarProntuario(prontuario);
        }else {
            prontuarioDAO.atualizarProntuario(prontuario);
        }
    }

    private String formatarObservacaoAtendimento(String observacoes, MedicoModel medico) throws SQLException, MedicoException{
        StringBuilder sb = new StringBuilder();
        sb.append("[ATENDIMENTO - ");
        sb.append(LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd//MM/yyyy HH:mm")));
        sb.append(" - Dr(a). ");
        sb.append(medico.getNomeUsuario());
        sb.append("]\n");

        if(observacoes != null && !observacoes.trim().isEmpty()){
            sb.append(observacoes);
        }else{
            sb.append("Atendimento realizado sem observações adicionais")
        }

        return sb.toString();
    }

    public ProntuarioModel buscarProntuarioPorPaciente(int idPaciente) throws SQLException, MedicoException{
        if(idPaciente <= 0){
            throw new MedicoException("Id do paciente invalido");
        }

        return prontuarioDAO.buscarPorPaciente(idPaciente);
    }

    public boolean criarProntuario(ProntuarioModel prontuario) throws SQLException, MedicoException{
        if(prontuario == null){
            throw new MedicoException("Prontuario nao pode ser nulo");
        }
        if(prontuario.getIdPaciente() <= 0){
            throw new MedicoException("Id do paciente invalido");
        }

        prontuario.setDataRegistro(LocalDateTime.now());
        return prontuarioDAO.cadastrarProntuario(prontuario);
    }

    public boolean atualizarProntuario(ProntuarioModel prontuario) throws SQLException, MedicoException{
        if(prontuario == null){
            throw new MedicoException("Prontuario nao pode ser nulo");
        }
        if(prontuario.getIdProntuario() <= 0){
            throw new MedicoException("Id do prontuario invalido");
        }

        return prontuarioDAO.atualizarProntuario(prontuario);
    }

    public void adicionarInformacaoProntuario(ProntuarioModel prontuario, String novaInformacao, MedicoModel medico) throws SQLException, MedicoException{
        if(prontuario == null){
            throw new MedicoException("Prontuario nao encontrado");
        }
        if(novaInformacao == null || novaInformacao.trim().isEmpty()){
            throw new MedicoException("Informaçao nao pode ser vazia");
        }
        if(medico == null){
            throw new MedicoException("Medico nao autenticado");
        }

        String informacaoAdicional = String.format(
                "[%s - Dr(a). %s] %s\n",
                LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                medico.getNomeUsuario(),
                novaInformacao
        );

        String observacoesAtuais = prontuario.getObservacoes();
        if(observacoesAtuais == null || observacoesAtuais.isEmpty()){
            prontuario.setObservacoes(informacaoAdicional);
        }else{
            prontuario.setObservacoes(observacoesAtuais + informacaoAdicional);
        }

        prontuarioDAO.atualizarProntuario(prontuario);
    }

    public PacienteModel buscarPacientePorCpf(String cpf) throws SQLException, MedicoException{
        if(cpf == null || cpf.trim().isEmpty()){
            throw new MedicoException("Cpf nao informado");
        }
        return pacienteDAO.buscarPorCpf(cpf);
    }

    public void solicitarExame(MedicoModel medico, PacienteModel paciente, String tipoExame, String observacoes) throws MedicoException{
        if(medico == null){
            throw new MedicoException("Medico nao autenticado");
        }
        if(paciente == null){
            throw new MedicoException("Paciente nao autenticado");
        }
        if(tipoExame == null || tipoExame.trim().isEmpty()){
            throw new MedicoException("Tipo de exame nao autenticado");
        }

        ExameModel exame = new ExameModel();
        exame.setIdMedico(medico.getIdMedico());
        exame.setIdPaciente(paciente.getIdPaciente());
        exame.setTipoExame(tipoExame);
        exame.setObservacoes(observacoes);
        exame.setDataSolicitacao(LocalDateTime.now());
        exame.setStatus("Solicitado");
        exameDAO.cadastrar(exame);

        System.out.println("Exame solicidado");
        System.out.println("Medico: " + medico.getNomeUsuario());
        System.out.println("Paciente: " + paciente.getNomeUsuario());
        System.out.println("Tipo exame: " + tipoExame);
        System.out.println("Observações: " + observacoes);

    }

    private void validarMedicoExistente(int idMedico) throws MedicoException{
        if(idMedico <= 0){
            throw new MedicoException("Id do medico invalido");
        }

        MedicoModel medico = medicoDAO.buscarPorId(idMedico);
        if(medico == null){
            throw new MedicoException("Medico nao encontrado");
        }
    }

    private void validarPacienteExistente(int idPaciente) throws MedicoException{
        if(idPaciente <= 0){
            throw new MedicoException("Id do paciente invalido");
        }

        PacienteModel paciente = pacienteDAO.buscarPorId(idPaciente);
        if(paciente == null){
            throw new MedicoException("Paciente nao encontrado");
        }
    }

    public boolean medicoExiste(int idMedico) throws MedicoException{
        if(idMedico <= 0){
            return false;
        }
        MedicoModel medico = medicoDAO.buscarPorId(idMedico);
        return medico != null;
    }

    public boolean isMedicoDisponivel(int idMedico, LocalDateTime horario) throws SQLException, MedicoException{
        validarMedicoExistente(idMedico);

        if(horario == null){
            throw new MedicoException("Horario nao informado");
        }

        List<ConsultaModel> consultas = consultaDAO.listarConsultasPorMedico(idMedico);
        return consultas.stream().noneMatch(c -> c.getHorarioConsulta().equals(horario));
    }

    public int contarConsultasRealizadas(int idMedico)throws  SQLException, MedicoException{
        validarMedicoExistente(idMedico);

        List<ConsultaModel> historico = consultaDAO.historicoDeConsultasMedico(idMedico);
        return historico.size();
    }

    public int contarPacienteAtendidos(int idMedico) throws SQLException, MedicoException{
        validarMedicoExistente(idMedico);

        List<ConsultaModel> historico = consultaDAO.historicoDeConsultasMedico(idMedico);
        return (int) historico.stream().map(ConsultaModel::getIdPaciente).distinct().count();
    }


}
