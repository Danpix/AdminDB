package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Modelos.Venta;
import com.ProyectoDB.AdminDB.Servicios.VentaSevicio;
import com.ProyectoDB.AdminDB.repetidas.SalidaSesiones;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.ProyectoDB.AdminDB.Main.context;

@Controller
public class ControllerVenta {
    public Button btnInicio;
    public Button btnProductos;
    public Button btnVentas;
    public Button btnClientes;
    public Button btnProveedores;
    public Button btnEmpleados;
    public TableView<Venta> tableVentas;
    public TableColumn folio_venta;
    public TableColumn fecha;
    public TableColumn total;
    public TableColumn<Venta, String> id_empl;
    public TableColumn<Venta, String> id_cliente;

    public Button btnEliminar;

    public TextField txtCliente;
    public Button btnSalir;
    public TextField txtBuscador;
    public Button btnBuscar;
    public Button btnCerrarSesion;
    public TextField txtFecha;
    public TextField txtTotal;
    public TextField txtFolio;
    public TextField txtEmp;
    SalidaSesiones salidaSesiones;

    @Autowired
    VentaSevicio ventaSevicio;
    public int idSeleccionado;
    public void MenuInicio(ActionEvent actionEvent) {
        this.salidaSesiones = new SalidaSesiones();
        salidaSesiones.InicioCarga(btnInicio);
    }

    public void MenuProductos(ActionEvent actionEvent) {
        this.salidaSesiones = new SalidaSesiones();
        salidaSesiones.ProductosCarga(btnProductos);
    }

    public void MenuVentas(ActionEvent actionEvent) {
        this.salidaSesiones = new SalidaSesiones();
        salidaSesiones.VentaCarga(btnVentas);
    }

    public void MenuClientes(ActionEvent actionEvent) {
        this.salidaSesiones = new SalidaSesiones();
        salidaSesiones.ClientesCarga(btnClientes);
    }

    public void MenuProveedores(ActionEvent actionEvent) {
        this.salidaSesiones = new SalidaSesiones();
        salidaSesiones.ProveedoresCarga(btnProveedores);
    }

    public void MenuEmpleados(ActionEvent actionEvent) {
        this.salidaSesiones = new SalidaSesiones();
        salidaSesiones.EmpleadosCarga(btnEmpleados);
    }

    public void Seleccionar(MouseEvent mouseEvent) {

        Venta emp = this.tableVentas.getSelectionModel().getSelectedItem();
        idSeleccionado=emp.getFolioventa();
        txtFolio.setText(emp.getFolioventa().toString());
        txtCliente.setText(emp.getCliente().getNombre_cliente());
        txtFecha.setText(emp.getFecha().toString());
        txtEmp.setText(emp.getEmpleado().getUsername());
        txtTotal.setText(emp.getTotal().toString());
    }
    public void MostrarTodos(ObservableList<Venta> ventas){
        id_cliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre_cliente()));
        id_empl.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleado().getUsername()));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        folio_venta.setCellValueFactory(new PropertyValueFactory<>("folioventa"));
        tableVentas.setItems(ventas);
        tableVentas.refresh();
    }


    public void Eliminar(ActionEvent actionEvent) {
        ventaSevicio.eliminarProducto(idSeleccionado);
        tableVentas.refresh();
        txtCliente.clear();
        txtTotal.clear();
        txtFecha.clear();
        txtFolio.clear();
        txtEmp.clear();
        List<Venta> venta=ventaSevicio.mostrarTodo();
        ObservableList<Venta> observablevtn = FXCollections.observableArrayList(venta);
        id_cliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre_cliente()));
        id_empl.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleado().getUsername()));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        folio_venta.setCellValueFactory(new PropertyValueFactory<>("folioventa"));
        tableVentas.setItems(observablevtn);
        tableVentas.refresh();
    }

    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Buscar(ActionEvent actionEvent) {
    }

    public void CerrarSesion(ActionEvent actionEvent) {
        this.salidaSesiones = new SalidaSesiones();
        salidaSesiones.InicioSesion(btnCerrarSesion);
    }
}
