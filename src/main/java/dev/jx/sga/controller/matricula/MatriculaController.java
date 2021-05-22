package dev.jx.sga.controller.matricula;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import dev.jx.sga.entity.Matricula;
import dev.jx.sga.entity.Alumno;
import dev.jx.sga.service.MatriculaService;
import dev.jx.sga.service.AnoEscolarService;
import dev.jx.sga.service.AlumnoService;

@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private AnoEscolarService anoEscolarService;

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("")
    public String getMatriculas(Model model) {
        model.addAttribute("matriculas", this.matriculaService.findAll());
        return "/matricula/i-matricula";
    }

    @GetMapping("/registrar/paso-uno")
    public String getRegistrarMatriculaPasoUno(
            @RequestParam(value = "alumno-dni", required = false) String dni,
            Model model
    ) {
        this.alumnoService.findAlumnoByPersona_Dni(dni).ifPresentOrElse((alumno) -> {
            model.addAttribute("alumno", alumno);
        }, () -> {
            model.addAttribute("alumno", new Alumno());
        });

        return "/matricula/r-uno-matricula";
    }

    @GetMapping("/registrar/paso-dos")
    public String getRegistrarMatriculaPasoDos(
            @RequestParam(value = "alumno-dni", required = false) String dni,
            Model model
    ) {
        Matricula matricula = new Matricula();
        this.alumnoService.findAlumnoByPersona_Dni(dni).ifPresent((alumno) -> {
            matricula.setAlumno(alumno);
        });
        model.addAttribute("matricula", matricula);
        model.addAttribute("anosEscolares", this.anoEscolarService.findAll());

        return "/matricula/r-dos-matricula";
    }

    @PostMapping("/registrar/paso-dos")
    public String postRegistrarMatriculaPasoDos(Matricula matricula) {
        this.matriculaService.save(matricula);
        return "redirect:/matriculas";
    }
}
