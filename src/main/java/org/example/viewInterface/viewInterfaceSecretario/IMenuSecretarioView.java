package org.example.viewInterface.viewInterfaceSecretario;

import org.example.model.*;

import java.util.List;

public interface IMenuSecretarioView
{
    int mostrarMenuPrincipal(String nomeSecretario);
    void mostrarTitulo(String titulo);

    void mostrarMensagemSucesso(String mensagem);
    void mostrarMensagemErro(String mensagem);
    void mostrarMensagemInfo(String mensagem);

    void mostrarListaPacientes(PacienteModel paciente);
    void mostrarListaMedicos(MedicoModel medico);
    void mostrarListaConsultas(ConsultaModel consulta);
    void mostrarListaHospitais(HospitalModel hospital);

    void mostrarDadosPacienteCompleto(PacienteModel paciente);
    void mostrarDadosMedicoCompleto(MedicoModel medico);
    void mostrarDadosConsultaCompleta(ConsultaModel consulta);
    void mostrarDadosSecretario(SecretarioModel secretario);

    String lerNomeCompleto();
    String lerCpf();
    String lerEmail();
    String lerSenha();
    String lerTelefone();
    String lerEndereco();
    String lerDataNascimento();
    String lerData();
    String lerHora();
    String lerTurno();
    String lerEspecialidade();
    int lerIdPaciente();
    int lerIdMedico();
    int lerIdConsulta();
    int lerIdHospital();
    int selecionarMedico(MedicoModel medicos);
    String selecionarHorario(String horarios);
    void lerDadosAtualizacaoPaciente(PacienteModel paciente);
    void lerDadosAtualizacaoSecretario(SecretarioModel secretario);
    boolean perguntarAcao(String mensagem);

}
