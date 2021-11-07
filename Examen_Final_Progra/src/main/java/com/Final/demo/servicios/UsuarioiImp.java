package com.Final.demo.servicios;

import com.Final.demo.modelos.e.UsuarioDepartamento;
import com.Final.demo.modelos.e.Usuarios;
import com.Final.demo.modelos.r.InUsuarioR;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gredys Morales
 */

@Service
public class UsuarioiImp implements InUsuarioServicios{
    final InUsuarioR usuarioRepository;

    @Autowired
    public UsuarioiImp(InUsuarioR usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuarios> listarUsuarios() {
        return (List<Usuarios>) usuarioRepository.findAll();
    }

    @Override
    public void guardar(Usuarios usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuarios buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioDepartamento> obtenerUsuariosDto() {
        List<UsuarioDepartamento> usuariofinal = new ArrayList<>();
        List<Usuarios> usuarios = (List<Usuarios>) usuarioRepository.findAll();

        if (usuarios.size() > 0) {
            for (Usuarios usuario : usuarios) {
                UsuarioDepartamento UsuarioD = new UsuarioDepartamento();
                UsuarioD.setId(usuario.getId());
                UsuarioD.setNombreCompleto(usuario.getNombre() + " " + usuario.getApellido());
                UsuarioD.setTelefono(usuario.getTelefono());
                UsuarioD.setProfesion(usuario.getProfesion().getDescripcion());
                UsuarioD.setDireccion(usuario.getDepartamento().getDescripcion());

                usuariofinal.add(UsuarioD);
            }
        }

        return usuariofinal;
    }


}
