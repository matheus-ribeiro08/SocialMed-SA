package org.example.service.hospital;

import org.example.dao.HospitalDAO;
import org.example.dao.MedicoDAO;
import org.example.exception.HospitalException;
import org.example.model.HospitalModel;
import org.example.model.MedicoModel;
import org.example.service.medico.MedicoService;

import java.sql.SQLException;
import java.util.List;

public class HospitalService {

    private final HospitalDAO hospitalDAO;
    private final MedicoDAO medicoDAO;

    public HospitalService(){
        this.hospitalDAO = new HospitalDAO();
        this.medicoDAO = new MedicoDAO();
    }

    public HospitalService(HospitalDAO hospitalDAO, MedicoDAO medicoDAO){
        this.hospitalDAO = hospitalDAO;
        this.medicoDAO = medicoDAO;
    }

    public List<HospitalModel> listarTodos() throws HospitalException {
        try {
            return hospitalDAO.listarHospitais();
        }catch (HospitalException e){
            throw new HospitalException("Erro ao listar hospitais");
        }
    }

    public HospitalModel buscarPorId(int idHospital) throws HospitalException {
        if (idHospital <= 0) {
            throw new HospitalException("ID do hospital inválido");
        }
        try {
            HospitalModel hospital = hospitalDAO.buscarPorId(idHospital);
            if (hospital == null) {
                throw new HospitalException("Hospital não encontrado com ID: " + idHospital);
            }
            return hospital;
        } catch (HospitalException e) {
            throw new HospitalException("Erro ao buscar hospital: " + e.getMessage(), e);
        }
    }

}
