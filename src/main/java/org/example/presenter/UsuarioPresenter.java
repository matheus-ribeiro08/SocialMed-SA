package org.example.presenter;

import org.example.model.UsuarioModel;
import org.example.model.PacienteModel;
import org.example.service.UsuarioService;
import org.example.utils.Ferramentas;
import org.example.viewInterface.ICadastroView;

public class UsuarioPresenter {

    private UsuarioService service;
    private PacienteModel model;
    private ICadastroView view;

    public UsuarioPresenter(PacienteModel model, ICadastroView view) {
        this.service = new UsuarioService();
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
            usuario.setDataNascimentoUsuario(dados[4]);
            usuario.setTelefoneUsuario(dados[5]);

            if (service.cadastrar(usuario)) {
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
            String[] dados = view.getDadosLogin();
            String email = dados[0];
            String senha = dados[1];

            UsuarioModel usuario = service.login(email,senha);

            if (usuario != null) {
                view.mostrarSucesso("Login realizado! Bem-vindo " + usuario.getNomeUsuario());
                menuPacienteLogado(usuario);
            } else {
                view.mostrarErro("Email ou senha incorretos!");
            }

        } catch (Exception e) {
            view.mostrarErro("Erro no login: " + e.getMessage());
        }
    }

