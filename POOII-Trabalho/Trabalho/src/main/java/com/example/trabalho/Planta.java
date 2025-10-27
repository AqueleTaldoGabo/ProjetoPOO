package com.example.trabalho;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Planta {
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
    public void deletarPlanta(String plantaNome){
        String sql = "DELETE FROM Planta WHERE nome = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println("Conex�o realizada com sucesso!");

            statement.setString(1, plantaNome);

            int linhasExcluidas = statement.executeUpdate();

            if (linhasExcluidas > 0) {
                System.out.println("Planta com ID " + plantaNome + " exclu�do com sucesso!");
            } else {
                System.out.println("Nenhuma planta encontrado com ID " + plantaNome);
            }

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }
    public void mudarPlanta(String nome, String nomeNovo, int custo, String tipo){
        String sql = "UPDATE Planta set nome = ?, custo = ?, tipo = ? WHERE nome = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println("Conex�o realizada com sucesso!");
            statement.setString(4, nome);

            if(!nomeNovo.isEmpty())
                statement.setString(1, (nomeNovo));
            else
                statement.setString(1, nome);
            if(custo != -1) {
                statement.setInt(2,custo);
            }
            if(!tipo.isEmpty()) {
                statement.setString(3, tipo);
            }
            int rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!2");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }

    public ObservableList<String> lista(){
        String sql = "Select nome From planta";

        List<String> lista = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {


            try (ResultSet result = statement.executeQuery()) {

                while (result.next()) {
                    String nome = result.getString("nome");
                    System.out.println(nome);
                    lista.add(nome);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
        ObservableList<String> list = FXCollections.observableArrayList(lista);

        return list;
    }
}
