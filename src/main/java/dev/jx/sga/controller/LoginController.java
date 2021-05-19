package dev.jx.sga.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import dev.jx.sga.entity.Usuario;
import dev.jx.sga.service.UsuarioService;

@Controller
@RequestMapping(value = "/ingresar")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public String getIngresar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/login";
    }

    @PostMapping("")
    public String postIngresar(Usuario usuario) {
        var wrapper = new Object() {
            String path = "/index";
        };
        this.usuarioService.findByAliasAndClave(usuario.getAlias(), usuario.getClave())
                .ifPresent((usuarioAutenticado) -> {
                    wrapper.path = "redirect:/index";
                });

        return wrapper.path;
    }
}
