package org.example.presenter;

import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.roteador.Roteador;
import org.example.service.ConsultaService;
import org.example.service.MedicoService;
import org.example.service.PacienteService;

import java.util.List;

public class MenuMedicoPresenter {

    private final Roteador roteador;
    private final MedicoModel medico;
    private final MenuMedicoView view;
    private final ConsultaService consultaService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    private final ProntuarioService prontuarioService;

    public MenuMedicoPresenter(Roteador roteador, MedicoModel medico, MenuMedicoView view, ConsultaService consultaService,
                               PacienteService pacienteService, MedicoService medicoService, ProntuarioService prontuarioService) {
        this.roteador = roteador;
        this.medico = medico;
        this.view = view;
        this.consultaService = consultaService;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
        this.prontuarioService = prontuarioService;
    }

    public void inicar(){
        boolean executando = true;

        while (executando){
            int opcao = view.mostrarMenuPrincipal(medico.getNomeUsuario(), medico.getEspecialidadeMedico());

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
                        visualizarPerfil();
                        break;
                    }
                    case 9:{
                        emitirAtestado();
                        break;
                    }
                    case 10:{
                        solicitarExame();
                        break;
                    }
                    case 11:{
                        executando = false;
                        roteador.irPara(Roteador.Destino.MENU_INICIAL);
                        break;
                    }
                    case 0:{
                        executando = false;
                        roteador.irPara(Roteador.Destino.SAIR);
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

    private void verProximasConsultas(){
        view.mostrarTitulo("Proximas consultas");

        try {
            List<ConsultaModel> consultas = consultaService.buscarProximasConsultasMedico(medico.getIdMedico(), 10);

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta futura agendada");
            }else {
                view.mostrarListaConsultaDetalhada(consultas);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao buscar consultas");
        }
    }

    private void atenderPaciente(){
        view.mostrarTitulo("Ateder paciente");

        try {
            long idConsulta = view.LerIdConsulta();
            ConsultaModel consulta = consultaService.buscarPorId(idConsulta);

            if(consulta == null){
                view.mostrarMensagemErro("Consulta nao encontrada!");
                return;
            }
            if(!consulta.getMedico().getId().equals(medico.getIdMedico())){
                view.mostrarMensagemErro("Esta consulta não é com voce!");
                return;
            }

            view.mostrarDadosConsultaCompleta(consulta);

            ProntuarioModel prontuario = prontuarioService.buscarPorPaciente(consulta.getPaciente().getId());

            if(prontuario == null){
                prontuario = new ProntuarioModel();
                prontuario.setPaciente(consulta.getPaciente());
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
                view.mostrarDadosPacientesCompleto(paciente);

                List<ConsultaModel> historico = consultaService.buscarHistoricoPacienteComMedico(paciente.getIdPaciente(), medico.getIdMedico());

                if(!historico.isEmpty()){
                    view.mostrarHistoricoAtendimentos(historico);
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

                if(view.perguntarAcesso("Deseja criar um prontuario?")){
                    criarProntuario(prontuario);
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
            ProntuarioModel prontuario = new ProntuarioModel();
            prontuario.setPaciente(paciente);
            prontuario.setInformacoesIniciais(view.lerInformacoesIniciais());

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

            view.mostrarMensagemErro("Prontuario atualizado com sucesso");
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
                view.mostrarHistoricoConsultas(consultas);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao mostrar historico de consultas");
        }
    }

    private void visualizarPerfil(){
        view.mostrarTitulo("MEU PERFIL");
        view.mostrarDadosMedico(medico);

        if(view.perguntarAcao("Deseja editar seus dados?")){
            editarPerfil();
        }
    }

    private void editarPerfil(){
        view.mostrarTitulo("Editar perfil");

        MedicoModel dadosAtualizados = view.lerDadosAtualizacaoMedico(medico);
        dadosAtualizados.setId(medico.getIdMedico());
        dadosAtualizados.setTipoUsuario(medico.getTipoUsuario());

        try {
            medicoService.atualizarPerfil(dadosAtualizados);
            view.mostrarMensagemSucesso("Perfil atualizado com sucesso");

            medico.setNomeUsuario(dadosAtualizados.getNomeUsuario());
            medico.setEmailUsuario(dadosAtualizados.getEmailUsuario());
            medico.setTelefoneUsuario(dadosAtualizados.getTelefoneUsuario());
            medico.setEspecialidadeMedico(dadosAtualizados.getEspecialidadeMedico());
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao editar perfil");
        }
    }

    private void emitirAtestado(){
        view.mostrarTitulo("Emitir atestado");

        try {
            String cpf = view.lerCpf();
            PacienteModel paciente = pacienteService.buscarPorCpf(cpf);

            if(paciente == null){
                view.mostrarMensagemInfo("Paciente nao encontrado");
                return;
            }

            String conteudo = view.lerConteudoAtestado;
            int dias = view.lerDiasAtestado();

            String atestado = medicoService.emitirAtestado(medico, paciente, conteudo, dias);

            view.mostrarAtestado(atestado);
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao emitir atestado");
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
