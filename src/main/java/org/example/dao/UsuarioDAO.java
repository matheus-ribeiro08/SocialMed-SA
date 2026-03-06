package org.example.dao;

import org.example.configuracao.ConnectionFactory;
import org.example.model.PacienteModel;
import org.example.model.UsuarioModel;

import java.sql.*;

public class UsuarioDAO
{
    public UsuarioModel login(String cpf, String senha)
    {
        String sql = "SELECT * FROM Usuario WHERE cpf_usuario = ? AND senha_usuario = ?";
        UsuarioModel usuarioModel = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, cpf);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    usuarioModel = new UsuarioModel(
                            rs.getInt("id_Usuario"),
                            rs.getString("nome_usuario"),
                            rs.getDate("data_Nascimento").toLocalDate(),
                            rs.getString("cpf_usuario"),
                            rs.getString("telefone_Usuario"),
                            rs.getString("email_Usuario"),
                            rs.getString("senha_Usuario")
                    );
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return usuarioModel;
    }
}
