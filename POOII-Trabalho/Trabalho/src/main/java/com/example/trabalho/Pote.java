package com.example.trabalho;

import java.sql.*;

public class Pote {

    String url = "jdbc:postgresql://localhost:5432/Planta";
    String usuario = "postgres";
    String senha = "12345";
    public void colocaPote(int poteid, int plantaid){

        String sql = "UPDATE Pote SET quantiaagua = ?, doenca = ?, plantaid = ? where poteid = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println("Conex�o realizada com sucesso!");

            statement.setInt(4, poteid);
            statement.setInt(1, 0);
            statement.setBoolean(2, false);
            statement.setInt(3, plantaid);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int idGerado = rs.getInt("poteid");
                    System.out.println("Pote inserido com ID: " + idGerado);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }
    public void Regar(int numpote) {
        String sql = "UPDATE Pote Set quantiaagua = ? WHERE poteid = ?";
        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println("Conex�o realizada com sucesso!");

            statement.setInt(1, 100);
            statement.setInt(2, numpote);
            int rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }
    public void RetiraPote(int numpote){
        String sql = "UPDATE Pote Set plantaid = ?, insetoid = ? WHERE poteid = ?";
        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println("Conex�o realizada com sucesso!");

            statement.setObject(1, null);
            statement.setObject(2, null);
            statement.setInt(3, numpote);
            int rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }

    public void gastarAgua(int numpote){
        int quantia =0, custo=0;
        String sql = "SELECT quantiaagua, custo FROM pote join planta on pote.plantaid = planta.plantaid where poteid = ?";
        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, numpote);
            try (ResultSet result = statement.executeQuery()) {
                System.out.println("CARLOOOOOS");

                if (result.next()) {
                    quantia = result.getInt("quantiaagua");
                    custo = result.getInt("custo");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados1!");
            System.out.println("Detalhes: " + e.getMessage());
        }


        sql = "UPDATE Pote set quantiaagua = ? WHERE poteid = ?";
        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println("Conex�o realizada com sucesso!");

            statement.setObject(1, (quantia-custo));
            System.out.println(quantia-custo);
            statement.setInt(2, numpote);
            int rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!2");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }
}
