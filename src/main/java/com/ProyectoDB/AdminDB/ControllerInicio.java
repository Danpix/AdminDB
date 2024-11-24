package com.ProyectoDB.AdminDB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControllerInicio {
    @Autowired
    private Repository repository;
    @FXML
    public TextField txtContraseña;
    @FXML
    public TextField txtNombre;
    @FXML
    public Button btnGuardar;
    @FXML
    public TextField txtEmail;
    @FXML
    public void guarda(){
        Modelo model=new Modelo();
        model.setNombre(txtNombre.getText());
        model.setContraseña(txtContraseña.getText());
        model.setEmail(txtEmail.getText());
        repository.save(model);
    }
    public void Guardar(ActionEvent actionEvent) {
        guarda();
    }
}
