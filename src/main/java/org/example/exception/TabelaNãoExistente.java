package org.example.exception;

import java.sql.SQLException;

public class TabelaNãoExistente extends SQLException {
    public TabelaNãoExistente(String message) {
        super(message);
    }
}
