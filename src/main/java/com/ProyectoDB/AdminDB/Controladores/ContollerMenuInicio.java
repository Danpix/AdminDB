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
    public TableView tableview;

    public TableColumn id_producto;
    public TableColumn nombre_producto;
    public TableColumn precio_venta;
    public TableColumn unidades_existencia;
    @Autowired
    public ProductoServicio productoServicio;

    public MenuItem modiProd;

    public TextField txtBuscador;
    public int bufer;
    public int tamaño;
    public TableColumn cantidad;
    public TableColumn subtotal;

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
        modiProd.getOnAction();
            System.out.println("Hoa");


    }


    public void Buscar(ActionEvent actionEvent) {

        List<Producto> productos = productoServicio.buscarNombre(txtBuscador.getText());
//        List<Producto> productos = productoServicio.obtenerTodosLosProductos();
        tamaño=productos.size();
        ObservableList<Producto> observableProductos = FXCollections.observableArrayList(productos);


        id_producto.setCellValueFactory(new PropertyValueFactory<>("id_producto"));

        nombre_producto.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
        for (int i=0;i<tamaño;i++){

            System.out.println(bufer);
            cantidad.setCellValueFactory(ellData -> {

                bufer= productos.getFirst().getUnidades_existencia();
                return new SimpleIntegerProperty(bufer).asObject();  // Devuelve el valor de 'bufer'

            });

        }
        unidades_existencia.setCellValueFactory(new PropertyValueFactory<>("unidades_existencia"));

        precio_venta.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));

        tableview.setItems(observableProductos);
    }
}
