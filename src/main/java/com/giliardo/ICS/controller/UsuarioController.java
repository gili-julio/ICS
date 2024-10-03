package com.giliardo.ICS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giliardo.ICS.entity.Usuario;
import com.giliardo.ICS.repository.UsuarioRepository;
import com.giliardo.ICS.security.CustomUserDetailsService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("sucesso!");
    }

    @GetMapping("/info")
    public String usuarioInfo(Model model) {
        // Obtém o usuário autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            // Se o usuário está autenticado
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                System.out.println("Username: " + username);
                Usuario usuario = usuarioRepository.findByEmail(username)
                        .orElseThrow(() -> new RuntimeException("User not found"));
                model.addAttribute("user", usuario);
            }
        }
        return "usuarios/info";
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios/listar";
    }

    @GetMapping("/cadastrar")
    public String cadastrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/register";
    }

    @GetMapping("/entrar")
    public String entrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/login";
    }

    @PostMapping("/cadastrar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        Optional<Usuario> possibleUser = usuarioRepository.findByEmail(usuario.getEmail());
        if (possibleUser.isEmpty()) {
            usuarioRepository.save(usuario);
            return "redirect:/usuarios";
        }
        return "redirect:/usuarios/cadastrar?error";

    }
}
