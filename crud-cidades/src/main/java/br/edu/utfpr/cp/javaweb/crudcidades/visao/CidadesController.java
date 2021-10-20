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
	
	
	@GetMapping("/alterar")
    public String alterar(
    		@RequestParam String nome,
    	    @RequestParam String estado,
    	    Model modelo
    	   ) {
		System.out.println("aqui");
		var cidadeatual = cidade.stream()
				.filter(cidades -> cidades.getNome().equals(nome) &&
						cidades.getEstado().equals(estado)
						
						).findAny();
		
		if (cidadeatual.isPresent()) {
			modelo.addAttribute("cidadeAtual",cidadeatual.get());
			modelo.addAttribute("ListarCidades",cidade);
		}
		
		return "/crud";
	}
	
	@PostMapping("/alterar")
	public String alterar(
			@RequestParam String nomeAtual,
			@RequestParam String estadoAtual,
			Cidades cidad
			) {
		
		System.out.println("aqui2");
		
		var cidadeatual =  cidade.removeIf(cidadeAtual -> 
		cidadeAtual.getNome().equals(nomeAtual) &&
		cidadeAtual.getEstado().equals(estadoAtual)
		);
		
		criar(cidad);
		
		return "redirect:/";
	}
	
}
