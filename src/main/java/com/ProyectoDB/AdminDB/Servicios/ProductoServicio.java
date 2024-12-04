package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Modelos.Categoria;
import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Modelos.Proveedor;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioCategoria;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    public RepositorioProducto repositorioProducto;
    @Autowired
    RepositorioCategoria repositorioCategoria;
    public List<Producto> obtenerTodosLosProductos() {
        return repositorioProducto.findAll();
    }
    public List<Producto> buscarNombre(String nombre_producto){
        return repositorioProducto.findByNombreproductoContainingIgnoreCase(nombre_producto);
    }
    public Optional<Producto> BuscarPorID(Integer idprod){
        return repositorioProducto.findByIdproducto(idprod);
    }

    public List<Producto> mostrartodos(){
        return repositorioProducto.findAll();
    }
    public void GuardarProducto(Producto producto){
        repositorioProducto.save(producto);
    }
    public void eliminarProducto(Integer id){
        repositorioProducto.deleteByIdproducto(id);
    }
    public Producto modificarProducto(Integer id, String nombre, Integer precio_venta, Integer precio_compra, Integer categoria_id, Integer unidadesExistencia) {
// Buscar el producto por su ID
        Optional<Producto> productoOptional = repositorioProducto.findByIdproducto(id);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();

            // Buscar la categoría asociada
            Optional<Categoria> categoriaOptional = repositorioCategoria.findByIdcategoria(categoria_id);
            if (categoriaOptional.isPresent()) {
                Categoria categoria = categoriaOptional.get();

                // Actualizar los campos del producto
                producto.setNombreproducto(nombre);
                producto.setPrecio_compra(precio_compra);
                producto.setPrecio_venta(precio_venta);
                producto.setCategoria(categoria);
                producto.setUnidades_existencia(unidadesExistencia);

                return repositorioProducto.save(producto); // Guarda los cambios
            } else {
                throw new IllegalArgumentException("La categoría con ID " + categoria_id + " no existe.");
            }
        } else {
            throw new IllegalArgumentException("El producto con ID " + id + " no existe.");
        }
    }


    public List<String> obtenerCategoriasDeProductos() {
        // Obtener todos los productos
        List<Producto> productos = repositorioProducto.findAll();

        // Crear una lista para almacenar las categorías
        List<String> categorias = new ArrayList<>();

        // Recorrer los productos y obtener el nombre de la categoría
        for (Producto producto : productos) {
            Categoria categoria = producto.getCategoria();
            if (categoria != null) {
                categorias.add(categoria.getNombrecategoria());
            } else {
                categorias.add("Producto: " + producto.getNombreproducto() + ", Categoría: No asignada");
            }
        }

        return categorias;
    }


}
