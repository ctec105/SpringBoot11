package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Usuario;
import com.example.demo.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;

	@GetMapping("/listado")
	public ModelAndView litarUsuario() {  
		ModelAndView mav = new ModelAndView("listado");
		mav.addObject("usuarios", usuarioService.listAllUsuario());
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	@PostMapping("/addUsuario")
	public String addUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.addUsuario(usuario);
		return "redirect:/usuario/listado";
	}
	
}
