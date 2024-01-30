package com.br.guerreiras.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.guerreiras.exception.ServiceExc;
import com.br.guerreiras.model.Usuario;
import com.br.guerreiras.repository.UsuarioRepository;
import com.br.guerreiras.service.ServiceUsuario;
import com.br.guerreiras.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	

	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@GetMapping("/")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("login/cadastro");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc{
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("redirect:/login");			
		}
		Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
		if(userLogin == null) {
			mv.addObject("msg", "Usuário não entrado. Tente novamente");
		}else {
			session.setAttribute("usuarioLogado", userLogin);
			return home();
		}
		return mv;
	}
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();		
		return login();
	}

	
	@PostMapping("salvarUsuario")
	public ModelAndView cadastrar(Usuario usuario) throws Exception {
		ModelAndView mv = new ModelAndView();
		serviceUsuario.salvarUsuario(usuario);
		mv.setViewName("redirect:/login");
		return mv;
	}
	

	
//	paginas de cadastros Usuarios
	
//	@GetMapping
//	public ModelAndView listar() {
//		ModelAndView page = new ModelAndView("cadastro/listar");
//		List<Usuario> cadastros = usuarioRepository.findAll();
//		page.addObject("cadastros", cadastros);
//		return page;
//	}
//	
//	@PostMapping("/{id}/editar")
//	public ModelAndView editar(@PathVariable Long id, @ModelAttribute Usuario usuario) throws Exception {
//	    usuario.setId(id);  
//	    ModelAndView modelAndView = new ModelAndView("redirect:/index");
//	    usuarioRepository.save(usuario);
//	    return modelAndView;
//	}
//	@GetMapping("/{id}")
//	public ModelAndView detalhar(@PathVariable Long id) {
//		ModelAndView modelAndView = new ModelAndView("cadastro/detalhar.html");
// 
//		Usuario cadastro = usuarioRepository.getReferenceById(id);
//		modelAndView.addObject("cadastro", cadastro);
// 
//		return modelAndView;
//	}
//	
//	@GetMapping("/{id}/editar")
//	public ModelAndView editar(@PathVariable Long id) {
//		ModelAndView modelAndView = new ModelAndView("cadastro/edicao");
// 
//		Usuario cadastro = usuarioRepository.getReferenceById(id);
//		modelAndView.addObject("cadastro", cadastro);
// 
//		return modelAndView;
//	}
//
//	@GetMapping("/{id}/excluir")
//	public ModelAndView excluir(@PathVariable Long id) {
//		ModelAndView modelAndView = new ModelAndView("redirect:/usuario");
// 
//		usuarioRepository.deleteById(id);
// 
//		return modelAndView;
//	}
}
