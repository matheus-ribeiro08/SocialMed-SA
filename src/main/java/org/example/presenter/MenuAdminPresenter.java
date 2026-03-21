package org.example.presenter;

import org.example.dao.AdminDAO;
import org.example.dao.MedicoDAO;
import org.example.enums.TipoUsuario;
import org.example.model.*;
import org.example.roteador.Roteador;
import org.example.service.AdminService;
import org.example.service.RelatorioService;
import org.example.service.UsuarioService;
import org.example.viewInterface.viewInterfaceAdm.IMenuAdminView;

import java.util.List;

public class MenuAdminPresenter {

    private final Roteador roteador;
    private final AdminModel admin;
    private final IMenuAdminView view;
    private final AdminService adminService;
    private final UsuarioService usuarioService;
    private final RelatorioService relatorioService;

    public MenuAdminPresenter(Roteador roteador, AdminModel admin, IMenuAdminView view){
        this.roteador = roteador;
        this.admin = admin;
        this.view = view;

        this.adminService = new AdminService();
        this.usuarioService = new UsuarioService();
        this.relatorioService = new RelatorioService();
    }

    public void iniciar(){
        boolean executando = true;

        while (executando){
            int opcao = view.mostrarMenuPrincipal(admin.getNomeUsuario());

            try {
                switch (opcao){
                    case 1:{
                        gerenciarUsuarios();
                        break;
                    }
                    case 2:{
                        gerenciarMedicos();
                        break;
                    }
                    case 3:{
                        gerenciarSecretarios();
                        break;
                    }
                    case 4:{
                        gerenciarPacientes();
                        break;
                    }
                    case 6:{
                        visualizarPerfil();
                        break;
                    }
                    case 7:{
                        executando = false;
                        roteador.irPara(Roteador.Destino.MENU_INICIAL, null);
                        break;
                    }
                    case 0:{
                        executando = false;
                        roteador.irPara(Roteador.Destino.SAIR, null);
                        break;
                    }
                    default:{
                        view.mostrarMensagemErro("Opção invalida");
                    }
                }
            }catch (Exception e){
                System.err.println("Erro!");
            }
        }
    }

    private void gerenciarUsuarios() {
        boolean gerenciado = true;

        while (gerenciado) {
            int opcao = view.mostrarMenuGerenciadoUsuarios();

            switch (opcao) {
                case 1: {
                    listarTodosOsUsuarios();
                    break;
                }
                case 2: {
                    buscarUsuario();
                    break;
                }
                case 3: {
                    criarUsuario();
                    break;
                }
                case 4: {
                    editarUsuario();
                    break;
                }
                case 0: {
                    gerenciado = false;
                    break;
                }
                default: {
                    view.mostrarMensagemErro("Opção invalida");
                }
            }
        }
    }

