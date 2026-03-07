package org.example.presenter;

import org.example.model.MedicoModel;
import org.example.view.IMedicoView;

public class MedicoPresenter {

    private IMedicoView view;
    private MedicoModel model;

    public MedicoPresenter(MedicoModel model,IMedicoView view)
    {
        this.model = model;
        this.view = view;
    }

    public void iniciar()
    {
        int op;

        do {

            op = view.mostrarMenuMedico();

        switch (op) {
            case 1: {
                visualizarConsultas();
                break;
            }

            case 2: {
                cancelarConsultas();
                break;
            }

            case 3: {
                sairMedico();
                break;
            }

            default: {
                System.err.println("Opção invalida!!!!!");
            }
        }
        }while (op != 3);
    }

    private void sairMedico() {



    }

    private void cancelarConsultas() {



    }

    private void visualizarConsultas() {


    }
}
