package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioEmpleado;
import com.ProyectoDB.AdminDB.Servicios.EmpleadosServicio;
import com.ProyectoDB.AdminDB.repetidas.SalidaSesiones;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

import static com.ProyectoDB.AdminDB.Main.context;

@Controller
public class ControllerEmpleadosMenu {
    @Autowired
    public EmpleadosServicio empleadosServicio;
    public TableColumn id_empT;
    public TableColumn rfc_empT;
    public TableView<Empleado> tableEmpleados;
    public TableColumn usuario_empT;
    public TableColumn apellidos_empT;
    public TableColumn puesto_empT;
    public TextField txtRfc;
    public TextField txtUsuario;
    public TextField txtApellidos;
    public Button btnGuardarDatos;
    public ChoiceBox cmbPuesto;
    public Button btnBuscar;
    public Button btnCerrarSesion;

    public void SeleccionarUsuario(MouseEvent mouseEvent) {
        Empleado emp = this.tableEmpleados.getSelectionModel().getSelectedItem();
        txtApellidos.setText(emp.getApellidos_empleado());
        txtRfc.setText(emp.getRfc_emp());
        txtUsuario.setText(emp.getUsername());
    }

    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Buscar(ActionEvent actionEvent) {
    }

    public void CerrarSesion(ActionEvent actionEvent) {
        SalidaSesiones sal = new SalidaSesiones();
        sal.InicioSesion(btnCerrarSesion);
    }
    public void MostrarTodos(ObservableList<Empleado> empleados){
        id_empT.setCellValueFactory(new PropertyValueFactory<>("id_empleado"));
        usuario_empT.setCellValueFactory(new PropertyValueFactory<>("username"));
        rfc_empT.setCellValueFactory(new PropertyValueFactory<>("rfc_emp"));
        apellidos_empT.setCellValueFactory(new PropertyValueFactory<>("apellidos_empleado"));
        puesto_empT.setCellValueFactory(new PropertyValueFactory<>("puesto_emp"));
        tableEmpleados.setItems(empleados);
        tableEmpleados.refresh();
    }
}
