package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Servicios.EmpleadosServicio;
import com.ProyectoDB.AdminDB.Servicios.ProductoServicio;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public Button btnCerrarSesion;
    public TableView<Producto> tableview;

    public TableColumn id_producto;
    public TableColumn nombre_producto;
    public TableColumn precio_venta;
    public TableColumn unidades_existencia;


    public TextField txtBuscador;
    public int bufer;
    public int tamaño;
    public TableColumn cantidad;
    public TableColumn subtotal;
    public Button btnBuscar;

    public void CerrarSesion(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesionB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) btnCerrarSesion.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }
    }

    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }



    public void Buscar(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/BuscarProductos.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) btnBuscar.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");


        }

    }

    public void setProductosObservableList(ObservableList<Producto> productos) {
        id_producto.setCellValueFactory(new PropertyValueFactory<>("idproducto"));
        nombre_producto.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
        unidades_existencia.setCellValueFactory(new PropertyValueFactory<>("unidades_existencia"));
        precio_venta.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));
        tableview.setItems(productos);
        tableview.refresh();
    }
}
