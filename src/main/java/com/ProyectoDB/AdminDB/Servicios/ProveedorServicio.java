package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Modelos.Categoria;
import com.ProyectoDB.AdminDB.Modelos.Cliente;
import com.ProyectoDB.AdminDB.Modelos.Proveedor;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioCategoria;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioClientes;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServicio {

    @Autowired
    RepositorioProveedor repositorioProveedor;

    public List<Proveedor> mostrartodos(){
        return repositorioProveedor.findAll();
    }
    public void GuardarProveedor(Proveedor proveedor){
        repositorioProveedor.save(proveedor);
    }
    public void eliminarProveedor(Integer id){
        repositorioProveedor.deleteByIdproveedor(id);
    }
    public Proveedor modificarCliente(Integer id, String nombre, String apellido, String telefono, String email) {

        Optional<Proveedor> usuarioOptional = repositorioProveedor.findByIdproveedor(id);

        if (usuarioOptional.isPresent()) {

            // Si el usuario existe, actualiza los campos
            Proveedor proveedor = usuarioOptional.get();
            proveedor.setNombre_prov(nombre);
            proveedor.setTelefono_prov(telefono);
            proveedor.setEmail_prov(email);
            return repositorioProveedor.save(proveedor); // Guarda los cambios
        } else {
            throw new IllegalArgumentException("El usuario con idProveedor " + id + " no existe.");
        }
    }
}
