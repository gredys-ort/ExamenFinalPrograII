package com.Final.demo.controles;

import com.Final.demo.modelos.e.Departamentos;
import com.Final.demo.servicios.InDepartamentoServicios;
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
@RequestMapping("/nice/departamentos")
public class DepartamentosControles {
    final InDepartamentoServicios departamentoService;

    @Autowired
    public DepartamentosControles(
            InDepartamentoServicios departamentoService
    ){
        this.departamentoService = departamentoService;
    }

    @GetMapping("/")
    public String listar(Model model){

        List<Departamentos> departamentos = departamentoService.listar();
        model.addAttribute("titulo", "Departamentos");
        model.addAttribute("departamentos", departamentos);

        return  "/nice/departamentos/Lista";
    }

    @GetMapping("/nuevo")
    public String crear(Model model){

        Departamentos departamento = new Departamentos();
        model.addAttribute("titulo", "Formulario: Nuevo departamento");
        model.addAttribute("departamento", departamento);

        return "/nice/departamentos/Ingresar";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute  Departamentos departamento, RedirectAttributes attribute) {
        departamentoService.guardar(departamento);
        attribute.addFlashAttribute("success", "Departamento guardado con éxito");
        return "redirect:/nice/departamentos/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){

        Departamentos departamento = departamentoService.buscarPorId(id);

        model.addAttribute("titulo", "Formulario: Editar departamento");
        model.addAttribute("departamento", departamento);

        return "/nice/departamentos/Ingrear";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id ,RedirectAttributes attribute){

        departamentoService.eliminar(id);
        attribute.addFlashAttribute("warning", "Departamento eliminado con éxito");
        return "redirect:/nice/departamentos/";
    }
    
    
}
