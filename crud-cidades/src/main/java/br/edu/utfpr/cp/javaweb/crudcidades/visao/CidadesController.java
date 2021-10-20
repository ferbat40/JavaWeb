package br.edu.utfpr.cp.javaweb.crudcidades.visao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CidadesController {
	
	private Set<Cidades> cidade;
	
	public CidadesController() {
		cidade = new HashSet();
		
	}

 
	@GetMapping("/")
	public String listar(Model memoria) {
	
		
		memoria.addAttribute("ListarCidades",cidade);
		
		return "/crud";
	}
	
	
	@PostMapping("/criar")
	public String criar(Cidades cidades) {
		cidade.add(cidades);
		return "redirect:/";
	}
	
	
	@GetMapping("/excluir")
	public String excluir(
			@RequestParam String nome,
			@RequestParam String estado
			) {
		
		
		cidade.removeIf(cidadeAtual -> 
				cidadeAtual.getNome().equals(nome) &&
				cidadeAtual.getEstado().equals(estado)
				);
		
		return "redirect:/";
	}
	
}
