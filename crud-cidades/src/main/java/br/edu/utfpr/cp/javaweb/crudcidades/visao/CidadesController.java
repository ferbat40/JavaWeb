package br.edu.utfpr.cp.javaweb.crudcidades.visao;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String criar(@Valid Cidades cidades, BindingResult validacao, Model memoria) {
	if (validacao.hasErrors()) {
			
			validacao.getFieldErrors()
			.forEach(e->System.out.println("BUNDA "+e.getField()+"  "+e.getDefaultMessage()));
			
	}
	
	
		if (validacao.hasErrors()) {
			
			validacao.getFieldErrors()
			.forEach(e->
			
					memoria.addAttribute(e.getField(),e.getDefaultMessage()));
			
		memoria.addAttribute("nomeInformado",cidades.getNome());
		memoria.addAttribute("cidadeInformada",cidades.getEstado());
		memoria.addAttribute("listarCidades",cidade);
		return ("/crud");
					
		}else {
		System.out.println("aqui");
		
		cidade.add(cidades);
		
		}
		
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
			
			, BindingResult validacao, Model memoria
			
			) {
		
		
		
		var cidadeatual =  cidade.removeIf(cidadeAtual -> 
		cidadeAtual.getNome().equals(nomeAtual) &&
		cidadeAtual.getEstado().equals(estadoAtual)
		);
		
		criar(cidad,validacao,memoria);
		
		return "redirect:/";
	}
	
}
