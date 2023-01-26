package com.profesor.pelis;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Translate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class controladorPrincipal {

    public Button salir;

    public VBox menu;
    public StackPane menuCompleto;


    public void initialize() {
        menuCompleto.setVisible(false);
    }

    public void close(ActionEvent actionEvent) {
        System.exit(1);
    }
    public void hiddeMenu(MouseEvent mouseEvent) {
        menuCompleto.setVisible(true);

    }

    public void showMenu(ActionEvent actionEvent) {
        menuCompleto.setVisible(false);
    }


    public void addFilm(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registerUser.fxml"));
            Main.mainScene.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFilm(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("peliculasView.fxml"));
            Main.mainScene.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
