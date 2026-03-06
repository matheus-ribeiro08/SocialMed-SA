package org.example.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Conexão com o Banco de Dados
    public static Connection getConnection ()
    {
        String url = "jdbc:mysql://avnadmin:AVNS_3ucIBTLub3-ZmTK9ixO@socialmed2026-theuzinx23-d156.i.aivencloud.com:19307/defaultdb?ssl-mode=REQUIRED";
        String user = "avnadmin";
        String senha = "AVNS_3ucIBTLub3-ZmTK9ixO";

        Connection conn = null;

        try
        {
            return conn = DriverManager.getConnection(url, user, senha);
        }
        catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco");
        }
        return conn;
    }
}