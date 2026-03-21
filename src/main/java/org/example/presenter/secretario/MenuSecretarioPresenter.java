package org.example.presenter.secretario;

import org.example.enums.TipoUsuario;
import org.example.model.ConsultaModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;
import org.example.roteador.Roteador;
import org.example.service.consulta.ConsultaService;
import org.example.service.paciente.PacienteService;
import org.example.service.secretario.SecretarioService;

import java.util.List;

public class MenuSecretarioPresenter {

    private final Roteador roteador;
    private final SecretarioModel secretario;
    private final MenuSecretarioView view;
    private final PacienteService pacienteService;
    private final ConsultaService consultaService;
    private final SecretarioService secretarioService;

    public MenuSecretarioPresenter(Roteador roteador, SecretarioModel secretario, MenuSecretarioView view, PacienteService pacienteService, ConsultaService consultaService, SecretarioService secretarioService) {
        this.roteador = roteador;
        this.secretario = secretario;
        this.view = view;
        this.pacienteService = pacienteService;
        this.consultaService = consultaService;
        this.secretarioService = secretarioService;
    }

    public void iniciar(){
        boolean executando = true;

        while (executando) {
            int opcao = view.mostrarMenuPrincipal(secretario.getNomeUsuario());

            try {
                switch (opcao) {
                    case 1: {
                        cadastrarPaciente();
                        break;
                    }
                    case 2: {
                        buscarPaciente();
                        break;
                    }
                    case 3: {
                        listrarPacientes();
                        break;
                    }
                    case 4: {
                        agendarConsulta();
                        break;
                    }
                    case 5: {
                        cancelarConsulta();
                        break;
                    }
                    case 6: {
                        listarConsultaHoje();
                        break;
                    }
                    case 7:{
                        listarConsultasPendentes();
                        break;
                    }
                    case 8:{
                        visualizarPerfil();
                        break;
                    }
                    case 9:{
                        executando = false;
                        roteador.irPara(Roteador.Destino.SAIR);
                        break;
                    }
                    default:{
                        view.mostrarMensagemErro("Erro");
                    }

                }
            }catch (Exception e){
                view.mostrarMensagemErro("Erro");
            }
        }
    }

    private void cadastrarPaciente(){
        view.mostrarTitulo("Cadastrar novo paciente");

        PacienteModel paciente = view.lerDadosPaciente();
        paciente.setTipoUsuario(TipoUsuario.PACIENTE);

        try {
            secretarioService.cadastrarPaciente(secretario, paciente);
            view.mostrarMensagemSucesso("Paciente cadastrado com sucesso!");
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao cadastrar paciente");
        }
    }

    private void buscarPaciente(){
        view.mostrarTitulo("Buscar paciente");

        String cpf = view.lerCpf();

        try {
            PacienteModel paciente = pacienteService.buscarPorCpf();

            if(paciente != null){
                view.mostrarDadosPaciente(paciente);

                if(view.perguntarAcao("Deseja editar esse paciente?")){
                    editarPaciente(paciente);
                }
            }else {
                view.mostrarMensagemErro("Paciente não encontrado!");
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao buscar paciente");
        }
    }

    private void listrarPacientes(){
        view.mostrarTitulo("Lista de paciente");

        try {
            List<PacienteModel> pacientes = pacienteService.listarTodos();

            if(pacientes.isEmpty()){
                view.mostrarMensagemInfo("Nehum paciente cadastrado.");
            }else{
                view.mostrarListaPacientes(pacientes);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao listar pacientes");
        }
    }

    private void agendarConsulta(){
        view.mostrarTitulo("Agendar consulta");

        try {
            String cpfPaciente = view.lerCpfPaciente();
            PacienteModel paciente = pacienteService.buscarPorCpf(cpfPaciente);

            if(paciente == null){
             view.mostrarMensagemErro("Paciente nao encontrado");
             return;
            }

            ConsultaModel consulta = view.lerDadosConsulta(paciente);
            consulta.setSecretario(secretario);

            secretarioService.agendarConsulta(secretario, consulta);
            view.mostrarMensagemSucesso("Consulta agendada com sucesso!");

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao agendar consulta");
        }
    }

    private void cancelarConsulta(){
        view.mostrarTitulo("cancelar consulta");

        try {
            long idConsulta = view.lerIdConsulta();
            ConsultaModel consulta = consultaService.buscarPorId(idConsulta);

            if(consulta == null){
                view.mostrarMensagemErro("Consulta nao encontrada!");
                return;
            }

            view.mostrarDadosConsulta(consulta);

            if(view.perguntarAcao("Confirmar cancelado")){
                secretarioService.cancelarConsulta(secretario, consulta);
                view.mostrarMensagemSucesso("Consulta cancelada com sucesso!");
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao cancelar consulta");
        }

    }

    private void listarConsultaHoje(){
        view.mostrarTitulo("Consultas de hoje");

        try {
            List<ConsultaModel> consultas = consultaService.buscarConsultasDoDia();

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta agendada para hoje");
            }else{
                view.mostrarListaConsultas(consultas);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao listar consultas de hoje");
        }
    }

    private void listarConsultasPendentes(){
        view.mostrarTitulo("Consultas Pendentes");

        try {
            List<ConsultaModel> consultas = consultaService.buscarConsultasPendentes();

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta pendente");
            }else{
                view.mostrarListaConsultas(consultas);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao listar consultas pendentes");
        }
    }

    private void visualizarPerfil(){
        view.mostrarTitulo("MEU PERFIL");
        view.mostrarDadosSecretario(secretario);

        if(view.perguntarAcai("Deseja editar seus dados?")){
            editarPerfil();
        }
    }

    private void editarPerfil(){
        view.mostrarTituli("Editar perfil");

        SecretarioModel dadosAtualizados = view.lerDadosAtualizacaoSecretario(secretario);
        dadosAtualizados.setIdSecretario(secretario.getIdSecretario());
        dadosAtualizados.setTipoUsuario(secretario.getTipoUsuario());

        try {
            secretario.setNomeUsuario(dadosAtualizados.getNomeUsuario());
            secretario.setEmailUsuario(dadosAtualizados.getEmailUsuario());
            secretario.setTelefoneUsuario(dadosAtualizados.getTelefoneUsuario());
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao atualizar perfil");
        }
    }
}
