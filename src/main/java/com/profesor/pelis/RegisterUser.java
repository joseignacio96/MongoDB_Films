package com.profesor.pelis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RegisterUser {

    @FXML
    private Button delete;
    @FXML
    private ListView<String> listVIew;

    ObservableList<String> directores = FXCollections.observableArrayList();

    @FXML
    private Button close;
    @FXML
    private TextField labelDirec;
    @FXML
    private Button btnadd;

    Stage stage;

    public void initialize() {

    }

    public void addItem(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("inputDire.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeStage(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void addValue(ActionEvent actionEvent) {
        String campo = labelDirec.getText();
        directores.add(campo);
        listVIew.setItems(directores);
        System.out.println(listVIew.toString());
        closeStage(new ActionEvent());
    }


    public void deleteItem(ActionEvent actionEvent) {
    }
}
