package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsultaModel {

    private long idConsulta;
    private LocalDateTime horarioConsulta;

    public ConsultaModel(long idConsulta, LocalDateTime horarioConsulta) {
        this.idConsulta = idConsulta;
        this.horarioConsulta = horarioConsulta;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public LocalDateTime getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(LocalDateTime horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }
}
