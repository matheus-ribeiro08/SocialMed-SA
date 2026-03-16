package org.example.viewInterface.viewInterfaceMedico;

import org.example.model.MedicoModel;

import java.util.List;

public interface IMedicoDao {
    void salvar(MedicoModel medico);
    void atualizar(MedicoModel medico);
    void deletar(long idMedico);
    MedicoModel buscarPorId(long idMedico);
    List<MedicoModel> bucarPorEspecialidade(String especialidade);
}
