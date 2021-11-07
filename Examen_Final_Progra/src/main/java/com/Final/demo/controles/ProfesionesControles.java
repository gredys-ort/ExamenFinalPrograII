package com.Final.demo.controles;

import com.Final.demo.modelos.e.Profesiones;
import com.Final.demo.servicios.InProfesionServicios;
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
@RequestMapping("/nice/profesiones")
public class ProfesionesControles {

    final InProfesionServicios profesionService;

    @Autowired
    public ProfesionesControles(
            InProfesionServicios profesionService
    ) {
        this.profesionService = profesionService;
    }

    @GetMapping("/")
    public String listar(Model model) {

        List<Profesiones> profesiones = profesionService.listar();

        model.addAttribute("titulo", "Profesiones");
        model.addAttribute("profesiones", profesiones);

        return "/nice/profesiones/Lista";
    }

    @GetMapping("/nuevo")
    public String crear(Model model) {

        Profesiones profesion = new Profesiones();

        model.addAttribute("titulo", "Formulario: Nueva profesión");
        model.addAttribute("profesion", profesion);

        return "/nice/profesiones/Ingresar";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Profesiones profesion, RedirectAttributes attribute) {

        profesionService.guardar(profesion);
        attribute.addFlashAttribute("success", "Profesión guardada con éxito");
        return "redirect:/nice/profesiones/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {

        Profesiones profesion = profesionService.buscarPorId(id);

        model.addAttribute("titulo", "Formulario: Editar profesión");
        model.addAttribute("profesion", profesion);

        return "/nice/profesiones/Ingresar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes attribute) {

        profesionService.eliminar(id);
        attribute.addFlashAttribute("warning", "Profesión eliminada con éxito");
        return "redirect:/nice/profesiones/";
    }
}
