package com.Final.demo.servicios;

import com.Final.demo.modelos.e.Profesiones;
import java.util.List;

/**
 *
 * @author Gredys Morales
 */
public interface InProfesionServicios {
    List<Profesiones> listar();
    void guardar(Profesiones profesion);
    Profesiones buscarPorId(Long id);
    void eliminar(Long id);
    
}
