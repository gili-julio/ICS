package com.giliardo.ICS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giliardo.ICS.entity.Loja;
import com.giliardo.ICS.entity.Usuario;
import com.giliardo.ICS.repository.LojaRepository;
import com.giliardo.ICS.repository.UsuarioRepository;

@Controller
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LojaRepository lojaRepository;
    @Autowired
    private LojaRepository produtoRepository;

    @GetMapping
    public String listarLojas(Model model) {
        model.addAttribute("lojas", lojaRepository.findAll());
        return "lojas/listar";
    }

    @GetMapping("/cadastrar")
    public String cadastrarLoja(Model model) {
        model.addAttribute("loja", new Loja());
        return "lojas/register";
    }

    @PostMapping("/cadastrar")
    public String salvarLoja(@ModelAttribute Loja loja) {
        lojaRepository.save(loja);
        return "redirect:/lojas";
    }

    @GetMapping("/{lojaId}/produtos")
    public String listarProdutosDaLoja(@PathVariable Long lojaId, Model model) {
        Optional<Loja> lojaOpt = lojaRepository.findById(lojaId);

        if (lojaOpt.isPresent()) {
            Loja loja = lojaOpt.get();
            model.addAttribute("loja", loja);
            model.addAttribute("produtos", loja.getProdutos());
            return "lojas/produtos";
        } else {
            return "redirect:/lojas";
        }
    }
}
