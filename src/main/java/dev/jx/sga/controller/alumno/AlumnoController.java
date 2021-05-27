package dev.jx.sga.controller.alumno;

import java.util.List;
import java.util.ArrayList;

import dev.jx.sga.entity.Matricula;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dev.jx.sga.entity.Alumno;
import dev.jx.sga.entity.AnoEscolar;
import dev.jx.sga.service.AlumnoService;
import dev.jx.sga.service.MatriculaService;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("")
    public String getAlumnos(Model model) {
        model.addAttribute("alumnos", this.alumnoService.findAll());
        return "/alumno/inicio";
    }

    @GetMapping("{id}")
    public String getAlumno(
            @PathVariable Long id,
            @RequestParam(value = "ano-escolar-id", required = false) Long anoEscolarId,
            Model model
    ) {
        this.alumnoService.findById(id).ifPresent((alumno) -> {
            model.addAttribute("alumno", alumno);
            List<Matricula> matriculas = alumno.getMatriculas();
            List<AnoEscolar> anosEscolares = new ArrayList<AnoEscolar>();
            Matricula matriculaSelected = null;

            for(Matricula matricula : matriculas) {
                AnoEscolar anoEscolar = matricula.getAnoEscolar();
                if (anoEscolar.getId().equals(anoEscolarId)) {
                    matriculaSelected = matricula;
                } else {
                    anosEscolares.add(anoEscolar);
                }
            }

            if (anoEscolarId == null && !anosEscolares.isEmpty()) {
                matriculaSelected = matriculas.remove(0);
                anosEscolares.remove(matriculaSelected.getAnoEscolar());
            }

            model.addAttribute("anosEscolares", anosEscolares);
            model.addAttribute("matriculaSelected", matriculaSelected);
        });
        return "/alumno/alumno";
    }

    @GetMapping("/registrar")
    public String getRegistrarAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "/alumno/registrar";
    }

    @PostMapping("/registrar")
    public String postRegistrarAlumno(Alumno alumno) {
        this.alumnoService.save(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/{id}/editar")
    public String getEditarAlumno(@PathVariable Long id, Model model) {
        this.alumnoService.findById(id).ifPresent((alumno) -> {
            model.addAttribute("alumno", alumno);
        });
        return "/alumno/editar";
    }

    @PostMapping("/{id}/editar")
    public String postEditarAlumno(Alumno alumno) {
        this.alumnoService.save(alumno);
        return "redirect:/alumnos";
    }
}
