package com.brenomorais.escola.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeolocalizacaoController {
	
	@GetMapping("/geolocalizacao/pesquisar")
	public String inicializarPesquisa() {
		return "/geolocalizacao/pesquisar";
	}

}
