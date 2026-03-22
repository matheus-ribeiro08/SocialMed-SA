package org.example.viewInterface.viewInterfacePaciente;

import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.ProntuarioModel;

import java.util.List;

public interface IMenuPacienteView {
    int mostrarMenuPrincipal(String nome);
    void mostrarTitulo(String titulo);

    void mostrarMensagemErro(String mensagem);
    void mostrarMensagemSucesso(String mensagem);
    void mostrarMensagemInfo(String mensagem);

    void mostrarDadosPaciente(PacienteModel paciente);
    void mostrarListaConsultas(List<ConsultaModel> consultas);
    void mostrarDetalhesConsulta(ConsultaModel consulta);
    void mostrarProntuario(ProntuarioModel prontuarioModel);

    void abrirMapaLocalizacao();
    void mostrarHistoricoConsultas(List<ConsultaModel> consultas);
    void mostrarAgenda(List<ConsultaModel> consultas);
    void mostrarListaMedicos(List<MedicoModel> medicos);

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

    int selecionarMedico(List<MedicoModel> medicos);
    String selecionarHorario(List<String> horarios);

    void lerDadosAtualizacaoPaciente(PacienteModel paciente);
    boolean perguntarAcao(String pergunta);
}
