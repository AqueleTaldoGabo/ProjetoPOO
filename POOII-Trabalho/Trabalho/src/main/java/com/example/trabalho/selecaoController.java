package com.example.trabalho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class selecaoController {
    dataSingleton data = dataSingleton.getInstance();
    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnTroca;

    @FXML
    private Label lblNomeLista;

    @FXML
    private ListView<String> listviewPlanta;

    @FXML
    public void initialize(){
        listviewPlanta.setItems(new Planta().lista());
    }

    @FXML
    public void inserir() throws IOException {
        Parent planta = FXMLLoader.load(getClass().getResource("inserir.fxml"));
        Scene plan = new Scene(planta);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(plan);
        stage.show();

    }

    @FXML
    public void deletar() throws IOException {
        if(lblNomeLista.getText().equals("Plantas"))
            new Planta().deletarPlanta(listviewPlanta.getSelectionModel().getSelectedItem());
        else
            new Inseto().deletarInseto(listviewPlanta.getSelectionModel().getSelectedItem());
        Parent planta = FXMLLoader.load(getClass().getResource("inserido.fxml"));
        Scene plan = new Scene(planta);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(plan);
        stage.show();
        listviewPlanta.setItems(new Planta().lista());
    }

    @FXML
    public void alterar() throws IOException {

        data.setNome(listviewPlanta.getSelectionModel().getSelectedItem());
        data.setTipo(lblNomeLista.getText());
        Parent planta = FXMLLoader.load(getClass().getResource("alterar.fxml"));
        Scene plan = new Scene(planta);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(plan);
        stage.show();
    }

    @FXML
    public void trocar(){
        if (btnTroca.getText().equals("Insetos...")) {
            btnTroca.setText("Plantas...");
            lblNomeLista.setText("Insetos");
            listviewPlanta.setItems(new Inseto().lista());
        } else{
            btnTroca.setText("Insetos...");
            lblNomeLista.setText("Plantas");
            listviewPlanta.setItems(new Planta().lista());
        }
    }

    @FXML
    public void sair(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
