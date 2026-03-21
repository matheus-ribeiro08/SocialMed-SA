package org.example.view.paciente;

import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfacePaciente.IMenuPacienteView;

import java.util.List;

public class Paciente implements IMenuPacienteView {
    @Override
    public int mostrarMenuPrincipal(String nome) {
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                       ███╗   ███╗███████╗███╗   ██╗██╗   ██╗   ██████╗  █████╗  ██████╗██╗███████╗███╗   ██╗████████╗███████╗                       ");
        System.out.println("                       ████╗ ████║██╔════╝████╗  ██║██║   ██║   ██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝                       ");
        System.out.println("                       ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║   ██████╔╝███████║██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗                         ");
        System.out.println("                       ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║   ██╔═══╝ ██╔══██║██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝                         ");
        System.out.println("                       ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝   ██║     ██║  ██║╚██████╗██║███████╗██║ ╚████║   ██║   ███████╗                       ");
        System.out.println("                       ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝                       ");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" OPÇÕES                                                                                                                                              ");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" (1) ➔ Ver minhas consultas                                                                                                                          ");
        System.out.println(" (2) ➔ Agendar nova consulta                                                                                                                         ");
        System.out.println(" (3) ➔ Cancelar Consulta                                                                                                                             ");
        System.out.println(" (4) ➔ Ver historico completo                                                                                                                        ");
        System.out.println(" (5) ➔ Meu prontuario");
        System.out.println(" (6) ➔ Visualizar meu perfil");
        System.out.println(" (7) ➔ Buscar medico por especialidade");
        System.out.println(" (8) ➔ Editar meu perfil");
        System.out.println(" (9) ➔ Ver mapa                                                                                                                                      ");
        System.out.println(" (0) ➔ Voltar para menu principal                                                                                                                                      ");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite a opção desejada: ");
        return Ferramentas.lInteiro();

    }


    @Override
    public void mostrarTitulo(String titulo) {

    }

    @Override
    public void mostrarMensagemErro(String mensagem) {

    }

    @Override
    public void mostrarMensagemSucesso(String mensagem) {

    }

    @Override
    public void mostrarMensagemInfo(String mensagem) {

    }

    @Override
    public void mostrarListaConsultas(List<ConsultaModel> consultas) {

    }

    @Override
    public void mostrarDetalhesConsulta(List<ConsultaModel> consultas) {

    }

    @Override
    public void mostrarProntuario(List<ConsultaModel> historico) {

    }

    @Override
    public void mostrarHistoricoConsultas(ConsultaModel consulta) {

    }

    @Override
    public void mostrarAgenda(List<ConsultaModel> consultas) {

    }

    @Override
    public void mostrarListaMedicos(List<MedicoModel> medicos) {

    }

    @Override
    public String lerCpf() {
        return "";
    }

    @Override
    public int lerIdConsulta() {
        return 0;
    }

    @Override
    public String lerData() {
        return "";
    }

    @Override
    public String lerDescricaoAgendamento() {
        return "";
    }

    @Override
    public String lerEspecialidade() {
        return "";
    }

    @Override
    public String lerNomeMedico() {
        return "";
    }

    @Override
    public String lerSenha() {
        return "";
    }

    @Override
    public String lerEmail() {
        return "";
    }

    @Override
    public String lerTelefone() {
        return "";
    }

    @Override
    public String lerEndereco() {
        return "";
    }

    @Override
    public int selecionarMedico(List<MedicoModel> medicos) {
        return 0;
    }

    @Override
    public String selecionarHorario(List<String> horarios) {
        return "";
    }

    @Override
    public void lerDadosAtualizacaoPaciente(PacienteModel paciente) {

    }

    @Override
    public boolean perguntarAcao(String pergunta) {
        return false;
    }
}
