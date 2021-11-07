
package com.Final.demo.servicios;

import com.Final.demo.modelos.e.Departamentos;
import java.util.List;

/**
 *
 * @author Gredys Morales
 */
public interface InDepartamentoServicios {
    List<Departamentos> listar();
    void guardar(Departamentos departamento);
    Departamentos buscarPorId(Long id);
    void eliminar(Long id);
    
}
