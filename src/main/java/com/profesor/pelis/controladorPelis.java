package com.profesor.pelis;

import com.mongodb.client.MongoCollection;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.bson.Document;

import static com.mongodb.client.model.Sorts.ascending;

public class controladorPelis {

    public Pagination pages;
    @FXML
    private TableColumn<Document, String> columnaTitle;

    @FXML
    private TableColumn<Document, String> columnaType;

    @FXML
    private TableColumn<Document, Integer> columnaYear;

    @FXML
    private TableView<Document> tablaPeliculas;
    private MongoCollection<Document> coleccionMovies;
    private ObservableList<Document> datosMovies;

    private final int ELEMETNS = 18;


    public void initialize () {

        columnaTitle.setCellValueFactory( param -> {
            String dato = param.getValue().getString("title");
            return new SimpleStringProperty(dato);
        });

        columnaType.setCellValueFactory( param -> {
            String dato = param.getValue().getString("type");
            return new SimpleStringProperty(dato);
        });

        columnaYear.setCellValueFactory( param -> {
            Integer dato = param.getValue().getInteger("year");
            return new SimpleObjectProperty<Integer>(dato);
        });

        coleccionMovies = Main.dataBaseMongo.getCollection("movies");

        datosMovies = coleccionMovies.find().into(FXCollections.observableArrayList());

        long conuntId  = coleccionMovies.countDocuments()/18;

        pages.setPageCount((int) conuntId);
        pages.setPageFactory(this::listPerPages);

    }

    public Node listPerPages(int elements) {
        int elementPerPages = elements * ELEMETNS;
        datosMovies = coleccionMovies.find().skip(elementPerPages).limit(18).sort(ascending("tittle")).into(FXCollections.observableArrayList());
        tablaPeliculas.setItems(datosMovies);
        return new VBox();
    }



}

