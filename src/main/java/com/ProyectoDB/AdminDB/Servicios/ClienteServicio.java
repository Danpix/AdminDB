package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Modelos.Cliente;
import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    RepositorioClientes repositorioClientes;
    public List<Cliente> mostrartodos(){
        return repositorioClientes.findAll();
    }
    public void GuardarCliente(Cliente cliente){
        repositorioClientes.save(cliente);
    }
    public void eliminarCliente(Integer id){
        repositorioClientes.deleteByIdcliente(id);
    }
    public Cliente modificarCliente(Integer id, String nombre, String apellido, String telefono, String email) {

        Optional<Cliente> usuarioOptional = repositorioClientes.findByIdcliente(id);

        if (usuarioOptional.isPresent()) {
            // Si el usuario existe, actualiza los campos
            Cliente cliente = usuarioOptional.get();
            cliente.setNombre_cliente(nombre);
            cliente.setApellidos_cliente(apellido);
            cliente.setTelefono_cliente(telefono);
            cliente.setEmail_cliente(email);
            return repositorioClientes.save(cliente); // Guarda los cambios
        } else {
            throw new IllegalArgumentException("El usuario con idcliente " + id + " no existe.");
        }
    }
    
}
