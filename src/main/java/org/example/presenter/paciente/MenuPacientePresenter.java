package org.example.presenter.paciente;

import org.example.enums.TipoUsuario;
import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.ProntuarioModel;
import org.example.roteador.Roteador;
import org.example.service.consulta.ConsultaService;
import org.example.service.medico.MedicoService;
import org.example.service.paciente.PacienteService;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfacePaciente.IMenuPacienteView;

import java.sql.SQLException;
import java.util.List;

public class MenuPacientePresenter {

    private final Roteador roteador;
    private final PacienteModel paciente;
    private final IMenuPacienteView view;
    private final ConsultaService consultaService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    private final ProntuarioService prontuarioService;

    public MenuPacientePresenter(Roteador roteador, PacienteModel paciente, IMenuPacienteView view){
        this.roteador = roteador;
        this.paciente = paciente;
        this.view = view;
        this.consultaService = new ConsultaService();
        this.pacienteService = new PacienteService();
        this.medicoService = new MedicoService();
        this.prontuarioService = new ProntuarioService();
    }

    public void iniciar() {
        boolean execuntando = false;

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
                        roteador.irPara(Roteador.Destino.MENU_INICIAL, null);
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
            List<ConsultaModel> consultas = consultaService.buscarConsultaPorPaciente(paciente.getIdPaciente());

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

            List<MedicoModel> medicos = medicoService.buscarMedicosPorEspecialidade(especialidade);

            if(medicos.isEmpty()){
                view.mostrarMensagemInfo("Nenhum medico encontrado para esta especialidade");
            }

            view.mostrarListaMedicos(medicos);

            int idMedico = view.selecionarMedico(medicos);
            MedicoModel medico = medicoService.buscarPorId(idMedico);

            if(medico == null){
                view.mostrarMensagemErro("Medico nao encontrado");
                return;
            }

            String data = view.lerData();
            List<String> horarios = consultaService.buscarHorariosDisponiveis(medico.getIdMedico());
            String horario = view.selecionarHorario(horarios);
            if(horarios.isEmpty()){
                view.mostrarMensagemInfo("Nenhum horario disponivel para esta data");
                return;
            }

            String descricao = view.lerDescricaoAgendamento();

            ConsultaModel consulta = consultaService.agendarConsulta(paciente.getIdPaciente(), medico.getIdMedico(), data, horario, descricao);

            if(consulta != null){
                view.mostrarMensagemSucesso("Consulta agendada com sucesso!");
                view.mostrarDetalhesConsulta(consulta);
            }else{
                view.mostrarMensagemErro("Erro ao agendar consulta");
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao agendar consulta");
        }
    }

    private void cancelarConsulta(){
        view.mostrarTitulo("Cancelar consulta");

        try {
            List<ConsultaModel> consultas = consultaService.buscarConsultaPorPaciente(paciente.getIdPaciente());

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
            List<ProntuarioModel> prontuarios = prontuarioService.buscarPorPaciente(paciente.getIdPaciente());

            if(prontuarios == null || prontuarios.isEmpty()){
                view.mostrarMensagemInfo("Voce ainda nao possui prontuario");
                return;
            }

            for(ProntuarioModel prontuario : prontuarios){
                view.mostrarProntuario(prontuario);
            }

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao acessar prontuario");
        }
    }

    private void verHistoricoConsultas(){
        view.mostrarTitulo("Historico consultas");

        try {
            List<ConsultaModel> historico = consultaService.buscarHistoricoCompletoPaciente(paciente.getIdPaciente());

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

            List<MedicoModel> medicos = medicoService.buscarMedicosPorEspecialidade(especialidade);

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

