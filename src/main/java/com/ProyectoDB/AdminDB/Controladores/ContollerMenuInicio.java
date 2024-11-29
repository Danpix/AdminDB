package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Servicios.EmpleadosServicio;
import com.ProyectoDB.AdminDB.Servicios.ProductoServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

import static com.ProyectoDB.AdminDB.Main.context;

@Controller
public class ContollerMenuInicio {
    public Button btnVender;
    public Button btnCerrarSesion;
    public ImageView btnBuscar;
    public TableView tableview;

    public TableColumn id_producto;
    public TableColumn nombre_producto;
    public TableColumn precio_venta;
    public TableColumn unidades_existencia;
    @Autowired
    public ProductoServicio productoServicio;

    public void CerrarSesion(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesion.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) btnCerrarSesion.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }

    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }



    public void Clientes(ActionEvent actionEvent) {
    }

    public void Proveedores(ActionEvent actionEvent) {
    }

    public void Ventas(ActionEvent actionEvent) {
    }

    public void Inicio(ActionEvent actionEvent) {
    }

    public void Empleados(ActionEvent actionEvent) {
    }

    public void ProductosMenu(ActionEvent actionEvent) {
    }

    public void Buscar(MouseEvent mouseEvent) {
        List<Producto> productos = productoServicio.obtenerTodosLosProductos();

        ObservableList<Producto> observableProductos = FXCollections.observableArrayList(productos);

        id_producto.setCellValueFactory(new PropertyValueFactory<>("id_producto"));

        nombre_producto.setCellValueFactory(new PropertyValueFactory<>("nombre_producto"));

        unidades_existencia.setCellValueFactory(new PropertyValueFactory<>("unidades_existencia"));

        precio_venta.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));

        tableview.setItems(observableProductos);
    }
}
