package com.ProyectoDB.AdminDB.repetidas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import javafx.scene.control.Button;


import java.io.IOException;

import static com.ProyectoDB.AdminDB.Main.context;

public class SalidaSesiones {

    public void cerrartodo(){
        System.exit(0);
    }
    public void InicioSesion(Button button){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesionB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
    public void InicioCarga(Button button){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/MenuInicioB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
    public void ProductosCarga(Button button){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesionB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
    public void EmpleadosCarga(Button button){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/EmpledosMenu.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
    public void ClientesCarga(Button button){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesionB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
    public void ProveedoresCarga(Button button){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesionB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
    public void VentaCarga(Button button){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesionB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
    public void BuscadorP(Button button){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/BuscarProductos.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }
}
