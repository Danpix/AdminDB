package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    public RepositorioProducto repositorioProducto;

    public List<Producto> obtenerTodosLosProductos() {
        return repositorioProducto.findAll();
    }
    public List<Producto> buscarNombre(String nombre_producto){
        return repositorioProducto.findByNombreproductoContainingIgnoreCase(nombre_producto);
    }
    public List<Producto> BuscarPorID(Integer idprod){
        return repositorioProducto.findByIdproducto(idprod);
    }


}
