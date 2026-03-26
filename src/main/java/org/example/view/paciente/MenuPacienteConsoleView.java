package org.example.view.paciente;

import org.example.model.*;
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
        System.out.println(Ferramentas.GREENclaro+"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                       ███╗   ███╗███████╗███╗   ██╗██╗   ██╗   ██████╗  █████╗  ██████╗██╗███████╗███╗   ██╗████████╗███████╗                       ");
        System.out.println("                       ████╗ ████║██╔════╝████╗  ██║██║   ██║   ██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝                       ");
        System.out.println("                       ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║   ██████╔╝███████║██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗                         ");
        System.out.println("                       ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║   ██╔═══╝ ██╔══██║██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝                         ");
        System.out.println("                       ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝   ██║     ██║  ██║╚██████╗██║███████╗██║ ╚████║   ██║   ███████╗                       ");
        System.out.println("                       ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝                       ");
        System.out.println(Ferramentas.GREENclaro+"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" OPÇÕES                                                                                                                                              ");
        System.out.println(Ferramentas.GREENclaro+"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" (1)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Ver minhas consultas                                                                                                                          ");
        System.out.println(Ferramentas.RESET+" (2)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Agendar nova consulta                                                                                                                         ");
        System.out.println(Ferramentas.RESET+" (3)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Cancelar Consulta                                                                                                                             ");
        System.out.println(Ferramentas.RESET+" (4)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Ver historico completo                                                                                                                        ");
        System.out.println(Ferramentas.RESET+" (5)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Meu prontuario");
        System.out.println(Ferramentas.RESET+" (6)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Visualizar meu perfil");
        System.out.println(Ferramentas.RESET+" (7)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Buscar medico por especialidade");
        System.out.println(Ferramentas.RESET+" (8)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Editar meu perfil");
        System.out.println(Ferramentas.RESET+" (9)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Ver mapa                                                                                                                                      ");
        System.out.println(Ferramentas.RESET+" (0)"+ Ferramentas.GREENescuro +"➔"+ Ferramentas.RESET+" Voltar para menu principal                                                                                                                                      ");
        System.out.println(Ferramentas.GREENclaro+"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a opção desejada: ");
        return Ferramentas.lInteiro();

    }

    @Override
    public void mostrarTituloListaHospital(){
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                       ██╗     ██╗███████╗████████╗ █████╗    ██╗  ██╗ ██████╗ ███████╗██████╗ ██╗████████╗ █████╗ ██╗███████╗                       ");
        System.out.println("                       ██║     ██║██╔════╝╚══██╔══╝██╔══██╗   ██║  ██║██╔═══██╗██╔════╝██╔══██╗██║╚══██╔══╝██╔══██╗██║██╔════╝                       ");
        System.out.println("                       ██║     ██║███████╗   ██║   ███████║   ███████║██║   ██║███████╗██████╔╝██║   ██║   ███████║██║███████╗                       ");
        System.out.println("                       ██║     ██║╚════██║   ██║   ██╔══██║   ██║  ██║██║   ██║╚════██║██╔═══╝ ██║   ██║   ██╔══██║██║╚════██║                       ");
        System.out.println("                       ███████╗██║███████║   ██║   ██║  ██║   ██║  ██║╚██████╔╝███████║██║     ██║   ██║   ██║  ██║██║███████║                       ");
        System.out.println("                       ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝   ╚═╝   ╚═╝  ╚═╝╚═╝╚══════╝                       ");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public void listarHospitais(HospitalModel hospital){
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Id: " + hospital.getIdHospital());
        System.out.println("Nome: " + hospital.getNomeHospital());
        System.out.println("Endereço: " + hospital.getEnderecoHospital());
        System.out.println("Quantidade de pessoas: " + hospital.getQuantPessoasHospital());
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public int selecionarHospital(){
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print("Digite o id do hospital desejado: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public void abrirMapaLocalizacao(){
        System.out.println("\n🗺️ Abrindo mapa de localização das clínicas...");
        System.out.println(Ferramentas.GREENclaro+"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);

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
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+Ferramentas.RESET);
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
    public void mostrarTituloLista(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("                      ██╗     ██╗███████╗████████╗ █████╗      ██████╗ ██████╗ ███╗   ██╗███████╗██╗   ██╗██╗  ████████╗ █████╗ ███████╗                   ");
        System.out.println("                      ██║     ██║██╔════╝╚══██╔══╝██╔══██╗    ██╔════╝██╔═══██╗████╗  ██║██╔════╝██║   ██║██║  ╚══██╔══╝██╔══██╗██╔════╝                   ");
        System.out.println("                      ██║     ██║███████╗   ██║   ███████║    ██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     ██║   ███████║███████╗                   ");
        System.out.println("                      ██║     ██║╚════██║   ██║   ██╔══██║    ██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██║   ██╔══██║╚════██║                   ");
        System.out.println("                      ███████╗██║███████║   ██║   ██║  ██║    ╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗██║   ██║  ██║███████║                   ");
        System.out.println("                      ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝     ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚══════╝                   ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarListaConsultas(ConsultaModel consulta) {

        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+Ferramentas.RESET);
        System.out.println("Id: " + consulta.getIdConsulta());
        System.out.println("Paciente: " + consulta.getIdPaciente());
        System.out.println("Medico: " + consulta.getIdMedico());
        System.out.println("Horario: " + consulta.getHorarioConsulta());
        System.out.println("Endereço: " + consulta.getLocalEndereco());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+Ferramentas.RESET);
    }

    @Override
    public void mostrarDadosPaciente(PacienteModel paciente){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("                      ██████╗  █████╗ ██████╗  ██████╗ ███████╗    ██████╗  █████╗  ██████╗██╗███████╗███╗   ██╗████████╗███████╗                      ");
        System.out.println("                      ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝    ██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝                      ");
        System.out.println("                      ██║  ██║███████║██║  ██║██║   ██║███████╗    ██████╔╝███████║██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗                        ");
        System.out.println("                      ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║    ██╔═══╝ ██╔══██║██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝                        ");
        System.out.println("                      ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║    ██║     ██║  ██║╚██████╗██║███████╗██║ ╚████║   ██║   ███████╗                      ");
        System.out.println("                      ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝                      ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("Id: " + paciente.getIdPaciente());
        System.out.println("Nome: " + paciente.getNomeUsuario());
        System.out.println("Telefone: " + paciente.getTelefoneUsuario());
        System.out.println("Cpf: " + paciente.getCpfUsuario());
        System.out.println("Endereço: " + paciente.getEnderecoPaciente());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarDetalhesConsulta(ConsultaModel consulta) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("                ██████╗  █████╗ ██████╗  ██████╗ ███████╗     ██████╗ ██████╗ ███╗   ██╗███████╗██╗   ██╗██╗  ████████╗ █████╗ ███████╗                ");
        System.out.println("                ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝    ██╔════╝██╔═══██╗████╗  ██║██╔════╝██║   ██║██║  ╚══██╔══╝██╔══██╗██╔════╝                ");
        System.out.println("                ██║  ██║███████║██║  ██║██║   ██║███████╗    ██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     ██║   ███████║███████╗                ");
        System.out.println("                ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║    ██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██║   ██╔══██║╚════██║                ");
        System.out.println("                ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║    ╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗██║   ██║  ██║███████║                ");
        System.out.println("                ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝     ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚══════╝                ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);

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
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("                  ███╗   ███╗███████╗██╗   ██╗    ██████╗ ██████╗  ██████╗ ███╗   ██╗████████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗                     ");
        System.out.println("                  ████╗ ████║██╔════╝██║   ██║    ██╔══██╗██╔══██╗██╔═══██╗████╗  ██║╚══██╔══╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗                    ");
        System.out.println("                  ██╔████╔██║█████╗  ██║   ██║    ██████╔╝██████╔╝██║   ██║██╔██╗ ██║   ██║   ██║   ██║███████║██████╔╝██║██║   ██║                    ");
        System.out.println("                  ██║╚██╔╝██║██╔══╝  ██║   ██║    ██╔═══╝ ██╔══██╗██║   ██║██║╚██╗██║   ██║   ██║   ██║██╔══██║██╔══██╗██║██║   ██║                    ");
        System.out.println("                  ██║ ╚═╝ ██║███████╗╚██████╔╝    ██║     ██║  ██║╚██████╔╝██║ ╚████║   ██║   ╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝                    ");
        System.out.println("                  ╚═╝     ╚═╝╚══════╝ ╚═════╝     ╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝                     ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("Id: " + prontuario.getIdProntuario());
        System.out.println("Medico: " + prontuario.getIdMedico());
        System.out.println("Paciente: " + prontuario.getIdPaciente());
        System.out.println("Diagnostico: " + prontuario.getDiagnostico());
        System.out.println("Consulta: " + prontuario.getIdConsulta());
        System.out.println("Observações: " + prontuario.getObservacoes());
        System.out.println("Prescrição medica: " + prontuario.getPrescricaoMedica());
        System.out.println("Data: " + prontuario.getDataRegistro());
        System.out.println("Sintomas: " + prontuario.getSintomas());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);


    }

    @Override
    public void mostrarHistoricoConsultas(ConsultaModel consulta) {

    }

    @Override
    public void mostrarTituloAgenda(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                             ███╗   ███╗██╗███╗   ██╗██╗  ██╗ █████╗      █████╗  ██████╗ ███████╗███╗   ██╗██████╗  █████╗                            ");
        System.out.println("                             ████╗ ████║██║████╗  ██║██║  ██║██╔══██╗    ██╔══██╗██╔════╝ ██╔════╝████╗  ██║██╔══██╗██╔══██╗                           ");
        System.out.println("                             ██╔████╔██║██║██╔██╗ ██║███████║███████║    ███████║██║  ███╗█████╗  ██╔██╗ ██║██║  ██║███████║                           ");
        System.out.println("                             ██║╚██╔╝██║██║██║╚██╗██║██╔══██║██╔══██║    ██╔══██║██║   ██║██╔══╝  ██║╚██╗██║██║  ██║██╔══██║                           ");
        System.out.println("                             ██║ ╚═╝ ██║██║██║ ╚████║██║  ██║██║  ██║    ██║  ██║╚██████╔╝███████╗██║ ╚████║██████╔╝██║  ██║                           ");
        System.out.println("                             ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝    ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝                           ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarAgenda(ConsultaModel consulta) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"Data: " + consulta.getHorarioConsulta());
        System.out.println("Medico(a): " + consulta.getIdMedico());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarTituloListaMedicos(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                           ██╗     ██╗███████╗████████╗ █████╗     ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗ ███████╗                             ");
        System.out.println("                           ██║     ██║██╔════╝╚══██╔══╝██╔══██╗    ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗██╔════╝                             ");
        System.out.println("                           ██║     ██║███████╗   ██║   ███████║    ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║███████╗                             ");
        System.out.println("                           ██║     ██║╚════██║   ██║   ██╔══██║    ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║╚════██║                             ");
        System.out.println("                           ███████╗██║███████║   ██║   ██║  ██║    ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝███████║                             ");
        System.out.println("                           ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝    ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝                             ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public void mostrarListaMedicos(MedicoModel medico) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("Id: " + medico.getIdUsuario());
        System.out.println("Nome: " + medico.getNomeUsuario());
        System.out.println("Tipo: " + medico.getTipoUsuario());
        System.out.println("Cpf: " + medico.getCpfUsuario());
        System.out.println("Especialidade: " + medico.getEspecialidadeMedico());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }


    @Override
    public String lerCpf() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o cpf: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public int lerIdConsulta() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o id da consulta: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public String lerData(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a data (dd/MM/yyyy): ");

        return Ferramentas.lString().trim();
    }


    @Override
    public String lerNomeCompleto() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o seu nome: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerDescricaoAgendamento() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a descricao de agendamento: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEspecialidade() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a especilidade desejada: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerNomeMedico() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o nome do medico: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerSenha() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a senha: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEmail() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o email: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerTelefone() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o telefone: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEndereco() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a data: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public int selecionarMedico() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"        ███████╗███████╗██╗     ███████╗ ██████╗██╗ ██████╗ ███╗   ██╗ █████╗ ██████╗   ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗ ███████╗        ");
        System.out.println("        ██╔════╝██╔════╝██║     ██╔════╝██╔════╝██║██╔═══██╗████╗  ██║██╔══██╗██╔══██╗  ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗██╔════╝        ");
        System.out.println("        ███████╗█████╗  ██║     █████╗  ██║     ██║██║   ██║██╔██╗ ██║███████║██████╔╝  ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║███████╗        ");
        System.out.println("        ╚════██║██╔══╝  ██║     ██╔══╝  ██║     ██║██║   ██║██║╚██╗██║██╔══██║██╔══██╗  ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║╚════██║        ");
        System.out.println("        ███████║███████╗███████╗███████╗╚██████╗██║╚██████╔╝██║ ╚████║██║  ██║██║  ██║  ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝███████║        ");
        System.out.println("        ╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝  ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝        ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);

        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o id do medico desejado: ");
        return Ferramentas.lInteiro();
    }

    @Override
    public void lerDadosAtualizacaoPaciente(PacienteModel paciente) {

    }

    @Override
    public boolean perguntarAcao(String mensagem) {
        System.out.println(mensagem + "(S/N): ");
        String resposta = Ferramentas.lString().trim().toUpperCase();
        return resposta.equalsIgnoreCase(("S")) || resposta.equalsIgnoreCase("Sim");
    }

    @Override
    public String lerHorario(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o horario desejado da consulta: ");

        return Ferramentas.lString();
    }
}
