package com.br.guerreiras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.guerreiras.model.Usuario;
import com.br.guerreiras.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class CadastroController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView page = new ModelAndView("cadastro/listar");
		List<Usuario> cadastros = usuarioRepository.findAll();
		page.addObject("cadastros", cadastros);
		return page;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id, @ModelAttribute Usuario usuario) throws Exception {
	    usuario.setId(id);  
	    ModelAndView modelAndView = new ModelAndView("redirect:/usuario");
	    usuarioRepository.save(usuario);
	    return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cadastro/detalhar.html");
 
		Usuario cadastro = usuarioRepository.getReferenceById(id);
		modelAndView.addObject("cadastro", cadastro);
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cadastro/edicao");
 
		Usuario cadastro = usuarioRepository.getReferenceById(id);
		modelAndView.addObject("cadastro", cadastro);
 
		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuario");
 
		usuarioRepository.deleteById(id);
 
		return modelAndView;
	}

}
