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
        Ferramentas.Delay(1500);
        Ferramentas.limpaTerminalOpcional(30);
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
                Ferramentas.Delay(1500);
                Ferramentas.limpaTerminalOpcional(30);
            }catch (Exception e){
                view.mostrarMensagemErro("Erro!");
                Ferramentas.Delay(1500);
                Ferramentas.limpaTerminalOpcional(30);
            }
        }
    }

    private void verMinhasConsultas(){
        view.mostrarTitulo("Minhas consultas");
        Ferramentas.limpaTerminalOpcional(30);

        try {
            List<ConsultaModel> consultas = consultaService.buscarConsultasPorPaciente(paciente.getIdPaciente());

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta agendada");
            }else{
                for(ConsultaModel consulta : consultas){
                view.mostrarListaConsultas(consulta);
            }
        }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao ver as suas consultas");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }

    }

    private void agendarConsulta(){
        view.mostrarTitulo("Agendar consulta");
        Ferramentas.limpaTerminalOpcional(30);

        try {
            String especialidade = view.lerEspecialidade();

            List<MedicoModel> medicos = medicoService.buscarMedicoPorEspecialidade(especialidade);

            if(medicos.isEmpty()){
                view.mostrarMensagemInfo("Nenhum medico encontrado para esta especialidade");
                return;
            }

            for(MedicoModel medico : medicos) {
                view.mostrarListaMedicos(medico);
            }

            int idMedico = view.selecionarMedico();
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

            String horarioStr = view.lerHorario();
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
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao agendar consulta");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }
    }

    private void cancelarConsulta(){
        view.mostrarTitulo("Cancelar consulta");
        Ferramentas.limpaTerminalOpcional(30);

        try {
            List<ConsultaModel> consultas = consultaService.buscarConsultasPorPaciente(paciente.getIdPaciente());

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhumna consulta ativa para cancelar");
                return;
            }

            for(ConsultaModel consulta : consultas){
                view.mostrarListaConsultas(consulta);
            }

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
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);

        } catch (SQLException e) {
            view.mostrarMensagemErro("Erro ao cancelar consulta");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }
    }


    private void acessarProntuario(){
        view.mostrarTitulo("Meu prontuario");
        Ferramentas.limpaTerminalOpcional(30);

        try {
            ProntuarioModel prontuario = prontuarioService.buscarPorPaciente(paciente.getIdPaciente());

            if(prontuario == null){
                view.mostrarMensagemInfo("Voce ainda nao possui prontuario");
                return;
            }

            view.mostrarProntuario(prontuario);

            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao acessar prontuario");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }
    }

    private void verHistoricoConsultas(){
        view.mostrarTitulo("Historico consultas");
        Ferramentas.limpaTerminalOpcional(30);

        try {
            List<ConsultaModel> historico = consultaService.listarHistoricoConsultaPaciente(paciente.getIdPaciente());

            if(historico.isEmpty()){
                view.mostrarMensagemInfo("Nenhum historico de consultas encontrado");
            }else {
                for (ConsultaModel consulta : historico) {
                    view.mostrarHistoricoConsultas(consulta);
                }
            }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao mostrar historico de consultas");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }
    }

    private void visualizarPerfil(){
        view.mostrarTitulo("Meu perfil");
        Ferramentas.limpaTerminalOpcional(30);

        PacienteModel detalhesBanco = pacienteService.buscarDetalhe(paciente.getIdUsuario());

        if(detalhesBanco != null)
        {
            paciente.setEnderecoPaciente((detalhesBanco.getEnderecoPaciente()));
        }
        view.mostrarDadosPaciente(paciente);

        if(view.perguntarAcao("Desejar editar seus dados?"));
        editarPerfil();
        Ferramentas.Delay(1500);
        Ferramentas.limpaTerminalOpcional(30);
    }

    private void editarPerfil(){
        view.mostrarTitulo("Editar perfil");
        Ferramentas.limpaTerminalOpcional(30);

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
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao editar perfil");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }
    }

    private void buscarMedicoPorEspecialidade(){
        view.mostrarTitulo("Buscar medico por especialidade");
        Ferramentas.limpaTerminalOpcional(30);

        try {
            String especialidade = view.lerEspecialidade();

            List<MedicoModel> medicos = medicoService.buscarMedicoPorEspecialidade(especialidade);

            if(medicos.isEmpty()){
                view.mostrarMensagemInfo("Nenhum medico encontrado para a especialidade");
            }else {
                for(MedicoModel medico : medicos){
                    view.mostrarListaMedicos(medico);
                }
            }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao buscar medicos");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }
    }

}

