package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Modelos.*;
import com.ProyectoDB.AdminDB.Repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VentaSevicio {
    @Autowired
    private RepositorioVenta ventaRepository;

    public void GuardarVenta(Venta venta){
        ventaRepository.save(venta);
    }
    public List<Venta> mostrarTodo(){
        return ventaRepository.findAll();
    }
    public void eliminarProducto(Integer id){
        ventaRepository.deleteByFolioventa(id);
    }

}
