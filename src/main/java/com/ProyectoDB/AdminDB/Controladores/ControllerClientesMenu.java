package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Cliente;
import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioClientes;
import com.ProyectoDB.AdminDB.Servicios.ClienteServicio;
import com.ProyectoDB.AdminDB.repetidas.SalidaSesiones;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ControllerClientesMenu {
    @Autowired
    private ClienteServicio clienteServicio;
    public Button btnInicio;
    public Button btnProductos;
    public Button btnVentas;
    public Button btnClientes;
    public Button btnProveedores;
    public Button btnEmpleados;
    public TableView<Cliente> tableClientes;
    public Button btnSalir;

    public Button btnEliminar;
    public Button btnModificar;
    public Button btnGuardarDatos;
    public TextField txtApellidos;

    public Button btnBuscar;
    public int idSeleccionado;
    public TextField txtTelefono;
    public TextField txtNombre;
    public TextField txtEmail;

    public Button btnCerrarSesion;
    public TableColumn id_cliT;
    public TableColumn apellidos_cliT;
    public TableColumn usuario_cliT;
    public TableColumn email_cliT;
    public TableColumn nombre_cliT;
    public TableColumn telefono_cliT;

    public void MostrarTodos(ObservableList<Cliente> clientes){
        id_cliT.setCellValueFactory(new PropertyValueFactory<>("idcliente"));
        nombre_cliT.setCellValueFactory(new PropertyValueFactory<>("nombre_cliente"));
        telefono_cliT.setCellValueFactory(new PropertyValueFactory<>("telefono_cliente"));
        apellidos_cliT.setCellValueFactory(new PropertyValueFactory<>("apellidos_cliente"));
        email_cliT.setCellValueFactory(new PropertyValueFactory<>("email_cliente"));
        tableClientes.setItems(clientes);
        tableClientes.refresh();
    }
    public void Seleccionar(MouseEvent mouseEvent) {
        Cliente cliente = this.tableClientes.getSelectionModel().getSelectedItem();
        idSeleccionado=cliente.getIdcliente();
        txtNombre.setText(cliente.getNombre_cliente());
        txtApellidos.setText(cliente.getApellidos_cliente());
        txtTelefono.setText(cliente.getTelefono_cliente());
        txtEmail.setText(cliente.getEmail_cliente());

    }
    public void MenuInicio(ActionEvent actionEvent) {
        SalidaSesiones sal = new SalidaSesiones();
        sal.InicioCarga(btnInicio);
    }

    public void MenuProductos(ActionEvent actionEvent) {
    }

    public void MenuVentas(ActionEvent actionEvent) {
    }

    public void MenuClientes(ActionEvent actionEvent) {
        SalidaSesiones sal = new SalidaSesiones();
        sal.ClientesCarga(btnClientes);
    }

    public void MenuProveedores(ActionEvent actionEvent) {
    }

    public void MenuEmpleados(ActionEvent actionEvent) {
        SalidaSesiones sal = new SalidaSesiones();
        sal.EmpleadosCarga(btnEmpleados);
    }



    public void Eliminar(ActionEvent actionEvent) {
        clienteServicio.eliminarCliente(idSeleccionado);
        tableClientes.refresh();
        txtApellidos.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtEmail.clear();
        List<Cliente> clientes=clienteServicio.mostrartodos();
        ObservableList<Cliente> observableEmp = FXCollections.observableArrayList(clientes);
        id_cliT.setCellValueFactory(new PropertyValueFactory<>("idcliente"));
        nombre_cliT.setCellValueFactory(new PropertyValueFactory<>("nombre_cliente"));
        telefono_cliT.setCellValueFactory(new PropertyValueFactory<>("telefono_cliente"));
        apellidos_cliT.setCellValueFactory(new PropertyValueFactory<>("apellidos_cliente"));
        email_cliT.setCellValueFactory(new PropertyValueFactory<>("email_cliente"));
        tableClientes.setItems(observableEmp);
        tableClientes.refresh();
    }



    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void ModificarCliente(ActionEvent actionEvent) {
        clienteServicio.modificarCliente(idSeleccionado,txtNombre.getText(),txtApellidos.getText(),txtTelefono.getText(),txtEmail.getText());
        txtApellidos.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtEmail.clear();
        List<Cliente> clientes=clienteServicio.mostrartodos();
        ObservableList<Cliente> observableEmp = FXCollections.observableArrayList(clientes);
        id_cliT.setCellValueFactory(new PropertyValueFactory<>("idcliente"));
        nombre_cliT.setCellValueFactory(new PropertyValueFactory<>("nombre_cliente"));
        telefono_cliT.setCellValueFactory(new PropertyValueFactory<>("telefono_cliente"));
        apellidos_cliT.setCellValueFactory(new PropertyValueFactory<>("apellidos_cliente"));
        email_cliT.setCellValueFactory(new PropertyValueFactory<>("email_cliente"));
        tableClientes.setItems(observableEmp);
        tableClientes.refresh();
    }

    public void GuardarCliente(ActionEvent actionEvent) {
        Cliente cliente = new Cliente();
        cliente.setApellidos_cliente(txtApellidos.getText());
        cliente.setNombre_cliente(txtNombre.getText());
        cliente.setEmail_cliente(txtEmail.getText());
        cliente.setTelefono_cliente(txtTelefono.getText());
        clienteServicio.GuardarCliente(cliente);
        txtApellidos.clear();
        txtNombre.clear();
        txtEmail.clear();
        txtTelefono.clear();
        List<Cliente> clientes=clienteServicio.mostrartodos();
        ObservableList<Cliente> observablecli = FXCollections.observableArrayList(clientes);
        id_cliT.setCellValueFactory(new PropertyValueFactory<>("idcliente"));
        nombre_cliT.setCellValueFactory(new PropertyValueFactory<>("nombre_cliente"));
        telefono_cliT.setCellValueFactory(new PropertyValueFactory<>("telefono_cliente"));
        apellidos_cliT.setCellValueFactory(new PropertyValueFactory<>("apellidos_cliente"));
        email_cliT.setCellValueFactory(new PropertyValueFactory<>("email_cliente"));
        tableClientes.setItems(observablecli);
        tableClientes.refresh();
    }

    public void Buscar(ActionEvent actionEvent) {
        SalidaSesiones sal = new SalidaSesiones();
        sal.BuscadorP(btnBuscar);
    }

    public void CerrarSesion(ActionEvent actionEvent) {
        SalidaSesiones sal = new SalidaSesiones();
        sal.InicioSesion(btnCerrarSesion);
    }
}
