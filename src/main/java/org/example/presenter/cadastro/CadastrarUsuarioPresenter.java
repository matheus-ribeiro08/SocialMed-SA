package org.example.presenter.cadastro;

import org.example.enums.Destinos;
import org.example.enums.TipoUsuario;
import org.example.exception.*;
import org.example.model.PacienteModel;
import org.example.model.UsuarioModel;
import org.example.roteador.Roteador;
import org.example.service.paciente.PacienteService;
import org.example.service.usuario.UsuarioService;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceCadastro.ICadastroView;

public class CadastrarUsuarioPresenter {

    private Roteador roteadorCadastro;
    private ICadastroView view;
    private UsuarioService usuarioService;
    private PacienteService pacienteService;

    public CadastrarUsuarioPresenter (Roteador roteadorCadastro, ICadastroView view){
        this.roteadorCadastro = roteadorCadastro;
        this.view = view;
        this.usuarioService = new UsuarioService();
        this.pacienteService = new PacienteService();
    }

    public void iniciarCadastro(){
        Ferramentas.limpaTerminalOpcional(30);
        boolean cadastrando = true;

        while (cadastrando) {
            try {
                String nome = view.pedirNome();
                String senha = view.pedirSenha();
                String email = view.pedirEmail();
                String cpf = view.pedirCPF();
                String telefone = view.pedirTelefone();
                String endereco = view.pedirEndereco();
                TipoUsuario tipoUsuario = TipoUsuario.PACIENTE;

                validarInformacoes(nome, senha, email, cpf, telefone);

                PacienteModel paciente = new PacienteModel(nome, tipoUsuario, email, senha, telefone, cpf, endereco);

                pacienteService.cadastrar(paciente);

                System.out.println("Cadastro realizado com sucesso!");
                roteadorCadastro.irPara(Destinos.LOGIN, null);
                Ferramentas.Delay(1500);
                Ferramentas.limpaTerminalOpcional(30);
                cadastrando = false;
            } catch (Exception e) {
                System.err.println("Erro no cadastro!");
                Ferramentas.Delay(1500);
                Ferramentas.limpaTerminalOpcional(30);

                if (perguntarTentarNovamente()) {
                    iniciarCadastro();
                } else {
                    roteadorCadastro.irPara(Destinos.LOGIN, null);
                    cadastrando = false;
                }
            }
        }
    }

    private boolean perguntarTentarNovamente(){
        Ferramentas.limpaTerminalOpcional(30);

        System.out.println("Deseja tentar novamente? (1 - Sim / 2 - Não): ");
        int opcao = Ferramentas.lInteiro();
        Ferramentas.Delay(1500);
        Ferramentas.limpaTerminalOpcional(30);
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
