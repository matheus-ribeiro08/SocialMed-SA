package org.example.service.prontuario;

import org.example.dao.ProntuarioDAO;
import org.example.model.MedicoModel;
import org.example.model.ProntuarioModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProntuarioService
{
    private final ProntuarioDAO prontuarioDAO;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public ProntuarioService() {
        this.prontuarioDAO = new ProntuarioDAO();
    }

    public ProntuarioService(ProntuarioDAO prontuarioDAO)
    {
        this.prontuarioDAO = prontuarioDAO;
    }

    public List<ProntuarioModel> buscarPorPaciente(int idPaciente)
    {
        if(idPaciente <= 0)
        {
            throw new IllegalArgumentException("ID do paciente inválido");
        }

        try {
            return prontuarioDAO.listarProntuarios(idPaciente);
        } catch (Exception e)
        {
            throw new RuntimeException("Erro ao buscar prontuarios ");
        }
    }

    public ProntuarioModel buscarPorConsulta(int idConsulta)
    {
        if(idConsulta <= 0)
        {
            throw  new IllegalArgumentException("ID consulta inválido");
        }
        try {
            return prontuarioDAO.buscarPorConsulta(idConsulta);
        } catch (Exception e)
        {
            throw new RuntimeException("Erro ao buscar Prontuario por Consulta");
        }
    }

    public boolean criar(ProntuarioModel prontuarioModel)
    {
        if(prontuarioModel == null)
        {
            throw new IllegalArgumentException("Prontuario nao pode ser nulo");
        }
        validarProntuario(prontuarioModel);

        if(prontuarioModel.getDataRegistro() == null)
        {
            prontuarioModel.setDataRegistro(LocalDateTime.now());
        }
        try {
            return prontuarioDAO.cadastrarProntuario(prontuarioModel);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar prontuario");
        }
    }

    public boolean atualzar(ProntuarioModel prontuarioModel)
    {
        if(prontuarioModel == null || prontuarioModel.getIdProntuario() <= 0){
            throw new IllegalArgumentException("Prontuario Invalido");
    }
           validarProntuario(prontuarioModel);

        try {
            return prontuarioDAO.atualizarProntuario(prontuarioModel);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar prontuario");
        }
    }

    public void adicionarInformacao(ProntuarioModel prontuarioModel, String novaInformacao, MedicoModel medico)
    {
        if(prontuarioModel == null)
        {
            throw new IllegalArgumentException("Prontuario nao pode ser nulo");
        }
        if(novaInformacao == null || novaInformacao.trim().isEmpty())
        {
            throw new IllegalArgumentException("Informacoes nao pode ser vazia");
        }
        if (medico == null)
        {
            throw new IllegalArgumentException("Medico nao pode ser nulo");
        }
        try {
            String timestamp = LocalDateTime.now().format(DATE_TIME_FORMATTER);
            String informacoesCompleta = String.format("[%s] Dr(a). %s: %s",
                    timestamp,
                    medico.getNomeUsuario(),
                    novaInformacao
            );

            ProntuarioModel novoProntuario = new ProntuarioModel();
            novoProntuario.setIdPaciente(prontuarioModel.getIdPaciente());
            novoProntuario.setIdMedico(medico.getIdMedico());
            novoProntuario.setIdConsulta(prontuarioModel.getIdConsulta());
            novoProntuario.setDiagnostico(prontuarioModel.getDiagnostico());
            novoProntuario.setSintomas((prontuarioModel.getSintomas()));
            novoProntuario.setPrescricaoMedica(prontuarioModel.getPrescricaoMedica());

            String observacoesAtuais = prontuarioModel.getObservacoes();
            String novasObservacoes;
            if(observacoesAtuais == null || observacoesAtuais.isEmpty())
            {
                novasObservacoes = informacoesCompleta;
            } else{
                novasObservacoes = observacoesAtuais + "\n\n" + informacoesCompleta;
            }
            novoProntuario.setObservacoes(novasObservacoes);
            novoProntuario.setDataRegistro(LocalDateTime.now());

            criar(novoProntuario);
        } catch (Exception e)
        {
            throw new RuntimeException("Erro ao adicionar informação ao prontuario");
        }
    }

    public List<ProntuarioModel> listarTodos()
    {
        try{
            return prontuarioDAO.listarTodosProntuarios();
        } catch (Exception e)
        {
            throw new RuntimeException("Erro ao listar prontuarios");
        }
    }


    private void validarProntuario(ProntuarioModel prontuario) {
        if (prontuario.getIdPaciente() <= 0) {
            throw new IllegalArgumentException("ID do paciente é obrigatório");
        }

        if (prontuario.getIdMedico() <= 0) {
            throw new IllegalArgumentException("ID do médico é obrigatório");
        }

        if (prontuario.getDiagnostico() == null || prontuario.getDiagnostico().trim().isEmpty()) {
            throw new IllegalArgumentException("Diagnóstico é obrigatório");
        }

        if (prontuario.getSintomas() == null || prontuario.getSintomas().trim().isEmpty()) {
            throw new IllegalArgumentException("Sintomas são obrigatórios");
        }
    }

}
