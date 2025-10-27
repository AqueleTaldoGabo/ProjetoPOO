package com.example.trabalho;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class inserirController {

    @FXML
    private Button entrarBotao;

    @FXML
    private TextField nomePlanta;

    @FXML
    private TextField nomePlanta1;

    @FXML
    private Button opcoesBotao;

    @FXML
    private RadioButton radioInsetoBtn;

    @FXML
    private RadioButton radioPlantaBtn;

    @FXML
    private ToggleGroup grupo;

    @FXML
    private Button sairBotao;

    @FXML
    private ChoiceBox<String> tipoPlanta;

    @FXML
    public void initialize(){
        String lista[] = {"Option 1", "Option 2", "Option 3"};
        tipoPlanta.getItems().addAll(lista);
    }

    @FXML
    void btnInserir(ActionEvent event) throws IOException {
        if(grupo.getSelectedToggle().equals(radioPlantaBtn) && nomePlanta1.getText() != "") {
            Planta planta = new Planta();
            planta.criaPlanta(nomePlanta.getText(), tipoPlanta.getValue(), parseInt(nomePlanta1.getText()));
            printInserido();
        } else if (grupo.getSelectedToggle().equals(radioInsetoBtn)) {
            Inseto inseto = new Inseto();
            inseto.criaInseto(nomePlanta.getText(), tipoPlanta.getValue());
            printInserido();
        }
        nomePlanta.setText("");
        tipoPlanta.setValue("");
        nomePlanta1.setText("");
    }
    void printInserido() throws IOException {
        Parent planta = FXMLLoader.load(getClass().getResource("inserido.fxml"));
        Scene plan = new Scene(planta);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(plan);
        stage.show();
    }
}
