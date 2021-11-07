
package com.Final.demo.servicios;

import com.Final.demo.modelos.e.Departamentos;
import com.Final.demo.modelos.r.InDepartamentoR;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gredys Morales
 */



@Service
public class DepartamentosImp implements InDepartamentoServicios{
    
   final InDepartamentoR departamentoRepository;

    @Autowired
    public DepartamentosImp(InDepartamentoR departamentoRepository){
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public List<Departamentos> listar() {
        return (List<Departamentos>) departamentoRepository.findAll();
    }

    @Override
    public void guardar(Departamentos departamento) {
        departamentoRepository.save(departamento);
    }

    @Override
    public Departamentos buscarPorId(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        departamentoRepository.deleteById(id);
    }
}

