package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Cliente;
import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Modelos.Proveedor;
import com.ProyectoDB.AdminDB.Servicios.ProveedorServicio;
import com.ProyectoDB.AdminDB.repetidas.SalidaSesiones;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ControllerProveedorMenu {
    @Autowired
    public ProveedorServicio proveedorServicio;
    public Button btnInicio;
    public Button btnProductos;
    public Button btnVentas;
    public Button btnClientes;
    public Button btnProveedores;
    public Button btnEmpleados;
    public TableView<Proveedor> tableProveedor;
    public TableColumn id_ProvT;
    public TableColumn nombre_ProvT;
    public TableColumn telefono_ProvT;
    public TableColumn email_ProvT;
    public TextField txtTelefono;
    public TextField txtNombre;
    public TextField txtEmail;
    public Button btnGuardarDatos;
    public Button btnEliminar;
    public Button btnModificar;
    public Button btnSalir;
    public TextField txtBuscador;
    public Button btnBuscar;
    public Button btnCerrarSesion;
    public int idSeleccionado;
    public SalidaSesiones salidaSesiones;


    public void MostrarTodos(ObservableList<Proveedor> proveedors){
        id_ProvT.setCellValueFactory(new PropertyValueFactory<>("idproveedor"));
        nombre_ProvT.setCellValueFactory(new PropertyValueFactory<>("nombre_prov"));
        email_ProvT.setCellValueFactory(new PropertyValueFactory<>("email_prov"));
        telefono_ProvT.setCellValueFactory(new PropertyValueFactory<>("telefono_prov"));
        tableProveedor.setItems(proveedors);
        tableProveedor.refresh();
    }
    public void ModificarProveedor(ActionEvent actionEvent) {
        proveedorServicio.modificarProveedor(idSeleccionado,txtNombre.getText(),txtTelefono.getText(),txtEmail.getText());
        txtNombre.clear();
        txtTelefono.clear();
        txtEmail.clear();
        List<Proveedor> proveedors=proveedorServicio.mostrartodos();
        ObservableList<Proveedor> observableEmp = FXCollections.observableArrayList(proveedors);
        id_ProvT.setCellValueFactory(new PropertyValueFactory<>("idproveedor"));
        nombre_ProvT.setCellValueFactory(new PropertyValueFactory<>("nombre_prov"));
        email_ProvT.setCellValueFactory(new PropertyValueFactory<>("email_prov"));
        telefono_ProvT.setCellValueFactory(new PropertyValueFactory<>("telefono_prov"));
        tableProveedor.setItems(observableEmp);
        tableProveedor.refresh();
    }

    public void Eliminar(ActionEvent actionEvent) {
        proveedorServicio.eliminarProveedor(idSeleccionado);
        tableProveedor.refresh();
        txtNombre.clear();
        txtTelefono.clear();
        txtEmail.clear();
        List<Proveedor> proveedors=proveedorServicio.mostrartodos();
        ObservableList<Proveedor> observableEmp = FXCollections.observableArrayList(proveedors);
        id_ProvT.setCellValueFactory(new PropertyValueFactory<>("idproveedor"));
        nombre_ProvT.setCellValueFactory(new PropertyValueFactory<>("nombre_prov"));
        email_ProvT.setCellValueFactory(new PropertyValueFactory<>("email_prov"));
        telefono_ProvT.setCellValueFactory(new PropertyValueFactory<>("telefono_prov"));
        tableProveedor.setItems(observableEmp);
        tableProveedor.refresh();
    }

    public void GuardarProveedor(ActionEvent actionEvent) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre_prov(txtNombre.getText());
        proveedor.setEmail_prov(txtEmail.getText());
        proveedor.setTelefono_prov(txtTelefono.getText());

        proveedorServicio.GuardarProveedor(proveedor);
        txtNombre.clear();
        txtEmail.clear();
        txtTelefono.clear();
        List<Proveedor> proveedors=proveedorServicio.mostrartodos();
        ObservableList<Proveedor> observablecli = FXCollections.observableArrayList(proveedors);
        id_ProvT.setCellValueFactory(new PropertyValueFactory<>("idproveedor"));
        nombre_ProvT.setCellValueFactory(new PropertyValueFactory<>("nombre_prov"));
        email_ProvT.setCellValueFactory(new PropertyValueFactory<>("email_prov"));
        telefono_ProvT.setCellValueFactory(new PropertyValueFactory<>("telefono_prov"));
        tableProveedor.setItems(observablecli);
        tableProveedor.refresh();
    }

    public void Seleccionar(MouseEvent mouseEvent) {
        Proveedor proveedor = this.tableProveedor.getSelectionModel().getSelectedItem();
        idSeleccionado=proveedor.getIdproveedor();
        txtNombre.setText(proveedor.getNombre_prov());
        txtTelefono.setText(proveedor.getTelefono_prov());
        txtEmail.setText(proveedor.getEmail_prov());

    }

    public void MenuEmpleados(ActionEvent actionEvent) {
        salidaSesiones.EmpleadosCarga(btnEmpleados);
    }

    public void MenuProveedores(ActionEvent actionEvent) {
        salidaSesiones.ProveedoresCarga(btnProveedores);
    }

    public void MenuClientes(ActionEvent actionEvent) {
        salidaSesiones.ClientesCarga(btnClientes);
    }

    public void MenuVentas(ActionEvent actionEvent) {

        salidaSesiones.VentaCarga(btnVentas);
    }

    public void MenuProductos(ActionEvent actionEvent) {
        salidaSesiones.ProductosCarga(btnProductos);
    }

    public void MenuInicio(ActionEvent actionEvent) {
        this.salidaSesiones = new SalidaSesiones();
        salidaSesiones.InicioCarga(btnInicio);
    }

    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Buscar(ActionEvent actionEvent) {
    }

    public void CerrarSesion(ActionEvent actionEvent) {
        salidaSesiones.InicioSesion(btnCerrarSesion);
    }
}
