package com.sesi.aula04.controller;

import com.sesi.aula04.model.Categoria;
import com.sesi.aula04.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categorias";
    }

    @GetMapping("/categorias/novo")
    public String exibirFormularioCriacao(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria-form";
    }

    @PostMapping("/categorias/salvar")
    public String salvarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }
}
