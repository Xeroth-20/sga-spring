package dev.jx.sga.controller.alumno;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import dev.jx.sga.entity.Alumno;
import dev.jx.sga.service.AlumnoService;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("")
    public String getAlumnos(Model model) {
        model.addAttribute("alumnos", this.alumnoService.findAll());
        return "/alumno/i-alumno";
    }

    @GetMapping("/registrar")
    public String getRegistrarAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "/alumno/r-alumno";
    }

    @PostMapping("/registrar")
    public String postRegistrarAlumno(Alumno alumno) {
        this.alumnoService.save(alumno);
        return "redirect:/alumnos";
    }
}
