package org.example.presenter.secretario;

import org.example.enums.TipoUsuario;
import org.example.model.ConsultaModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;
import org.example.roteador.Roteador;
import org.example.service.consulta.ConsultaService;
import org.example.service.medico.MedicoService;
import org.example.service.paciente.PacienteService;
import org.example.service.secretario.SecretarioService;

import java.util.List;

public class MenuSecretarioPresenter
{
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
    public void iniciar()
    {
        boolean executando = true;

        while(executando)
        {
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
                        roteador.irPara(Roteador.Destino.MENU_INICIAL, null);
                        break;
                    default:
                        view.mostrarMensagemErro("Opção inválida");
                }
            } catch (Exception e) {
                view.mostrarMensagemErro("Erro");
            }
        }
    }

    private void cadastrarPaciente()
    {
        view.mostrarTitulo("CADASTRAR PACIENTE");

        try
        {
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
            view.mostrarMensagemErro;
        }
    }
}
