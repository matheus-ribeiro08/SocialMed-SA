package org.example.presenter;

import org.example.model.UsuarioModel;
import org.example.model.PacienteModel;
import org.example.utils.Ferramentas;
import org.example.view.ICadastroView;

import java.time.LocalDate;

public class UsuarioPresenter {
    private PacienteModel model;
    private ICadastroView view;

    public UsuarioPresenter(PacienteModel model, ICadastroView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.mostrarMenuPrincipal();

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    fazerCadastro();
                    break;
                case 3:
                    view.mostrarMensagem("Saindo do sistema...");
                    Ferramentas.Delay(1500);
                    break;
                default:
                    view.mostrarErro("Opção inválida!");
                    Ferramentas.Delay(1500);
            }


        } while (opcao != 3);
    }

    private void fazerCadastro() {
        try {
            String[] dados = view.getDadosCadastro();

            if (dados[0].isEmpty() || dados[1].isEmpty() || dados[2].isEmpty() || dados[3].isEmpty() || dados[4].isEmpty() || dados[6].isEmpty()) {
                view.mostrarErro("Campos obrigatórios não preenchidos!");
                return;
            }

            UsuarioModel usuario = new UsuarioModel(0, null, null, null, null, null, null);
            usuario.setNomeUsuario(dados[0]);
            usuario.setEmailUsuario(dados[1]);
            usuario.setSenhaUsuario(dados[2]);
            usuario.setCpfUsuario(dados[3]);
            String data = dados[4];
            LocalDate date = LocalDate.parse(data);
            usuario.setDataNascimentoUsuario(dados[4]);
            usuario.setTelefoneUsuario(dados[5]);

            if (model.cadastrar(usuario)) {
                view.mostrarSucesso("Cadastro realizado com sucesso!");
            } else {
                view.mostrarErro("Email ou CPF já cadastrado!");
            }

        } catch (Exception e) {
            view.mostrarErro("Erro no cadastro: " + e.getMessage());
        }
    }

    private void fazerLogin() {
        try {
            // 1. Pega os dados da View
            String[] dados = view.getDadosLogin();
            String email = dados[0];
            String senha = dados[1];

            // 2. Manda o Model verificar
            Paciente paciente = model.login(email, senha);

            // 3. Mostra resultado
            if (paciente != null) {
                view.mostrarSucesso("Login realizado! Bem-vindo " + paciente.getNomeCompleto());
                // Aqui você pode chamar o menu do paciente logado
                menuPacienteLogado(paciente);
            } else {
                view.mostrarErro("Email ou senha incorretos!");
            }

        } catch (Exception e) {
            view.mostrarErro("Erro no login: " + e.getMessage());
        }
    }

    private void menuPacienteLogado(UsuarioModel usuario) {
        int opcao;
        do {

            System.out.println("\n=== MENU DO PACIENTE ===");
            System.out.println("1 - Meus Dados");
            System.out.println("2 - Atualizar Cadastro");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(Ferramentas.lString());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    mostrarDadosPaciente(paciente);
                    break;
                case 2:
                    // atualizarPaciente(paciente);
                    break;
                case 3:
                    view.mostrarMensagem("Saindo do menu paciente...");
                    break;
                default:
                    view.mostrarErro("Opção inválida!");
            }


        } while (opcao != 3);
    }

    private void mostrarDadosPaciente(Paciente paciente) {
        view.mostrarDadosPaciente(
                paciente.getNomeCompleto(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getDataNascimentoFormatada(),
                paciente.getTelefone(),
                paciente.getEndereco(),
                "", // convenio (se tiver)
                ""  // carteirinha (se tiver)
        );
    }
}