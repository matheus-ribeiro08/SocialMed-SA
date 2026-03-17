package org.example.view.paciente;

import org.example.model.HospitalModel;
import org.example.model.MedicoModel;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfacePaciente.IPacienteAgendarConsulta;

import java.time.LocalDate;
import java.util.List;

public class AgendarConsultaView implements IPacienteAgendarConsulta {

    @Override
    public String pedirEspecialidade() {
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("  ███╗   ███╗███████╗███╗   ██╗██╗   ██╗   █████╗  ██████╗ ███████╗███╗   ██╗██████╗  █████╗ ██████╗    ██████╗  ██████╗ ███╗   ██╗███████╗███╗   ██╗██╗  ████████╗ █████╗   ");
        System.out.println("  ████╗ ████║██╔════╝████╗  ██║██║   ██║  ██╔══██╗██╔════╝ ██╔════╝████╗  ██║██╔══██╗██╔══██╗██╔══██╗  ██╔════╝ ██╔═══██╗████╗  ██║██╔════╝╚██║   ██║██║  ╚══██╔══╝██╔══██╗  ");
        System.out.println("  ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║  ███████║██║  ███╗█████╗  ██╔██╗ ██║██║  ██║███████║██████╔╝  ██║      ██║   ██║██╔██╗ ██║███████╗ ██║   ██║██║     ██║   ███████║  ");
        System.out.println("  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║  ██╔══██║██║   ██║██╔══╝  ██║╚██╗██║██║  ██║██╔══██║██╔══██╗  ██║      ██║   ██║██║╚██╗██║╚════██║ ██║   ██║██║     ██║   ██╔══██║  ");
        System.out.println("  ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝  ██║  ██║╚██████╔╝███████╗██║ ╚████║██████╔╝██║  ██║██║  ██║  ╚██████╗╗╚██████╔╝██║ ╚████║███████║ ╚██████╔╝███████ ██║   ██║  ██║  ");
        System.out.println("  ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝   ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═════╝╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝  ╚═════╝ ╚══════ ╚═╝   ╚═╝  ╚═╝  ");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("Digite a especialidade desejada: ");
        return Ferramentas.lString();
    }

    @Override
    public String pedirData() {
        System.out.print("Digite a data (DD/MM/AAAA): ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirHora(){
        System.out.print("Digite a hora (HH:MM): ");

        return Ferramentas.lString();
    }

    @Override
    public void mostrarMedicosDisponiveis(List<MedicoModel> medicos) {
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("                 ███╗   ███╗███████╗██████╗ ██╗ ██████╗  ██████╗ ███████╗     ██████╗ ██╗███████╗██████╗  ██████╗ ███╗   ██╗██╗██╗   ██╗███████╗██╗███████╗                  ");
        System.out.println("                 ████╗ ████║██╔════╝██╔══██╗██║██╔════╝ ██╔═══██╗██╔════╝     ██╔══██╗██║██╔════╝██╔══██╗██╔═══██╗████╗  ██║██║██║   ██║██╔════╝██║██╔════╝                  ");
        System.out.println("                 ██╔████╔██║█████╗  ██║  ██║██║██║      ██║   ██║███████╗     ██║  ██║██║███████╗██████╔╝██║   ██║██╔██╗ ██║██║██║   ██║█████╗  ██║███████╗                  ");
        System.out.println("                 ██║╚██╔╝██║██╔══╝  ██║  ██║██║██║      ██║   ██║╚════██║     ██║  ██║██║╚════██║██╔═══╝ ██║   ██║██║╚██╗██║██║╚██╗ ██╔╝██╔══╝  ██║╚════██║                  ");
        System.out.println("                 ██║ ╚═╝ ██║███████╗██████╔╝██║╚██████╗╗╚██████╔╝███████║     ██████╔╝██║███████║██║     ╚██████╔╝██║ ╚████║██║ ╚████╔╝ ███████╗██║███████║                  ");
        System.out.println("                 ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝ ╚═════╝╝ ╚═════╝ ╚══════╝     ╚═════╝ ╚═╝╚══════╝╚═╝      ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═══╝  ╚══════╝╚═╝╚══════╝                  ");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        if(medicos.isEmpty()){
            System.out.println("Nenhum medico disponivel");
            return;
        }

        for (MedicoModel m : medicos){
            System.out.printf("ID: %d - Dr(a). %s%n", m.getIdMedico(), m.getNomeUsuario());
            System.out.printf("   Especialidade: %s%n%n", m.getEspecialidadeMedico());
        }

    }

    @Override
    public int selecionarMedico() {
        System.out.println("Digite o ID do médico desejado: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public boolean confirmarAgendamento() {
        System.out.print("Confirmar agendamento? (1 - Sim / 2 - Não): ");
        return Ferramentas.lInteiro() == 1;
    }

    @Override
    public void mostrarOpcoesHospitais(List<HospitalModel> hospitais) {
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("              ██╗  ██╗ ██████╗ ███████╗██████╗ ██╗████████╗ █████╗ ██╗███████╗  ██████╗ ██╗███████╗██████╗  ██████╗ ███╗   ██╗██╗██╗   ██╗███████╗██╗███████╗                ");
        System.out.println("              ██║  ██║██╔═══██╗██╔════╝██╔══██╗██║╚══██╔══╝██╔══██╗██║██╔════╝  ██╔══██╗██║██╔════╝██╔══██╗██╔═══██╗████╗  ██║██║██║   ██║██╔════╝██║██╔════╝                ");
        System.out.println("              ███████║██║   ██║███████╗██████╔╝██║   ██║   ███████║██║███████╗  ██║  ██║██║███████╗██████╔╝██║   ██║██╔██╗ ██║██║██║   ██║█████╗  ██║███████╗                ");
        System.out.println("              ██╔══██║██║   ██║╚════██║██╔═══╝ ██║   ██║   ██╔══██║██║╚════██║  ██║  ██║██║╚════██║██╔═══╝ ██║   ██║██║╚██╗██║██║╚██╗ ██╔╝██╔══╝  ██║╚════██║                ");
        System.out.println("              ██║  ██║╚██████╔╝███████║██║     ██║   ██║   ██║  ██║██║███████║  ██████╔╝██║███████║██║     ╚██████╔╝██║ ╚████║██║ ╚████╔╝ ███████╗██║███████║                ");
        System.out.println("              ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝   ╚═╝   ╚═╝  ╚═╝╚═╝╚══════╝  ╚═════╝ ╚═╝╚══════╝╚═╝      ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═══╝  ╚══════╝╚═╝╚══════╝                ");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

        if(hospitais.isEmpty()){
            System.out.println("Nenhum hospitais disponiveis");
            return;
        }

        for(HospitalModel h : hospitais) {
            System.out.printf("Id: %d - %s%n" + h.getIdHospital() + h.getNomeHospital());
            System.out.printf("    Endereço: %s%n", h.getEnderecoHospital());
        }

    }

    @Override
    public int selecionarHospital(){
        System.out.println("Digite o ID do hospital desejado: ");

        return Ferramentas.lInteiro();
    }

}
