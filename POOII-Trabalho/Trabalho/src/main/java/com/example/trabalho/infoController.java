package com.example.trabalho;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.sql.*;

public class infoController {
    dataSingleton data = dataSingleton.getInstance();

    @FXML
    private Label lblConsumo;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblTipo;

    @FXML
    private ProgressBar pgAguaPlanta;

    @FXML
    public void initialize(){
        String url = "jdbc:postgresql://localhost:5432/Planta";
        String usuario = "postgres";
        String senha = "12345";

        String sql = "Select * From pote join planta on pote.plantaid = planta.plantaid where poteid = ?";
        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, data.getPote());

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {
                    lblNome.setText("Nome: " + result.getString("nome"));
                    lblTipo.setText("Tipo:  " + result.getString("tipo"));
                    lblConsumo.setText("Consumo " + result.getString("custo"));
                    pgAguaPlanta.setProgress(result.getDouble("quantiaagua")/100);
                } else {
                    System.out.println("Nenhum estudante encontrado com o ID informado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }
}