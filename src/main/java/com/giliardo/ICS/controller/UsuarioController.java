package com.giliardo.ICS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giliardo.ICS.entity.Usuario;
import com.giliardo.ICS.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("sucesso!");
    }

    @GetMapping("/auth/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "auth/usuarios-lista";
    }

    @GetMapping("/listar")
    public String listarFalso(Model model) {
        return "public/usuarios-lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "public/register";
    }

    @GetMapping("/entrar")
    public String entrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "public/login";
    }

    @PostMapping("/cadastrar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }
}
