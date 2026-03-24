package org.example.viewInterface.viewInterfaceMedico;

import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.ProntuarioModel;

import java.util.List;

public interface IMenuMedicoView
{
    int mostrarMenuPrincipal(String nome);
    void mostrarTitulo(String titulo);

    void mostrarMensagemErro(String mensagem);
    void mostrarMensagemSucesso(String mensagem);
    void mostrarMensagemInfo(String mensagem);

    void mostrarListaConsultasDetalhadas(ConsultaModel consulas);
    void mostrarHistoricoConsultas(ConsultaModel consulta);
    void mostrarHistoricoAtendimentos(ConsultaModel historico);

    void mostrarDadosConsultaCompleta(ConsultaModel consulta);
    void mostrarDadosPacienteCompleto(PacienteModel paciente);
    void mostrarDadosMedico(MedicoModel medico);
    void mostrarProntuario(ProntuarioModel prontuario);

    String lerNomeCompleto();
    String lerEmail();
    String lerTelefone();
    String lerEspecialidade();
    String lerSenha();
    String lerData();
    String lerSintomas();
    int lerIdConsulta();
    int lerIdMedico();
    String lerDiagnostico();
    String lerPrescricao();
    String lerObservacoes();
    String lerCpf();
    String lerInformacoesIniciais();
    String lerInformacaoAdicional();;
    String lerTipoExame();

    void lerDadosAtualizacaoMedico(MedicoModel medico);
    boolean perguntarAcao(String pergunta);


}
