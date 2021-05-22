package dev.jx.sga.controller.academico;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import dev.jx.sga.entity.AnoEscolar;
import dev.jx.sga.service.AnoEscolarService;

@Controller
@RequestMapping(value="/academico/anos-escolares")
public class AnoEscolarController {

    @Autowired
    private AnoEscolarService anoEscolarService;

    @GetMapping("")
    public String getAnosEscolares(Model model) {
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());
        return "/academico/ano-escolar/i-ano-escolar";
    }

    @GetMapping("/registrar")
    public String getRegistrarAnoEscolar(Model model) {
        model.addAttribute("anoEscolar", new AnoEscolar());
        return "/academico/ano-escolar/r-ano-escolar";
    }

    @PostMapping("/registrar")
    public String postRegistrarAnoEscolar(AnoEscolar anoEscolar) {
        this.anoEscolarService.save(anoEscolar);
        return "redirect:/academico/anos-escolares";
    }

    @GetMapping("/{id}")
    public String getVerAnoEscolar(@PathVariable Long id, Model model) {
        this.anoEscolarService.findById(id).ifPresent((anoEscolar) -> {
            model.addAttribute("anoEscolar", anoEscolar);
        });
        return "/academico/ano-escolar/v-ano-escolar";
    }

    @GetMapping("/{id}/editar")
    public String getEditarAnoEscolar(@PathVariable Long id, Model model) {
        this.anoEscolarService.findById(id).ifPresent((anoEscolar) -> {
            model.addAttribute("anoEscolar", anoEscolar);
        });
        return "/academico/ano-escolar/e-ano-escolar";
    }

    @PostMapping("/{id}/editar")
    public String postEditarAnoEscolar(@PathVariable Long id, AnoEscolar anoEscolar) {
        this.anoEscolarService.save(anoEscolar);
        return "redirect:/academico/anos-escolares";
    }
}
