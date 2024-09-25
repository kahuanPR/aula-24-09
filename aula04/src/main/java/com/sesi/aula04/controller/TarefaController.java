package com.sesi.aula04.controller;

import com.sesi.aula04.model.Tarefa;
import com.sesi.aula04.Repository.TarefaRepository;
import com.sesi.aula04.Repository.UsuarioRepository;
import com.sesi.aula04.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/tarefas")
    public String listarTarefas(Model model) {
        model.addAttribute("tarefas", tarefaRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "tarefas";
    }

    @GetMapping("/tarefas/novo")
    public String exibirFormularioCriacao(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "tarefa-form"; // Verifique se o nome está correto
    }



    @PostMapping("/tarefas/salvar")
    public String salvarTarefa(@ModelAttribute Tarefa tarefa) {
        tarefaRepository.save(tarefa);
        return "redirect:/tarefas";
    }
}
