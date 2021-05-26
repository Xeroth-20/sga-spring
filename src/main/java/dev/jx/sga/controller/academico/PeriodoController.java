package dev.jx.sga.controller.academico;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import dev.jx.sga.entity.Periodo;
import dev.jx.sga.service.PeriodoService;
import dev.jx.sga.service.AnoEscolarService;

@Controller
@RequestMapping(value = "/academico/periodos")
public class PeriodoController {

    @Autowired
    private PeriodoService periodoService;

    @Autowired
    private AnoEscolarService anoEscolarService;

    @GetMapping("")
    public String getPeriodos(Model model) {
        model.addAttribute("periodos", this.periodoService.findAll());
        return "/academico/periodo/inicio";
    }

    @GetMapping("{id}")
    public String getPeriodo(@PathVariable Long id, Model model) {
        this.periodoService.findById(id).ifPresent((periodo) -> {
            model.addAttribute("periodo", periodo);
        });
        return "/academico/periodo/periodo";
    }

    @GetMapping("/registrar")
    public String getRegistrarPeriodo(Model model) {
        model.addAttribute("periodo", new Periodo());
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());

        return "/academico/periodo/registrar";
    }

    @PostMapping("/registrar")
    public String postRegistrarPeriodo(Periodo periodo) {
        this.periodoService.save(periodo);
        return "redirect:/academico/periodos";
    }

    @GetMapping("/{id}/editar")
    public String getEditarPeriodo(@PathVariable Long id, Model model) {
        this.periodoService.findById(id).ifPresent((periodo) -> {
            model.addAttribute("periodo", periodo);
            model.addAttribute("anosEscolares", this.anoEscolarService.findAll());
        });
        return "/academico/periodo/editar";
    }

    @PostMapping("/{id}/editar")
    public String postEditarPeriodo(Periodo periodo) {
        this.periodoService.save(periodo);
        return "redirect:/academico/periodos";
    }
}
