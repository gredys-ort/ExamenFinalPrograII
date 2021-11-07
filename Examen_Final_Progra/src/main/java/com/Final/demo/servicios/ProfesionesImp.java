package com.Final.demo.servicios;

import com.Final.demo.modelos.e.Profesiones;
import com.Final.demo.modelos.r.InProfesionR;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gredys Morales 
 */



@Service
public class ProfesionesImp implements InProfesionServicios{
     final InProfesionR profesionRepository;

    @Autowired
    public ProfesionesImp(InProfesionR profesionRepository){
        this.profesionRepository = profesionRepository;
    }

    @Override
    public List<Profesiones> listar() {
        return (List<Profesiones>) profesionRepository.findAll();
    }

    @Override
    public void guardar(Profesiones profesion) {
        profesionRepository.save(profesion);
    }

    @Override
    public Profesiones buscarPorId(Long id) {
        return profesionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        profesionRepository.deleteById(id);
    }
    
}
