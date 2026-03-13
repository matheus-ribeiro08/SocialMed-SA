package org.example.presenter;

import org.example.dao.MedicoDAO;
import org.example.model.ConsultaModel;
import org.example.model.MedicoModel;
import org.example.view.IMedicoView;

import java.awt.*;

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
            case 1 -> visualizarConsultas();


            case 2 -> cancelarConsultas();


            case 3 -> sairMedico();

            default -> System.err.println("Opção invalida!!!!!");
             }
        }while (op != 3);
    }

    private void sairMedico() {


    }

    private void cancelarConsultas() {



    }

    public List<ConsultaModel> visualizarConsultasPorMedico(int idMedico)
    {

    }
}
