package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioEmpleado;
import com.ProyectoDB.AdminDB.Servicios.EmpleadosServicio;
import com.ProyectoDB.AdminDB.repetidas.SalidaSesiones;
import jakarta.transaction.Transactional;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
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
import java.util.List;

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
    public Integer idSeleccionado;
    public PasswordField txtContraseña;
    public Button btnEmpleados;
    public Button btnProveedores;
    public Button btnClientes;
    public Button btnVentas;
    public Button btnProductos;
    public Button btnInicio;
    public Button btnEliminarEmp;
    public Button btnSalir;

    public void SeleccionarUsuario(MouseEvent mouseEvent) {
        Empleado emp = this.tableEmpleados.getSelectionModel().getSelectedItem();
        idSeleccionado=emp.getIdempleado();
        txtApellidos.setText(emp.getApellidos_empleado());
        txtRfc.setText(emp.getRfc_emp());
        txtContraseña.setText(emp.getPassword());
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
        id_empT.setCellValueFactory(new PropertyValueFactory<>("idempleado"));
        usuario_empT.setCellValueFactory(new PropertyValueFactory<>("username"));
        rfc_empT.setCellValueFactory(new PropertyValueFactory<>("rfc_emp"));
        apellidos_empT.setCellValueFactory(new PropertyValueFactory<>("apellidos_empleado"));
        puesto_empT.setCellValueFactory(new PropertyValueFactory<>("puesto_emp"));
        tableEmpleados.setItems(empleados);
        tableEmpleados.refresh();
    }

    public void Eliminar(ActionEvent actionEvent) {
        empleadosServicio.eliminarEmpleado(idSeleccionado);
        tableEmpleados.refresh();
        txtApellidos.clear();
        txtApellidos.clear();
        txtRfc.clear();
        txtContraseña.clear();
        List<Empleado> empleados=empleadosServicio.MostrarTodos();
        ObservableList<Empleado> observableEmp = FXCollections.observableArrayList(empleados);
        id_empT.setCellValueFactory(new PropertyValueFactory<>("idempleado"));
        usuario_empT.setCellValueFactory(new PropertyValueFactory<>("username"));
        rfc_empT.setCellValueFactory(new PropertyValueFactory<>("rfc_emp"));
        apellidos_empT.setCellValueFactory(new PropertyValueFactory<>("apellidos_empleado"));
        puesto_empT.setCellValueFactory(new PropertyValueFactory<>("puesto_emp"));
        tableEmpleados.setItems(observableEmp);
        tableEmpleados.refresh();
    }

    public void GuardarEmp(ActionEvent actionEvent) {
        Empleado emp = new Empleado();
        emp.setRfc_emp(txtRfc.getText());
        emp.setApellidos_empleado(txtApellidos.getText());
        emp.setUsername(txtUsuario.getText());
        emp.setPassword(txtContraseña.getText());
        emp.setPuesto_emp("Admin");
        empleadosServicio.GuardarEmpleados(emp);
        txtApellidos.clear();
        txtApellidos.clear();
        txtUsuario.clear();
        txtRfc.clear();
        txtContraseña.clear();
        List<Empleado> empleados=empleadosServicio.MostrarTodos();
        ObservableList<Empleado> observableEmp = FXCollections.observableArrayList(empleados);
        id_empT.setCellValueFactory(new PropertyValueFactory<>("idempleado"));
        usuario_empT.setCellValueFactory(new PropertyValueFactory<>("username"));
        rfc_empT.setCellValueFactory(new PropertyValueFactory<>("rfc_emp"));
        apellidos_empT.setCellValueFactory(new PropertyValueFactory<>("apellidos_empleado"));
        puesto_empT.setCellValueFactory(new PropertyValueFactory<>("puesto_emp"));
        tableEmpleados.setItems(observableEmp);
        tableEmpleados.refresh();
    }

    public void Modificaremp(ActionEvent actionEvent) {
        
        empleadosServicio.modificarUsuario(idSeleccionado,txtUsuario.getText(),txtApellidos.getText(),txtContraseña.getText(),txtRfc.getText());
        txtApellidos.clear();
        txtApellidos.clear();
        txtUsuario.clear();
        txtRfc.clear();
        txtContraseña.clear();
        List<Empleado> empleados=empleadosServicio.MostrarTodos();
        ObservableList<Empleado> observableEmp = FXCollections.observableArrayList(empleados);
        id_empT.setCellValueFactory(new PropertyValueFactory<>("idempleado"));
        usuario_empT.setCellValueFactory(new PropertyValueFactory<>("username"));
        rfc_empT.setCellValueFactory(new PropertyValueFactory<>("rfc_emp"));
        apellidos_empT.setCellValueFactory(new PropertyValueFactory<>("apellidos_empleado"));
        puesto_empT.setCellValueFactory(new PropertyValueFactory<>("puesto_emp"));
        tableEmpleados.setItems(observableEmp);
        tableEmpleados.refresh();
    }

    public void MenuInicio(ActionEvent actionEvent) {
        SalidaSesiones salidaSesiones=new SalidaSesiones();
        salidaSesiones.InicioCarga(btnInicio);
    }

    public void MenuProductos(ActionEvent actionEvent) {
    }

    public void MenuEmpleados(ActionEvent actionEvent) {
        SalidaSesiones salidaSesiones=new SalidaSesiones();
        salidaSesiones.EmpleadosCarga(btnEmpleados);
    }

    public void MenuProveedores(ActionEvent actionEvent) {
    }

    public void MenuClientes(ActionEvent actionEvent) {
    }

    public void MenuVentas(ActionEvent actionEvent) {
    }
}
