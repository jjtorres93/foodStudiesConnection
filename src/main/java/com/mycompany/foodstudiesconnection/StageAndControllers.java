package com.mycompany.foodstudiesconnection;

import javafx.stage.Stage;

public class StageAndControllers {

    private static Stage mainStage;
    private static Stage autoresStage;
    private static Stage publisStage;
    private static VistaAutoresController controladorAutores;
    private static VistaPublicacionesController controladorPublis;

    public static Stage getPublisStage() {
        return publisStage;
    }

    public static void setPublisStage(Stage publisStage) {
        StageAndControllers.publisStage = publisStage;
    }

    public static VistaAutoresController getControladorAutores() {
        return controladorAutores;
    }

    public static VistaPublicacionesController getControladorPublis() {
        return controladorPublis;
    }

    public static void setControladorPublis(VistaPublicacionesController controladorPublis) {
        StageAndControllers.controladorPublis = controladorPublis;
    }

    public static void setControladorAutores(VistaAutoresController controladorAutores) {
        StageAndControllers.controladorAutores = controladorAutores;
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        StageAndControllers.mainStage = mainStage;
    }

    public static Stage getAutoresStage() {
        return autoresStage;
    }

    public static void setAutoresStage(Stage autoresStage) {
        StageAndControllers.autoresStage = autoresStage;
    }

}
