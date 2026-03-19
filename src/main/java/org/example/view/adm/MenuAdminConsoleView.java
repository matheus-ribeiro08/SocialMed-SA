package org.example.view.adm;

import org.example.enums.TipoUsuario;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;
import org.example.model.UsuarioModel;
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
        System.out.println("                         ███╗   ███╗███████╗███╗   ██╗██╗   ██╗    ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗                                      ");
        System.out.println("                         ████╗ ████║██╔════╝████╗  ██║██║   ██║    ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗                                     ");
        System.out.println("                         ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║                                     ");
        System.out.println("                         ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║                                     ");
        System.out.println("                         ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝                                     ");
        System.out.println("                         ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝                                      ");
        System.out.println("                                                                                                                                                       ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" OPÇÕES                                                                                                                                                ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" (1) ➔ Ver agenda de hoje                                                                                                                              ");
        System.out.println(" (2) ➔ Ver próximas consultas                                                                                                                          ");
        System.out.println(" (3) ➔ Atender paciente                                                                                                                                ");
        System.out.println(" (4) ➔ Buscar paciente                                                                                                                                 ");
        System.out.println(" (5) ➔ Acessar prontuario                                                                                                                              ");
        System.out.println(" (6) ➔ Atualizar prontuario                                                                                                                            ");
        System.out.println(" (7) ➔ Ver historico de consultas                                                                                                                      ");
        System.out.println(" (8) ➔ Visualizar perfil                                                                                                                               ");
        System.out.println(" (0) ➔ Voltar para menu inicial                                                                                                                        ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite a opção desejada: ");

        return 0;
    }

    @Override
    public int mostrarMenuGerenciadoUsuarios() {
        return 0;
    }

    @Override
    public String lerCpf() {
        return "";
    }

    @Override
    public boolean perguntarAcao(String mensagem) {
        return false;
    }

    @Override
    public TipoUsuario selecionarTipoUsuario() {
        return null;
    }

    @Override
    public MedicoModel lerDadosNovoMedico() {
        return null;
    }

    @Override
    public SecretarioModel lerDadosNovoSecretario() {
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
