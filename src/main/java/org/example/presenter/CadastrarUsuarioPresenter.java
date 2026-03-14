package org.example.presenter;

import org.example.exception.*;
import org.example.model.UsuarioModel;
import org.example.roteador.RoteadorCadastro;
import org.example.service.UsuarioService;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceCadastro.ICadastroView;

public class CadastrarUsuarioPresenter {

    private RoteadorCadastro roteadorCadastro;
    private ICadastroView view;
    private UsuarioService usuarioService;

    public CadastrarUsuarioPresenter (RoteadorCadastro roteadorCadastro, ICadastroView view){
        this.roteadorCadastro = roteadorCadastro;
        this.view = view;
        this.usuarioService = new UsuarioService();
    }

    public void iniciarCadastro(){
        try {
            String nome = view.pedirNome();
            String senha = view.pedirSenha();
            String email = view.pedirEmail();
            String cpf = view.pedirCPF();
            String telefone = view.pedirTelefone();

            validarInformacoes(nome,senha,email,cpf,telefone);

            UsuarioModel usuario = new UsuarioModel(nome,email,senha,telefone,cpf);

            usuarioService.cadastrar(usuario);

            System.out.println("Cadastro realizado com sucesso!");
            roteadorCadastro.irPara("login");
        }catch (Exception e){
            System.err.println("Erro no cadastro!");

        }
    }

    private boolean perguntarTentarNovamente(){
        System.out.println("Deseja tentar novamente? (1 - Sim / 2 - Não): ");
        int opcao = Ferramentas.lInteiro();
        return opcao == 1;
    }

    public void validarInformacoes(String nome, String senha, String email, String cpf, String telefone){
        if(nome == null || nome.length() < 1 || nome.length() > 2253){
            throw new NomeInvalido("Nome inválido!");
        }

        if (email == null || email.isBlank() || !email.contains("@") || email.length() > 345){
            throw new EmailInvalido("Email inválido!");
        }

        if (senha == null || senha.isBlank()){
            throw new SenhaInvalida("A senha não pode ser vazia!");
        }

        if(senha.length() < 8){
            throw new SenhaInvalida("Senha deve conter 8 digitos ou mais!");
        }

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).+$";

        if(!senha.matches(regex)){
            throw new SenhaInvalida("A senha deve conter caracteres especiais!");
        }

        if(cpf == null || cpf.isBlank()){
            throw new CpfInvalido("Cpf inválido!");
        }

        if(telefone == null || telefone.isBlank()){
            throw new TelefoneInvalido("Telefone inválido!");
        }

    }


}
