package org.example.presenter.admin;

import org.example.enums.Destinos;
import org.example.enums.TipoUsuario;
import org.example.model.*;
import org.example.roteador.Roteador;
import org.example.service.admin.AdminService;
import org.example.service.consulta.ConsultaService;
import org.example.service.medico.MedicoService;
import org.example.service.relatorio.RelatorioService;
import org.example.service.usuario.UsuarioService;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceAdm.IMenuAdminView;

import java.sql.SQLException;
import java.util.List;

public class MenuAdminPresenter {

    private final Roteador roteador;
    private final AdminModel admin;
    private final IMenuAdminView view;
    private final AdminService adminService;
    private final UsuarioService usuarioService;
    private final MedicoService medicoService;
    private final RelatorioService relatorioService;
    private final ConsultaService consultaService;

    public MenuAdminPresenter(Roteador roteador, AdminModel admin, IMenuAdminView view) {
        this.roteador = roteador;
        this.admin = admin;
        this.view = view;

        this.adminService = new AdminService();
        this.usuarioService = new UsuarioService();
        this.medicoService = new MedicoService();
        this.relatorioService = new RelatorioService();
        this.consultaService = new ConsultaService();
    }

    public void iniciar() {
        Ferramentas.Delay(1500);
        Ferramentas.limpaTerminalOpcional(30);
        boolean executando = true;

        while (executando) {
            int opcao = view.mostrarMenuPrincipal(admin.getNomeUsuario());

            try {
                switch (opcao) {
                    case 1: {
                        gerenciarUsuarios();
                        break;
                    }
                    case 2: {
                        gerenciarMedicos();
                        break;
                    }
                    case 3: {
                        gerenciarPacientes();
                        break;
                    }
                    case 4: {
                        visualizarPerfil();
                        break;
                    }
                    case 5: {
                        executando = false;
                        Ferramentas.Delay(1500);
                        Ferramentas.limpaTerminalOpcional(30);
                        roteador.irPara(Destinos.SAIR, null);
                        break;
                    }
                    case 6: {
                        executando = false;
                        Ferramentas.Delay(1500);
                        Ferramentas.limpaTerminalOpcional(30);
                        roteador.irPara(Destinos.MENU_INICIAL, null);
                        break;
                    }
                    default: {
                        view.mostrarMensagemErro("Opção invalida");
                        Ferramentas.Delay(1500);
                        Ferramentas.limpaTerminalOpcional(30);
                    }
                }
            } catch (Exception e) {
                System.err.println("Erro!");
            }
        }
    }

    private void visualizarPerfil() {
        view.mostrarTitulo("Meu Perfil");
        Ferramentas.limpaTerminalOpcional(30);
        view.mostrarDadosUsuarioCompleto(admin);

        if(view.perguntarAcao("Deseja editar seus dados?")){
            UsuarioModel usuario = admin;
            view.lerDadosAtualizacaoUsuario(usuario);
            try {
                adminService.atualizarUsuario(admin, usuario);
                view.mostrarMensagemSucesso("Perfil atualizado com sucesso");
                Ferramentas.Delay(1500);
                Ferramentas.limpaTerminalOpcional(30);
            }catch (Exception e){
                view.mostrarMensagemErro("Erro ao atualizar perfil");
            }
        }
    }

