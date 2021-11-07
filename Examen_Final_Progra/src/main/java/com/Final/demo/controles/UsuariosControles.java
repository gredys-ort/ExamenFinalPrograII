package com.Final.demo.controles;

import com.Final.demo.modelos.e.Departamentos;
import com.Final.demo.modelos.e.Profesiones;
import com.Final.demo.modelos.e.UsuarioDepartamento;
import com.Final.demo.modelos.e.Usuarios;
import com.Final.demo.servicios.InDepartamentoServicios;
import com.Final.demo.servicios.InProfesionServicios;
import com.Final.demo.servicios.InUsuarioServicios;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Gredys Morales
 */

@Controller
@RequestMapping("/nice/usuarios")
public class UsuariosControles {
    final InUsuarioServicios usuarioService;
    final InProfesionServicios profesionService;
    final InDepartamentoServicios departamentoService;

    @Autowired
    public UsuariosControles(
            InUsuarioServicios usuarioServicios,
            InProfesionServicios profesionService,
            InDepartamentoServicios departamentoService
    ){
        this.usuarioService = usuarioServicios;
        this.profesionService = profesionService;
        this.departamentoService = departamentoService;
    }

    @GetMapping("/")
    public String listarUsuarios(Model model){

        List<UsuarioDepartamento> usuarios = usuarioService.obtenerUsuariosDto();

        model.addAttribute("titulo", "Usuarios");
        model.addAttribute("usuarios", usuarios);

        return  "/nice/usuarios/Lista";
    }

    @GetMapping("/dto")
    public String listarUsuariosDto(){

        List<UsuarioDepartamento> UsuariosDepartamento = usuarioService.obtenerUsuariosDto();
        return  "/nice/usuarios/Lista";
    }

    @GetMapping("/nuevo")
    public String crearUsuario(Model model){

        Usuarios usuario = new Usuarios();
        List<Profesiones> profesiones = profesionService.listar();
        List<Departamentos> departamentos = departamentoService.listar();

        model.addAttribute("titulo", "Formulario: Nuevo usuario");
        model.addAttribute("usuario", usuario);
        model.addAttribute("profesiones", profesiones);
        model.addAttribute("departamentos", departamentos);

        return "/nice/usuarios/Ingresar";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Usuarios usuario, RedirectAttributes attribute) {
        usuario.setRegistro(new Date());
        usuarioService.guardar(usuario);
        attribute.addFlashAttribute("success", "Usuario guardado con éxito");
        return "redirect:/nice/usuarios/";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model){

        Usuarios usuario = usuarioService.buscarPorId(id);
        List<Profesiones> profesiones = profesionService.listar();
        List<Departamentos> departamentos = departamentoService.listar();

        model.addAttribute("titulo", "Formulario: Editar usuario");
        model.addAttribute("usuario", usuario);
        model.addAttribute("profesiones", profesiones);
        model.addAttribute("departamentos", departamentos);

        return "/nice/usuarios/Ingresar";
    }

    @GetMapping("/Detalles/{id}")
    public String verUsuario(@PathVariable("id") Long id, Model model){

        Usuarios usuario = usuarioService.buscarPorId(id);
        model.addAttribute("usuario", usuario);

        return "/nice/usuarios/Detalles";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id ,RedirectAttributes attribute){

        usuarioService.eliminar(id);
        attribute.addFlashAttribute("warning", "Usuario eliminado con éxito");
        return "redirect:/nice/usuarios/";
    }
    
    
}
