package com.sesi.aula04.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sesi.aula04.Repository.UsuarioRepository;
import com.sesi.aula04.model.Usuario;


@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Exibe o formulário
	@GetMapping("/formulario") 
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "formulario";
	}
	
	//adicionar usuario
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return"redirect:/usuarios";
	}
	
	//listar lista
	@GetMapping("/usuarios")
	public String listarUsuario(Model modelo) {
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		
		return "usuarios";
		
	}
	
	//remover
	@GetMapping("removerUsuario/{id}")
	public String removerUsuario(@PathVariable int id) {
	    usuarioRepository.deleteById(id);
		return "redirect:/usuarios";
		
	}
	
	//editar
	@GetMapping("editarUsuario/{id}")
	public String editarUsuario(@PathVariable int id, Model modelo) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		if(usuarioOpt.isPresent()) {
			modelo.addAttribute("usuario", usuarioOpt.get());
			return "formulario";
		}else {
			return "redirect:/usuarios";
		}
		
		
	}
	

	
	
}