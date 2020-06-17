package com.mycompany.foodstudiesconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class DBConector {

    private static Connection conexion = null;

    private static final String URL = "jdbc:mysql://localhost:3306/FoodStudiesConnection";
    private static final String USER = "root";
    private static final String PASSWORD = "mistakesWereMade93";

    public Connection getConexion() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado con éxito");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Error");
            alert.setContentText("No se ha podido realizar correctamente la conexion");
            alert.showAndWait();
        }

        return conexion;
    }

    public void closeConexion() throws SQLException {
        conexion.close();
    }
}
