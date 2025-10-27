package com.example.trabalho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class alterarController {
    dataSingleton data = dataSingleton.getInstance();

    @FXML
    private Button btnAlterar;

    @FXML
    private ToggleGroup grupo;

    @FXML
    private Label lblCustoNovo;

    @FXML
    private Label lblNome2;

    @FXML
    private Label lblNomeNovo;

    @FXML
    private Label lblNovoNome;

    @FXML
    private TextField nomePlanta1;

    @FXML
    private TextField nomePlanta12;

    @FXML
    private ChoiceBox<String> tipoPlanta2;

    @FXML
    private Label ttTipo;

    @FXML
    private Label tipoLbl;

    @FXML
    public void initialize(){
        lblNovoNome.setText(data.getNome());
        tipoLbl.setText(data.getTipo());
        String lista[] = {"Option 1", "Option 2", "Option 3"};
        tipoPlanta2.getItems().addAll(lista);
    }

    @FXML
    void btnInserir(ActionEvent event) throws IOException {
        if(tipoLbl.getText().equals("Plantas")){
            int val;
            if(nomePlanta1.getText().isBlank()){
                val = -1;
            }else{
                val = Integer.parseInt(nomePlanta1.getText());
            }
            new Planta().mudarPlanta(lblNovoNome.getText(), nomePlanta12.getText(), val, tipoPlanta2.getValue());

        }else{
            new Inseto().mudarInseto(lblNovoNome.getText(), nomePlanta12.getText(), tipoPlanta2.getValue());
        }
        printInserido();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
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