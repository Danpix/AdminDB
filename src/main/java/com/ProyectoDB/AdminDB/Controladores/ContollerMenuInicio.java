package com.ProyectoDB.AdminDB.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ContollerMenuInicio {
    public Button btnVender;
    public Button btnCerrarSesion;

    public void CerrarSesion(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesion.fxml"));
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) btnCerrarSesion.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
}
