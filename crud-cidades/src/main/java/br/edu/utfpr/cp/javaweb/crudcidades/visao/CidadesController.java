package br.edu.utfpr.cp.javaweb.crudcidades.visao;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CidadesController {

 
	@GetMapping("/")
	public String listar(Model memoria) {
		
		var cidade = Set.of(
				
				new Cidades("Piraciaba","SP"),
				new Cidades("Itu","SP"),
				new Cidades("Praia Grande","SP")
				
				);
		
		memoria.addAttribute("ListarCidades",cidade);
		
		return "/crud";
		
		
	}
	
}
