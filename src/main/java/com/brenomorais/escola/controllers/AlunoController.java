package com.brenomorais.escola.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.brenomorais.escola.models.Aluno;

@Controller
public class AlunoController {
	
	@GetMapping("/aluno/cadastrar")
	public String cadastrar(Model model) {
		
		model.addAttribute("aluno", new Aluno());
		return "aluno/cadastrar";
	}

}
