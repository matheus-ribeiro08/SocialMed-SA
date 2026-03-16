package org.example.viewInterface.viewInterfacePaciente;

import org.example.model.ConsultaModel;
import org.example.service.ConsultaService;

import java.util.List;

public interface IPacienteViewHistoricoConsultas {

    void mostrarHistoricoConsulta(List<ConsultaModel> consultas);

}