    private void gerenciarUsuarios() {
        Ferramentas.limpaTerminalOpcional(30);
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

    private void listarTodosOsUsuarios() {
        view.mostrarTitulo("Lista de usuarios");
        Ferramentas.limpaTerminalOpcional(30);
        try {
            List<UsuarioModel> usuarios = usuarioService.listarTodosUsuarios();

            if (usuarios.isEmpty()) {
                view.mostrarMensagemInfo("Nenhum usuario cadastrado");
            } else {
                view.mostrarTituloListaUsuarios();
                for(UsuarioModel usuario : usuarios) {
                    view.mostrarListaUsuarios(usuario);
                }
            }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao listar usuarios");
        }
    }

    private void buscarUsuario() {
        view.mostrarTitulo("Usuario");
        Ferramentas.limpaTerminalOpcional(30);

        String cpf = view.lerCpf();
        Ferramentas.Delay(1500);
        Ferramentas.limpaTerminalOpcional(30);

        try {
            UsuarioModel usuario = usuarioService.buscarPorCpf(cpf);

            if (usuario != null) {
                view.mostrarDadosUsuarioCompleto(usuario);
            } else {
                view.mostrarMensagemErro("Usuario nao encontrado");
            }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao buscar usuario");
        }
    }

    private void criarUsuario() {
        view.mostrarTitulo("Criar novo usuario");
        Ferramentas.limpaTerminalOpcional(30);

        TipoUsuario tipo = view.selecionarTipoUsuario();

        try {
            switch (tipo) {
                case MEDICO: {
                    criarMedico();
                    break;
                }
                case SECRETARIO: {
                    criarSecretrario();
                    break;
                }
                default: {
                    view.mostrarMensagemErro("Tipo invalido!");
                }
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao criar usuario");
        }
    }

    private void criarMedico() {
        MedicoModel medico = null;
        Ferramentas.limpaTerminalOpcional(30);

        view.lerDadosNovoMedico();

        String nomeCompleto = view.lerNomeCompleto();
        String senha = view.lerSenha();
        String cpf = view.lerCpf();
        String email = view.lerEmail();
        String telefone = view.lerTelefone();
        String especialidade = view.lerEspecialidade();
        TipoUsuario tipoUsuario = TipoUsuario.MEDICO;

        MedicoModel medicoModel = new MedicoModel(nomeCompleto, senha, cpf, email, telefone, tipoUsuario, especialidade);

        adminService.criarMedico(admin, medicoModel);

        view.mostrarMensagemSucesso("Medico criado com sucesso!");
        Ferramentas.Delay(1500);
        Ferramentas.limpaTerminalOpcional(30);
    }

    private void criarSecretrario() {
        SecretarioModel secretario = null;
        Ferramentas.limpaTerminalOpcional(30);

        view.lerDadosNovoSecretario();

        String nomeCompleto = view.lerNomeCompleto();
        String senha = view.lerSenha();
        String cpf = view.lerCpf();
        String email = view.lerEmail();
        String telefone = view.lerTelefone();
        String turno = view.lerTurno();
        TipoUsuario tipoUsuario = TipoUsuario.SECRETARIO;

        SecretarioModel secretarioModel = new SecretarioModel(nomeCompleto, senha, cpf, email, telefone, tipoUsuario, turno);

        adminService.criarSecretario(admin, secretarioModel);

        view.mostrarMensagemSucesso("Secretario criado com sucesso!");
        Ferramentas.Delay(1500);
        Ferramentas.limpaTerminalOpcional(30);
    }

    private void editarUsuario() {
        view.mostrarTitulo("Editar Usuario");
        Ferramentas.limpaTerminalOpcional(30);

        String cpf = view.lerCpf();

        try {
            UsuarioModel usuario = usuarioService.buscarPorCpf(cpf);

            if (usuario == null) {
                view.mostrarMensagemErro("Usuario nao encontrado");
                return;
            }

            String nomeCompleto = view.lerNomeCompleto();
            String senha = view.lerSenha();
            String email = view.lerEmail();
            String telefone = view.lerTelefone();

            usuario.setNomeUsuario(nomeCompleto);
            usuario.setSenhaUsuario(senha);
            usuario.setEmailUsuario(email);
            usuario.setTelefoneUsuario(telefone);

            view.mostrarDadosUsuarioCompleto(usuario);

            adminService.atualizarUsuario(admin, usuario);
            view.mostrarMensagemSucesso("Usuario atualizado com sucesso!");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);

        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao editar usuario");
        }

    }


    private void gerenciarMedicos() {
        view.mostrarTitulo("Gerenciar medico");
        Ferramentas.limpaTerminalOpcional(30);

        boolean visualizando = true;

        try {
            List<MedicoModel> medicos = usuarioService.listarMedicos();

            if (medicos.isEmpty()) {
                view.mostrarMensagemInfo("Nenhum medico cadastrado");
                return;
            }

            for (MedicoModel medico: medicos) {
                view.mostrarListaMedicos(medico);
            }

            int id = view.selecionarMedico();
            MedicoModel medico = usuarioService.buscarMedicoPorId(id);


            while (visualizando) {
                int opcao = view.mostrarMenuDetalheMedico(medico);

                switch (opcao) {
                    case 1: {
                        verAgendaMedico(medico);
                        break;
                    }
                    case 2: {
                        verHistoricoMedico(medico);
                        break;
                    }
                    case 3: {
                        editarMedico(medico);
                        break;
                    }
                    case 4: {
                        removerMedico(medico);
                        break;
                    }
                    case 0: {
                        visualizando = false;
                        break;
                    }
                    default: {
                        view.mostrarMensagemErro("Opção invalida");
                        Ferramentas.limpaTerminalOpcional(30);
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao gerencar Medico");
        }
    }

    private void removerMedico(MedicoModel medico){
       view.mostrarTitulo("Remover usuario");
       Ferramentas.limpaTerminalOpcional(30);

       try {
           if (view.perguntarAcao("Remover Medico?")){
               adminService.removerMedico(admin, medico.getIdMedico());
               view.mostrarMensagemSucesso("Medico removido com sucesso");
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }


    private void verAgendaMedico(MedicoModel medico) {
        view.mostrarTitulo("Agenda do medico " + medico.getNomeUsuario());
        Ferramentas.limpaTerminalOpcional(30);
        try {
            List<ConsultaModel> consultas = consultaService.listarConsultasAtivasPorMedico(medico.getIdMedico());

            if(consultas.isEmpty()){
                view.mostrarMensagemErro("Nenhuma consulta futura agendada para esse medico");
            }else{
                for(ConsultaModel c : consultas){
                    view.mostrarMensagemInfo(String.format("ID: %d | Paciente: %d | Data/Hora: %s | Local: %s",
                            c.getIdConsulta(), c.getIdPaciente(), c.getHorarioConsulta(), c.getLocalEndereco()));
                }
            }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void verAgendaPaciente(PacienteModel paciente) {
        Ferramentas.limpaTerminalOpcional(30);
        view.mostrarTitulo("Agenda do paciente " + paciente.getNomeUsuario());
        Ferramentas.limpaTerminalOpcional(30);
        try {
            List<ConsultaModel> consultas = consultaService.listarConsultasAtivasPorPaciente(paciente.getIdPaciente());

            if(consultas.isEmpty()){
                view.mostrarMensagemErro("Nenhuma consulta futura agendada para esse paciente");
            }else{
                for(ConsultaModel c : consultas){
                    view.mostrarMensagemInfo(String.format("ID: %d | Medico: %d | Data/Hora: %s | Local: %s",
                            c.getIdConsulta(), c.getIdMedico(), c.getHorarioConsulta(), c.getLocalEndereco()));
                }
            }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void verHistoricoPaciente(PacienteModel paciente) {
        Ferramentas.limpaTerminalOpcional(30);
        view.mostrarTitulo("Historico de consultas - Paciente: " + paciente.getNomeUsuario());
        try {
            List<ConsultaModel> consultas = consultaService.listarHistoricoConsultaPaciente(paciente.getIdPaciente());

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta passada encontrada para este paciente");
            }else {
                for (ConsultaModel c : consultas) {
                    view.mostrarMensagemInfo(String.format("ID: %d | Médico: %d | Data/Hora: %s | Local: %s",
                            c.getIdConsulta(), c.getIdMedico(), c.getHorarioConsulta(), c.getLocalEndereco()));
                }
            }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void verHistoricoMedico(MedicoModel medico) {
        Ferramentas.limpaTerminalOpcional(30);
        view.mostrarTitulo("Historico de consultas - Medico: " + medico.getNomeUsuario());

        try {
            List<ConsultaModel> consultas = consultaService.listarHistoricoConsultaMedico(medico.getIdMedico());

            if(consultas.isEmpty()){
                view.mostrarMensagemInfo("Nenhuma consulta passada encontrada para este medico");
            }else {
                for (ConsultaModel c : consultas) {
                    view.mostrarMensagemInfo(String.format("ID: %d | Paciente: %d | Data/Hora: %s | Local: %s",
                            c.getIdConsulta(), c.getIdMedico(), c.getHorarioConsulta(), c.getLocalEndereco()));
                }
            }
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void editarMedico(MedicoModel medico) {
        Ferramentas.limpaTerminalOpcional(30);

        try {
            if (medico == null) {
                view.mostrarMensagemErro("Medico nao encontrado");
                return;
            }

            String nomeCompleto = view.lerNomeCompleto();
            String senha = view.lerSenha();
            String email = view.lerEmail();
            String telefone = view.lerTelefone();
            String especialidade = view.lerEspecialidade();

            medico.setNomeUsuario(nomeCompleto);
            medico.setSenhaUsuario(senha);
            medico.setEmailUsuario(email);
            medico.setTelefoneUsuario(telefone);
            medico.setEspecialidadeMedico(especialidade);

            adminService.atualizarMedico(admin, medico);
            view.mostrarMensagemSucesso("Medico atualizado com sucesso!");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);

        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao editar usuario");
        }
    }

    private void gerenciarPacientes() {
        Ferramentas.limpaTerminalOpcional(30);
        boolean visualizando = true;

        try {
            List<PacienteModel> pacientes = usuarioService.listarTodos();

            if (pacientes.isEmpty()) {
                view.mostrarMensagemInfo("Nenhum paciente cadastrado");
                return;
            }

            for (PacienteModel pacienteModel: pacientes) {
                view.mostrarListaPacientes(pacienteModel);
            }

            String cpf = view.lerCpf();
            PacienteModel paciente = usuarioService.buscarPacientePorCpf(cpf);

            while (visualizando) {
                int opcao = view.mostrarMenuDetalhePaciente(paciente);

                switch (opcao) {
                    case 1: {
                        verAgendaPaciente(paciente);
                        break;
                    }
                    case 2: {
                        verHistoricoPaciente(paciente);
                        break;
                    }
                    case 3: {
                        editarPaciente(paciente);
                        break;
                    }
                    case 4: {
                        removerPaciente(paciente);
                        break;
                    }
                    case 0: {
                        visualizando = false;
                        break;
                    }
                    default: {
                        view.mostrarMensagemErro("Opção invalida");
                        Ferramentas.limpaTerminalOpcional(30);
                    }
                }
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao gerenciar paciente");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);
        }
    }

    private void removerPaciente(PacienteModel paciente){
        view.mostrarTitulo("Remover paciente");
        Ferramentas.limpaTerminalOpcional(30);

        try {
            if (view.perguntarAcao("Remover Paciente?")){
                adminService.removerPaciente(admin, paciente.getIdPaciente());
                view.mostrarMensagemSucesso("Paciente removido com sucesso");
                Ferramentas.Delay(1500);
                Ferramentas.limpaTerminalOpcional(30);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void editarPaciente(PacienteModel paciente) {
        Ferramentas.limpaTerminalOpcional(30);

        try {
            if (paciente == null) {
                view.mostrarMensagemErro("Paciente nao encontrado");
                Ferramentas.Delay(1500);
                Ferramentas.limpaTerminalOpcional(30);
                return;
            }

            String nomeCompleto = view.lerNomeCompleto();
            String senha = view.lerSenha();
            String email = view.lerEmail();
            String telefone = view.lerTelefone();
            String endereco = view.lerEndereco();

            paciente.setNomeUsuario(nomeCompleto);
            paciente.setSenhaUsuario(senha);
            paciente.setEmailUsuario(email);
            paciente.setTelefoneUsuario(telefone);
            paciente.setEnderecoPaciente(endereco);

            adminService.atualizarPaciente(admin, paciente);
            view.mostrarMensagemSucesso("Paciente atualizado com sucesso!");
            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);

        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao editar paciente");
        }
    }

    private void gerenciarSecretarios() {
        Ferramentas.limpaTerminalOpcional(30);
        view.mostrarTitulo("Gerenciar secretario");

        try {
            List<SecretarioModel> secretarios = usuarioService.listarSecretarios();

            if (secretarios.isEmpty()) {
                view.mostrarMensagemInfo("Nenhum secretario cadastrado");
                return;
            }
            for (SecretarioModel secretario: secretarios) {
                view.mostrarListaSecretarios(secretario);
            }

            int id = view.selecionarMedico();
            MedicoModel medico = usuarioService.buscarMedicoPorId(id);

            if (medico == null) {
                view.mostrarMensagemErro("Medico nao encontrado");
                return;
            }

            Ferramentas.Delay(1500);
            Ferramentas.limpaTerminalOpcional(30);

        } catch (Exception e) {
            System.err.println("Erro ao gerencar Medico");
        }
    }
}



