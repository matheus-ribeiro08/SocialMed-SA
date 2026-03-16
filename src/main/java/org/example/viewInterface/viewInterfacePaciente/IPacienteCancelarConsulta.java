package org.example.viewInterface.viewInterfacePaciente;

import org.example.model.ConsultaModel;

import java.util.List;

public interface IPacienteCancelarConsulta {

    void mostrarConsultasAtivas(List<ConsultaModel> consultas);
    int selecionarConsultaParaCancelar();
    boolean confirmarCancelamento();
    void mostrarCancelamentoSucesso();
    void mostrarErroDeCancelamento();

}
