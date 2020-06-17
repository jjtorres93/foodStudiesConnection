package com.mycompany.foodstudiesconnection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button autores;
    @FXML
    private Button publicaciones;
    @FXML
    private Button salirFSC;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void autoresMenu(ActionEvent event) throws IOException {
        Stage autores = StageAndControllers.getAutoresStage();
        if (autores == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VistaAutores.fxml"));
            Parent root = loader.load();

            StageAndControllers.setControladorAutores((VistaAutoresController) loader.getController());

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            autores = new Stage();
            StageAndControllers.setAutoresStage(autores);
            autores.setTitle("Autores");
            autores.setScene(scene);
            autores.initOwner(StageAndControllers.getMainStage());
            autores.initModality(Modality.WINDOW_MODAL);
        }
        autores.showAndWait();
    }

    @FXML
    private void publicacionesMenu(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("INFO");
        alert.setContentText("App en beta, solo disponible para autores");
        alert.showAndWait();
//        Stage publis = StageAndControllers.getPublisStage();
//        if (publis == null){
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VistaPublicaciones.fxml"));
//        Parent root = loader.load();
//        
//        StageAndControllers.setControladorPublis((VistaPublicacionesController) loader.getController());
//        
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
//        
//        publis = new Stage();
//        StageAndControllers.setPublisStage(publis);
//        publis.setTitle("Publicaciones");
//        publis.setScene(scene);
//        publis.initOwner(StageAndControllers.getMainStage());
//        publis.initModality(Modality.WINDOW_MODAL);
//        }
//        publis.showAndWait();
    }

    @FXML
    private void cerrarApp(ActionEvent event) {
        Platform.exit();
    }
}
