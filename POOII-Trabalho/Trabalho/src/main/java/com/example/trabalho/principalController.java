package com.example.trabalho;

import com.sun.security.auth.NTUserPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class principalController{
    private double custo = 0.5;
    @FXML
    private Button btnInfo1;

    @FXML
    private Button btnInfo2;

    @FXML
    private Button btnInfo3;

    @FXML
    private Button btnInfo4;

    @FXML
    private Button btnInfo5;

    @FXML
    private Button btnInfo6;

    @FXML
    private Button btnMelhorar;

    @FXML
    private Button btnPlantar1;

    @FXML
    private Button btnPlantar2;

    @FXML
    private Button btnPlantar3;

    @FXML
    private Button btnPlantar4;

    @FXML
    private Button btnPlantar5;

    @FXML
    private Button btnPlantar6;

    @FXML
    private Button btnRegar1;

    @FXML
    private Button btnRegar2;

    @FXML
    private Button btnRegar3;

    @FXML
    private Button btnRegar4;

    @FXML
    private Button btnRegar5;

    @FXML
    private Button btnRegar6;

    @FXML
    private Button btnRetirar1;

    @FXML
    private Button btnRetirar2;

    @FXML
    private Button btnRetirar3;

    @FXML
    private Button btnRetirar4;

    @FXML
    private Button btnRetirar5;

    @FXML
    private Button btnRetirar6;

    @FXML
    private Button btnTempo;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private VBox vbox_pote1;

    @FXML
    private VBox vbox_pote2;

    @FXML
    private VBox vbox_pote3;

    @FXML
    private VBox vbox_pote4;

    @FXML
    private VBox vbox_pote5;

    @FXML
    private VBox vbox_pote6;

    @FXML
    public void initialize(){
        progressBar.setProgress(1);
    }

    @FXML
    void AcaoDeletar(ActionEvent event) {
        if(event.getSource().equals(btnRetirar1)){
            new Pote().RetiraPote(1);
        } else if (event.getSource().equals(btnRetirar2)) {
            new Pote().RetiraPote(2);
        } else if (event.getSource().equals(btnRetirar3)) {
            new Pote().RetiraPote(3);
        } else if (event.getSource().equals(btnRetirar4)) {
            new Pote().RetiraPote(4);
        } else if (event.getSource().equals(btnRetirar5)) {
            new Pote().RetiraPote(5);
        } else if (event.getSource().equals(btnRetirar6)) {
            new Pote().RetiraPote(6);
        }
    }



    @FXML
    void AcaoInfo(ActionEvent event) throws IOException {
        dataSingleton data = dataSingleton.getInstance();

        if(event.getSource().equals(btnInfo1)){
            data.setPote(1);
        }else if (event.getSource().equals(btnInfo2)){
            data.setPote(2);
        } else if (event.getSource().equals(btnInfo3)) {
            data.setPote(3);
        } else if (event.getSource().equals(btnInfo4)) {
            data.setPote(4);
        } else if (event.getSource().equals(btnInfo5)) {
            data.setPote(5);
        } else if (event.getSource().equals(btnInfo6)) {
            data.setPote(6);
        }
        Parent planta = FXMLLoader.load(getClass().getResource("informacoesPlanta.fxml"));
        Scene plan = new Scene(planta);
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(plan);
        stage.show();
    }

    @FXML
    void AcaoPlantar(ActionEvent event) throws IOException {
        dataSingleton data = dataSingleton.getInstance();

        if(event.getSource().equals(btnPlantar1)){
            data.setPote(1);
        }else if (event.getSource().equals(btnPlantar2)){
            data.setPote(2);
        } else if (event.getSource().equals(btnPlantar3)) {
            data.setPote(3);
        } else if (event.getSource().equals(btnPlantar4)) {
            data.setPote(4);
        } else if (event.getSource().equals(btnPlantar5)) {
            data.setPote(5);
        } else if (event.getSource().equals(btnPlantar6)) {
            data.setPote(6);
        }

        Parent planta = FXMLLoader.load(getClass().getResource("Lista.fxml"));
        Scene plan = new Scene(planta);
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(plan);
        stage.show();
    }

    @FXML
    void AcaoRegar(ActionEvent event) {
        if(progressBar.getProgress() > 0) {
            if (event.getSource().equals(btnRegar1)) {
                new Pote().Regar(1);
                progressBar.setProgress(progressBar.getProgress() - custo);
            } else if (event.getSource().equals(btnRegar2)) {
                new Pote().Regar(2);
                progressBar.setProgress(progressBar.getProgress() - custo);
            } else if (event.getSource().equals(btnRegar3)) {
                new Pote().Regar(3);
                progressBar.setProgress(progressBar.getProgress() - custo);
            } else if (event.getSource().equals(btnRegar4)) {
                new Pote().Regar(4);
                progressBar.setProgress(progressBar.getProgress() - custo);
            } else if (event.getSource().equals(btnRegar5)) {
                new Pote().Regar(5);
                progressBar.setProgress(progressBar.getProgress() - custo);
            } else if (event.getSource().equals(btnRegar6)) {
                new Pote().Regar(6);
                progressBar.setProgress(progressBar.getProgress() - custo);
            }

            System.out.println("calros");
        }
    }

    @FXML
    void AtivarMelhor(ActionEvent event) {
        if(progressBar.getProgress() >= 1){
            progressBar.setProgress(0);
            custo = custo/1.2;
        }
    }

    @FXML
    void PassarOTempo(ActionEvent event) {
        new Pote().gastarAgua(1);
        new Pote().gastarAgua(2);
        new Pote().gastarAgua(3);
        new Pote().gastarAgua(4);
        new Pote().gastarAgua(5);
        new Pote().gastarAgua(6);
        progressBar.setProgress(progressBar.getProgress() + 0.5);

    }

}