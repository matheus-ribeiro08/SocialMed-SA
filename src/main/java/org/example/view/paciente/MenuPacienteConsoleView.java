package org.example.view.paciente;

import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.ProntuarioModel;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfacePaciente.IMenuPacienteView;

import java.awt.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MenuPacienteConsoleView implements IMenuPacienteView {
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
    public void abrirMapaLocalizacao(){
        System.out.println("\n🗺️ Abrindo mapa de localização das clínicas...");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        try {
            String caminhoMapa = "src/main/resources/mapa.html";
            File arquivoMapa = new File(caminhoMapa);

            if(!arquivoMapa.exists()) {
                caminhoMapa = "mapa.html";
                arquivoMapa = new File(caminhoMapa);
            }

            if (arquivoMapa.exists()) {
                Desktop.getDesktop().browse(arquivoMapa.toURI());
                System.out.println("Mapa aberto no navegador");
                System.out.println("Feche o navegador quando terminar de visualizar");
            } else {
                System.out.println("Arquivo do mapa nao encontrado");
            }

        }catch (Exception e){
            System.out.println("Erro ao abrir mapa");
            System.out.println("Verifique se o arquivo html esta no local correto");
        }

        System.out.println("\nPressionar ENTER para continuar");
        Ferramentas.lString();
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
    public void mostrarListaConsultas(List<ConsultaModel> consultas) {
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
    public void mostrarDadosPaciente(PacienteModel paciente){
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                      ██████╗  █████╗ ██████╗  ██████╗ ███████╗    ██████╗  █████╗  ██████╗██╗███████╗███╗   ██╗████████╗███████╗                      ");
        System.out.println("                      ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝    ██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝                      ");
        System.out.println("                      ██║  ██║███████║██║  ██║██║   ██║███████╗    ██████╔╝███████║██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗                        ");
        System.out.println("                      ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║    ██╔═══╝ ██╔══██║██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝                        ");
        System.out.println("                      ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║    ██║     ██║  ██║╚██████╗██║███████╗██║ ╚████║   ██║   ███████╗                      ");
        System.out.println("                      ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝                      ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Id: " + paciente.getIdPaciente());
        System.out.println("Nome: " + paciente.getNomeUsuario());
        System.out.println("Telefone: " + paciente.getTelefoneUsuario());
        System.out.println("Cpf: " + paciente.getCpfUsuario());
        System.out.println("Endereço: " + paciente.getEnderecoPaciente());
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public void mostrarDetalhesConsulta(ConsultaModel consulta) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                ██████╗  █████╗ ██████╗  ██████╗ ███████╗     ██████╗ ██████╗ ███╗   ██╗███████╗██╗   ██╗██╗  ████████╗ █████╗ ███████╗                ");
        System.out.println("                ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝    ██╔════╝██╔═══██╗████╗  ██║██╔════╝██║   ██║██║  ╚══██╔══╝██╔══██╗██╔════╝                ");
        System.out.println("                ██║  ██║███████║██║  ██║██║   ██║███████╗    ██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     ██║   ███████║███████╗                ");
        System.out.println("                ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║    ██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██║   ██╔══██║╚════██║                ");
        System.out.println("                ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║    ╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗██║   ██║  ██║███████║                ");
        System.out.println("                ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝     ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚══════╝                ");
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
    public void mostrarProntuario(ProntuarioModel prontuario) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                  ███╗   ███╗███████╗██╗   ██╗    ██████╗ ██████╗  ██████╗ ███╗   ██╗████████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗                     ");
        System.out.println("                  ████╗ ████║██╔════╝██║   ██║    ██╔══██╗██╔══██╗██╔═══██╗████╗  ██║╚══██╔══╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗                    ");
        System.out.println("                  ██╔████╔██║█████╗  ██║   ██║    ██████╔╝██████╔╝██║   ██║██╔██╗ ██║   ██║   ██║   ██║███████║██████╔╝██║██║   ██║                    ");
        System.out.println("                  ██║╚██╔╝██║██╔══╝  ██║   ██║    ██╔═══╝ ██╔══██╗██║   ██║██║╚██╗██║   ██║   ██║   ██║██╔══██║██╔══██╗██║██║   ██║                    ");
        System.out.println("                  ██║ ╚═╝ ██║███████╗╚██████╔╝    ██║     ██║  ██║╚██████╔╝██║ ╚████║   ██║   ╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝                    ");
        System.out.println("                  ╚═╝     ╚═╝╚══════╝ ╚═════╝     ╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝                     ");
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
    public void mostrarHistoricoConsultas(List<ConsultaModel> consultas) {

    }

    @Override
    public void mostrarAgenda(List<ConsultaModel> consultas) {
        if(consultas == null || consultas.isEmpty()){
            System.out.println("Nenhuma consulta marcada");
            return;
        }

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                             ███╗   ███╗██╗███╗   ██╗██╗  ██╗ █████╗      █████╗  ██████╗ ███████╗███╗   ██╗██████╗  █████╗                            ");
        System.out.println("                             ████╗ ████║██║████╗  ██║██║  ██║██╔══██╗    ██╔══██╗██╔════╝ ██╔════╝████╗  ██║██╔══██╗██╔══██╗                           ");
        System.out.println("                             ██╔████╔██║██║██╔██╗ ██║███████║███████║    ███████║██║  ███╗█████╗  ██╔██╗ ██║██║  ██║███████║                           ");
        System.out.println("                             ██║╚██╔╝██║██║██║╚██╗██║██╔══██║██╔══██║    ██╔══██║██║   ██║██╔══╝  ██║╚██╗██║██║  ██║██╔══██║                           ");
        System.out.println("                             ██║ ╚═╝ ██║██║██║ ╚████║██║  ██║██║  ██║    ██║  ██║╚██████╔╝███████╗██║ ╚████║██████╔╝██║  ██║                           ");
        System.out.println("                             ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝    ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝                           ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for(ConsultaModel consulta : consultas){
            System.out.println("Data: " + consulta.getHorarioConsulta());
            System.out.println("Medico(a): " + consulta.getIdMedico());
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
    }

    @Override
    public void mostrarListaMedicos(List<MedicoModel> medicos) {
        if(medicos == null || medicos.isEmpty()){
            System.out.println("Nenhum medico cadastrado");
            return;
        }
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                           ██╗     ██╗███████╗████████╗ █████╗     ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗ ███████╗                             ");
        System.out.println("                           ██║     ██║██╔════╝╚══██╔══╝██╔══██╗    ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗██╔════╝                             ");
        System.out.println("                           ██║     ██║███████╗   ██║   ███████║    ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║███████╗                             ");
        System.out.println("                           ██║     ██║╚════██║   ██║   ██╔══██║    ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║╚════██║                             ");
        System.out.println("                           ███████╗██║███████║   ██║   ██║  ██║    ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝███████║                             ");
        System.out.println("                           ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝    ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝                             ");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        for(MedicoModel medico : medicos){
            System.out.println("Id: " + medico.getIdUsuario());
            System.out.println("Nome: " + medico.getNomeUsuario());
            System.out.println("Tipo: " + medico.getTipoUsuario());
            System.out.println("Cpf: " + medico.getCpfUsuario());
            System.out.println("Especialidade: " + medico.getEspecialidadeMedico());
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        }
    }


    @Override
    public String lerCpf() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤igite o cpf: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public int lerIdConsulta() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite o id da consulta: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public String lerData() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite a data: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerNomeCompleto() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite o seu nome: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerDescricaoAgendamento() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite a descricao de agendamento: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEspecialidade() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite a especilidade desejada: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerNomeMedico() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite o nome do medico: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerSenha() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite a senha: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEmail() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite o email: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerTelefone() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite o telefone: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEndereco() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(" ➤ Digite a data: ");

        return Ferramentas.lString().trim();
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
