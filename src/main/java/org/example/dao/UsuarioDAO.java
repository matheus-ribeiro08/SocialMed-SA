package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.MedicoModel;
import org.example.model.UsuarioModel;

import java.sql.*;
import java.util.List;

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
    public boolean cadastrarUsuario(UsuarioModel usuario)
    {
        String sql = "INSERT INTO Usuario (nome_usuario, email_Usuario, senha_Usuario, telefone_Usuario, cpf_Usuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            stmt.setString(4, usuario.getTelefoneUsuario());
            stmt.setString(5, usuario.getCpfUsuario());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
            return false;
        }
    }
}
