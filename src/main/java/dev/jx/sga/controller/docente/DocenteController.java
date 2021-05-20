package dev.jx.sga.controller.docente;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import dev.jx.sga.entity.Docente;
import dev.jx.sga.service.DocenteService;

@Controller
@RequestMapping(value = "/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("")
    public String getDocentes(Model model) {
        model.addAttribute("docentes", this.docenteService.findAll());
        return "/docente/i-docente";
    }

    @GetMapping("/registrar")
    public String getRegistrarDocente(Model model) {
        model.addAttribute("docente", new Docente());
        return "/docente/r-docente";
    }

    @PostMapping("/registrar")
    public String postRegistrarDocente(Docente docente) {
        this.docenteService.save(docente);
        return "redirect:/docentes";
    }
}
