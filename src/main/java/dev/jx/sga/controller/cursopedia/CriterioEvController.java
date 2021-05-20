package dev.jx.sga.controller.cursopedia;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import dev.jx.sga.entity.CriterioEv;
import dev.jx.sga.service.CriterioEvService;
import dev.jx.sga.service.AnoEscolarService;

@Controller
@RequestMapping(value = "/cursopedia/criterios")
public class CriterioEvController {

    @Autowired
    private CriterioEvService criterioEvService;

    @Autowired
    private AnoEscolarService anoEscolarService;

    @GetMapping("")
    public String getCriteriosEv(Model model) {
        model.addAttribute("criteriosEv", this.criterioEvService.findAll());
        return "/cursopedia/criterio-ev/i-criterio-ev";
    }

    @GetMapping("/registrar")
    public String getRegistrarCriterioEv(Model model) {
        model.addAttribute("criterioEv", new CriterioEv());
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());

        return "/cursopedia/criterio-ev/r-criterio-ev";
    }

    @PostMapping("/registrar")
    public String postRegistrarCriterioEv(CriterioEv criterioEv) {
        this.criterioEvService.save(criterioEv);
        return "redirect:/cursopedia/criterios";
    }
}
