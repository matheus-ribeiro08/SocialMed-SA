package org.example.presenter.paciente;

import org.example.enums.Destinos;
import org.example.enums.TipoUsuario;
import org.example.model.*;
import org.example.roteador.Roteador;
import org.example.service.consulta.ConsultaService;
import org.example.service.hospital.HospitalService;
import org.example.service.medico.MedicoService;
import org.example.service.paciente.PacienteService;
import org.example.service.prontuario.ProntuarioService;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfacePaciente.IMenuPacienteView;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class
MenuPacientePresenter {

    private final Roteador roteador;
    private final PacienteModel paciente;
    private final IMenuPacienteView view;
    private final ConsultaService consultaService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    private final ProntuarioService prontuarioService;
    private final HospitalService hospitalService;

    public MenuPacientePresenter(Roteador roteador, PacienteModel paciente, IMenuPacienteView view){
        this.roteador = roteador;
        this.paciente = paciente;
        this.view = view;
        this.consultaService = new ConsultaService();
        this.pacienteService = new PacienteService();
        this.medicoService = new MedicoService();
        this.prontuarioService = new ProntuarioService();
        this.hospitalService = new HospitalService();
    }

    public void iniciar() {
        boolean execuntando = true;

        while (execuntando) {
            int opcao = view.mostrarMenuPrincipal(paciente.getNomeUsuario());

            try {
                switch (opcao) {
                    case 1: {
                        verMinhasConsultas();
                        break;
                    }
                    case 2: {
                        agendarConsulta();
                        break;
                    }
                    case 3: {
                        cancelarConsulta();
                        break;
                    }
                    case 4: {
                        verHistoricoConsultas();
                        break;
                    }
                    case 5: {
                        acessarProntuario();
                        break;
                    }
                    case 6: {
                        visualizarPerfil();
                        break;
                    }
                    case 7: {
                        buscarMedicoPorEspecialidade();
                        break;
                    }
                    case 8: {
                        editarPerfil();
                        break;
                    }
                    case 9: {
                        view.abrirMapaLocalizacao();
                        break;
                    }
                    case 0: {
                        execuntando = false;
                        roteador.irPara(Destinos.MENU_INICIAL, null);
                    }
                    default:{
                        view.mostrarMensagemErro("Opção invalida");
                    }
                }
            }catch (Exception e){
                view.mostrarMensagemErro("Erro!");
            }
        }
    }

    private void verMinhasConsultas(){
        view.mostrarTitulo("Minhas consultas");

        try {
            List<ConsultaModel> consultas = consultaService.buscarConsultasPorPaciente(paciente.getIdPaciente());

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta agendada");
            }else{
                view.mostrarListaConsultas(consultas);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao ver as suas consultas");
        }

    }

    private void agendarConsulta(){
        view.mostrarTitulo("Agendar consulta");

        try {
            String especialidade = view.lerEspecialidade();

            List<MedicoModel> medicos = medicoService.buscarMedicoPorEspecialidade(especialidade);

            if(medicos.isEmpty()){
                view.mostrarMensagemInfo("Nenhum medico encontrado para esta especialidade");
                return;
            }

            view.mostrarListaMedicos(medicos);

            int idMedico = view.selecionarMedico(medicos);
            MedicoModel medico = medicoService.buscarPorId(idMedico);

            if(medico == null){
                view.mostrarMensagemErro("Medico nao encontrado");
                return;
            }

            String data = view.lerData();
            List<String> horarios = consultaService.buscarHorariosDisponiveis(medico.getIdMedico(), data);

            if(horarios.isEmpty()){
                view.mostrarMensagemInfo("Nenhum horario disponivel para esta data");
                return;
            }

            String horarioStr = view.selecionarHorario(horarios);
            LocalDateTime horarioConsulta = consultaService.converterStringParaDateTime(data, horarioStr);

            if(horarios.isEmpty()){
                view.mostrarMensagemInfo("Nenhum horario disponivel para esta data");
                return;
            }

            HospitalModel hospital = hospitalService.buscarHospitalDoMedico(medico.getIdMedico());

            String descricao = view.lerDescricaoAgendamento();

            ConsultaModel consulta = new ConsultaModel();
            consulta.setIdMedico(medico.getIdMedico());
            consulta.setIdPaciente(paciente.getIdPaciente());
            consulta.setIdHospital(hospital.getIdHospital());
            consulta.setLocalEndereco(hospital.getEnderecoHospital());
            consulta.setHorarioConsulta(horarioConsulta);
            
            consultaService.agendarConsulta(consulta);

            view.mostrarMensagemSucesso("Consulta agendada com sucesso!");
            view.mostrarDetalhesConsulta(consulta);

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao agendar consulta");
        }
    }

    private void cancelarConsulta(){
        view.mostrarTitulo("Cancelar consulta");

        try {
            List<ConsultaModel> consultas = consultaService.buscarConsultasPorPaciente(paciente.getIdPaciente());

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhumna consulta ativa para cancelar");
                return;
            }

            view.mostrarListaConsultas(consultas);

            int idConsulta = view.lerIdConsulta();
            ConsultaModel consulta = consultaService.buscarConsultaPorId(idConsulta);

            if(consulta == null){
                view.mostrarMensagemErro("Consulta nao encontrada");
                return;
            }

            if(consulta.getIdPaciente() != paciente.getIdPaciente()){
                view.mostrarMensagemErro("Esta consulta nao pertence a voce");
                return;
            }

            if(view.perguntarAcao("Tem certeza que deseja cancelar esta consulta")){
                boolean cancelado = consultaService.cancelarConsulta(idConsulta);

                if(cancelado){
                    view.mostrarMensagemSucesso("Consulta cancelada com sucesso");
                }else {
                    view.mostrarMensagemErro("Erro ao cancelar consulta");
                }
            }

        } catch (SQLException e) {
            view.mostrarMensagemErro("Erro ao cancelar consulta");
        }
    }


    private void acessarProntuario(){
        view.mostrarTitulo("Meu prontuario");

        try {
            ProntuarioModel prontuario = prontuarioService.buscarPorPaciente(paciente.getIdPaciente());

            if(prontuario == null){
                view.mostrarMensagemInfo("Voce ainda nao possui prontuario");
                return;
            }

            view.mostrarProntuario(prontuario);

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao acessar prontuario");
        }
    }

    private void verHistoricoConsultas(){
        view.mostrarTitulo("Historico consultas");

        try {
            List<ConsultaModel> historico = consultaService.listarHistoricoConsultaPaciente(paciente.getIdPaciente());

            if(historico.isEmpty()){
                view.mostrarMensagemInfo("Nenhum historico de consultas encontrado");
            }else {
                view.mostrarHistoricoConsultas(historico);
            }

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao mostrar historico de consultas");
        }
    }

    private void visualizarPerfil(){
        view.mostrarTitulo("Meu perfil");
        view.mostrarDadosPaciente(paciente);

        if(view.perguntarAcao("Deseja editar seus dados?")){
            editarPerfil();
        }
    }

    private void editarPerfil(){
        view.mostrarTitulo("Editar perfil");

        try {
            view.lerDadosAtualizacaoPaciente(paciente);

            String nomeCompleto = view.lerNomeCompleto();
            String senha = view.lerSenha();
            String email = view.lerEmail();
            String telefone = view.lerTelefone();
            String endereco = view.lerEndereco();

            boolean atualizado = pacienteService.atualizar(paciente);

            if(atualizado){
                view.mostrarMensagemSucesso("Perfil atualizado com sucesso");
            }else{
                view.mostrarMensagemErro("Erro ao atualizar perfil");
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao editar perfil");
        }
    }

    private void buscarMedicoPorEspecialidade(){
        view.mostrarTitulo("Buscar medico por especialidade");

        try {
            String especialidade = view.lerEspecialidade();

            List<MedicoModel> medicos = medicoService.buscarMedicoPorEspecialidade(especialidade);

            if(medicos.isEmpty()){
                view.mostrarMensagemInfo("Nenhum medico encontrado para a especialidade");
            }else {
                view.mostrarListaMedicos(medicos);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao buscar medicos");
        }
    }

}

