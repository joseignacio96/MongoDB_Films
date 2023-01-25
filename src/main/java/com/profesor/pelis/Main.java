package com.profesor.pelis;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.bson.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main extends Application {

    final String FICHERO_CONFIGURACION = "settings.properties";
    static Properties configuracion = new Properties();
    static MongoClient clienteMongo;
    static MongoDatabase dataBaseMongo;

    public static BorderPane mainScene;

    @Override
    public void start(Stage stage) throws IOException {

        cargarConfiguracion(FICHERO_CONFIGURACION,configuracion);
        contectarBaseDeDatos(configuracion);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        mainScene = fxmlLoader.load();
        Scene scene = new Scene(mainScene);
        stage.setTitle("Información de peliculas");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void cargarConfiguracion(String ficheroConfiguracion, Properties config) {
        try {
            InputStream input = this.getClass().getClassLoader().getResourceAsStream(ficheroConfiguracion);
            config.load(input);
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Error al leer el fichero de configuración");
            alerta.setTitle("Error al leer el fichero de configuración");
            alerta.setContentText("ERROR: No se ha podido leer el contenido del fichero " + ficheroConfiguracion );
            alerta.showAndWait();
            System.exit(1);
        }
    }

    private void contectarBaseDeDatos(Properties config) {
        try {
            clienteMongo= MongoClients.create(config.getProperty("MONGODB_URI"));
            dataBaseMongo = clienteMongo.getDatabase(config.getProperty("MONGODB_DATABASE"));
        } catch ( Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Error no se ha podido conectar a la base de datos");
            alerta.setTitle("Error no se ha podido conectar a la base de datos");
            alerta.setContentText("ERROR: No se ha podido conectar a la base de datos  " + config.getProperty("MONGODB_DATABASE") );
            alerta.showAndWait();
            System.exit(2);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}