package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Servicios.EmpleadosServicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public int ID_empleadoActual;
    public Optional<Empleado> empleado;


    @FXML
    public void Comprueba(){

        if (empleadosServicio.validarUsuario(txtNombre.getText(), txtContraseña.getText())||(txtNombre.getText().equals("admin")&&txtContraseña.getText().equals("1234"))){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDBI/MenuInicioB.fxml"));
            loader.setControllerFactory(context::getBean);
            try {
                Scene scene=new Scene(loader.load());
                Stage stage=(Stage) btnIngresar.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
                empleado=empleadosServicio.encontrarID(txtNombre.getText(),txtContraseña.getText());

                ID_empleadoActual=empleado.get().getIdempleado();
                System.out.println(ID_empleadoActual);

            } catch (IOException e) {
                System.out.println("GG el proyecto fallo");
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null); // Puedes personalizar el encabezado si lo necesitas
            alert.setContentText("ERROR AL COMPROBAR LOS DATOS");
            alert.showAndWait();
        }
    }
    public void IniciarSesion(ActionEvent actionEvent) {
        Comprueba();
    }

    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }
    public int devolverIdempledoActual(){
        return ID_empleadoActual;
    }
}
