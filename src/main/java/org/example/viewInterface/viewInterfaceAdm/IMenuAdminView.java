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
    MedicoModel lerDadosNovoMedico();
    SecretarioModel lerDadosNovoSecretario();
    UsuarioModel lerDadosAtualizacaoUsuario(UsuarioModel usuarioExistente);
    MedicoModel lerDadosAtualizacaoMedico(MedicoModel medicoExistente);
    void mostrarListaUsuarios(List<UsuarioModel> usuarios);
    void mostrarListaMedicos(List<MedicoModel> medicos);
    void mostrarDadosUsuarioCompleto(UsuarioModel usuario);
    long selecionarMedico();
    int mostrarMenuDetalhesMedico(MedicoModel medico);
    int mostrarMenuDetalhesPaciente(PacienteModel paciente);
    int mostrarMenuDetalhesSecretario(SecretarioModel secretario);
    void mostrarTitulo(String titulo);
    void mostrarMensagemSucesso(String mensagem);
    void mostrarMensagemErro(String mensagem);
    void mostrarMensagemInfo(String mensagem);

}
