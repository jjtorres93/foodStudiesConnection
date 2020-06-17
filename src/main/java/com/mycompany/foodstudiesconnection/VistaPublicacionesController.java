package com.mycompany.foodstudiesconnection;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class VistaPublicacionesController implements Initializable {

    @FXML
    private Button publisBotonAdd;
    @FXML
    private Button publisBotonSearch;
    @FXML
    private Button publisBotonDel;
    @FXML
    private Button salirPublis;
    @FXML
    private TextField autorInputNombre;
    @FXML
    private RadioButton publisTitle;
    @FXML
    private RadioButton publisAutor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        this.publisAutor.setToggleGroup(tg);
        this.publisTitle.setToggleGroup(tg);
    }

    @FXML
    private void publisAnadir(ActionEvent event) {
    }

    @FXML
    private void publisBuscar(ActionEvent event) {
    }

    @FXML
    private void publisBorrar(ActionEvent event) {
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        StageAndControllers.getPublisStage().close();
    }

    @FXML
    private void seleccionar(MouseEvent event) {
    }

}