    private void listarTodosOsUsuarios(){
        view.mostrarTitulo("Lista de usuarios");

        try {
            List<UsuarioModel> usuarios = usuarioService.listarTodosUsuarios();

            if(usuarios.isEmpty()){
                view.mostrarMensagemInfo("Nenhum usuario cadastrado");
            }else{
                view.mostrarListaUsuarios(usuarios);
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao listar usuarios");
        }
    }

    private void buscarUsuario(){
        view.mostrarTitulo("Usuario");

        String cpf = view.lerCpf();

        try {
            UsuarioModel usuario = usuarioService.buscarPorCpf(cpf);

            if(usuario != null){
                view.mostrarDadosUsuarioCompleto(usuario);
            }else{
                view.mostrarMensagemErro("Usuario nao encontrado");
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao buscar usuario");
        }
    }

    private void criarUsuario(){
        view.mostrarTitulo("Criar novo usuario");

        TipoUsuario tipo = view.selecionarTipoUsuario();

        try {
            switch (tipo){
                case MEDICO:{
                    criarMedico();
                    break;
                }
                case SECRETARIO:{
                    criarSecretrario();
                    break;
                }
                default:{
                    view.mostrarMensagemErro("Tipo invalido!");
                }
            }
        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao criar usuario");
        }
    }

    private void criarMedico(){
        MedicoModel medico = null;

        view.lerDadosNovoMedico();

        String nomeCompleto = view.lerNomeCompleto();
        String senha = view.lerSenha();
        String cpf = view.lerCpf();
        String email = view.lerEmail();
        String telefone = view.lerTelefone();
        String especialidade = view.lerEspecialidade();
        TipoUsuario tipoUsuario = TipoUsuario.MEDICO;

        MedicoModel medicoModel = new MedicoModel(nomeCompleto,senha,cpf, email, telefone, especialidade, tipoUsuario);



        adminService.criarMedico(admin, medico);

        view.mostrarMensagemSucesso("Medico criado com sucesso!");
    }

    private void criarSecretrario(){
        SecretarioModel secretario = view.lerDadosNovoSecretario();
        adminService.criarMedico(admin, secretario);
        view.mostrarMensagemSucesso("Secretario criado com sucesso!");
    }

    private void editarUsuario(){
        view.mostrarTitulo("Editar Usuario");

        String cpf = view.lerCpf();

        try {
            UsuarioModel usuario = usuarioService.buscarPorCpf(criarMedico());

            if(usuario == null){
                view.mostrarMensagemErro("Usuario nao encontrado");
                return;
            }

            view.mostrarDadosUsuarioCompleto(usuario);

            UsuarioModel dadosAtualizados = view.lerDadosAtualizacaoUsuario(usuario);
            dadosAtualizados.setId(usuario.getIdUsuario());

            adminService.atualizarUsuario(admin, dadosAtualizados);
            view.mostrarMensagemSucesso("Usuario atualizado com sucesso!");

        }catch (Exception e){
            view.mostrarMensagemErro("Erro ao editar usuario");
        }

    }



    private void gerenciarMedicos(){
        view.mostrarTitulo("Gerenciar medico");

        try {
            List<MedicoModel> medicos = usuarioService.listarMedicos();

            if(medicos.isEmpty()){
                view.mostrarMensagemInfo("Nenhum medico cadastrado");
                return;
            }

            view.mostrarListaMedicos(medicos);

            long id = view.selecionarMedico();
            MedicoModel medico = usuarioService.buscarMedicoPorId(id);

            if(medico == null){
                view.mostrarMensagemErro("Medico nao encontrado");
                return;
            }

        }catch (Exception e){
            System.err.println("Erro ao gerencar Medico");
        }
    }


    private void verAgendaMedico(MedicoModel medico){
        //implementar visualização da agenda do medico
    }

    private void verHistoricoMedico(MedicoModel medico){
        //implementar visualização do historico do medico
    }

    private void editarMedico(MedicoModel medico){
        MedicoModel dadosAtualizados = view.lerDadosAtualizacaoMedico(medico);
        dadosAtualizados.setId(medico.getIdMedico());
        adminService.atualizarMedico(admin, dadosAtualizados);
        view.mostrarMensagemSucesso("Medico atualizado");
    }

    private void gerenciarPacientes(PacienteModel paciente){
        boolean visualizando = true;

        while (visualizando){
            int opcao = view.mostrarMenuDetalhesPaciente(paciente);

            switch (opcao){
                case 1:{
                    verAgendaPaciente(paciente);
                    break;
                }
                case 2:{
                    verHistoricoPaciente(paciente);
                    break;
                }
                case 3:{
                    editarPaciente(paciente);
                    break;
                }
                case 4:{
                    if(view.perguntarAcao("Remover paciente?")){
                        adminService.RemoverPaciente(admin, paciente.getIdPaciente());
                        view.mostrarMensagemSucesso("Paciente removido!");
                        visualizando = false;
                    }
                    break;
                }
                case 0:{
                    visualizando = false;
                    break;
                }
                default:{
                    view.mostrarMensagemErro("Opção invalida");
                }
            }
        }
    }

    private void gerenciarSecretarios(){
        view.mostrarTitulo("Gerenciar secretario");

        try {
            List<SecretarioModel> secretarios = usuarioService.listarMedicos();

            if(secretarios.isEmpty()){
                view.mostrarMensagemInfo("Nenhum secretario cadastrado");
                return;
            }

            view.mostrarListaSecretarios(secretarios);

            long id = view.selecionarMedico();
            MedicoModel medico = usuarioService.buscarMedicoPorId(id);

            if(medico == null){
                view.mostrarMensagemErro("Medico nao encontrado");
                return;
            }

            visualizarDetalhesMedico(medico);
        }catch (Exception e){
            System.err.println("Erro ao gerencar Medico");
        }
    }

    private void gerenciarSecretarios(SecretarioModel secretario){
        boolean visualizando = true;

        while (visualizando){
            int opcao = view.mostrarMenuDetalhesSecretario(secretario);

            switch (opcao){
                case 1:{
                    editarSecretario(paciente);
                    break;
                }
                case 2:{
                    if(view.perguntarAcao("Remover Secretario?")){
                        adminService.RemoverSecretario(admin, secretario.getIdPaciente());
                        view.mostrarMensagemSucesso("Secretario removido!");
                        visualizando = false;
                    }
                    break;
                }
                case 0:{
                    visualizando = false;
                    break;
                }
                default:{
                    view.mostrarMensagemErro("Opção invalida");
                }
            }
        }
    }




}
