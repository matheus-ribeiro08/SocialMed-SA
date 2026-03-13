package org.example.viewInterface.viewInterfacePaciente;

import org.example.model.ConsultaModel;

import java.util.List;

public interface IPacienteViewConsultas {
    void exibirConsultas(List<ConsultaModel> consultas);
    void abrirTelaDetalheConsulta(ConsultaModel consulta);


}
