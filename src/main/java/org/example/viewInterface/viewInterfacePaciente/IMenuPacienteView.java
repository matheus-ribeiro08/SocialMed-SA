package org.example.viewInterface.viewInterfacePaciente;

import org.example.model.*;

import java.util.List;

public interface IMenuPacienteView {
    int mostrarMenuPrincipal(String nome);
    void mostrarTitulo(String titulo);

    void mostrarMensagemErro(String mensagem);
    void mostrarMensagemSucesso(String mensagem);
    void mostrarMensagemInfo(String mensagem);

    void mostrarDadosPaciente(PacienteModel paciente);
    void mostrarListaConsultas(ConsultaModel consulta);
    void mostrarDetalhesConsulta(ConsultaModel consulta);
    void mostrarProntuario(ProntuarioModel prontuarioModel);

    void mostrarTituloListaMedicos();
    void mostrarTituloAgenda();
    void mostrarTituloLista();

    void mostrarTituloListaHospital();

    void listarHospitais(HospitalModel hospital);
    int selecionarHospital();
    void abrirMapaLocalizacao();
    void mostrarHistoricoConsultas(ConsultaModel consulta);
    void mostrarAgenda(ConsultaModel consulta);
    void mostrarListaMedicos(MedicoModel medico);

    String lerHorario();
    String lerNomeCompleto();
    String lerCpf();
    int lerIdConsulta();
    String lerData();
    String lerDescricaoAgendamento();
    String lerEspecialidade();
    String lerNomeMedico();
    String lerSenha();
    String lerEmail();
    String lerTelefone();
    String lerEndereco();;

    int selecionarMedico();

    void lerDadosAtualizacaoPaciente(PacienteModel paciente);
    boolean perguntarAcao(String pergunta);
}
