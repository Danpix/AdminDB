package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Repositorios.RepositorioEmpleado;
import com.ProyectoDB.AdminDB.Servicios.EmpleadosServicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

import static com.ProyectoDB.AdminDB.Main.context;


@Controller
public class ControllerInicio {

    @Autowired
    public EmpleadosServicio empleadosServicio;

    @FXML
    public TextField txtContraseña;
    @FXML
    public TextField txtNombre;
    @FXML
    public Button btnGuardar;
    public Button btnSalir;
    public Button btnIngresar;



    @FXML
    public void Comprueba(){

        if (empleadosServicio.validarUsuario(txtNombre.getText(), txtContraseña.getText())){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/MenuInicioB.fxml"));
            loader.setControllerFactory(context::getBean);
            try {
                Scene scene=new Scene(loader.load());
                Stage stage=(Stage) btnIngresar.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                System.out.println("GG el proyecto fallo");
            }
        }else {
            System.out.println("ERROR EL USUARIO NO ESTA EN LA BASE DE DATOS");
        }
    }
    public void IniciarSesion(ActionEvent actionEvent) {
        Comprueba();
    }

    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }
}
