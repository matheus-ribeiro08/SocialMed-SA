package org.example.view.medico;

import org.example.model.*;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceMedico.IMenuMedicoView;

import java.util.List;

public class MenuMedicoConsoleView implements IMenuMedicoView {

    @Override
    public int mostrarMenuPrincipal(String nome){
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                                ███╗   ███╗███████╗███╗   ██╗██╗   ██╗    ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗                               ");
        System.out.println("                                ████╗ ████║██╔════╝████╗  ██║██║   ██║    ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗                              ");
        System.out.println("                                ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║                              ");
        System.out.println("                                ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║                              ");
        System.out.println("                                ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝                              ");
        System.out.println("                                ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝                               ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" OPÇÕES                                                                                                                                                ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" (1) ➔ mostrar Lista Consultas Detalhadas                                                                                                              ");
        System.out.println(" (2) ➔ mostrar Historico Consulta                                                                                                                      ");
        System.out.println(" (3) ➔ mostrar Historico Atendimentos                                                                                                                  ");
        System.out.println(" (4) ➔ mostrar Dados Consulta Completa                                                                                                                 ");
        System.out.println(" (5) ➔ mostrar Dados Pacientes Completo                                                                                                                ");
        System.out.println(" (6) ➔ ver Perfil                                                                                                                                      ");
        System.out.println(" (7) ➔ Ver Prontuario                                                                                                                                  ");
        System.out.println(" (8) ➔ lerDadosAtualizacaoMedico                                                                                                                       ");
        System.out.println(" (0) ➔ Voltar para menu inicial                                                                                                                        ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite a opção desejada: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public void mostrarTitulo(String titulo) {
        System.out.println("\n" + titulo);
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public void mostrarMensagemSucesso(String mensagem) {
        System.out.println("\n" + mensagem);
    }

    @Override
    public void mostrarMensagemErro(String mensagem){
        System.out.println("\n" + mensagem);
    }

    @Override
    public void mostrarMensagemInfo(String mensagem) {
        System.out.println("\n" + mensagem);
    }

    @Override
    public void mostrarListaConsultasDetalhadas(List<ConsultaModel> consultas) {
        if(consultas == null || consultas.isEmpty()){
            System.out.println("Nenhuma consulta marcada");
            return;
        }

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                      ██╗     ██╗███████╗████████╗ █████╗      ██████╗ ██████╗ ███╗   ██╗███████╗██╗   ██╗██╗  ████████╗ █████╗ ███████╗                   ");
        System.out.println("                      ██║     ██║██╔════╝╚══██╔══╝██╔══██╗    ██╔════╝██╔═══██╗████╗  ██║██╔════╝██║   ██║██║  ╚══██╔══╝██╔══██╗██╔════╝                   ");
        System.out.println("                      ██║     ██║███████╗   ██║   ███████║    ██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     ██║   ███████║███████╗                   ");
        System.out.println("                      ██║     ██║╚════██║   ██║   ██╔══██║    ██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██║   ██╔══██║╚════██║                   ");
        System.out.println("                      ███████╗██║███████║   ██║   ██║  ██║    ╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗██║   ██║  ██║███████║                   ");
        System.out.println("                      ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝     ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚══════╝                   ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for(ConsultaModel consulta : consultas){
            System.out.println("Id: " + consulta.getIdConsulta());
            System.out.println("Paciente: " + consulta.getIdPaciente());
            System.out.println("Medico: " + consulta.getIdMedico());
            System.out.println("Horario: " + consulta.getHorarioConsulta());
            System.out.println("Endereço: " + consulta.getLocalEndereco());
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
    }

    @Override
    public void mostrarHistoricoConsultas(List<ConsultaModel> consultas) {

    }

    @Override
    public void mostrarHistoricoAtendimentos(List<ConsultaModel> historico) {

    }

    @Override
    public void mostrarDadosConsultaCompleta(ConsultaModel consulta) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                     ██████╗  █████╗ ██████╗  ██████╗ ███████╗     ██████╗ ██████╗ ███╗   ██╗███████╗██╗   ██╗██╗  ████████╗ █████╗                    ");
        System.out.println("                     ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝    ██╔════╝██╔═══██╗████╗  ██║██╔════╝██║   ██║██║  ╚══██╔══╝██╔══██╗                   ");
        System.out.println("                     ██║  ██║███████║██║  ██║██║   ██║███████╗    ██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     ██║   ███████║                   ");
        System.out.println("                     ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║    ██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██║   ██╔══██║                   ");
        System.out.println("                     ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║    ╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗██║   ██║  ██║                   ");
        System.out.println("                     ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝     ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝                   ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Id: " + consulta.getIdConsulta());
        System.out.println("Paciente: " + consulta.getIdPaciente());
        System.out.println("Medico: " + consulta.getIdMedico());
        System.out.println("Horario: " + consulta.getHorarioConsulta());
        System.out.println("Endereço: " + consulta.getLocalEndereco());
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

    }

    @Override
    public void mostrarDadosPacienteCompleto(PacienteModel paciente) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                           ██████╗  █████╗ ██████╗  ██████╗ ███████╗   ██████╗  █████╗  ██████╗██╗███████╗███╗   ██╗████████╗███████╗                            ");
        System.out.println("                           ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝   ██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝                            ");
        System.out.println("                           ██║  ██║███████║██║  ██║██║   ██║███████╗   ██████╔╝███████║██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗                              ");
        System.out.println("                           ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║   ██╔═══╝ ██╔══██║██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝                              ");
        System.out.println("                           ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║   ██║     ██║  ██║╚██████╗██║███████╗██║ ╚████║   ██║   ███████╗                            ");
        System.out.println("                           ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝   ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝                            ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Id: " + paciente.getIdUsuario());
        System.out.println("Nome: " + paciente.getNomeUsuario());
        System.out.println("Telefone: " + paciente.getTelefoneUsuario());
        System.out.println("Cpf: " + paciente.getCpfUsuario());
        System.out.println("Email: " + paciente.getEmailUsuario());
        System.out.println("Endereço: " + paciente.getEnderecoPaciente());
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

    }

    @Override
    public void mostrarDadosMedico(MedicoModel medico) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                         ██████╗  █████╗ ██████╗  ██████╗ ███████╗  ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗ ███████╗                            ");
        System.out.println("                         ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝  ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗██╔════╝                            ");
        System.out.println("                         ██║  ██║███████║██║  ██║██║   ██║███████╗  ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║███████╗                            ");
        System.out.println("                         ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║  ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║╚════██║                            ");
        System.out.println("                         ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║  ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝███████║                            ");
        System.out.println("                         ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝  ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝                            ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Id: " + medico.getIdUsuario());
        System.out.println("Nome: " + medico.getNomeUsuario());
        System.out.println("Telefone: " + medico.getTelefoneUsuario());
        System.out.println("Cpf: " + medico.getCpfUsuario());
        System.out.println("Email: " + medico.getEmailUsuario());
        System.out.println("Especialidade: " + medico.getEspecialidadeMedico());
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public void mostrarProntuario(ProntuarioModel prontuario) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("             ██████╗  █████╗ ██████╗  ██████╗ ███████╗   ██████╗ ██████╗  ██████╗ ███╗   ██╗████████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗              ");
        System.out.println("             ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝   ██╔══██╗██╔══██╗██╔═══██╗████╗  ██║╚══██╔══╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗             ");
        System.out.println("             ██║  ██║███████║██║  ██║██║   ██║███████╗   ██████╔╝██████╔╝██║   ██║██╔██╗ ██║   ██║   ██║   ██║███████║██████╔╝██║██║   ██║             ");
        System.out.println("             ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║   ██╔═══╝ ██╔══██╗██║   ██║██║╚██╗██║   ██║   ██║   ██║██╔══██║██╔══██╗██║██║   ██║             ");
        System.out.println("             ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║   ██║     ██║  ██║╚██████╔╝██║ ╚████║   ██║   ╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝             ");
        System.out.println("             ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝   ╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝              ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Id: " + prontuario.getIdProntuario());
        System.out.println("Medico: " + prontuario.getIdMedico());
        System.out.println("Paciente: " + prontuario.getIdPaciente());
        System.out.println("Diagnostico: " + prontuario.getDiagnostico());
        System.out.println("Consulta: " + prontuario.getIdConsulta());
        System.out.println("Observações: " + prontuario.getObservacoes());
        System.out.println("Prescrição medica: " + prontuario.getPrescricaoMedica());
        System.out.println("Data: " + prontuario.getDataRegistro());
        System.out.println("Sintomas: " + prontuario.getSintomas());
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public String lerTelefone() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite o telefone: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerSenha(){
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" ➤ Digite a senha: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEmail() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite o email: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerNomeCompleto() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite o nome");

        return Ferramentas.lString();
    }

