package org.example.viewInterface.viewInterfaceMedico;

import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;

import java.util.List;

public interface IMenuMedicoView
{
    int mostrarMenuPrincipa(String nomeMedico, String especialidade);
    void mostrarTitulo(String titulo);

    void mostrarMensagemErro(String mensagem);
    void mostrarMensagemSucesso(String mensagem);
    void mostrarMensagemInfo(String mensagem);

    void mostrarListaConsultasDetalhadas(List<ConsultaModel> consultas);
    void mostrarHistoricoConsultas(List<ConsultaModel> consultas);
    void mostrarHistoricoAtendimentos(List<ConsultaModel> historico);

    void mostrarDadosConsultaCompleta(ConsultaModel consulta);
    void mostrarDadosPacientesCompleto(PacienteModel paciente);
    void mostrarDadosMedico(MedicoModel medico);
    void mostrarProntuario(ProntuarioModel prontuario);

    long lerIdConsulta();
    String lerDiagnostico();
    String lerPrescricao();
    String lerObservacoes();
    String lerCpf();
    String lerInformacoesIniciais();
    String lerInformacaoAdicional();;
    String lerTipoExame();

    MedicoModel lerDadosAtualizacaoMedico(MedicoModel medico);
    boolean perguntarAcesso(String pergunta);
    boolean perguntarAcao(String pergunta);


}
