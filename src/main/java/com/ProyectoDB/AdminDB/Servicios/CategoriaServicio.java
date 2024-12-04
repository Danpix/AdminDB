package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Modelos.Categoria;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioCategoria;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    public RepositorioCategoria repositorioCategoria;

    public List<String>obtenerNombre(Integer idCategoria){
        return repositorioCategoria.findNombreCategoriaByIdCategoria(idCategoria);
    }
    public Optional<Categoria>EncontrarPorID(Integer idCategoria){
        return repositorioCategoria.findByIdcategoria(idCategoria);
    }
}
