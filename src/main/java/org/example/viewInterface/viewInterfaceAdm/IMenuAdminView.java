package org.example.viewInterface.viewInterfaceAdm;

import org.example.enums.TipoUsuario;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;
import org.example.model.UsuarioModel;

import java.util.List;

public interface IMenuAdminView {

    int mostrarMenuPrincipal(String nomeAdmin);
    int mostrarMenuGerenciadoUsuarios();
    String lerCpf();
    boolean perguntarAcao(String mensagem);
    TipoUsuario selecionarTipoUsuario();
    String lerNomeCompleto();
    String lerEmail();
    String lerTelefone();
    String lerEndereco();
    String lerTurno();
    String lerEspecialidade();
    String lerSenha();
    int lerId();
    void lerDadosNovoMedico();
    void lerDadosNovoSecretario();
    int mostrarMenuDetalhePaciente(PacienteModel paciente);
    int mostrarMenuDetalheMedico(MedicoModel medico);
    void lerDadosAtualizacaoUsuario(UsuarioModel usuario);
    void lerDadosAtualizacaoMedico(MedicoModel medico);
    void mostrarListaSecretarios(List<SecretarioModel> secretarios);
    void mostrarListaUsuarios(List<UsuarioModel> usuarios);
    void mostrarListaPacientes(List<PacienteModel> pacientes);
    void mostrarListaMedicos(List<MedicoModel> medicos);
    void mostrarDadosUsuarioCompleto(UsuarioModel usuario);
    int selecionarMedico();
    void mostrarTitulo(String titulo);
    void mostrarMensagemSucesso(String mensagem);
    void mostrarMensagemErro(String mensagem);
    void mostrarMensagemInfo(String mensagem);

}
