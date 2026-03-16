package org.example.view.paciente;

import org.example.model.PacienteModel;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfacePaciente.IPacienteAgendarConsulta;
import org.example.viewInterface.viewInterfacePaciente.IPacienteMenu;
import org.example.viewInterface.viewInterfacePaciente.IPacienteViewConsultas;

public class MenuPacienteView implements IPacienteMenu {

    private PacienteModel pacienteLogado;

    @Override
    public void setPacienteLogado(PacienteModel paciente){
        this.pacienteLogado = paciente;
    }

    @Override
    public int mostrarMenuPrincipal() {
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                       ███╗   ███╗███████╗███╗   ██╗██╗   ██╗   ██████╗  █████╗  ██████╗██╗███████╗███╗   ██╗████████╗███████╗                       │");
        System.out.println("│                       ████╗ ████║██╔════╝████╗  ██║██║   ██║   ██╔══██╗██╔══██╗██╔════╝██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝                       │");
        System.out.println("│                       ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║   ██████╔╝███████║██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗                         │");
        System.out.println("│                       ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║   ██╔═══╝ ██╔══██║██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝                         │");
        System.out.println("│                       ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝   ██║     ██║  ██║╚██████╗██║███████╗██║ ╚████║   ██║   ███████╗                       │");
        System.out.println("│                       ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝                       │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");

        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ OPÇÕES                                                                                                                                              │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ (1) ➔ Ver minhas consultas                                                                                                                          │");
        System.out.println("│ (2) ➔ Agendar nova consulta                                                                                                                         │");
        System.out.println("│ (3) ➔ Cancelar Consulta                                                                                                                             │");
        System.out.println("│ (4) ➔ Ver historico completo                                                                                                                        │");
        System.out.println("│ (5) ➔ Ver mapa                                                                                                                                      │");
        System.out.println("│ (0) ➔ Ver mapa                                                                                                                                      │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.print("│ ➤ Digite a opção desejada: ");

        return Ferramentas.lInteiro();

    }



}
