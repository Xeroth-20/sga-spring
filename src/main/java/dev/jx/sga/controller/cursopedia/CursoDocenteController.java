package dev.jx.sga.controller.cursopedia;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import dev.jx.sga.entity.CursoDocente;
import dev.jx.sga.entity.Docente;
import dev.jx.sga.service.CursoDocenteService;
import dev.jx.sga.service.AnoEscolarService;
import dev.jx.sga.service.DocenteService;

@Controller
@RequestMapping(value = "/cursopedia/cursos-docente")
public class CursoDocenteController {

    @Autowired
    private CursoDocenteService cursoDocenteService;

    @Autowired
    private AnoEscolarService anoEscolarService;

    @Autowired
    private DocenteService docenteService;

    @GetMapping("")
    public String getCursosDocente(Model model) {
        model.addAttribute("cursosDocente", this.cursoDocenteService.findAll());
        return "/cursopedia/curso-docente/i-curso-docente";
    }

    @GetMapping("/registrar/paso-uno")
    public String getRegistrarCursoDocentePasoUno(
            @RequestParam(value = "docente-dni", required = false) String dni,
            Model model
    ) {
        this.docenteService.findDocenteByPersona_Dni(dni).ifPresentOrElse((docente) -> {
            model.addAttribute("docente", docente);
        }, () -> {
            model.addAttribute("docente", new Docente());
        });
        return "/cursopedia/curso-docente/r-uno-curso-docente";
    }

    @GetMapping("/registrar/paso-dos")
    public String getRegistrarCursoDocentePasoDos(
            @RequestParam(value = "docente-dni", required = false) String dni,
            Model model
    ) {
        CursoDocente cursoDocente = new CursoDocente();
        this.docenteService.findDocenteByPersona_Dni(dni).ifPresent(cursoDocente::setDocente);
        model.addAttribute("cursoDocente", cursoDocente);
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());

        return "/cursopedia/curso-docente/r-dos-curso-docente";
    }

    @PostMapping("/registrar/paso-dos")
    public String postRegistrarCursoDocentePasoDos(CursoDocente cursoDocente) {
        this.cursoDocenteService.save(cursoDocente);
        return "redirect:/cursopedia/cursos-docente";
    }
}
