package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Servicios.EmpleadosServicio;
import com.ProyectoDB.AdminDB.Servicios.ProductoServicio;
import com.ProyectoDB.AdminDB.repetidas.SalidaSesiones;
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
    @Autowired
    public EmpleadosServicio empleadosServicio;
    public TableColumn id_producto;
    public TableColumn nombre_producto;
    public TableColumn precio_venta;
    public TableColumn unidades_existencia;


    public TextField txtBuscador;
    public TableColumn cantidad;
    public TableColumn subtotal;
    public Button btnBuscar;
    public MenuItem mIModificarEmp;

    public void CerrarSesion(ActionEvent actionEvent) {
        SalidaSesiones sal = new SalidaSesiones();
        sal.InicioSesion(btnCerrarSesion);
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

    public void ModificarClientes(ActionEvent actionEvent) {
        List<Empleado> emp=empleadosServicio.MostrarTodos();
        ObservableList<Empleado> observableEmp = FXCollections.observableArrayList(emp);



        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/EmpledosMenu.fxml"));
        loader.setControllerFactory(context::getBean);
        try {
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) btnBuscar.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();

            stage.show();
            ControllerEmpleadosMenu controllerEmpleadosMenu = loader.getController();
            controllerEmpleadosMenu.MostrarTodos(observableEmp);
        } catch (IOException e) {
            System.out.println("GG el proyecto fallo");
        }

    }
}
