package org.example.service.Exame;

import org.example.dao.ExameDAO;
import org.example.dao.MedicoDAO;
import org.example.dao.PacienteDAO;
import org.example.exception.ExameException;
import org.example.model.ExameModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;

import java.sql.SQLException;
import java.util.List;

public class ExameService {

    private final ExameDAO exameDAO;
    private final MedicoDAO medicoDAO;
    private final PacienteDAO pacienteDAO;

    public ExameService() {
        this.exameDAO = new ExameDAO();
        this.medicoDAO = new MedicoDAO();
        this.pacienteDAO = new PacienteDAO();
    }

    public ExameService(ExameDAO exameDAO, MedicoDAO medicoDAO, PacienteDAO pacienteDAO) {
        this.exameDAO = exameDAO;
        this.medicoDAO = medicoDAO;
        this.pacienteDAO = pacienteDAO;
    }

    public void solicitarExame(MedicoModel medico, PacienteModel paciente, String tipoExame, String observacoes) throws ExameException {
        validarMedico(medico);
        validarPaciente(paciente);
        validarTipoExame(tipoExame);

        ExameModel exame = new ExameModel();
        exame.setIdMedico(medico.getIdMedico());
        exame.setIdPaciente(paciente.getIdPaciente());
        exame.setTipoExame(tipoExame);
        exame.setObservacoes(observacoes);

        boolean cadastrado = exameDAO.cadastrar(exame);
        if (!cadastrado) {
            throw new ExameException("Erro ao cadastrar exame");
        }
    }

    public List<ExameModel> listarExamesPorPaciente(int idPaciente) throws ExameException {
        if (idPaciente <= 0) {
            throw new ExameException("Id do paciente invalido");
        }

        return exameDAO.listarPorPaciente(idPaciente);
    }

    public List<ExameModel> listarExamesPorMedico(int idMedico) throws ExameException {
        if (idMedico <= 0) {
            throw new ExameException("Id do medico invalido");
        }

        return exameDAO.listarPorMedico(idMedico);
    }

    public List<ExameModel> listarExamesPendentes() throws ExameException {
        return exameDAO.listarExamesPendentes();
    }

    public ExameModel buscarExamePorId(int idExame) throws ExameException {
        if (idExame <= 0) {
            throw new ExameException("Id do exame invalido");
        }
        ExameModel exame = exameDAO.buscarPorId(idExame);
        if (exame == null) {
            throw new ExameException("Exame nao encontrado");
        }

        return exame;
    }

    public boolean cancelarExame(int idExame) throws ExameException {
        if (idExame <= 0) {
            throw new ExameException("Id do exame invalido");
        }
        ExameModel exame = buscarExamePorId(idExame);
        if (!"SOLICITADO".equals(exame.getStatus())) {
            throw new ExameException("Exame nao pode ser cancelado pois ja foi " + exame.getStatus().toLowerCase());
        }
        return exameDAO.cancelarExame(idExame);
    }

    public boolean atualizarStatusExame(int idExame, String novoStatus) throws ExameException {
        if (idExame <= 0) {
            throw new ExameException("Id do exame invalido");
        }
        if (novoStatus == null || novoStatus.trim().isEmpty()) {
            throw new ExameException("Status nao informado");
        }
        if (!novoStatus.equals("SOLICITADO") && !novoStatus.equals("REALIZADO") && !novoStatus.equals("CANCELADO")) {
            throw new ExameException("Status invalido: " + novoStatus);
        }
        return exameDAO.atualizarStatus(idExame, novoStatus);
    }

    public boolean realizarExame(int idExame) throws ExameException {
        return atualizarStatusExame(idExame, "REALIZADO");
    }

    private void validarMedico(MedicoModel medico) throws ExameException {
        if (medico == null) {
            throw new ExameException("Medico nao autenticado");
        }
        if (medico.getIdMedico() <= 0) {
            throw new ExameException("Id do medico invalido");
        }
        try {
            MedicoModel medicoExistente = medicoDAO.buscarPorId(medico.getIdMedico());
            if (medicoExistente == null) {
                throw new ExameException("Medico nao encontrado no sistema");
            }
        }catch (SQLException e) {
            throw new ExameException("Erro ao validar medico:");

        }
    }

    private void validarPaciente(PacienteModel paciente) throws ExameException {
        if (paciente == null) {
            throw new ExameException("Paciente não autenticado");
        }
        if (paciente.getIdPaciente() <= 0) {
            throw new ExameException("ID do paciente inválido");
        }
        try {
            PacienteModel pacienteExistente = pacienteDAO.buscarPorId(paciente.getIdPaciente());
            if (pacienteExistente == null) {
                throw new ExameException("Paciente não encontrado no sistema");
            }
        } catch (SQLException e) {
            throw new ExameException("Erro ao validar paciente: " + e.getMessage(), e);
        }
    }

    private void validarTipoExame(String tipoExame) throws ExameException{
        if(tipoExame == null || tipoExame.trim().isEmpty()){
            throw new ExameException("Tipo de exame nao informado");
        }
    }


}
