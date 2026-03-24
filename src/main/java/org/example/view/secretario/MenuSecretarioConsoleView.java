package org.example.view.secretario;

import org.example.model.*;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceSecretario.IMenuSecretarioView;

import java.util.List;

public class MenuSecretarioConsoleView implements IMenuSecretarioView {

    private static final String DIVISOR = "───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    @Override
    public int mostrarMenuPrincipal(String nomeSecretario) {
        System.out.println(DIVISOR);
        System.out.println("    ███████╗███████╗ ██████╗██████╗ ███████╗████████╗ █████╗ ██████╗ ██╗ ██████╗     ██████╗ █████╗ ██████╗ ██╗   ██╗██╗   ██╗███████╗██╗   ██╗ ");
        System.out.println("    ██╔════╝██╔════╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║██╔═══██╗    ██╔══██╗██╔══██╗██╔══██╗╚██╗ ██╔╝██║   ██║██╔════╝╚██╗ ██╔╝ ");
        System.out.println("    ███████╗█████╗  ██║     ██████╔╝█████╗     ██║   ███████║██████╔╝██║██║   ██║    ██████╔╝███████║██████╔╝ ╚████╔╝ ██║   ██║█████╗   ╚████╔╝  ");
        System.out.println("    ╚════██║██╔══╝  ██║     ██╔══██╗██╔══╝     ██║   ██╔══██║██╔══██╗██║██║   ██║    ██╔══██╗██╔══██║██╔══██╗  ╚██╔╝  ╚██╗ ██╔╝██╔══╝   ╚██╔╝   ");
        System.out.println("    ███████║███████╗╚██████╗██║  ██║███████╗   ██║   ██║  ██║██║  ██║██║╚██████╔╝    ██║  ██║██║  ██║██║  ██║   ██║    ╚████╔╝ ███████╗   ██║    ");
        System.out.println("    ╚══════╝╚══════╝ ╚═════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝     ╚═══╝  ╚══════╝   ╚═╝    ");
        System.out.println(DIVISOR + "\n");
        System.out.println(DIVISOR);
        System.out.println(" OPÇÕES                                                                                                                                                 ");
        System.out.println(DIVISOR);
        System.out.println(" (1) ➔ Cadastrar Paciente");
        System.out.println(" (2) ➔ Buscar Paciente");
        System.out.println(" (3) ➔ Listar Pacientes");
        System.out.println(" (4) ➔ Atualizar Paciente");
        System.out.println(" (5) ➔ Remover Paciente");
        System.out.println(" (6) ➔ Agendar Consulta");
        System.out.println(" (7) ➔ Cancelar Consulta");
        System.out.println(" (8) ➔ Reagendar Consulta");
        System.out.println(" (9) ➔ Listar Todas Consultas");
        System.out.println("(10) ➔ Listar Consultas por Paciente");
        System.out.println("(11) ➔ Listar Consultas por Médico");
        System.out.println("(12) ➔ Listar Médicos");
        System.out.println("(13) ➔ Editar Perfil");
        System.out.println(" (0) ➔ Voltar para menu inicial");
        System.out.println(DIVISOR);
        System.out.print(" ➤ Digite a opção desejada: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public void mostrarTitulo(String titulo) {
        System.out.println("\n" + titulo);
        System.out.println(DIVISOR);
    }

    @Override
    public void mostrarMensagemSucesso(String mensagem) {
        System.out.println("\n✅ " + mensagem);
    }

    @Override
    public void mostrarMensagemErro(String mensagem) {
        System.err.println("\n❌ " + mensagem);
    }

    @Override
    public void mostrarMensagemInfo(String mensagem) {
        System.out.println("\nℹ️ " + mensagem);
    }

    @Override
    public void mostrarListaPacientes(PacienteModel paciente) {

        System.out.println(DIVISOR);
            System.out.println("ID: " + paciente.getIdPaciente() + " | Nome: " + paciente.getNomeUsuario() +
                    " | CPF: " + paciente.getCpfUsuario() + " | Telefone: " + paciente.getTelefoneUsuario());
        System.out.println(DIVISOR);
    }

    @Override
    public void mostrarListaMedicos(MedicoModel medico) {

        System.out.println(DIVISOR);
            System.out.println("ID: " + medico.getIdMedico() + " | Nome: " + medico.getNomeUsuario() +
                    " | Especialidade: " + medico.getEspecialidadeMedico() + " | Telefone: " + medico.getTelefoneUsuario());
    }

    @Override
    public void mostrarListaConsultas(ConsultaModel consulta) {


        System.out.println(DIVISOR);
            System.out.println("ID: " + consulta.getIdConsulta() + " | Paciente: " + consulta.getIdPaciente() +
                    " | Médico: " + consulta.getIdMedico() + " | Data/Hora: " + consulta.getHorarioConsulta() +
                    " | Local: " + consulta.getLocalEndereco());
            System.out.println(DIVISOR);

    }

    @Override
    public void mostrarListaHospitais(HospitalModel hospital) {

        System.out.println(DIVISOR);
            System.out.println("ID: " + hospital.getIdHospital() + " | Nome: " + hospital.getNomeHospital() +
                    " | Endereço: " + hospital.getEnderecoHospital());
            System.out.println(DIVISOR);
    }

    @Override
    public void mostrarDadosPacienteCompleto(PacienteModel paciente) {
        System.out.println(DIVISOR);
        System.out.println("ID: " + paciente.getIdPaciente());
        System.out.println("Nome: " + paciente.getNomeUsuario());
        System.out.println("CPF: " + paciente.getCpfUsuario());
        System.out.println("Email: " + paciente.getEmailUsuario());
        System.out.println("Telefone: " + paciente.getTelefoneUsuario());
        System.out.println("Endereço: " + paciente.getEnderecoPaciente());
        System.out.println(DIVISOR);
    }

    @Override
    public void mostrarDadosMedicoCompleto(MedicoModel medico) {
        System.out.println(DIVISOR);
        System.out.println("ID Médico: " + medico.getIdMedico());
        System.out.println("ID Usuário: " + medico.getIdUsuario());
        System.out.println("Nome: " + medico.getNomeUsuario());
        System.out.println("CPF: " + medico.getCpfUsuario());
        System.out.println("Email: " + medico.getEmailUsuario());
        System.out.println("Telefone: " + medico.getTelefoneUsuario());
        System.out.println("Especialidade: " + medico.getEspecialidadeMedico());
        System.out.println(DIVISOR);
    }

    @Override
    public void mostrarDadosConsultaCompleta(ConsultaModel consulta) {
        System.out.println(DIVISOR);
        System.out.println("ID Consulta: " + consulta.getIdConsulta());
        System.out.println("Paciente: " + consulta.getIdPaciente());
        System.out.println("Médico: " + consulta.getIdMedico());
        System.out.println("Hospital: " + consulta.getIdHospital());
        System.out.println("Local: " + consulta.getLocalEndereco());
        System.out.println("Data/Hora: " + consulta.getHorarioConsulta());
        System.out.println(DIVISOR);
    }

    @Override
    public void mostrarDadosSecretario(SecretarioModel secretario) {
        System.out.println(DIVISOR);
        System.out.println("ID Secretário: " + secretario.getIdSecretario());
        System.out.println("ID Usuário: " + secretario.getIdUsuario());
        System.out.println("Nome: " + secretario.getNomeUsuario());
        System.out.println("CPF: " + secretario.getCpfUsuario());
        System.out.println("Email: " + secretario.getEmailUsuario());
        System.out.println("Telefone: " + secretario.getTelefoneUsuario());
        System.out.println("Turno: " + secretario.getTurnoTrabalhadoSecretario());
        System.out.println(DIVISOR);
    }

    @Override
    public String lerNomeCompleto() {
        System.out.print(" ➤ Digite o nome completo: ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerCpf() {
        System.out.print(" ➤ Digite o CPF (apenas números): ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEmail() {
        System.out.print(" ➤ Digite o email: ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerSenha() {
        System.out.print(" ➤ Digite a senha: ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerTelefone() {
        System.out.print(" ➤ Digite o telefone: ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEndereco() {
        System.out.print(" ➤ Digite o endereço: ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerDataNascimento() {
        System.out.print(" ➤ Digite a data de nascimento (dd/MM/yyyy): ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerData() {
        System.out.print(" ➤ Digite a data (dd/MM/yyyy): ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerHora() {
        System.out.print(" ➤ Digite a hora (HH:mm): ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerTurno() {
        System.out.print(" ➤ Digite o turno (Manhã/Tarde/Noite): ");
        return Ferramentas.lString().trim();
    }

    @Override
    public String lerEspecialidade() {
        System.out.print(" ➤ Digite a especialidade (opcional para filtro): ");
        return Ferramentas.lString().trim();
    }

    @Override
    public int lerIdPaciente() {
        System.out.print(" ➤ Digite o ID do paciente: ");
        return Ferramentas.lInteiro();
    }

    @Override
    public int lerIdMedico() {
        System.out.print(" ➤ Digite o ID do médico: ");
        return Ferramentas.lInteiro();
    }

    @Override
    public int lerIdConsulta() {
        System.out.print(" ➤ Digite o ID da consulta: ");
        return Ferramentas.lInteiro();
    }

    @Override
    public int lerIdHospital() {
        System.out.print(" ➤ Digite o ID do hospital: ");
        return Ferramentas.lInteiro();
    }

    @Override
    public int selecionarMedico(MedicoModel medico) {
        System.out.println(DIVISOR);
        mostrarListaMedicos(medico);
        System.out.print(" ➤ Escolha o ID do médico: ");
        return Ferramentas.lInteiro();
    }

    @Override
    public String selecionarHorario(String horario) {
        System.out.println("Horários disponíveis:");
        for (int i = 0; i < horarios.size(); i++) {
            System.out.println(" (" + (i + 1) + ") " + horarios.get(i));
        }
        System.out.print(" ➤ Escolha o horário (número): ");
        int escolha = Ferramentas.lInteiro();
        if (escolha >= 1 && escolha <= horarios.size()) {
            return horarios.get(escolha - 1);
        }
        return null;
    }

    @Override
    public void lerDadosAtualizacaoPaciente(PacienteModel paciente) {
        System.out.println(DIVISOR);
        System.out.println(" ➤ ATUALIZAÇÃO DE PACIENTE");
        System.out.println(DIVISOR);

        System.out.println("Dados atuais:");
        mostrarDadosPacienteCompleto(paciente);

        System.out.println("\nDigite os novos dados (ou pressione ENTER para manter o atual):");

        String nome = lerNomeCompleto();
        if (!nome.isEmpty()) paciente.setNomeUsuario(nome);

        String email = lerEmail();
        if (!email.isEmpty()) paciente.setEmailUsuario(email);

        String telefone = lerTelefone();
        if (!telefone.isEmpty()) paciente.setTelefoneUsuario(telefone);

        String endereco = lerEndereco();
        if (!endereco.isEmpty()) paciente.setEnderecoPaciente(endereco);
    }

    @Override
    public void lerDadosAtualizacaoSecretario(SecretarioModel secretario) {
        System.out.println(DIVISOR);
        System.out.println(" ➤ ATUALIZAÇÃO DE SECRETÁRIO");
        System.out.println(DIVISOR);

        System.out.println("Dados atuais:");
        mostrarDadosSecretario(secretario);

        System.out.println("\nDigite os novos dados (ou pressione ENTER para manter o atual):");

        String nome = lerNomeCompleto();
        if (!nome.isEmpty()) secretario.setNomeUsuario(nome);

        String email = lerEmail();
        if (!email.isEmpty()) secretario.setEmailUsuario(email);

        String telefone = lerTelefone();
        if (!telefone.isEmpty()) secretario.setTelefoneUsuario(telefone);

        String turno = lerTurno();
        if (!turno.isEmpty()) secretario.setTurnoTrabalhadoSecretario(turno);
    }

    @Override
    public boolean perguntarAcao(String mensagem) {
        System.out.print("\n❓ " + mensagem + " (S/N): ");
        String resposta = Ferramentas.lString().trim().toUpperCase();
        return resposta.equals("S") || resposta.equals("SIM");
    }
}
