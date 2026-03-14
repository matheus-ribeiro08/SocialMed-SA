package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.MedicoModel;
import org.example.model.UsuarioModel;

import java.sql.*;
import java.util.List;

public class UsuarioDAO
{
    public UsuarioModel login(String cpf, String senha) throws SQLException {
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
            throw new SQLException(e);
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

    public String existeCpf (String cpf)
    {
        String sql = "SELECT cpf_Usuario FROM Usuario WHERE cpf_Usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, cpf);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next())
                {
                    return rs.getString("cpf_Usuario");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar o CPF.");
        }
        return null;
    }

    public String existeEmail (String email)
    {
        String sql = "SELECT email_Usuario FROM Usuario WHERE email_Usuario";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, email);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next())
                {
                    return rs.getString("email_Usuario");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar o email.");
        }
        return null;
    }

    public UsuarioModel buscarPorCpf(String cpf)
    {
        String sql = "SELECT * FROM Usuario WHERE cpf_Usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.getResultSet();

            if(rs.next())
            {
                return extrairUsuario(rs);
            }
        }catch (SQLException e)
        {
            System.err.println("Erro ao buscar o CPF.");
        }
        return null;
    }

    public UsuarioModel buscarPorEmail(String email)
    {
        String sql = "SELECT * FROM Usuario WHERE email_Usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, email);
            ResultSet rs = stmt.getResultSet();

            if(rs.next())
            {
                return extrairUsuario(rs);
            }
        }catch (SQLException e)
        {
            System.err.println("Erro ao buscar o Email.");
        }
        return null;
    }

    public UsuarioModel extrairUsuario(ResultSet rs) throws  SQLException
    {
        UsuarioModel Usuario = new UsuarioModel(
                rs.getString("nome_Usuario"),
                rs.getString("email_Usuario"),
                rs.getString("senha_Usuario"),
                rs.getString("cpf_Usuario"),
                rs.getString("telefone_Usuario")
        );
        Usuario.setId(rs.getInt("id_Usuario"));
        return Usuario;
    }
}
