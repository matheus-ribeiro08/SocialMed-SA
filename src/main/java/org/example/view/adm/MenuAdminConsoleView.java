package org.example.view.adm;

import org.example.enums.TipoUsuario;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;
import org.example.model.UsuarioModel;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceAdm.IMenuAdminView;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class MenuAdminConsoleView implements IMenuAdminView {

    @Override
    public int mostrarMenuPrincipal(String nomeAdmin) {

        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"    ███╗   ███╗███████╗███╗   ██╗██╗   ██╗     █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗██╗███████╗████████╗██████╗  █████╗ ██████╗  ██████╗ ██████╗     ");
        System.out.println("    ████╗ ████║██╔════╝████╗  ██║██║   ██║    ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║██║██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔══██╗    ");
        System.out.println("    ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║██║███████╗   ██║   ██████╔╝███████║██║  ██║██║   ██║██████╔╝    ");
        System.out.println("    ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║██║╚════██║   ██║   ██╔══██╗██╔══██║██║  ██║██║   ██║██╔══██╗    ");
        System.out.println("    ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║██║███████║   ██║   ██║  ██║██║  ██║██████╔╝╚██████╔╝██║  ██║    ");
        System.out.println("    ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝    ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" OPÇÕES                                                                                                                                                ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" (1) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Gerenciar Usuarios                                                                                                                              ");
        System.out.println(Ferramentas.RESET+" (2) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Gerenciar Medicos                                                                                                                               ");
        System.out.println(Ferramentas.RESET+" (3) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Gerenciar Pacientes                                                                                                                             ");
        System.out.println(Ferramentas.RESET+" (4) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Visualizar perfil                                                                                                                               ");
        System.out.println(Ferramentas.RESET+" (5) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Fechar sistema                                                                                                                                  ");
        System.out.println(Ferramentas.RESET+" (6) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Voltar para menu inicial                                                                                                                        ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a opção desejada: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public int mostrarMenuGerenciadoUsuarios() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"      ██████╗ ███████╗██████╗ ███████╗███╗   ██╗ ██████╗██╗ █████╗ ██████╗         ██╗   ██╗███████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗ ███████╗      ");
        System.out.println("     ██╔════╝ ██╔════╝██╔══██╗██╔════╝████╗  ██║██╔════╝██║██╔══██╗██╔══██╗        ██║   ██║██╔════╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗██╔════╝      ");
        System.out.println("     ██║  ███╗█████╗  ██████╔╝█████╗  ██╔██╗ ██║██║     ██║███████║██████╔╝        ██║   ██║███████╗██║   ██║███████║██████╔╝██║██║   ██║███████╗      ");
        System.out.println("     ██║   ██║██╔══╝  ██╔══██╗██╔══╝  ██║╚██╗██║██║     ██║██╔══██║██╔══██╗        ██║   ██║╚════██║██║   ██║██╔══██║██╔══██╗██║██║   ██║╚════██║      ");
        System.out.println("     ╚██████╔╝███████╗██║  ██║███████╗██║ ╚████║╚██████╗██║██║  ██║██║  ██║        ╚██████╔╝███████║╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝███████║      ");
        System.out.println("      ╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝╚═╝╚═╝  ╚═╝╚═╝  ╚═╝         ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝ ╚══════╝      ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" OPÇÕES                                                                                                                                                ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" (1) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Listar todos os usuarios                                                                                                                        ");
        System.out.println(Ferramentas.RESET+" (2) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Buscar usuario por CPF                                                                                                                          ");
        System.out.println(Ferramentas.RESET+" (3) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Criar novo usuario                                                                                                                              ");
        System.out.println(Ferramentas.RESET+" (4) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Editar Usuario                                                                                                                                  ");
        System.out.println(Ferramentas.RESET+" (0) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Voltar                                                                                                                                          ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(Ferramentas.YELLOW+" ➤"+Ferramentas.RESET+" Digite a opção desejada: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public String lerCpf() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite o CPF (11 numeros): ");
        return Ferramentas.lString().trim();
    }

    @Override
    public boolean perguntarAcao(String mensagem) {
        System.out.println(mensagem + "(S/N): ");
        String resposta = Ferramentas.lString().trim().toUpperCase();
        return resposta.equalsIgnoreCase(("S")) || resposta.equalsIgnoreCase("Sim");
    }

    @Override
    public TipoUsuario selecionarTipoUsuario() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Tipos de usuario: ");
        System.out.println("(1) ➔ Médico");
        System.out.println("(2) ➔ Secretário");
        System.out.printf(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a opção desejada: ");

        int opcao = Ferramentas.lInteiro();

        switch (opcao){
            case 1: return TipoUsuario.MEDICO;
            case 2:return  TipoUsuario.SECRETARIO;
            default:return null;
        }
    }

    @Override
    public void lerDadosNovoMedico(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                           ███╗   ██╗ ██████╗ ██╗   ██╗ ██████╗    ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗                                      ");
        System.out.println("                           ████╗  ██║██╔═══██╗██║   ██║██╔═══██╗   ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗                                     ");
        System.out.println("                           ██╔██╗ ██║██║   ██║██║   ██║██║   ██║   ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║                                     ");
        System.out.println("                           ██║╚██╗██║██║   ██║╚██╗ ██╔╝██║   ██║   ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║                                     ");
        System.out.println("                           ██║ ╚████║╚██████╔╝ ╚████╔╝ ╚██████╔╝   ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝                                     ");
        System.out.println("                           ╚═╝  ╚═══╝ ╚═════╝   ╚═══╝   ╚═════╝    ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝                                      ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public String lerEspecialidade(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite a especialidade: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public void lerDadosNovoSecretario() {

        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                      ███╗   ██╗ ██████╗ ██╗   ██╗ ██████╗   ███████╗███████╗ ██████╗██████╗ ███████╗████████╗ █████╗ ██╗ ██████╗                      ");
        System.out.println("                      ████╗  ██║██╔═══██╗██║   ██║██╔═══██╗  ██╔════╝██╔════╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██║██╔═══██╗                     ");
        System.out.println("                      ██╔██╗ ██║██║   ██║██║   ██║██║   ██║  ███████╗█████╗  ██║     ██████╔╝█████╗     ██║   ███████║██║██║   ██║                     ");
        System.out.println("                      ██║╚██╗██║██║   ██║╚██╗ ██╔╝██║   ██║  ╚════██║██╔══╝  ██║     ██╔══██╗██╔══╝     ██║   ██╔══██║██║██║   ██║                     ");
        System.out.println("                      ██║ ╚████║╚██████╔╝ ╚████╔╝ ╚██████╔╝  ███████║███████╗╚██████╗██║  ██║███████╗   ██║   ██║  ██║██║╚██████╔╝                     ");
        System.out.println("                      ╚═╝  ╚═══╝ ╚═════╝   ╚═══╝   ╚═════╝   ╚══════╝╚══════╝ ╚═════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝ ╚═════╝                      ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);

    }

    @Override
    public String lerTurno() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite o turno: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEndereco() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite o endereço: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerTelefone() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite o telefone: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerSenha(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite a senha: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEmail() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite o email: ");

        return Ferramentas.lString().trim();
    }

    @Override
    public String lerNomeCompleto() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite o nome: ");

        return Ferramentas.lString();
    }

    @Override
    public int lerId(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+"Digite o Id: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public int mostrarMenuDetalheMedico(MedicoModel medico){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"          ██████╗ ███████╗██████╗ ███████╗███╗   ██╗ ██████╗██╗ █████╗ ██████╗         ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗ ███████╗         ");
        System.out.println("         ██╔════╝ ██╔════╝██╔══██╗██╔════╝████╗  ██║██╔════╝██║██╔══██╗██╔══██╗        ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗██╔════╝         ");
        System.out.println("         ██║  ███╗█████╗  ██████╔╝█████╗  ██╔██╗ ██║██║     ██║███████║██████╔╝        ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║███████╗         ");
        System.out.println("         ██║   ██║██╔══╝  ██╔══██╗██╔══╝  ██║╚██╗██║██║     ██║██╔══██║██╔══██╗        ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║╚════██║         ");
        System.out.println("         ╚██████╔╝███████╗██║  ██║███████╗██║ ╚████║╚██████╗██║██║  ██║██║  ██║        ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝███████║         ");
        System.out.println("          ╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝╚═╝╚═╝  ╚═╝╚═╝  ╚═╝        ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝         ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" OPÇÕES                                                                                                                                                ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" (1) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Ver Agenda do Medico                                                                                                                            ");
        System.out.println(Ferramentas.RESET+" (2) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Ver historico medico                                                                                                                            ");
        System.out.println(Ferramentas.RESET+" (3) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Editar Medico                                                                                                                                   ");
        System.out.println(Ferramentas.RESET+" (4) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Remover Medico                                                                                                                                  ");
        System.out.println(Ferramentas.RESET+" (0) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Voltar                                                                                                                                          ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.printf(Ferramentas.YELLOW+" ➤"+ Ferramentas.YELLOW+" Digite a opção desejada: ");

        return Ferramentas.lInteiro();

    }

    @Override
    public int mostrarMenuDetalhePaciente(PacienteModel paciente){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"       ██████╗ ███████╗██████╗ ███████╗███╗   ██╗ ██████╗██╗ █████╗ ██████╗         ██████╗  █████╗  ██████╗██╗███████╗███╗   ██╗████████╗███████╗     ");
        System.out.println("      ██╔════╝ ██╔════╝██╔══██╗██╔════╝████╗  ██║██╔════╝██║██╔══██╗██╔══██╗        ██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝     ");
        System.out.println("      ██║  ███╗█████╗  ██████╔╝█████╗  ██╔██╗ ██║██║     ██║███████║██████╔╝        ██████╔╝███████║██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗       ");
        System.out.println("      ██║   ██║██╔══╝  ██╔══██╗██╔══╝  ██║╚██╗██║██║     ██║██╔══██║██╔══██╗        ██╔═══╝ ██╔══██║██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝       ");
        System.out.println("      ╚██████╔╝███████╗██║  ██║███████╗██║ ╚████║╚██████╗██║██║  ██║██║  ██║        ██║     ██║  ██║╚██████╗██║███████╗██║ ╚████║   ██║   ███████╗     ");
        System.out.println("       ╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝╚═╝╚═╝  ╚═╝╚═╝  ╚═╝        ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝     ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" OPÇÕES                                                                                                                                                ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" (1) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Ver Agenda do Paciente                                                                                                                          ");
        System.out.println(Ferramentas.RESET+" (2) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Ver historico Paciente                                                                                                                          ");
        System.out.println(Ferramentas.RESET+" (3) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Editar Paciente                                                                                                                                 ");
        System.out.println(Ferramentas.RESET+" (4) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Remover Paciente                                                                                                                                ");
        System.out.println(Ferramentas.RESET+" (0) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Voltar                                                                                                                                          ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a opção desejada: ");

        return Ferramentas.lInteiro();

    }

    @Override
    public void lerDadosAtualizacaoUsuario(UsuarioModel usuario) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"             ██████╗  █████╗ ██████╗  ██████╗ ███████╗   █████╗ ████████╗██╗   ██╗ █████╗ ██╗     ██╗███████╗ █████╗  ██████╗ ███████╗                 ");
        System.out.println("             ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝  ██╔══██╗╚══██╔══╝██║   ██║██╔══██╗██║     ██║    ██╔╝██╔══██╗██╔═══██╗██╔════╝                 ");
        System.out.println("             ██║  ██║███████║██║  ██║██║   ██║███████╗  ███████║   ██║   ██║   ██║███████║██║     ██║   ██╔╝ ███████║██║   ██║███████╗                 ");
        System.out.println("             ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║  ██╔══██║   ██║   ██║   ██║██╔══██║██║     ██║  ██╔╝  ██╔══██║██║   ██║╚════██║                 ");
        System.out.println("             ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║  ██║  ██║   ██║   ╚██████╔╝██║  ██║███████╗██║███████╗██║  ██║╚██████╔╝███████║                 ");
        System.out.println("             ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝  ╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                 ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" DADOS");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"Id: " + usuario.getIdUsuario());
        System.out.println("Nome: " + usuario.getNomeUsuario());
        System.out.println("Telefone: " + usuario.getTelefoneUsuario());
        System.out.println("Cpf: " + usuario.getCpfUsuario());
        System.out.println("Email: " + usuario.getEmailUsuario());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void lerDadosAtualizacaoMedico(MedicoModel medico) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"             ██████╗  █████╗ ██████╗  ██████╗ ███████╗   █████╗ ████████╗██╗   ██╗ █████╗ ██╗     ██╗███████╗ █████╗  ██████╗ ███████╗                 ");
        System.out.println("             ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝  ██╔══██╗╚══██╔══╝██║   ██║██╔══██╗██║     ██║    ██╔╝██╔══██╗██╔═══██╗██╔════╝                 ");
        System.out.println("             ██║  ██║███████║██║  ██║██║   ██║███████╗  ███████║   ██║   ██║   ██║███████║██║     ██║   ██╔╝ ███████║██║   ██║███████╗                 ");
        System.out.println("             ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║  ██╔══██║   ██║   ██║   ██║██╔══██║██║     ██║  ██╔╝  ██╔══██║██║   ██║╚════██║                 ");
        System.out.println("             ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║  ██║  ██║   ██║   ╚██████╔╝██║  ██║███████╗██║███████╗██║  ██║╚██████╔╝███████║                 ");
        System.out.println("             ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝  ╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                 ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" DADOS");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"Id: " + medico.getIdMedico());
        System.out.println("Nome: " + medico.getNomeUsuario());
        System.out.println("Telefone: " + medico.getTelefoneUsuario());
        System.out.println("Cpf: " + medico.getCpfUsuario());
        System.out.println("Email: " + medico.getEmailUsuario());
        System.out.println("Especialidade: " + medico.getEspecialidadeMedico());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarTituloListaPacientes(){

        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                  ██╗     ██╗███████╗████████╗ █████╗     ██████╗  █████╗  ██████╗██╗███████╗███╗   ██╗████████╗███████╗███████╗                       ");
        System.out.println("                  ██║     ██║██╔════╝╚══██╔══╝██╔══██╗    ██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝██╔════╝                       ");
        System.out.println("                  ██║     ██║███████╗   ██║   ███████║    ██████╔╝███████║██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗  ███████╗                       ");
        System.out.println("                  ██║     ██║╚════██║   ██║   ██╔══██║    ██╔═══╝ ██╔══██║██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝  ╚════██║                       ");
        System.out.println("                  ███████╗██║███████║   ██║   ██║  ██║    ██║     ██║  ██║╚██████╗██║███████╗██║ ╚████║   ██║   ███████╗███████║                       ");
        System.out.println("                  ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝╚══════╝                       ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

    }

    @Override
    public void mostrarListaPacientes(PacienteModel paciente) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("Id: " + paciente.getIdUsuario());
        System.out.println("Nome: " + paciente.getNomeUsuario());
        System.out.println("Cpf: " + paciente.getCpfUsuario());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarTituloListaUsuarios(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                    ██╗     ██╗███████╗████████╗ █████╗   ██╗   ██╗███████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗ ███████╗                               ");
        System.out.println("                    ██║     ██║██╔════╝╚══██╔══╝██╔══██╗  ██║   ██║██╔════╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗██╔════╝                               ");
        System.out.println("                    ██║     ██║███████╗   ██║   ███████║  ██║   ██║███████╗██║   ██║███████║██████╔╝██║██║   ██║███████╗                               ");
        System.out.println("                    ██║     ██║╚════██║   ██║   ██╔══██║  ██║   ██║╚════██║██║   ██║██╔══██║██╔══██╗██║██║   ██║╚════██║                               ");
        System.out.println("                    ███████╗██║███████║   ██║   ██║  ██║  ╚██████╔╝███████║╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝███████║                               ");
        System.out.println("                    ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝ ╚══════╝                               ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);

    }

    @Override
    public void mostrarListaUsuarios(UsuarioModel usuario) {

        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("Id: " + usuario.getIdUsuario());
        System.out.println("Nome: " + usuario.getNomeUsuario());
        System.out.println("Cpf: " + usuario.getCpfUsuario());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarTituloListaMedicos(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                        ██╗     ██╗███████╗████████╗ █████╗    ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗ ███████╗                                 ");
        System.out.println("                        ██║     ██║██╔════╝╚══██╔══╝██╔══██╗   ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗██╔════╝                                 ");
        System.out.println("                        ██║     ██║███████╗   ██║   ███████║   ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║███████╗                                 ");
        System.out.println("                        ██║     ██║╚════██║   ██║   ██╔══██║   ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║╚════██║                                 ");
        System.out.println("                        ███████╗██║███████║   ██║   ██║  ██║   ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝███████║                                 ");
        System.out.println("                        ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝                                 ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarListaMedicos(MedicoModel medico) {

        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("Id: " + medico.getIdMedico());
        System.out.println("Nome: " + medico.getNomeUsuario());
        System.out.println("Cpf: " + medico.getCpfUsuario());
        System.out.println("Especialidade: " + medico.getEspecialidadeMedico());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    public void mostrarTituloListaSecretarios(){
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                      ██╗     ██╗███████╗████████╗ █████╗     ███████╗███████╗ ██████╗██████╗ ███████╗████████╗ █████╗ ██╗ ██████╗                     ");
        System.out.println("                      ██║     ██║██╔════╝╚══██╔══╝██╔══██╗    ██╔════╝██╔════╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██║██╔═══██╗                    ");
        System.out.println("                      ██║     ██║███████╗   ██║   ███████║    ███████╗█████╗  ██║     ██████╔╝█████╗     ██║   ███████║██║██║   ██║                    ");
        System.out.println("                      ██║     ██║╚════██║   ██║   ██╔══██║    ╚════██║██╔══╝  ██║     ██╔══██╗██╔══╝     ██║   ██╔══██║██║██║   ██║                    ");
        System.out.println("                      ███████╗██║███████║   ██║   ██║  ██║    ███████║███████╗╚██████╗██║  ██║███████╗   ██║   ██║  ██║██║╚██████╔╝                    ");
        System.out.println("                      ╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝    ╚══════╝╚══════╝ ╚═════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝ ╚═════╝                     ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarListaSecretarios(SecretarioModel secretario) {

        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("Id: " + secretario.getIdUsuario());
        System.out.println("Nome: " + secretario.getNomeUsuario());
        System.out.println("Cpf: " + secretario.getCpfUsuario());
        System.out.println("Turno: " + secretario.getTurnoTrabalhadoSecretario());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarDadosUsuarioCompleto(UsuarioModel usuario) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                           ██████╗  █████╗ ██████╗  ██████╗ ███████╗ ██╗   ██╗███████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗                             ");
        System.out.println("                           ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝ ██║   ██║██╔════╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗                            ");
        System.out.println("                           ██║  ██║███████║██║  ██║██║   ██║███████╗ ██║   ██║███████╗██║   ██║███████║██████╔╝██║██║   ██║                            ");
        System.out.println("                           ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║ ██║   ██║╚════██║██║   ██║██╔══██║██╔══██╗██║██║   ██║                            ");
        System.out.println("                           ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║ ╚██████╔╝███████║╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝                            ");
        System.out.println("                           ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝  ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝                             ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println("Id: " + usuario.getIdUsuario());
        System.out.println("Nome: " + usuario.getNomeUsuario());
        System.out.println("Telefone: " + usuario.getTelefoneUsuario());
        System.out.println("Senha: " + usuario.getSenhaUsuario());
        System.out.println("Cpf: " + usuario.getCpfUsuario());
        System.out.println("Email: " + usuario.getEmailUsuario());
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public int selecionarMedico() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"            ███████╗███████╗██╗     ███████╗ ██████╗██╗ ██████╗ ███╗   ██╗ █████╗ ██████╗   ███╗   ███╗███████╗██████╗ ██╗ ██████╗ ██████╗             ");
        System.out.println("            ██╔════╝██╔════╝██║     ██╔════╝██╔════╝██║██╔═══██╗████╗  ██║██╔══██╗██╔══██╗  ████╗ ████║██╔════╝██╔══██╗██║██╔════╝██╔═══██╗            ");
        System.out.println("            ███████╗█████╗  ██║     █████╗  ██║     ██║██║   ██║██╔██╗ ██║███████║██████╔╝  ██╔████╔██║█████╗  ██║  ██║██║██║     ██║   ██║            ");
        System.out.println("            ╚════██║██╔══╝  ██║     ██╔══╝  ██║     ██║██║   ██║██║╚██╗██║██╔══██║██╔══██╗  ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║     ██║   ██║            ");
        System.out.println("            ███████║███████╗███████╗███████╗╚██████╗██║╚██████╔╝██║ ╚████║██║  ██║██║  ██║  ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╚██████╔╝            ");
        System.out.println("            ╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝  ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝ ╚═════╝             ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+Ferramentas.RESET);

        System.out.println("Digite o id do medico desejado: ");
        return Ferramentas.lInteiro();
    }

    @Override
    public void mostrarTitulo(String titulo) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(titulo);
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
    }

    @Override
    public void mostrarMensagemSucesso(String mensagem) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(mensagem);
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public void mostrarMensagemErro(String mensagem) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(mensagem);
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public void mostrarMensagemInfo(String mensagem) {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(mensagem);
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}
