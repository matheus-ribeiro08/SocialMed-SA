package org.example.viewInterface.viewInterfacePaciente;

import org.example.model.HospitalModel;
import org.example.model.MedicoModel;

import java.time.LocalDate;
import java.util.List;

public interface IPacienteAgendarConsulta {

    String pedirEspecialidade();
    String pedirData();
    String pedirHora();
    void mostrarMedicosDisponiveis(List<MedicoModel> medicos);
    int selecionarMedico();
    boolean confirmarAgendamento();
    int selecionarHospital();
    void mostrarOpcoesHospitais(List<HospitalModel> hospitais);

}
