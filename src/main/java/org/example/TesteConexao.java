package org.example; // Mude para o pacote correto onde você vai criar esta classe

import org.example.configuracao.ConnectionFactory; // Importe a sua classe de conexão
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        System.out.println("Iniciando o teste de conexão com o banco de dados Aiven...");
        System.out.println("Aguarde, conectando...\n");

        // O try-with-resources já fecha a conexão automaticamente no final
        try (Connection conn = ConnectionFactory.getConnection()) {

            if (conn != null) {
                System.out.println("✅ SUCESSO! A conexão com o MySQL foi estabelecida perfeitamente.");
                System.out.println("Seu banco de dados está pronto para receber os inserts e selects!");
            } else {
                System.out.println("⚠️ ATENÇÃO: A conexão não deu erro, mas retornou nula.");
            }

        } catch (SQLException e) {
            System.err.println("❌ ERRO: Não foi possível conectar ao banco de dados.");
            System.err.println("Detalhes do erro para você debugar: " + e.getMessage());

            // Dicas comuns de erro:
            System.err.println("\n--- Dicas de Solução ---");
            System.err.println("1. Verifique se o seu IP está liberado na firewall da Aiven.");
            System.err.println("2. Confira se o usuário, senha e URL no ConnectionFactory estão corretos.");
            System.err.println("3. Veja se a dependência do mysql-connector-j está no seu pom.xml.");
        }
    }
}