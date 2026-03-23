package org.example.presenter.secretario;

import org.example.enums.Destinos;
import org.example.enums.TipoUsuario;
import org.example.model.*;
import org.example.roteador.Roteador;
import org.example.service.consulta.ConsultaService;
import org.example.service.medico.MedicoService;
import org.example.service.paciente.PacienteService;
import org.example.service.secretario.SecretarioService;
import org.example.viewInterface.viewInterfaceSecretario.IMenuSecretarioView;

import java.time.LocalDateTime;
import java.util.List;

public class MenuSecretarioPresenter {
    private final Roteador roteador;
    private final SecretarioModel secretario;
    private final IMenuSecretarioView view;
    private final SecretarioService secretarioService;
    private final ConsultaService consultaService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public MenuSecretarioPresenter(Roteador roteador, SecretarioModel secretario, IMenuSecretarioView view) {
        this.roteador = roteador;
        this.secretario = secretario;
        this.view = view;
        this.secretarioService = new SecretarioService();
        this.consultaService = new ConsultaService();
        this.pacienteService = new PacienteService();
        this.medicoService = new MedicoService();
    }

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            int opcao = view.mostrarMenuPrincipal(secretario.getNomeUsuario());
            try {
                switch (opcao) {
                    case 1:
                        cadastrarPaciente();
                        break;
                    case 2:
                        buscarPaciente();
                        break;
                    case 3:
                        listarPacientes();
                        break;
                    case 4:
                        atualizarPaciente();
                        break;
                    case 5:
                        removerPaciente();
                        break;
                    case 6:
                        agendarConsulta();
                        break;
                    case 7:
                        cancelarConsulta();
                        break;
                    case 8:
                        reagendarConsulta();
                        break;
                    case 9:
                        listarConsultas();
                        break;
                    case 10:
                        listarConsultasPorPaciente();
                        break;
                    case 11:
                        listarConsultasPorMedico();
                        break;
                    case 12:
                        listarMedicos();
                        break;
                    case 13:
                        editarPerfil();
                        break;
                    case 0:
                        executando = false;
                        roteador.irPara(Destinos.MENU_INICIAL, null);
                        break;
                    default:
                        view.mostrarMensagemErro("Opção inválida");
                }
            } catch (Exception e) {
                view.mostrarMensagemErro("Erro");
            }
        }
    }

    private void cadastrarPaciente() {
        view.mostrarTitulo("CADASTRAR PACIENTE");

        try {
            String nome = view.lerNomeCompleto();
            String email = view.lerEmail();
            String senha = view.lerSenha();
            String cpf = view.lerCpf();
            String telefone = view.lerTelefone();
            String endereco = view.lerEndereco();

            PacienteModel paciente = new PacienteModel();
            paciente.setNomeUsuario(nome);
            paciente.setEmailUsuario(email);
            paciente.setSenhaUsuario(senha);
            paciente.setCpfUsuario(cpf);
            paciente.setTelefoneUsuario(telefone);
            paciente.setEnderecoPaciente(endereco);

            secretarioService.cadastrarPaciente(paciente);
            view.mostrarMensagemSucesso("Paciente cadastrado com sucesso!");
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao cadastrar paciente");
        }
    }

    private void buscarPaciente() {
        view.mostrarTitulo("BUSCAR PACIENTE");

        try {
            String cpf = view.lerCpf();
            PacienteModel paciente = secretarioService.buscarPacientePorCpf(cpf);
            view.mostrarDadosPacienteCompleto(paciente);
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao buscar paciente: " + e.getMessage());
        }
    }

    private void listarPacientes() {
        view.mostrarTitulo("LISTAR PACIENTES");

        try {
            List<PacienteModel> pacientes = secretarioService.listarTodosPacientes();
            if (pacientes.isEmpty()) {
                view.mostrarMensagemInfo("Nenhum paciente cadastrado");
            } else {
                view.mostrarListaPacientes(pacientes);
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao listar pacientes: " + e.getMessage());
        }
    }

    private void atualizarPaciente() {
        view.mostrarTitulo("ATUALIZAR PACIENTE");

        try {
            int idPaciente = view.lerIdPaciente();
            PacienteModel paciente = secretarioService.buscarPacientePorId(idPaciente);

            view.mostrarDadosPacienteCompleto(paciente);

            if (view.perguntarAcao("Deseja atualizar os dados deste paciente?")) {
                String nome = view.lerNomeCompleto();
                String email = view.lerEmail();
                String telefone = view.lerTelefone();
                String endereco = view.lerEndereco();

                paciente.setNomeUsuario(nome);
                paciente.setEmailUsuario(email);
                paciente.setTelefoneUsuario(telefone);
                paciente.setEnderecoPaciente(endereco);

                secretarioService.atualizarPaciente(paciente);
                view.mostrarMensagemSucesso("Paciente atualizado com sucesso!");
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Paciente atualizado com sucesso!");
        }
    }

    private void removerPaciente() {
        view.mostrarTitulo("REMOVER PACIENTE");

        try {
            int idPaciente = view.lerIdPaciente();
            PacienteModel paciente = secretarioService.buscarPacientePorId(idPaciente);

            view.mostrarDadosPacienteCompleto(paciente);

            if (view.perguntarAcao("Tem certeza que deseja remover este paciente")) {
                secretarioService.removerPaciente(idPaciente);
                view.mostrarMensagemSucesso("Paciente removido com sucesso");
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao remover paciente");
        }
    }

    private void agendarConsulta() {
        view.mostrarTitulo("AGENDAR CONSULTA");

        try {
            List<MedicoModel> medicos = secretarioService.listarTodosMedicos();
            view.mostrarListaMedicos(medicos);

            int idMedico = view.lerIdMedico();
            MedicoModel medico = secretarioService.buscarMedicoPorId(idMedico);

            List<HospitalModel> hospitais = secretarioService.listarHospitais();
            view.mostrarListaHospitais(hospitais);

            int idHospital = view.lerIdHospital();
            HospitalModel hospital = hospitais.stream()
                    .filter(h -> h.getIdHospital() == idHospital)
                    .findFirst()
                    .orElse(null);

            String cpf = view.lerCpf();
            PacienteModel paciente = secretarioService.buscarPacientePorCpf(cpf);

            String data = view.lerData();
            String hora = view.lerHora();
            LocalDateTime horario = consultaService.converterStringParaDateTime(data, hora);

            ConsultaModel consulta = new ConsultaModel();
            consulta.setIdMedico(idMedico);
            consulta.setIdPaciente(paciente.getIdPaciente());
            consulta.setIdHospital(idHospital);
            consulta.setLocalEndereco(hospital != null ? hospital.getEnderecoHospital() : "");
            consulta.setHorarioConsulta(horario);

            secretarioService.agendarConsulta(consulta);
            view.mostrarMensagemSucesso("Consulta agendada com sucesso");
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao agendar consulta");
        }
    }

    private void cancelarConsulta() {
        view.mostrarTitulo("CANCELAR CONSULTA");

        try {
            int idConsulta = view.lerIdConsulta();
            ConsultaModel consulta = consultaService.buscarConsultaPorId(idConsulta);

            view.mostrarDadosConsultaCompleta(consulta);

            if (view.perguntarAcao("Tem certeza que deseja cancelar esta consulta?")) {
                secretarioService.cancelarConsulta(idConsulta);
                view.mostrarMensagemSucesso("Consulta cancelada com sucesso!");
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao cancelar consulta.");
        }
    }

    private void reagendarConsulta() {
        view.mostrarTitulo("REAGENDAR CONSULTA");

        try {
            int idConsulta = view.lerIdConsulta();
            ConsultaModel consulta = consultaService.buscarConsultaPorId(idConsulta);

            view.mostrarDadosConsultaCompleta(consulta);

            String data = view.lerData();
            String hora = view.lerHora();
            LocalDateTime novoHorario = consultaService.converterStringParaDateTime(data, hora);
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao reagendar consulta.");
        }
    }

    private void listarConsultas() {
        view.mostrarTitulo("LISTAR CONSULTAS");

        try {
            List<ConsultaModel> consultas = secretarioService.listarTodasConsultas();
            if (consultas.isEmpty()) {
                view.mostrarMensagemInfo("Nenhuma consulta agendada");
            } else {
                view.mostrarListaConsultas(consultas);
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao listar consultas");
        }
    }

    private void listarConsultasPorPaciente() {
        view.mostrarTitulo("CONSULTAS POR PACIENTE");

        try {
            int idPaciente = view.lerIdPaciente();
            List<ConsultaModel> consultas = secretarioService.listarConsultasPorPaciente(idPaciente);

            if (consultas.isEmpty()) {
                view.mostrarMensagemInfo("Nenhuma consulta encontrada para este paciente");
            } else {
                view.mostrarListaConsultas(consultas);
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao listar consultas");
        }
    }

    private void listarConsultasPorMedico() {
        view.mostrarTitulo("CONSULTAS POR MÉDICO");

        try {
            List<MedicoModel> medicos = secretarioService.listarTodosMedicos();
            view.mostrarListaMedicos(medicos);

            int idMedico = view.lerIdMedico();
            List<ConsultaModel> consultas = secretarioService.listarConsultasPorMedico(idMedico);

            if (consultas.isEmpty()) {
                view.mostrarMensagemInfo("Nenhuma consulta encontrada para este médico");
            } else {
                view.mostrarListaConsultas(consultas);
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao listar consultas");
        }
    }

    private void listarMedicos() {
        view.mostrarTitulo("LISTAR MEDICOS");

        try {
            List<MedicoModel> medicos = secretarioService.listarTodosMedicos();
            if (medicos.isEmpty()) {
                view.mostrarMensagemInfo("Nenhum médico cadastrado");
            } else {
                view.mostrarListaMedicos(medicos);
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao listar médico");
        }
    }

    private void editarPerfil() {
        view.mostrarTitulo("EDITAR PERFIL");

        try {
            view.mostrarDadosSecretario(secretario);

            if (view.perguntarAcao("Deseja editar seus dados?")) {
                String nome = view.lerNomeCompleto();
                String email = view.lerEmail();
                String senha = view.lerSenha();
                String telefone = view.lerTelefone();
                String turno = view.lerTurno();

                secretario.setNomeUsuario(nome);
                secretario.setEmailUsuario(email);
                secretario.setSenhaUsuario(senha);
                secretario.setTelefoneUsuario(telefone);
                secretario.setTurnoTrabalhadoSecretario(turno);

                secretarioService.atualizarSecretario(secretario);
                view.mostrarMensagemSucesso("Perfil atualizado com sucesso");
            }
        } catch (Exception e) {
            view.mostrarMensagemErro("Erro ao editar perfil");
        }

    }
}
