package dev.jx.sga.controller.cursopedia;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import dev.jx.sga.entity.Curso;
import dev.jx.sga.service.CursoService;
import dev.jx.sga.service.AnoEscolarService;
import dev.jx.sga.service.GradoService;

@Controller
@RequestMapping(value = "/cursopedia/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private AnoEscolarService anoEscolarService;

    @Autowired
    private GradoService gradoService;

    @GetMapping("")
    public String getCursos(Model model) {
        model.addAttribute("cursos", this.cursoService.findAll());
        return "/cursopedia/curso/i-curso";
    }

    @GetMapping("/registrar")
    public String getRegistrarCurso(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());

        return "/cursopedia/curso/r-curso";
    }

    @PostMapping("/registrar")
    public String postRegistrarCurso(Curso curso) {
        this.cursoService.save(curso);
        return "redirect:/cursopedia/cursos";
    }

    @GetMapping("/opciones")
    public String getOpcionesCurso(@RequestParam("grado-id") Long id, Model model) {
        this.gradoService.findById(id).ifPresent((grado) -> {
            model.addAttribute("cursos", grado.getCursos());
        });
        return "/components/opciones :: opciones-curso";
    }
}
