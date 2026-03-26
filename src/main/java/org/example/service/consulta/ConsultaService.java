package org.example.service.consulta;

import org.example.dao.ConsultaDAO;
import org.example.dao.HospitalDAO;
import org.example.dao.MedicoDAO;
import org.example.dao.PacienteDAO;
import org.example.exception.ConsultaException;
import org.example.model.ConsultaModel;
import org.example.model.HospitalModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;

import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsultaService {

    private ConsultaDAO consultaDAO;
    private MedicoDAO medicoDAO;
    private HospitalDAO hospitalDAO;
    private PacienteDAO pacienteDAO;

    public ConsultaService(){
        this.consultaDAO = new ConsultaDAO();
        this.medicoDAO = new MedicoDAO();
        this.hospitalDAO = new HospitalDAO();
        this.pacienteDAO = new PacienteDAO();
    }

    public ConsultaService(ConsultaDAO consultaDAO, MedicoDAO medicoDAO, HospitalDAO hospitalDAO, PacienteDAO pacienteDAO){
        this.consultaDAO = consultaDAO;
        this.medicoDAO = medicoDAO;
        this.hospitalDAO = hospitalDAO;
        this.pacienteDAO = pacienteDAO;
    }

    public List<HospitalModel> listarHospitais() throws SQLException{
        return hospitalDAO.listarHospitais();
    }

    public ConsultaModel buscarConsultaPorId(int idConsulta) throws SQLException{
        if (idConsulta <= 0){
            throw new IllegalArgumentException("Id da consulta inválido");
        }
        return consultaDAO.buscarPorId(idConsulta);
    }


    public MedicoModel buscarMedicoPorId(int idMedico) throws SQLException{
        if (idMedico <= 0){
            throw new IllegalArgumentException("Id do médico inválido");
        }
        return medicoDAO.buscarPorId(idMedico);
    }

    public PacienteModel buscarPacientePorId(int idPaciente) throws SQLException{
        if (idPaciente <= 0){
            throw new IllegalArgumentException("Id do paciente inválido");
        }
        return pacienteDAO.buscarPorId(idPaciente);
    }

    public List<ConsultaModel> buscarConsultasPorPaciente(int idPaciente) throws SQLException{
        if (idPaciente <= 0){
            throw new IllegalArgumentException("Id do paciente inválido");
        }
        return consultaDAO.listarConsultasPorPaciente(idPaciente);
    }

    public List<String> buscarHorariosDisponiveis(int idMedico, String dataStr){

        if (idMedico <= 0){
            throw new ConsultaException("Id do medico invalido");
        }
        if(dataStr == null || dataStr.trim().isEmpty()){
            throw new ConsultaException("Data nao informada");
        }

        LocalDate data;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(dataStr, formatter);
        }catch (DateTimeParseException e){
            throw new ConsultaException("Formato de data invalido");
        }

        if(data.isBefore(LocalDate.now())){
            throw new ConsultaException("Nao é possivel agendar consultas em datas passadas");
        }

        List<ConsultaModel> consultaDoDia;
        try {
            consultaDoDia = consultaDAO.listarConsultasPorMedicoEData(idMedico, data);
        }catch (SQLException e){
            throw new ConsultaException("Erro ao buscar horarios ja disponiveis");
        }

        Set<String> horariosOcupados = new HashSet<>();
        for (ConsultaModel c : consultaDoDia){
            LocalDateTime horario = c.getHorarioConsulta();
            if(horario.toLocalDate().equals(data)){
                String horarioStr = horario.format(DateTimeFormatter.ofPattern("HH:mm"));
                horariosOcupados.add(horarioStr);
            }
        }

        List<String> horariosDisponiveis = new ArrayList<>();
        LocalTime inicio = LocalTime.of(8, 0);
        LocalTime fim = LocalTime.of(18, 0);
        Duration intervalo = Duration.ofMinutes(30);

        LocalTime horarioAtual = inicio;
        while (horarioAtual.isBefore(fim)) {
            String horarioStr = horarioAtual.format(DateTimeFormatter.ofPattern("HH:mm"));
            if (!horariosOcupados.contains(horarioStr)) {
                horariosDisponiveis.add(horarioStr);
            }
            horarioAtual = horarioAtual.plus(intervalo);
        }

        return horariosDisponiveis;
    }


    public void agendarConsulta(ConsultaModel consulta) throws Exception {

        validarConsulta(consulta);

        MedicoModel medico = medicoDAO.buscarPorId(consulta.getIdMedico());
        if(medico == null){
            throw new ConsultaException("Médico não encontrado");
        }

        PacienteModel paciente = pacienteDAO.buscarPorId(consulta.getIdPaciente());
        if(paciente == null){
            throw new ConsultaException("Paciente não encontrado");
        }

        HospitalModel hospital = hospitalDAO.buscarPorId(consulta.getIdHospital());
        if(hospital == null){
            throw new ConsultaException("Hospital não encontrado");
        }

        if(!idMedicoDisponivel(consulta.getIdMedico(), consulta.getHorarioConsulta())){
            throw new ConsultaException("Medico não disponivel neste horario");
        }

        if(isPacienteOcupado(consulta.getIdPaciente(), consulta.getHorarioConsulta())){
            throw new ConsultaException("Paciente ja possui uma consulta agendada nesse horario");
        }

        int idConsultaGerado = consultaDAO.cadastrarConsulta(consulta);

        if (idConsultaGerado > 0) {
            System.out.println("Consulta agendada com sucesso! O ID da consulta é: " + idConsultaGerado);
        } else {
            System.out.println("Erro ao agendar consulta. Verifique os dados.");
        }

    }

    private void validarConsulta(ConsultaModel consulta) throws Exception {
        if(consulta == null){
            throw new Exception("Consulta não pode ser nula");
        }
        if(consulta.getIdPaciente() <= 0){
            throw new Exception("ID do paciente invalido");
        }
        if(consulta.getIdMedico() <= 0){
            throw new Exception("ID do medico invalido");
        }
        if(consulta.getIdHospital() <= 0){
            throw new Exception("Id do hospital invalido");
        }
        if(consulta.getLocalEndereco() == null || consulta.getLocalEndereco().trim().isEmpty()){
            throw new Exception("Endereço do hospital não informado");
        }
        if(consulta.getHorarioConsulta() == null){
            throw new Exception("Horário da consulta não informado");
        }
        if(consulta.getHorarioConsulta().isBefore(LocalDateTime.now())){
            throw new Exception("Não é possivel agendar consultas no passado");
        }
    }

    public List<ConsultaModel> listarConsultasAtivas(int idPaciente) throws SQLException{
        LocalDateTime agora = LocalDateTime.now();
        return consultaDAO.listarConsultasPorPaciente(idPaciente);
    }

    public List<ConsultaModel> listarConsultasAtivasPorMedico(int idMedico) throws SQLException{
        if(idMedico <= 0){
            throw new IllegalArgumentException("Id do medico invalido");
        }
        LocalDateTime agora = LocalDateTime.now();
        List<ConsultaModel> todasConsultas = consultaDAO.listarConsultasPorMedico(idMedico);

        return todasConsultas.stream().filter(c -> c.getHorarioConsulta().isAfter(agora)).collect(Collectors.toList());
    }

    public List<ConsultaModel> listarConsultasAtivasPorPaciente(int idPaciente) throws SQLException{
        if(idPaciente <= 0){
            throw new IllegalArgumentException("Id do paciente invalido");
        }
        LocalDateTime agora = LocalDateTime.now();
        List<ConsultaModel> todasConsultas = consultaDAO.listarConsultasPorPaciente(idPaciente);

        return todasConsultas.stream().filter(c -> c.getHorarioConsulta().isAfter(agora)).collect(Collectors.toList());
    }

    public List<ConsultaModel> listarHistoricoConsultaMedico(int idMedico) throws SQLException{
        if(idMedico <= 0){
            throw new IllegalArgumentException("Id do medico invalido");
        }
        return consultaDAO.historicoDeConsultasMedico(idMedico);
    }

    public List<ConsultaModel> listarHistoricoConsultaPaciente(int idPaciente) throws SQLException{
        if(idPaciente <= 0){
            throw new IllegalArgumentException("Id do paciente invalido");
        }
        return consultaDAO.historicoDeConsultasPaciente(idPaciente);
    }

    public List<ConsultaModel> buscarProximasConsultasMedico(int idMedico, int limite) throws SQLException{
        if(idMedico <= 0){
            throw new IllegalArgumentException("Id do medico invalido");
        }
        if(limite <= 0){
            throw new IllegalArgumentException("Limite invalido");
        }

        List<ConsultaModel> consultas = listarConsultasAtivasPorMedico(idMedico);
        return consultas.stream().limit(limite).collect(Collectors.toList());
    }

    public List<ConsultaModel> buscarHistoricoPacienteComMedico(int idPaciente, int idMedico) throws SQLException{
        if(idPaciente <= 0){
            throw new IllegalArgumentException("Id do paciente invalido");
        }
        if(idMedico <= 0){
            throw new IllegalArgumentException("Id do medico invalido");
        }

        List<ConsultaModel> historico = consultaDAO.historicoDeConsultasMedico(idMedico);
        return historico.stream().filter(c -> c.getIdPaciente() == idPaciente).collect(Collectors.toList());
    }

    public List<ConsultaModel> buscarHistoricoMedico(int idMedico) throws SQLException{
        if(idMedico <= 0){
            throw new IllegalArgumentException("Id do medico invalido");
        }

        return consultaDAO.historicoDeConsultasMedico(idMedico);
    }

    public boolean cancelarConsulta(int idConsulta) throws SQLException{
        if(idConsulta <= 0){
            throw new IllegalArgumentException("Id da consulta invalido");
        }
        return consultaDAO.deletarConsulta(idConsulta);
    }

    private boolean idMedicoDisponivel(int idMedico, LocalDateTime horario) throws SQLException{
        List<ConsultaModel> consultaMedico = consultaDAO.listarConsultasPorMedico(idMedico);
        return consultaMedico.stream().noneMatch(c -> c.getHorarioConsulta().equals(horario));
    }

    private boolean isPacienteOcupado(int idPaciente, LocalDateTime horario) throws SQLException{
        List<ConsultaModel> consultasPaciente = consultaDAO.listarConsultasPorPaciente(idPaciente);
        return consultasPaciente.stream().anyMatch(c -> c.getHorarioConsulta().equals(horario));
    }

    public boolean isConsultaFutura(ConsultaModel consulta){
        return consulta != null &&
                consulta.getHorarioConsulta() != null &&
                consulta.getHorarioConsulta().isAfter(LocalDateTime.now());
    }

    public boolean isConsultaHoje(ConsultaModel consulta){
        if(consulta == null || consulta.getHorarioConsulta() == null){
            return false;
        }

        LocalDateTime hoje = LocalDateTime.now();
        return consulta.getHorarioConsulta().toLocalDate().equals(hoje.toLocalDate());
    }

    public List<ConsultaModel> buscarConsultasDoDia(int idMedico) throws SQLException{
        if(idMedico <= 0){
            throw new IllegalArgumentException("Id do medico invalido");
        }

        List<ConsultaModel> consultas = listarConsultasAtivasPorMedico(idMedico);
        return consultas.stream().filter(this::isConsultaHoje).collect(Collectors.toList());
    }

    public List<ConsultaModel> listarTodasConsultas() throws SQLException{
        return consultaDAO.listarConsultas();
    }

    public List<ConsultaModel> buscarProximasConsultas() throws SQLException{
        return consultaDAO.buscarProximasConsultas();
    }

    public LocalDateTime converterStringParaDateTime(String data, String hora) throws Exception{
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return LocalDateTime.parse(data + " " + hora, formatter);
        }catch (DateTimeException e){
            throw new Exception("Data ou hora invalida" + e.getMessage());
        }
    }

    public String formatarDateTime(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dateTime.format(formatter);
    }
}
