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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;



@Controller
public class ControllerInicio {
    @Autowired
    private RepositorioEmpleado repositorioEmpleado;
    @Autowired
    public EmpleadosServicio empleadosServicio;

    @FXML
    public TextField txtContraseña;
    @FXML
    public TextField txtNombre;
    @FXML
    public Button btnGuardar;
    @FXML
    public TextField txtEmail;

    private boolean aceptado;
    @FXML
    public void Comprueba(){

//        empleado.setUsername("Kevin");
//        empleado.setPassword("1234");
        if (empleadosServicio.validarUsuario(txtNombre.getText(), txtContraseña.getText())){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/MenuInicio.fxml"));
            try {
                Scene scene=new Scene(loader.load());
                Stage stage=(Stage) btnGuardar.getScene().getWindow();
                stage.setScene(scene);
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
}
