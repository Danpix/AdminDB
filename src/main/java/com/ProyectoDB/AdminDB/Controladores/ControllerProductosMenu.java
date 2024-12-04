package com.ProyectoDB.AdminDB.Controladores;

import com.ProyectoDB.AdminDB.Modelos.Categoria;
import com.ProyectoDB.AdminDB.Modelos.Cliente;
import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Servicios.CategoriaServicio;
import com.ProyectoDB.AdminDB.Servicios.ProductoServicio;
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
import java.util.Optional;

@Controller
public class ControllerProductosMenu {
    @Autowired
    public ProductoServicio productoServicio;
    @Autowired
    public CategoriaServicio categoriaServicio;
    public Button btnInicio;
    public Button btnProductos;
    public Button btnVentas;
    public Button btnClientes;
    public Button btnProveedores;
    public Button btnEmpleados;
    public TableView<Producto> tableProductos;
    public TableColumn id_prodT;
    public TableColumn nombre_prodT;
    public TableColumn unidadesExistT;
    public TableColumn precio_compraT;
    public TableColumn precio_ventaT;
    public Button btnEliminar;
    public Button btnModificar;
    public Button btnSalir;
    public TextField txtBuscador;
    public Button btnBuscar;
    public Button btnCerrarSesion;
    public TextField txtNombre;
    public Button btnGuardarDatos;
    public TextField txtPrecioCompra;
    public TextField txtPrecioVenta;
    public ComboBox cmbCategoria;
    public TextField txtUnidades;
    public SalidaSesiones salidaSesiones;
    public int idSeleccionado;
    public int idCategoria;
    public TableColumn categoriaT;


    public void MostrarTodos(ObservableList<Producto> productos){
        id_prodT.setCellValueFactory(new PropertyValueFactory<>("idproducto"));
        nombre_prodT.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
        precio_compraT.setCellValueFactory(new PropertyValueFactory<>("precio_compra"));
        precio_ventaT.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));
        unidadesExistT.setCellValueFactory(new PropertyValueFactory<>("unidades_existencia"));
        tableProductos.setItems(productos);
        tableProductos.refresh();
    }

    public void MenuInicio(ActionEvent actionEvent) {
        salidaSesiones.InicioCarga(btnInicio);
    }

    public void MenuProductos(ActionEvent actionEvent) {
        salidaSesiones.ProductosCarga(btnProductos);
    }

    public void MenuVentas(ActionEvent actionEvent) {
    }

    public void Seleccionar(MouseEvent mouseEvent) {
        Producto producto = this.tableProductos.getSelectionModel().getSelectedItem();
        idSeleccionado=producto.getIdproducto();
        idCategoria=producto.getCategoria().getIdcategoria();
        txtNombre.setText(producto.getNombreproducto());
        txtUnidades.setText(producto.getUnidades_existencia().toString());
        txtPrecioCompra.setText(producto.getPrecio_compra().toString());
        txtPrecioVenta.setText(producto.getPrecio_venta().toString());


    }

    public void MenuEmpleados(ActionEvent actionEvent) {
    }

    public void GuardarProducto(ActionEvent actionEvent) {
        Producto producto = new Producto();
        producto.setPrecio_venta(Integer.parseInt(txtPrecioVenta.getText()));
        // Obtener el ID de la categoría (por ejemplo, de un ComboBox)
        int idCategoria = cmbCategoria.getSelectionModel().getSelectedIndex();

// Buscar la categoría en tu servicio o repositorio

        Optional<Categoria> categoriaSeleccionada = categoriaServicio.EncontrarPorID(idCategoria);

        if (categoriaSeleccionada.isPresent()) {
            producto.setCategoria(categoriaSeleccionada.get());
        } else {
            throw new IllegalArgumentException("La categoría con ID " + idCategoria + " no existe.");
        }
        producto.setNombreproducto(txtNombre.getText());
        producto.setUnidades_existencia(Integer.parseInt(txtUnidades.getText()));
        producto.setPrecio_compra(Integer.parseInt(txtPrecioCompra.getText()));

        productoServicio.GuardarProducto(producto);
        txtPrecioCompra.clear();
        txtPrecioVenta.clear();
        txtNombre.clear();
        txtUnidades.clear();

        List<Producto> productos=productoServicio.mostrartodos();
        ObservableList<Producto> observableProd = FXCollections.observableArrayList(productos);
        id_prodT.setCellValueFactory(new PropertyValueFactory<>("idproducto"));
        nombre_prodT.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
        precio_compraT.setCellValueFactory(new PropertyValueFactory<>("precio_compra"));
        precio_ventaT.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));
        unidadesExistT.setCellValueFactory(new PropertyValueFactory<>("unidades_existencia"));
        tableProductos.setItems(observableProd);
        tableProductos.refresh();
    }

    public void ModificarProducto(ActionEvent actionEvent) {
        productoServicio.modificarProducto(idSeleccionado,txtNombre.getText(),Integer.parseInt(txtPrecioVenta.getText()),Integer.parseInt(txtPrecioCompra.getText()),idCategoria,Integer.parseInt(txtUnidades.getText()));
        txtUnidades.clear();
        txtNombre.clear();
        txtPrecioVenta.clear();
        txtPrecioCompra.clear();
        List<Producto> productos=productoServicio.mostrartodos();
        ObservableList<Producto> observableprod = FXCollections.observableArrayList(productos);
        id_prodT.setCellValueFactory(new PropertyValueFactory<>("idproducto"));
        nombre_prodT.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
        precio_compraT.setCellValueFactory(new PropertyValueFactory<>("precio_compra"));
        precio_ventaT.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));
        unidadesExistT.setCellValueFactory(new PropertyValueFactory<>("unidades_existencia"));
        tableProductos.setItems(observableprod);
        tableProductos.refresh();
    }

    public void Eliminar(ActionEvent actionEvent) {
        productoServicio.eliminarProducto(idSeleccionado);
        tableProductos.refresh();
        txtPrecioVenta.clear();
        txtNombre.clear();
        txtUnidades.clear();
        txtPrecioCompra.clear();
        List<Producto> productos=productoServicio.mostrartodos();
        ObservableList<Producto> observableEmp = FXCollections.observableArrayList(productos);
        id_prodT.setCellValueFactory(new PropertyValueFactory<>("idproducto"));
        nombre_prodT.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
        precio_compraT.setCellValueFactory(new PropertyValueFactory<>("precio_compra"));
        precio_ventaT.setCellValueFactory(new PropertyValueFactory<>("precio_venta"));
        unidadesExistT.setCellValueFactory(new PropertyValueFactory<>("unidades_existencia"));
        tableProductos.setItems(observableEmp);
        tableProductos.refresh();
    }

    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Buscar(ActionEvent actionEvent) {
    }
    public void CerrarSesion(ActionEvent actionEvent) {
        salidaSesiones.InicioSesion(btnCerrarSesion);
    }

    public void MenuProveedores(ActionEvent actionEvent) {
        salidaSesiones.ProveedoresCarga(btnProveedores);
    }

    public void MenuClientes(ActionEvent actionEvent) {
        salidaSesiones.ClientesCarga(btnClientes);
    }
}
