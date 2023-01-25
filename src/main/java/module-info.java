module com.profesor.pelis {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;

    requires org.kordamp.ikonli.javafx;

    opens com.profesor.pelis to javafx.fxml;
    exports com.profesor.pelis;
}