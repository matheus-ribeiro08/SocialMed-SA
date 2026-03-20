package org.example.view.adm;

import org.example.enums.TipoUsuario;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;
import org.example.model.UsuarioModel;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceAdm.IMenuAdminView;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class MenuAdminConsoleView implements IMenuAdminView {

    @Override
    public int mostrarMenuPrincipal(String nomeAdmin) {

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("    ███╗   ███╗███████╗███╗   ██╗██╗   ██╗     █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗██╗███████╗████████╗██████╗  █████╗ ██████╗  ██████╗ ██████╗     ");
        System.out.println("    ████╗ ████║██╔════╝████╗  ██║██║   ██║    ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║██║██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔══██╗    ");
        System.out.println("    ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║██║███████╗   ██║   ██████╔╝███████║██║  ██║██║   ██║██████╔╝    ");
        System.out.println("    ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║██║╚════██║   ██║   ██╔══██╗██╔══██║██║  ██║██║   ██║██╔══██╗    ");
        System.out.println("    ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║██║███████║   ██║   ██║  ██║██║  ██║██████╔╝╚██████╔╝██║  ██║    ");
        System.out.println("    ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝    ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" OPÇÕES                                                                                                                                                ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" (1) ➔ Gerenciar Usuarios                                                                                                                              ");
        System.out.println(" (2) ➔ Gerenciar Medicos                                                                                                                          ");
        System.out.println(" (3) ➔ Gerenciar Secretarios                                                                                                                               ");
        System.out.println(" (4) ➔ Gerenciar Pacientes                                                                                                                                 ");
        System.out.println(" (5) ➔ Acessar prontuario                                                                                                                              ");
        System.out.println(" (6) ➔ Atualizar prontuario                                                                                                                            ");
        System.out.println(" (7) ➔ Ver historico de consultas                                                                                                                      ");
        System.out.println(" (8) ➔ Visualizar perfil                                                                                                                               ");
        System.out.println(" (0) ➔ Voltar para menu inicial                                                                                                                        ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite a opção desejada: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public int mostrarMenuGerenciadoUsuarios() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("      ██████╗ ███████╗██████╗ ███████╗███╗   ██╗ ██████╗██╗ █████╗ ██████╗         ██╗   ██╗███████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗ ███████╗      ");
        System.out.println("     ██╔════╝ ██╔════╝██╔══██╗██╔════╝████╗  ██║██╔════╝██║██╔══██╗██╔══██╗        ██║   ██║██╔════╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗██╔════╝      ");
        System.out.println("     ██║  ███╗█████╗  ██████╔╝█████╗  ██╔██╗ ██║██║     ██║███████║██████╔╝        ██║   ██║███████╗██║   ██║███████║██████╔╝██║██║   ██║███████╗      ");
        System.out.println("     ██║   ██║██╔══╝  ██╔══██╗██╔══╝  ██║╚██╗██║██║     ██║██╔══██║██╔══██╗        ██║   ██║╚════██║██║   ██║██╔══██║██╔══██╗██║██║   ██║╚════██║      ");
        System.out.println("     ╚██████╔╝███████╗██║  ██║███████╗██║ ╚████║╚██████╗██║██║  ██║██║  ██║        ╚██████╔╝███████║╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝███████║      ");
        System.out.println("      ╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝╚═╝╚═╝  ╚═╝╚═╝  ╚═╝         ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝ ╚══════╝      ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" OPÇÕES                                                                                                                                                ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" (1) ➔ Listar todos os usuarios                                                                                                                        ");
        System.out.println(" (2) ➔ Buscar usuario por Id                                                                                                                           ");
        System.out.println(" (3) ➔ Buscar usuario por CPF                                                                                                                          ");
        System.out.println(" (4) ➔ Criar novo usuario                                                                                                                              ");
        System.out.println(" (5) ➔ Editar Usuario                                                                                                                                  ");
        System.out.println(" (6) ➔ Desativar Usuario                                                                                                                               ");
        System.out.println(" (7) ➔ Ativar Usuario                                                                                                                                  ");
        System.out.println(" (0) ➔ Voltar                                                                                                                                          ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite a opção desejada: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public String lerCpf() {
        System.out.println("Digite o CPF (11 numeros): ");
        return Ferramentas.lString().trim();
    }

    @Override
    public boolean perguntarAcao(String mensagem) {
        System.out.println(mensagem + "(S/N): ");
        String resposta = Ferramentas.lString().trim().toUpperCase();
        return resposta.equalsIgnoreCase(("S")) || resposta.equalsIgnoreCase("Sim");
    }

    @Override
    public TipoUsuario selecionarTipoUsuario() {
        System.out.println("\nTipos de usuario: ");
        System.out.println("  (1) ➔ Médico");
        System.out.println("  (2) ➔ Secretário");
        System.out.printf(" ➤ Digite a opção desejada: ");

        int opcao = Ferramentas.lInteiro();

        switch (opcao){
            case 1: return TipoUsuario.MEDICO;
            case 2:return  TipoUsuario.SECRETARIO;
            default:return null;
        }
    }

    @Override
    public void lerDadosNovoMedico(MedicoModel medico) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                           ███╗   ██╗ ██████╗ ██╗   ██╗ ██████╗    ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗                                      ");
        System.out.println("                           ████╗  ██║██╔═══██╗██║   ██║██╔═══██╗   ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗                                     ");
        System.out.println("                           ██╔██╗ ██║██║   ██║██║   ██║██║   ██║   ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║                                     ");
        System.out.println("                           ██║╚██╗██║██║   ██║╚██╗ ██╔╝██║   ██║   ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║                                     ");
        System.out.println("                           ██║ ╚████║╚██████╔╝ ╚████╔╝ ╚██████╔╝   ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝                                     ");
        System.out.println("                           ╚═╝  ╚═══╝ ╚═════╝   ╚═══╝   ╚═════╝    ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝                                      ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        String nome = lerNomeCompleto();
        medico.setNomeUsuario(nome);

        String cpf = lerCpf();
        medico.setCpfUsuario(cpf);

        String email = lerEmail();
        medico.setEmailUsuario(email);

        String telefone = lerTelefone();
        medico.setTelefoneUsuario(telefone);

        String especialidade = lerEspecialidade();
        medico.setEspecialidadeMedico(especialidade);

        medico.setTipoUsuario(TipoUsuario.MEDICO);
    }

    private String lerEspecialidade(){
        System.out.println("Digite a especialidade: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public void lerDadosNovoSecretario(SecretarioModel secretario) {

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                      ███╗   ██╗ ██████╗ ██╗   ██╗ ██████╗   ███████╗███████╗ ██████╗██████╗ ███████╗████████╗ █████╗ ██╗ ██████╗                      ");
        System.out.println("                      ████╗  ██║██╔═══██╗██║   ██║██╔═══██╗  ██╔════╝██╔════╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██║██╔═══██╗                     ");
        System.out.println("                      ██╔██╗ ██║██║   ██║██║   ██║██║   ██║  ███████╗█████╗  ██║     ██████╔╝█████╗     ██║   ███████║██║██║   ██║                     ");
        System.out.println("                      ██║╚██╗██║██║   ██║╚██╗ ██╔╝██║   ██║  ╚════██║██╔══╝  ██║     ██╔══██╗██╔══╝     ██║   ██╔══██║██║██║   ██║                     ");
        System.out.println("                      ██║ ╚████║╚██████╔╝ ╚████╔╝ ╚██████╔╝  ███████║███████╗╚██████╗██║  ██║███████╗   ██║   ██║  ██║██║╚██████╔╝                     ");
        System.out.println("                      ╚═╝  ╚═══╝ ╚═════╝   ╚═══╝   ╚═════╝   ╚══════╝╚══════╝ ╚═════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝ ╚═════╝                      ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        String nome = lerNomeCompleto();
        secretario.setNomeUsuario(nome);

        String cpf = lerCpf();
        secretario.setCpfUsuario(cpf);

        String email = lerEmail();
        secretario.setEmailUsuario(email);

        String telefone = lerTelefone();
        secretario.setTelefoneUsuario(telefone);

        String turno = lerTurno();
        secretario.setTurnoTrabalhadoSecretario(turno);

        secretario.setTipoUsuario(TipoUsuario.SECRETARIO);

    }

    private String lerTurno() {
        System.out.print("Digite o turno: ");

        return Ferramentas.lString().trim();
    }

    private String lerEndereco() {
        System.out.print("Digite o endereço: ");

        return Ferramentas.lString().trim();
    }

    private String lerTelefone() {
        System.out.print("Digite o telefone: ");

        return Ferramentas.lString().trim();
    }

    private String lerEmail() {
        System.out.print("Digite o email: ");

        return Ferramentas.lString().trim();
    }

    private String lerNomeCompleto() {
        System.out.print("Digite o nome");

        return Ferramentas.lString();
    }

    @Override
    public void lerDadosAtualizacaoUsuario(UsuarioModel usuarioExistente, UsuarioModel usuarioAtualizado) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("             ██████╗  █████╗ ██████╗  ██████╗ ███████╗   █████╗ ████████╗██╗   ██╗ █████╗ ██╗     ██╗███████╗ █████╗  ██████╗ ███████╗                 ");
        System.out.println("             ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝  ██╔══██╗╚══██╔══╝██║   ██║██╔══██╗██║     ██║    ██╔╝██╔══██╗██╔═══██╗██╔════╝                 ");
        System.out.println("             ██║  ██║███████║██║  ██║██║   ██║███████╗  ███████║   ██║   ██║   ██║███████║██║     ██║   ██╔╝ ███████║██║   ██║███████╗                 ");
        System.out.println("             ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║  ██╔══██║   ██║   ██║   ██║██╔══██║██║     ██║  ██╔╝  ██╔══██║██║   ██║╚════██║                 ");
        System.out.println("             ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║  ██║  ██║   ██║   ╚██████╔╝██║  ██║███████╗██║███████╗██║  ██║╚██████╔╝███████║                 ");
        System.out.println("             ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝  ╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                 ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("(Deixe em branco se quiser manter os dados atuais!)");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("Nome: [" + usuarioExistente.getNomeUsuario() + "]:");
        String nome = Ferramentas.lString().trim();
        usuarioAtualizado.setNomeUsuario(nome.isEmpty() ? usuarioExistente.getNomeUsuario() : nome);

        System.out.println("Email: [" + usuarioExistente.getEmailUsuario() + "]:");
        String email = Ferramentas.lString().trim();
        usuarioAtualizado.setEmailUsuario(email.isEmpty() ? usuarioExistente.getEmailUsuario() : email);

        System.out.println("Telefone: [" + usuarioExistente.getTelefoneUsuario() + "]:");
        String telefone = Ferramentas.lString().trim();
        usuarioAtualizado.setTelefoneUsuario(telefone.isEmpty() ? usuarioExistente.getTelefoneUsuario() : telefone);

        usuarioAtualizado.setIdUsuario(usuarioExistente.getIdUsuario());
        usuarioAtualizado.setSenhaUsuario(usuarioExistente.getSenhaUsuario());
        usuarioAtualizado.setCpfUsuario(usuarioExistente.getCpfUsuario());
        usuarioAtualizado.setTipoUsuario(usuarioExistente.getTipoUsuario());
    }

    @Override
    public void lerDadosAtualizacaoMedico(MedicoModel medicoExistente, MedicoModel medicoAtualizado) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("             ██████╗  █████╗ ██████╗  ██████╗ ███████╗   █████╗ ████████╗██╗   ██╗ █████╗ ██╗     ██╗███████╗ █████╗  ██████╗ ███████╗                 ");
        System.out.println("             ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝  ██╔══██╗╚══██╔══╝██║   ██║██╔══██╗██║     ██║    ██╔╝██╔══██╗██╔═══██╗██╔════╝                 ");
        System.out.println("             ██║  ██║███████║██║  ██║██║   ██║███████╗  ███████║   ██║   ██║   ██║███████║██║     ██║   ██╔╝ ███████║██║   ██║███████╗                 ");
        System.out.println("             ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║  ██╔══██║   ██║   ██║   ██║██╔══██║██║     ██║  ██╔╝  ██╔══██║██║   ██║╚════██║                 ");
        System.out.println("             ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║  ██║  ██║   ██║   ╚██████╔╝██║  ██║███████╗██║███████╗██║  ██║╚██████╔╝███████║                 ");
        System.out.println("             ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝  ╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                 ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("(Deixe em branco se quiser manter os dados atuais!)");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("Nome: [" + medicoExistente.getNomeUsuario() + "]:");
        String nome = Ferramentas.lString().trim();
        medicoAtualizado.setNomeUsuario(nome.isEmpty() ? medicoExistente.getNomeUsuario() : nome);

        System.out.println("Email: [" + medicoExistente.getEmailUsuario() + "]:");
        String email = Ferramentas.lString().trim();
        medicoAtualizado.setEmailUsuario(email.isEmpty() ? medicoExistente.getEmailUsuario() : email);

        System.out.println("Telefone: [" + medicoExistente.getTelefoneUsuario() + "]:");
        String telefone = Ferramentas.lString().trim();
        medicoAtualizado.setTelefoneUsuario(telefone.isEmpty() ? medicoExistente.getTelefoneUsuario() : telefone);

        medicoAtualizado.setIdUsuario(medicoExistente.getIdUsuario());
        medicoAtualizado.setSenhaUsuario(medicoExistente.getSenhaUsuario());
        medicoAtualizado.setCpfUsuario(medicoExistente.getCpfUsuario());
        medicoAtualizado.setTipoUsuario(medicoExistente.getTipoUsuario());


    }

    @Override
    public void mostrarListaUsuarios(List<UsuarioModel> usuarios) {
        if(usuarios == null || usuarios.isEmpty()){
            System.out.println("Nenhum usuario cadastrado");
            return;
        }

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                    ██╗     ██╗███████╗████████╗ █████╗   ██╗   ██╗███████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗ ███████╗                               ");
        System.out.println("                    ██║     ██║██╔════╝╚══██╔══╝██╔══██╗  ██║   ██║██╔════╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗██╔════╝                               ");
        System.out.println("                    ██║     ██║███████╗   ██║   ███████║  ██║   ██║███████╗██║   ██║███████║██████╔╝██║██║   ██║███████╗                               ");
        System.out.println("                    ██║     ██║╚════██║   ██║   ██╔══██║  ██║   ██║╚════██║██║   ██║██╔══██║██╔══██╗██║██║   ██║╚════██║                               ");
        System.out.println("                    ███████╗██║███████║   ██║   ██║  ██║  ╚██████╔╝███████║╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝███████║                               ");
        System.out.println("                    ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝ ╚══════╝                               ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        for(UsuarioModel usuario : usuarios){
            System.out.println("Id: " + usuario.getIdUsuario());
            System.out.println("Nome: " + usuario.getNomeUsuario());
            System.out.println("Tipo: " + usuario.getTipoUsuario());
            System.out.println("Cpf: " + usuario.getCpfUsuario());
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        }
    }

    @Override
    public void mostrarListaMedicos(List<MedicoModel> medicos) {
        if(medicos == null || medicos.isEmpty()){
            System.out.println("Nenhum medico cadastrado");
            return;
        }

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                        ██╗     ██╗███████╗████████╗ █████╗    ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗ ███████╗                                 ");
        System.out.println("                        ██║     ██║██╔════╝╚══██╔══╝██╔══██╗   ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗██╔════╝                                 ");
        System.out.println("                        ██║     ██║███████╗   ██║   ███████║   ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║███████╗                                 ");
        System.out.println("                        ██║     ██║╚════██║   ██║   ██╔══██║   ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║╚════██║                                 ");
        System.out.println("                        ███████╗██║███████║   ██║   ██║  ██║   ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝███████║                                 ");
        System.out.println("                        ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝                                 ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for(MedicoModel medico : medicos){
            System.out.println("Id: " + medico.getIdUsuario());
            System.out.println("Nome: " + medico.getNomeUsuario());
            System.out.println("Cpf: " + medico.getCpfUsuario());
            System.out.println("Especialidade: " + medico.getEspecialidadeMedico());
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }

    }

    @Override
    public void mostrarListaSecretarios(List<SecretarioModel> secretarios) {
        if(secretarios == null || secretarios.isEmpty()){
            System.out.println("Nenhum secretario cadastrado");
            return;
        }

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                      ██╗     ██╗███████╗████████╗ █████╗     ███████╗███████╗ ██████╗██████╗ ███████╗████████╗ █████╗ ██╗ ██████╗                     ");
        System.out.println("                      ██║     ██║██╔════╝╚══██╔══╝██╔══██╗    ██╔════╝██╔════╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██║██╔═══██╗                    ");
        System.out.println("                      ██║     ██║███████╗   ██║   ███████║    ███████╗█████╗  ██║     ██████╔╝█████╗     ██║   ███████║██║██║   ██║                    ");
        System.out.println("                      ██║     ██║╚════██║   ██║   ██╔══██║    ╚════██║██╔══╝  ██║     ██╔══██╗██╔══╝     ██║   ██╔══██║██║██║   ██║                    ");
        System.out.println("                      ███████╗██║███████║   ██║   ██║  ██║    ███████║███████╗╚██████╗██║  ██║███████╗   ██║   ██║  ██║██║╚██████╔╝                    ");
        System.out.println("                      ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝    ╚══════╝╚══════╝ ╚═════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝ ╚═════╝                     ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for(SecretarioModel secretario : secretarios){
            System.out.println("Id: " + secretario.getIdUsuario());
            System.out.println("Nome: " + secretario.getNomeUsuario());
            System.out.println("Cpf: " + secretario.getCpfUsuario());
            System.out.println("Turno: " + secretario.getTurnoTrabalhadoSecretario());
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }

    }

    @Override
    public void mostrarDadosUsuarioCompleto(UsuarioModel usuario) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                           ██████╗  █████╗ ██████╗  ██████╗ ███████╗ ██╗   ██╗███████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗                             ");
        System.out.println("                           ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝ ██║   ██║██╔════╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗                            ");
        System.out.println("                           ██║  ██║███████║██║  ██║██║   ██║███████╗ ██║   ██║███████╗██║   ██║███████║██████╔╝██║██║   ██║                            ");
        System.out.println("                           ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║ ██║   ██║╚════██║██║   ██║██╔══██║██╔══██╗██║██║   ██║                            ");
        System.out.println("                           ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║ ╚██████╔╝███████║╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝                            ");
        System.out.println("                           ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝  ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝                             ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Id: " + usuario.getIdUsuario());
        System.out.println("Nome: " + usuario.getNomeUsuario());
        System.out.println("Tipo: " + usuario.getTipoUsuario());
        System.out.println("Telefone: " + usuario.getTelefoneUsuario());
        System.out.println("Senha: " + usuario.getSenhaUsuario());
        System.out.println("Cpf: " + usuario.getCpfUsuario());
        System.out.println("Email: " + usuario.getEmailUsuario());
    }

    @Override
    public long selecionarMedico() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("            ███████╗███████╗██╗     ███████╗ ██████╗██╗ ██████╗ ███╗   ██╗ █████╗ ██████╗   ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗             ");
        System.out.println("            ██╔════╝██╔════╝██║     ██╔════╝██╔════╝██║██╔═══██╗████╗  ██║██╔══██╗██╔══██╗  ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗            ");
        System.out.println("            ███████╗█████╗  ██║     █████╗  ██║     ██║██║   ██║██╔██╗ ██║███████║██████╔╝  ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║            ");
        System.out.println("            ╚════██║██╔══╝  ██║     ██╔══╝  ██║     ██║██║   ██║██║╚██╗██║██╔══██║██╔══██╗  ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║            ");
        System.out.println("            ███████║███████╗███████╗███████╗╚██████╗██║╚██████╔╝██║ ╚████║██║  ██║██║  ██║  ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝            ");
        System.out.println("            ╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝  ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝             ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("Digite o id do medico desejado: ");
        return Ferramentas.lLong();
    }

    @Override
    public void mostrarTitulo(String titulo) {
        System.out.println("\n" + titulo);
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public void mostrarMensagemSucesso(String mensagem) {
        System.out.println("\n" + mensagem);
    }

    @Override
    public void mostrarMensagemErro(String mensagem) {
        System.out.println("\n" + mensagem);
    }

    @Override
    public void mostrarMensagemInfo(String mensagem) {
        System.out.println("\n" + mensagem);
    }
}
