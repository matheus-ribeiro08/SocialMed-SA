package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.enums.TipoUsuario;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO
{
    public boolean cadastrarPaciente(PacienteModel paciente) throws SQLException {
        String sqlUsuario = "INSERT INTO Usuario (nome_Usuario, email_Usuario, senha_Usuario, telefone_Usuario, cpf_Usuario, tipo_Usuario) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlPaciente = "INSERT INTO Paciente (id_Usuario, endereco_Paciente) VALUES (?, ?)";

        Connection conn = null;

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, paciente.getNomeUsuario());
                stmt.setString(2, paciente.getEmailUsuario());
                stmt.setString(3, paciente.getSenhaUsuario());
                stmt.setString(4, paciente.getTelefoneUsuario());
                stmt.setString(5, paciente.getCpfUsuario());
                stmt.setInt(6, TipoUsuario.PACIENTE.getCodigo());

                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idUsuarioGerado = rs.getInt(1);

                        try (PreparedStatement stmtP = conn.prepareStatement(sqlPaciente)) {
                            stmtP.setInt(1, idUsuarioGerado);
                            stmtP.setString(2, paciente.getEnderecoPaciente());
                            stmtP.executeUpdate();
                        }

                    } else {
                        throw new SQLException("Falha a criar Usuario");
                    }
                }
            }
            conn.commit();
            return true;

        } catch (SQLException e)
        {
            if(conn != null)
            {
                try
                {
                    conn.rollback();
                }
                catch (SQLException ex)
                {
                    System.err.println("Erro ao dar rollback: " + ex.getMessage());
                }
            }
            System.err.println("Erro ao cadastrar paciente: " + e.getMessage());
            throw e;
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.setAutoCommit(true);
                    conn.close();
                }
                catch (SQLException e)
                {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    public PacienteModel buscarDetalhePorIdUsuario(int idUsuario) throws SQLException
    {
        String sql = "SELECT * FROM Paciente WHERE id_Usuario = ?";
        PacienteModel detalhes = new PacienteModel();

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idUsuario);

            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    detalhes.setEnderecoPaciente(rs.getString("endereco_Paciente"));
                }
            }
        } catch (SQLException e)
        {
            System.err.println("Erro ao encontrar detalhes do paciente");
        }
        return detalhes;
    }


    public List<PacienteModel> listarTodosPacientes()
    {
        List<PacienteModel> pacientes = new ArrayList<>();
        String sql = "SELECT u.*, p.id_Paciente, p.endereco_Paciente FROM Paciente p INNER JOIN Usuario u ON p.id_Usuario = u.id_Usuario";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                PacienteModel paciente = new PacienteModel();

                paciente.setIdUsuario(rs.getInt("id_Usuario"));
                paciente.setNomeUsuario(rs.getString("nome_usuario"));
                paciente.setEmailUsuario(rs.getString("email_Usuario"));
                paciente.setSenhaUsuario(rs.getString("senha_Usuario"));
                paciente.setTelefoneUsuario(rs.getString("telefone_Usuario"));
                paciente.setCpfUsuario(rs.getString("cpf_Usuario"));

                paciente.setIdPaciente(rs.getInt("id_Paciente"));
                paciente.setEnderecoPaciente(rs.getString("endereco_Paciente"));

                pacientes.add(paciente);
            }
        }catch (SQLException e)
        {
            System.err.println("Erro: " + e.getMessage());
        }
        return pacientes;
    }

    public PacienteModel buscarPorCpf (String cpf)
    {
        PacienteModel paciente = null;

        String sql = "SELECT u.*, p.id_Paciente, p.endereco_Paciente " +
                "FROM Paciente p " +
                "INNER JOIN Usuario u ON p.id_Usuario = u.id_Usuario " +
                "WHERE u.cpf_Usuario = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    paciente = new PacienteModel();
                    paciente.setIdPaciente(rs.getInt("id_Paciente"));
                    paciente.setIdUsuario(rs.getInt("id_Usuario"));
                    paciente.setNomeUsuario(rs.getString("nome_usuario"));
                    paciente.setEmailUsuario(rs.getString("email_Usuario"));
                    paciente.setSenhaUsuario(rs.getString("senha_Usuario"));
                    paciente.setTelefoneUsuario(rs.getString("telefone_Usuario"));
                    paciente.setCpfUsuario(rs.getString("cpf_Usuario"));
                    paciente.setEnderecoPaciente(rs.getString("endereco_Paciente"));

                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao buscar paciente por Cpf");
        }
        return paciente;
    }

    public PacienteModel buscarPorId (int idPaciente)
    {
        PacienteModel paciente = null;

        String sql = "SELECT u.*, p.id_Paciente, p.endereco_Paciente " +
                "FROM Paciente p " +
                "INNER JOIN Usuario u ON p.id_Usuario = u.id_Usuario " +
                "WHERE p.id_Paciente = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idPaciente);

            try (ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    paciente = new PacienteModel();
                    paciente.setIdUsuario(rs.getInt("id_Usuario"));
                    paciente.setIdPaciente(rs.getInt("id_Paciente"));
                    paciente.setNomeUsuario(rs.getString("nome_usuario"));
                    paciente.setEmailUsuario(rs.getString("email_Usuario"));
                    paciente.setSenhaUsuario(rs.getString("senha_Usuario"));
                    paciente.setTelefoneUsuario(rs.getString("telefone_Usuario"));
                    paciente.setCpfUsuario(rs.getString("cpf_Usuario"));
                    paciente.setEnderecoPaciente(rs.getString("endereco_Paciente"));
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao buscar Paciente por ID");
        }
        return paciente;
    }

    public boolean atualizarPaciente(PacienteModel paciente) throws  SQLException {
        String sqlUsuario = "UPDATE Usuario SET nome_Usuario = ?, email_Usuario = ?, senha_Usuario = ?, telefone_Usuario = ? WHERE id_Usuario = ?";
        String sqlPaciente = "UPDATE Paciente SET endereco_Paciente = ? WHERE id_Paciente = ?";

        Connection conn = null;


        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sqlUsuario)) {
                stmt.setString(1, paciente.getNomeUsuario());
                stmt.setString(2, paciente.getEmailUsuario());
                stmt.setString(3, paciente.getSenhaUsuario());
                stmt.setString(4, paciente.getTelefoneUsuario());
                stmt.setInt(5, paciente.getIdUsuario());

                int linhasAfestadas = stmt.executeUpdate();
                if (linhasAfestadas == 0) {
                    throw new SQLException("Usuario nao encontrado para atualização");
                }

            }

            try (PreparedStatement stmt = conn.prepareStatement(sqlPaciente)) {
                stmt.setString(1, paciente.getEnderecoPaciente());
                stmt.setInt(2, paciente.getIdPaciente());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Paciente nao encontrado para atualização");
                }
            }

                conn.commit();
                return true;

            } catch (SQLException e) {
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException ex) {
                        System.err.println("Erro ao dar rollback!");
                    }
                }
                System.err.println("Erro ao atualizar paciente");
                throw e;
            } finally {
                if (conn != null) {
                    try {
                        conn.setAutoCommit(true);
                        conn.close();
                    } catch (SQLException e) {
                        System.err.println("Erro ao fechar conexao");
                    }
                }
        }
    }

    public boolean removerPaciente(int idPaciente) throws SQLException{
        String sqlBuscarIdUsuario = "SELECT id_Usuario FROM Paciente WHERE id_Paciente = ?";
        String sqlRemoverPaciente = "DELETE FROM Paciente WHERE id_Paciente = ?";
        String sqlRemoverUsuario = "DELETE FROM Usuario WHERE id_Usuario = ?";

        Connection conn = null;
        Integer idUsuario = null;

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            try(PreparedStatement stmt = conn.prepareStatement(sqlBuscarIdUsuario)){
                stmt.setInt(1 , idPaciente);
                try(ResultSet rs = stmt.executeQuery()) {
                    if(rs.next()){
                        idUsuario = rs.getInt("id_Usuario");
                    }else {
                        throw new SQLException("Paciente nao encontrado");
                    }

                }
            }

            try(PreparedStatement stmt  = conn.prepareStatement(sqlRemoverPaciente)) {
                stmt.setInt(1, idPaciente);
                int linhasAfetadas = stmt.executeUpdate();
                if(linhasAfetadas == 0){
                    throw new SQLException("Erro ao remover paciente");
                }
            }

            try(PreparedStatement stmt  = conn.prepareStatement(sqlRemoverUsuario)) {
                stmt.setInt(1, idUsuario);
                int linhasAfetadas = stmt.executeUpdate();
                if(linhasAfetadas == 0){
                    throw new SQLException("Erro ao remover usuario");
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.err.println("Erro ao dar rollback!");
                }
            }
            System.err.println("Erro ao remover paciente");
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexao");
                }
            }
        }
    }

}




