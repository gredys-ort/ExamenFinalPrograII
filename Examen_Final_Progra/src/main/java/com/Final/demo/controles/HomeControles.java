
package com.Final.demo.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Gredys Morales
 */
@Controller
public class HomeControles {
    @GetMapping({"/", "/Inicio", "/index"})
    public String index(){
        return "Inicio";
    }
}
