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

    private final DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/mm/yyyy");
    private final DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
    private final DateTimeFormatter formatterDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

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
    public MedicoModel lerDadosNovoMedico() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                           ███╗   ██╗ ██████╗ ██╗   ██╗ ██████╗    ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗                                      ");
        System.out.println("                           ████╗  ██║██╔═══██╗██║   ██║██╔═══██╗   ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗                                     ");
        System.out.println("                           ██╔██╗ ██║██║   ██║██║   ██║██║   ██║   ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║                                     ");
        System.out.println("                           ██║╚██╗██║██║   ██║╚██╗ ██╔╝██║   ██║   ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║                                     ");
        System.out.println("                           ██║ ╚████║╚██████╔╝ ╚████╔╝ ╚██████╔╝   ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝                                     ");
        System.out.println("                           ╚═╝  ╚═══╝ ╚═════╝   ╚═══╝   ╚═════╝    ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝                                      ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        String nome = lerNomeCompleto();
        String cpf = lerCpf();
        String email = lerEmail();
        String telefone = lerTelefone();
        String dataNascimento = lerDatanascimento();
        String endereco = lerEndereco();
        String crm = lerCrm();
        String especialidade = lerEspecialidade();


        return null;
    }

    @Override
    public SecretarioModel lerDadosNovoSecretario() {

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                  ███╗   ██╗ ██████╗ ██╗   ██╗ ██████╗    ███████╗███████╗ ██████╗██████╗ ███████╗████████╗ █████╗ ██████╗ ██╗ ██████╗                 ");
        System.out.println("                  ████╗  ██║██╔═══██╗██║   ██║██╔═══██╗   ██╔════╝██╔════╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║██╔═══██╗                ");
        System.out.println("                  ██╔██╗ ██║██║   ██║██║   ██║██║   ██║   ███████╗█████╗  ██║     ██████╔╝█████╗     ██║   ███████║██████╔╝██║██║   ██║                ");
        System.out.println("                  ██║╚██╗██║██║   ██║╚██╗ ██╔╝██║   ██║   ╚════██║██╔══╝  ██║     ██╔══██╗██╔══╝     ██║   ██╔══██║██╔══██╗██║██║   ██║                ");
        System.out.println("                  ██║ ╚████║╚██████╔╝ ╚████╔╝ ╚██████╔╝   ███████║███████╗╚██████╗██║  ██║███████╗   ██║   ██║  ██║██║  ██║██║╚██████╔╝                ");
        System.out.println("                  ╚═╝  ╚═══╝ ╚═════╝   ╚═══╝   ╚═════╝    ╚══════╝╚══════╝ ╚═════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝                 ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        return null;
    }

    @Override
    public UsuarioModel lerDadosAtualizacaoUsuario(UsuarioModel usuarioExistente) {
        return null;
    }

    @Override
    public MedicoModel lerDadosAtualizacaoMedico(MedicoModel medicoExistente) {
        return null;
    }

    @Override
    public void mostrarListaUsuarios(List<UsuarioModel> usuarios) {

    }

    @Override
    public void mostrarListaMedicos(List<MedicoModel> medicos) {

    }

    @Override
    public void mostrarDadosUsuarioCompleto(UsuarioModel usuario) {

    }

    @Override
    public long selecionarMedico() {
        return 0;
    }

    @Override
    public int mostrarMenuDetalhesMedico(MedicoModel medico) {
        return 0;
    }

    @Override
    public int mostrarMenuDetalhesPaciente(PacienteModel paciente) {
        return 0;
    }

    @Override
    public int mostrarMenuDetalhesSecretario(SecretarioModel secretario) {
        return 0;
    }

    @Override
    public void mostrarTitulo(String titulo) {

    }

    @Override
    public void mostrarMensagemSucesso(String mensagem) {

    }

    @Override
    public void mostrarMensagemErro(String mensagem) {

    }

    @Override
    public void mostrarMensagemInfo(String mensagem) {

    }
}
