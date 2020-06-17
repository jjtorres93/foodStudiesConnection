/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.foodstudiesconnection;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class VistaAutoresController implements Initializable {

    Autor aux = new Autor(null, null);

    @FXML
    private TextField autorInputApellido;
    @FXML
    private TextField autorInputNombre;
    @FXML
    private Button autorBotonDel;
    @FXML
    private Button autorBotonAdd;
    @FXML
    private TableView<Autor> tbAutores;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colApellido;

    private ObservableList<Autor> autores;
    @FXML
    private Button salirAutores;

    ;
    @FXML
    private Button orderName;
    @FXML
    private Button guardarXmlButton;

    /**
     * Initializes the controller class.s
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aux.getConexion();
        try {
            aux.cargarBD();
        } catch (SQLException ex) {
            Logger.getLogger(VistaAutoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        autores = FXCollections.observableArrayList(aux.listaDeAutores);
        this.tbAutores.setItems(autores);

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));

    }

    @FXML
    private void autorBorrar(ActionEvent event) {
        Autor a = this.tbAutores.getSelectionModel().getSelectedItem();
        if (a == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un autor");
            alert.showAndWait();
        } else {
            this.autores.remove(a);
            this.tbAutores.refresh();
        }
    }

    @FXML
    private void autorAnadir(ActionEvent event) {
        String nombre = this.autorInputNombre.getText();
        String apellido = this.autorInputApellido.getText();

        Autor a = new Autor(nombre, apellido);
        if (!this.autores.contains(a)) {
            this.autores.add(a);
            this.tbAutores.setItems(autores);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El autor ya existe");
            alert.showAndWait();
        }
    }

    @FXML
    private void cerrarVentana(ActionEvent event) throws SQLException {
        StageAndControllers.getAutoresStage().close();
        aux.closeConexion();
    }

    @FXML
    private void seleccionar(MouseEvent event) {
        Autor a = this.tbAutores.getSelectionModel().getSelectedItem();

        if (a != null) {
            this.autorInputNombre.setText(a.getNombre());
            this.autorInputApellido.setText(a.getApellido());
        }
    }

    @FXML
    private void odernarPorNombre(ActionEvent event) {
        FXCollections.sort(autores, null);
    }

    @FXML
    private void guardarXML(ActionEvent event) throws JAXBException {
        File listaXML = new File("listaDeAutores.xml");
        JAXBContext context = JAXBContext.newInstance(Autor.class);
        Marshaller marsh = context.createMarshaller();
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marsh.marshal(autores, listaXML);
    }

}
