package org.example.presenter;

import org.example.enums.TipoUsuario;
import org.example.model.PacienteModel;
import org.example.model.UsuarioModel;
import org.example.roteador.Roteador;
import org.example.utils.Ferramentas;
import org.example.view.paciente.MenuPacienteView;

public class MenuPacientePresenter {

    private Roteador roteador;
    private MenuPacienteView view;
    private PacienteModel paciente;

    public MenuPacientePresenter(Roteador roteador, PacienteModel paciente){
        this.roteador = roteador;
        this.paciente = paciente;
        this.view = new MenuPacienteView();

        if(paciente.getTipoUsuario() != TipoUsuario.PACIENTE){
            throw new IllegalStateException("Usuario não é do tipo Paciente");
        }

        this.view.setPacienteLogado(paciente);
    }

    public void inicar(){
        boolean executando = true;

        while (executando){
            int opcao = view.mostrarMenuPrincipal();

            switch (opcao){
                case 1:{
                    verConsultas();
                    break;
                }
                case 2:{
                    agendarConsulta();
                    break;
                }
                case 3: {
                    cancelarConsulta();
                    break;
                }
                case 4:{
                    verHistorico();
                    break;
                }
                case 5:{
                    verMapa();
                    break;
                }
                case 0:{
                    System.out.println("Voltando ao menu inicial...");
                    Ferramentas.Delay(1500);
                    executando = false;
                    roteador.irPara("menuInicial");
                    break;
                }
                default:{
                    System.out.println("Opção invalida");
                    Ferramentas.Delay(1500);
                }
            }
        }
    }
}

