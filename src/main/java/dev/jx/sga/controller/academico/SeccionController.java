package dev.jx.sga.controller.academico;

import java.util.List;
import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dev.jx.sga.entity.Seccion;
import dev.jx.sga.entity.Alumno;
import dev.jx.sga.service.SeccionService;
import dev.jx.sga.service.AnoEscolarService;
import dev.jx.sga.service.GradoService;
import dev.jx.sga.service.MatriculaService;

@Controller
@RequestMapping(value = "/academico/secciones")
public class SeccionController {

    @Autowired
    private SeccionService seccionService;

    @Autowired
    private AnoEscolarService anoEscolarService;

    @Autowired
    private GradoService gradoService;

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("")
    public String getSecciones(Model model) {
        model.addAttribute("secciones", this.seccionService.findAll());
        return "/academico/seccion/inicio";
    }

    @GetMapping("{id}")
    public String getSeccion(@PathVariable Long id, Model model) {
        this.seccionService.findById(id).ifPresent((seccion) -> {
            model.addAttribute("seccion", seccion);
            List<Alumno> alumnos = new ArrayList<Alumno>();
            this.matriculaService.findAllBySeccion_Id(seccion.getId()).forEach((matricula) -> {
                alumnos.add(matricula.getAlumno());
            });
            model.addAttribute("alumnos", alumnos);
        });
        return "/academico/seccion/seccion";
    }

    @GetMapping("/registrar")
    public String getRegistrarSeccion(Model model) {
        model.addAttribute("seccion", new Seccion());
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());

        return "/academico/seccion/registrar";
    }

    @PostMapping("/registrar")
    public String postRegistrarSeccion(Seccion seccion) {
        this.seccionService.save(seccion);
        return "redirect:/academico/secciones";
    }

    @GetMapping("/{id}/editar")
    public String getEditarSeccion(@PathVariable Long id, Model model) {
        this.seccionService.findById(id).ifPresent((seccion) -> {
            model.addAttribute("seccion", seccion);
            model.addAttribute("anosEscolares", this.anoEscolarService.findAll());
            this.anoEscolarService.findById(seccion.getGrado().getAnoEscolar().getId()).ifPresent((anoEscolar) -> {
                model.addAttribute("grados", anoEscolar.getGrados());
            });
        });
        return "/academico/seccion/editar";
    }

    @PostMapping("/{id}/editar")
    public String postEditarSeccion(Seccion seccion) {
        this.seccionService.save(seccion);
        return "redirect:/academico/secciones";
    }

    @GetMapping("/opciones")
    public String getOpcionesSeccion(@RequestParam("grado-id") Long id, Model model) {
        this.gradoService.findById(id).ifPresent((grado) -> {
            model.addAttribute("secciones", grado.getSecciones());
        });
        return "/components/opciones :: opciones-seccion";
    }
}
