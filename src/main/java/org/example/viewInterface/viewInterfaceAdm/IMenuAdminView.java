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
    void lerDadosNovoMedico(MedicoModel medico);
    void lerDadosNovoSecretario(SecretarioModel secretario);
    void lerDadosAtualizacaoUsuario(UsuarioModel usuarioExistente, UsuarioModel usuarioAtualizado);
    void lerDadosAtualizacaoMedico(MedicoModel medicoExistente, MedicoModel medicoAtualizado);
    void mostrarListaUsuarios(List<UsuarioModel> usuarios);
    void mostrarListaMedicos(List<MedicoModel> medicos);
    void mostrarDadosUsuarioCompleto(UsuarioModel usuario);
    long selecionarMedico();
    void mostrarTitulo(String titulo);
    void mostrarMensagemSucesso(String mensagem);
    void mostrarMensagemErro(String mensagem);
    void mostrarMensagemInfo(String mensagem);

}
