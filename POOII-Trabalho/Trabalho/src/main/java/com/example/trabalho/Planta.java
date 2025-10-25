package com.example.trabalho;

import java.sql.*;

public class Planta {
    int[] plantas = new int[6];
    String url = "jdbc:postgresql://localhost:5432/Planta";
    String usuario = "postgres";
    String senha = "12345";

    public void criaPlanta(String nome, String tipo, int custo){
        String sql = "INSERT INTO planta (nome, tipo, vida, custo) VALUES (?, ?, ?, ?) RETURNING plantaid";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println("Conex�o realizada com sucesso!");

            statement.setString(1, nome);
            statement.setString(2, tipo);
            statement.setInt(3, 3);
            statement.setInt(4, custo);


            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int idGerado = rs.getInt("plantaid");
                    System.out.println("Planta inserida com ID: " + idGerado);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }
    public void deletarPlanta(int plantaId){
        String sql = "DELETE FROM Planta WHERE plantaid = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println("Conex�o realizada com sucesso!");

            int idParaExcluir = plantaId;
            statement.setInt(1, idParaExcluir);

            int linhasExcluidas = statement.executeUpdate();

            if (linhasExcluidas > 0) {
                System.out.println("Planta com ID " + idParaExcluir + " exclu�do com sucesso!");
            } else {
                System.out.println("Nenhuma planta encontrado com ID " + idParaExcluir);
            }

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }

}
