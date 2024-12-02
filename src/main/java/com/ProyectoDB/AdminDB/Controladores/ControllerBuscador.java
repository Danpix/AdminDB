package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Servicios.CategoriaServicio;
import com.ProyectoDB.AdminDB.Servicios.ProductoServicio;
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
public class ControllerBuscador {
    @Autowired
    public ProductoServicio productoServicio;
    @Autowired
    public CategoriaServicio categoriaServicio;
    @Autowired
    private ContollerMenuInicio contollerMenuInicio;

    public TextField txtBuscar;
    public TableView<Producto> tableProductos;
    public TableColumn nombre_producto;
    public TableColumn id_producto;
    public TableColumn precio_producto;
    public TableColumn categoria_producto;
    public TableColumn existencia_producto;
    public Button btnSalir;
    public int tamaño;
    public Integer idprodsel;
    private static ObservableList<Producto> productosSeleccionados = FXCollections.observableArrayList();

    public  Producto producsel;
    public void Buscar(ActionEvent actionEvent) {
        List<Producto> productos = productoServicio.buscarNombre(txtBuscar.getText());
        ObservableList<Producto> observableProductos = FXCollections.observableArrayList(productos);

        tamaño=productos.size();
        id_producto.setCellValueFactory(new PropertyValueFactory<>("idproducto"));

        nombre_producto.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));

        existencia_producto.setCellValueFactory(new PropertyValueFactory<>("unidades_existencia"));

        precio_producto.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));


        //.setCellValueFactory(new PropertyValueFactory<>("precio_venta") ); <------- pendiente subtotal y cantidad

        tableProductos.setItems(observableProductos);
    }

    public void Salir(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/MenuInicioB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) btnSalir.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");


        }
    }


    public void Seleccionar(MouseEvent mouseEvent) {
       Producto p = this.tableProductos.getSelectionModel().getSelectedItem();
        idprodsel=p.getIdproducto();


        List<Producto> productos = productoServicio.BuscarPorID(idprodsel);
        ObservableList<Producto> observableProductos = FXCollections.observableArrayList(productos);
        contollerMenuInicio.setProductosObservableList(observableProductos);

        productosSeleccionados.addAll(observableProductos);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/MenuInicioB.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) btnSalir.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

            // Obtén el controlador de la vista cargada
            ContollerMenuInicio contollerMenuInicio = loader.getController();

            // Actualiza la tabla en el controlador de la nueva vista
            contollerMenuInicio.setProductosObservableList(productosSeleccionados);
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }

    }


}
