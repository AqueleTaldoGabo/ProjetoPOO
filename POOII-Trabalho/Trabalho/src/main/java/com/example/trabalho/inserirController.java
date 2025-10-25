package com.example.trabalho;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class inserirController {

    @FXML
    private Button btnInserir;

    @FXML
    private TextField custoPlanta;

    @FXML
    private TextField nomePlanta;

    @FXML
    private ChoiceBox<String> tipoPlanta;

    @FXML
    public void initialize(){
        String lista[] = {"Option 1", "Option 2", "Option 3"};
        tipoPlanta.getItems().addAll(lista);
    }

    @FXML
    void btnInserir(ActionEvent event) {
        Planta planta = new Planta();
        planta.criaPlanta(nomePlanta.getText(), tipoPlanta.getValue(), parseInt(custoPlanta.getText()));
    }

}
