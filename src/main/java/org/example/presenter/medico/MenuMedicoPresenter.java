package org.example.presenter.medico;

import org.example.enums.Destinos;
import org.example.enums.TipoUsuario;
import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.ProntuarioModel;
import org.example.roteador.Roteador;
import org.example.service.consulta.ConsultaService;
import org.example.service.medico.MedicoService;
import org.example.service.paciente.PacienteService;
import org.example.service.prontuario.ProntuarioService;
import org.example.viewInterface.viewInterfaceAdm.IMenuAdminView;
import org.example.viewInterface.viewInterfaceMedico.IMenuMedicoView;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class MenuMedicoPresenter {

    private final Roteador roteador;
    private final MedicoModel medico;
    private final IMenuMedicoView view;
    private final ConsultaService consultaService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    private final ProntuarioService prontuarioService;

    public MenuMedicoPresenter(Roteador roteador, MedicoModel medico, IMenuMedicoView view) {
        this.roteador = roteador;
        this.medico = medico;
        this.view = view;
        this.consultaService = new ConsultaService();
        this.pacienteService = new PacienteService();
        this.medicoService = new MedicoService();
        this.prontuarioService = new ProntuarioService();
    }

    public void inicar(){
        boolean executando = true;

        while (executando){
            int opcao = view.mostrarMenuPrincipal(medico.getNomeUsuario());
            try {
                switch (opcao){
                    case 1:{
                        verAgendaHoje();
                        break;
                    }
                    case 2:{
                        verProximasConsultas();
                        break;
                    }
                    case 3:{
                        atenderPaciente();
                        break;
                    }
                    case 4:{
                        buscarPaciente();
                        break;
                    }
                    case 5:{
                        acessarProntuario();
                        break;
                    }
                    case 6:{
                        atualizarProntuario();
                        break;
                    }
                    case 7:{
                        verHistoricoConsultas();
                        break;
                    }
                    case 8:{
                        editarPerfil(medico);
                        break;
                    }
                    case 9:{
                        solicitarExame();
                        break;
                    }
                    case 11:{
                        executando = false;
                        roteador.irPara(Destinos.MENU_INICIAL, null);
                        break;
                    }
                    case 0:{
                        executando = false;
                        roteador.irPara(Destinos.SAIR, null);
                        break;
                    }
                    default:{
                        view.mostrarMensagemErro("Opção invalida!");
                    }
                }
            }catch (Exception e){
                view.mostrarMensagemErro("Erro!");
            }
        }
    }

    private void verAgendaHoje(){
        view.mostrarTitulo("Agenda de hoje");

        try {
            List<ConsultaModel> consultasHoje = consultaService.buscarConsultasDoDia(medico.getIdMedico());

            if(consultasHoje.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta agendada para hoje");
            }else{
                for(ConsultaModel consulta: consultasHoje){
                    view.mostrarListaConsultasDetalhadas(consulta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void verProximasConsultas(){
        view.mostrarTitulo("Proximas consultas");

        try {
            List<ConsultaModel> consultas = consultaService.buscarProximasConsultasMedico(medico.getIdMedico(), 10);

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta futura agendada");
            }else {
                for(ConsultaModel consulta: consultas){
                    view.mostrarListaConsultasDetalhadas(consulta);
                }
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao buscar consultas");
        }
    }

    private void atenderPaciente(){
        view.mostrarTitulo("Ateder paciente");

        try {
            int idConsulta = view.lerIdConsulta();
            ConsultaModel consulta = consultaService.buscarConsultaPorId(idConsulta);

            if(consulta == null){
                view.mostrarMensagemErro("Consulta nao encontrada!");
                return;
            }
            if(!(consulta.getIdMedico() == medico.getIdMedico())){
                view.mostrarMensagemErro("Esta consulta não é com voce!");
                return;
            }

            view.mostrarDadosConsultaCompleta(consulta);

            ProntuarioModel prontuario = prontuarioService.buscarPorPaciente(consulta.getIdPaciente());

            if(prontuario == null){
                prontuario = new ProntuarioModel();
                prontuario.setIdPaciente(consulta.getIdPaciente());
            }

            String diagnostico = view.lerDiagnostico();
            String prescricao = view.lerPrescricao();
            String observacoes = view.lerObservacoes();

            medicoService.realizarAtendimento(medico, consulta, diagnostico, prescricao, observacoes);

            view.mostrarTitulo("Atendimento Realizado com sucesso!");

        }catch (Exception e){
            view.mostrarMensagemErro("Erro no atendimento");
        }
    }

    private void buscarPaciente(){
        view.mostrarTitulo("Buscar paciente");

        String cpf = view.lerCpf();

        try {
            PacienteModel paciente = pacienteService.buscarPorCpf(cpf);

            if(paciente != null){
                view.mostrarDadosPacienteCompleto(paciente);

                List<ConsultaModel> historico = consultaService.buscarHistoricoPacienteComMedico(paciente.getIdPaciente(), medico.getIdMedico());

                if(!historico.isEmpty()){
                    for(ConsultaModel h: historico){
                        view.mostrarHistoricoAtendimentos(h);
                    }

                }
            }else{
                view.mostrarMensagemErro("Paciente nao encontrado");
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao buscar paciente");
        }
    }

    private void acessarProntuario(){
        view.mostrarTitulo("Acessar prontuario");

        try {
            String cpf = view.lerCpf();
            PacienteModel paciente = pacienteService.buscarPorCpf(cpf);

            if(paciente == null){
                view.mostrarMensagemErro("Paciente nao encontrado!");
                return;
            }

            ProntuarioModel prontuario = prontuarioService.buscarPorPaciente(paciente.getIdPaciente());

            if(prontuario == null){
                view.mostrarMensagemInfo("Paciente nao possui prontuario");

                if(view.perguntarAcao("Deseja criar um prontuario?")){
                    criarProntuario(paciente);
                }
            }else{
                view.mostrarProntuario(prontuario);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao acesssar prontuario");
        }
    }

    private void criarProntuario(PacienteModel paciente){
        try {

            String sintomas = view.lerSintomas();
            String diagnostico = view.lerDiagnostico();
            String prescricaoMedica = view.lerPrescricao();
            String observacoes = view.lerObservacoes();
            LocalDateTime dataRegistro = LocalDateTime.now();

            ProntuarioModel prontuario = new ProntuarioModel(medico.getIdMedico(), paciente.getIdPaciente(), sintomas, diagnostico, prescricaoMedica,
                            observacoes, dataRegistro);

            prontuarioService.criar(prontuario);
            view.mostrarMensagemSucesso("Prontuario criado com sucesso!");
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao criar Prontuario");
        }
    }

    private void atualizarProntuario(){
        view.mostrarTitulo("Atualizar Prontuario");

        try {
            String cpf = view.lerCpf();
            PacienteModel paciente = pacienteService.buscarPorCpf(cpf);

            if(paciente == null){
                view.mostrarMensagemErro("Paciente não possui prontuario");
                return;
            }

            ProntuarioModel prontuario = prontuarioService.buscarPorPaciente(paciente.getIdPaciente());

            String novaInformacao = view.lerInformacaoAdicional();
            prontuarioService.adicionarInformacao(prontuario, novaInformacao, medico);

            view.mostrarMensagemSucesso("Prontuario atualizado com sucesso");
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao atualizar prontuario");
        }
    }

    private void verHistoricoConsultas(){
        view.mostrarTitulo("Historico de consultas");

        try {
            List<ConsultaModel> consultas = consultaService.buscarHistoricoMedico(medico.getIdMedico());

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhum historico de consultas encontrado");
            }else {
                for(ConsultaModel consulta: consultas){
                    view.mostrarHistoricoAtendimentos(consulta);
                }
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao mostrar historico de consultas");
        }
    }

    private void visualizarPerfil(){
        view.mostrarTitulo("MEU PERFIL");
        view.mostrarDadosMedico(medico);

        if(view.perguntarAcao("Deseja editar seus dados?")){
            editarPerfil(medico);
        }
    }

    private void editarPerfil(MedicoModel medico){
        view.mostrarTitulo("Editar perfil");

        try {
            String nomeCompleto = view.lerNomeCompleto();
            String senha = view.lerSenha();
            String cpf = view.lerCpf();
            String email = view.lerEmail();
            String telefone = view.lerTelefone();
            String especialidade = view.lerEspecialidade();

            medico.setNomeUsuario(nomeCompleto);
            medico.setSenhaUsuario(senha);
            medico.setCpfUsuario(cpf);
            medico.setEmailUsuario(email);
            medico.setTelefoneUsuario(telefone);
            medico.setEspecialidadeMedico(especialidade);

            medicoService.atualizarMedico(medico);

            view.mostrarMensagemSucesso("Perfil atualizado com sucesso");

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao editar perfil");
        }
    }

    private void solicitarExame(){
        view.mostrarTitulo("Solicitar exame");

        try {
            String cpf = view.lerCpf();
            PacienteModel paciente = pacienteService.buscarPorCpf(cpf);

            if(paciente == null){
                view.mostrarMensagemErro("Paciente nao encontrado");
                return;
            }

            String tipoExame = view.lerTipoExame();
            String observacoes = view.lerObservacoes();

            medicoService.solicitarExame(medico, paciente, tipoExame, observacoes);

            view.mostrarMensagemSucesso("Exame solicitado com sucesso!");
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao solicitar exame");
        }
    }
}
