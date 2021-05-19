package dev.jx.sga.controller.academico;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import dev.jx.sga.entity.Seccion;
import dev.jx.sga.entity.AnoEscolar;
import dev.jx.sga.service.SeccionService;
import dev.jx.sga.service.AnoEscolarService;

@Controller
@RequestMapping(value = "/academico/secciones")
public class SeccionController {

    @Autowired
    private SeccionService seccionService;

    @Autowired
    private AnoEscolarService anoEscolarService;

    @GetMapping("")
    public String getSecciones(Model model) {
        model.addAttribute("secciones", this.seccionService.findAll());
        return "/academico/seccion/i-seccion";
    }

    @GetMapping("/registrar")
    public String getRegistrarSeccion(Model model) {
        model.addAttribute("seccion", new Seccion());
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());
        model.addAttribute("grados", new AnoEscolar().getGrados());

        return "/academico/seccion/r-seccion";
    }

    @PostMapping("/registrar")
    public String postRegistrarSeccion(Seccion seccion) {
        this.seccionService.save(seccion);
        return "redirect:/academico/secciones";
    }
}
