package com.example.trabalho;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class listaController {
    String url = "jdbc:postgresql://localhost:5432/Planta";
    String usuario = "postgres";
    String senha = "12345";

    dataSingleton data = dataSingleton.getInstance();

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private ComboBox<String> lisLista;

    @FXML
    public void initialize(){

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
        System.out.println(list);
        lisLista.setItems(list);
    }

    @FXML
    public void Confimar(ActionEvent actionEvent) {
        String sql = "Select plantaid From planta where nome = ?";
        int id=0;
        List<String> lista = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lisLista.getValue());
            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {
                    id = result.getInt("plantaid");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na opera��o com o banco de dados!");
            System.out.println("Detalhes: " + e.getMessage());
        }
        new Pote().colocaPote(data.getPote(), id);
        Stage stage = (Stage) btnConfirmar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Cancelar(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}