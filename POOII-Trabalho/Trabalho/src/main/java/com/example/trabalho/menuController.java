package com.example.trabalho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;



public class menuController {
    @FXML
    private Label titleLbl;
    @FXML
    private Button jogarBtn;
    @FXML
    private Button baralhoBtn;
    @FXML
    private Button sairBtn;


    public void jogarButtonClick(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Scene scene = new Scene(fxmlLoader);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void baralhoButtonClick(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("baralho.fxml"));
        Parent planta = FXMLLoader.load(getClass().getResource("inserir.fxml"));
        Scene scene = new Scene(fxmlLoader);
        Scene plan = new Scene(planta);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //window.setScene(scene);
        //window.show();
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(plan);
        stage.show();
    }

    public void sairButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) sairBtn.getScene().getWindow();
        stage.close();
    }
}