package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Repositorios.RepositorioDetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaServicio {
    @Autowired
    RepositorioDetalleVenta  repositorioDetalleVenta;
}
