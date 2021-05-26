package dev.jx.sga.controller.academico;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dev.jx.sga.entity.Grado;
import dev.jx.sga.service.GradoService;
import dev.jx.sga.service.AnoEscolarService;

@Controller
@RequestMapping(value = "/academico/grados")
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @Autowired
    private AnoEscolarService anoEscolarService;

    @GetMapping("")
    public String getGrados(Model model) {
        model.addAttribute("grados", this.gradoService.findAll());
        return "/academico/grado/inicio";
    }

    @GetMapping("{id}")
    public String getGrados(@PathVariable Long id, Model model) {
        this.gradoService.findById(id).ifPresent((grado) -> {
            model.addAttribute("grado", grado);
        });
        return "/academico/grado/grado";
    }

    @GetMapping("/registrar")
    public String getRegistrarGrado(Model model) {
        model.addAttribute("grado", new Grado());
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());

        return "/academico/grado/registrar";
    }

    @PostMapping("/registrar")
    public String postRegistrarGrado(Grado grado) {
        this.gradoService.save(grado);
        return "redirect:/academico/grados";
    }

    @GetMapping("/{id}/editar")
    public String getEditarGrado(@PathVariable Long id, Model model) {
        this.gradoService.findById(id).ifPresent((grado) -> {
            model.addAttribute("grado", grado);
            model.addAttribute("anosEscolares", this.anoEscolarService.findAll());
        });

        return "/academico/grado/editar";
    }

    @PostMapping("/{id}/editar")
    public String postEditarGrado(Grado grado) {
        this.gradoService.save(grado);
        return "redirect:/academico/grados";
    }

    @GetMapping(value = "/opciones")
    public String getOpcionesGrado(@RequestParam("ano-escolar-id") Long id, Model model) {
        this.anoEscolarService.findById(id).ifPresent((anoEscolar) -> {
            model.addAttribute("grados", anoEscolar.getGrados());
        });
        return "/components/opciones :: opciones-grado";
    }
}
