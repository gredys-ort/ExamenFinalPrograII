package com.Final.demo.modelos.r;

import com.Final.demo.modelos.e.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gredys Morales
 */

@Repository
public interface InUsuarioR extends CrudRepository<Usuarios, Long> {
    
}
