package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Cliente;
import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Modelos.Venta;
import com.ProyectoDB.AdminDB.Servicios.ClienteServicio;
import com.ProyectoDB.AdminDB.Servicios.EmpleadosServicio;
import com.ProyectoDB.AdminDB.Servicios.VentaSevicio;
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
import java.util.Date;
import java.util.Optional;

import static com.ProyectoDB.AdminDB.Main.context;

@Controller
public class ControllerDetalleVenta {
    @Autowired
    public ClienteServicio clienteServicio;
    @Autowired
    public VentaSevicio ventaSevicio;
    public Label txttotal;
    @Autowired
    EmpleadosServicio empleadosServicio;
    public Button btnSalirDetalle;
    public Button btnVenta;
    public TableColumn idProdT;
    public TableColumn nombreProdT;
    public TableColumn precioProdT;
    public TableColumn idClienteT;
    public TableColumn nombreClienteT;
    public TableColumn apellidosClienteT;
    public TableColumn telefonoClienteT;
    public TableView<Cliente> tableCliente;
    public TableView<Producto> tableProductos;
    public Integer idSeleccionado;
    public int id_empleadoActual=1;//<------------ empleado por defecto
    public ObservableList<Producto> productosCarrito;
    int sum=0;
    @Autowired
    public ControllerInicio inicio;

    public void DesplegarTodo(ObservableList<Producto> carrito,ObservableList<Cliente> clientes){
         sum=0;
        productosCarrito=carrito; //<----------------------- SUMA DE PRECIOS
        for (Producto producto : productosCarrito){
            sum += producto.getPrecio_venta();
        }
        txttotal.setText("$ " + sum);
        //-----------------------------------------------------------------------------
        idProdT.setCellValueFactory(new PropertyValueFactory<>("idproducto"));
        nombreProdT.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
        precioProdT.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));
        tableProductos.setItems(carrito);
        tableProductos.refresh();
        //-------------------------------------------------------------------------------
        idClienteT.setCellValueFactory(new PropertyValueFactory<>("idcliente"));
        nombreClienteT.setCellValueFactory(new PropertyValueFactory<>("nombre_cliente"));
        telefonoClienteT.setCellValueFactory(new PropertyValueFactory<>("telefono_cliente"));
        apellidosClienteT.setCellValueFactory(new PropertyValueFactory<>("apellidos_cliente"));
        tableCliente.setItems(clientes);
        tableCliente.refresh();

    }
    public void CancelarVenta(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDBI/MenuInicioB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) btnSalirDetalle.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();


        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }

    public void RealizarVenta(ActionEvent actionEvent) {
        id_empleadoActual=inicio.devolverIdempledoActual();
        System.out.println(id_empleadoActual);
        Optional empleado=empleadosServicio.encontrarIDsolo(id_empleadoActual);
        Optional cliente=clienteServicio.encontrarporid(idSeleccionado);
        if (empleado.isPresent() || cliente.isPresent()){
            Cliente clientes =(Cliente) cliente.get();
            Empleado emp= (Empleado) empleado.get();

            Venta venta = new Venta();
            venta.setFecha(new Date());
            venta.setEmpleado(emp);
            venta.setCliente(clientes);
            venta.setTotal(sum);
            venta.setDetalleVenta(null);
            ventaSevicio.GuardarVenta(venta);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("VENTA REALIZADA");
            alert.setHeaderText(null); // Puedes personalizar el encabezado si lo necesitas
            alert.setContentText("VENTA REALIZADA CON EXITO");
            alert.showAndWait();
        }


    }

    public void seleccionCliente(MouseEvent mouseEvent) {
        Cliente cliente = this.tableCliente.getSelectionModel().getSelectedItem();
        idSeleccionado=cliente.getIdcliente();
    }

}
