package org.example.view;

import org.example.model.ConsultaModel;
import org.example.viewInterface.viewInterfacePaciente.IPacienteViewConsultas;

import java.util.List;

public class PacienteConsultasView implements IPacienteViewConsultas {


    @Override
    public void exibirConsultas(List<ConsultaModel> consultas) {

        System.out.println("");


    }

    @Override
    public void abrirTelaDetalheConsulta(ConsultaModel consulta) {

    }


}