    @Override
    public String lerEspecialidade() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" ➤ Digite a especilidade: ");

        return Ferramentas.lString();
    }


    @Override
    public int lerIdConsulta() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite o id da consulta: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public String lerDiagnostico() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite o diagnostico: ");

        return Ferramentas.lString();
    }

    @Override
    public String lerPrescricao() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite a prescricao: ");

        return Ferramentas.lString();
    }

    @Override
    public String lerObservacoes() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite as observações: ");

        return Ferramentas.lString();
    }

    @Override
    public String lerCpf() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite o cpf: ");

        return Ferramentas.lString();
    }

    @Override
    public String lerInformacoesIniciais() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite as informações iniciais: ");

        return Ferramentas.lString();
    }

    @Override
    public String lerInformacaoAdicional() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite as informações adicionais: ");

        return Ferramentas.lString();
    }

    @Override
    public int lerIdMedico() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite o id do medico desejado: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public String lerTipoExame() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite o tipo de exame: ");

        return Ferramentas.lString();
    }

    @Override
    public void lerDadosAtualizacaoMedico(MedicoModel medico) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("             ██████╗  █████╗ ██████╗  ██████╗ ███████╗   █████╗ ████████╗██╗   ██╗ █████╗ ██╗     ██╗███████╗ █████╗  ██████╗ ███████╗                 ");
        System.out.println("             ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝  ██╔══██╗╚══██╔══╝██║   ██║██╔══██╗██║     ██║    ██╔╝██╔══██╗██╔═══██╗██╔════╝                 ");
        System.out.println("             ██║  ██║███████║██║  ██║██║   ██║███████╗  ███████║   ██║   ██║   ██║███████║██║     ██║   ██╔╝ ███████║██║   ██║███████╗                 ");
        System.out.println("             ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║  ██╔══██║   ██║   ██║   ██║██╔══██║██║     ██║  ██╔╝  ██╔══██║██║   ██║╚════██║                 ");
        System.out.println("             ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║  ██║  ██║   ██║   ╚██████╔╝██║  ██║███████╗██║███████╗██║  ██║╚██████╔╝███████║                 ");
        System.out.println("             ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝  ╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                 ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Id: " + medico.getIdUsuario());
        System.out.println("Nome: " + medico.getNomeUsuario());
        System.out.println("Telefone: " + medico.getTelefoneUsuario());
        System.out.println("Cpf: " + medico.getCpfUsuario());
        System.out.println("Email: " + medico.getEmailUsuario());
        System.out.println("Especialidade: " + medico.getEspecialidadeMedico());
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public boolean perguntarAcao(String mensagem) {
        System.out.println(mensagem + "(S/N): ");
        String resposta = Ferramentas.lString().trim().toUpperCase();
        return resposta.equalsIgnoreCase(("S")) || resposta.equalsIgnoreCase("Sim");
    }

    @Override
    public String lerData(){

    }

    @Override
    public String lerSintomas(){
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" ➤ Digite os sintomas: ");

        return Ferramentas.lString();
    }
}


