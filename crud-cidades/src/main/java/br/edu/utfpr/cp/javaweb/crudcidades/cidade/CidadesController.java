package br.edu.utfpr.cp.javaweb.crudcidades.cidade;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CidadesController {
	

	CidadeRepository repository;
	
	
	private Set<Cidades> cidade;
	
	public CidadesController(CidadeRepository repository) {
		cidade = new HashSet<Cidades>();
		this.repository=repository;
		
		
	}

 
	@GetMapping("/")
	public String listar(Model memoria) {
	
		
		memoria.addAttribute("ListarCidades", repository.findAll()
				.stream()
				.map(e->new Cidades(
						e.getNome(),
						e.getEstado()
						
						
						
						)).collect(Collectors.toList())
				
				);
		
		return "/crud";
	}
	

	@PostMapping("/criar")
	public String criar(@Valid Cidades cidades, BindingResult validacao, Model memoria) {
	
	
		if (validacao.hasErrors()) {
			
			validacao.getFieldErrors()
			.forEach(e->
			
					memoria.addAttribute(e.getField(),e.getDefaultMessage()));
			
		memoria.addAttribute("nomeInformado",cidades.getNome());
		memoria.addAttribute("cidadeInformada",cidades.getEstado());
		memoria.addAttribute("listarCidades",cidade);
		return ("/crud");
					
		}else {
		
		repository.save(cidades.clonar());
		
		
		}
		
		return "redirect:/";
	}
	
	
	@GetMapping("/excluir")
	public String excluir(
			@RequestParam String nome,
			@RequestParam String estado
			) {
		
		
		var cidadeEstadoEncontrado = repository.findByNomeAndEstado(nome, estado);
		
		cidadeEstadoEncontrado.ifPresent(repository::delete);
		
		
		return "redirect:/";
	}
	
	
	@GetMapping("/alterar")
    public String alterar(
    		@RequestParam String nome,
    	    @RequestParam String estado,
    	    Model modelo
    	   ) {
		
		
		
		var cidadeAtual = repository.findByNomeAndEstado(nome, estado);
		
		
		cidadeAtual.ifPresent(e->{
			modelo.addAttribute("cidadeAtual",e);
			modelo.addAttribute("ListarCidades",repository.findAll());
			
		});	
		
		return "/crud";
	}
	
	@PostMapping("/alterar")
	public String alterar(
			@RequestParam String nomeAtual,
			@RequestParam String estadoAtual,
			Cidades cidad
			
			
			
			) {
		
		var cidadeAtual = repository.findByNomeAndEstado(nomeAtual, estadoAtual);
		
				if (cidadeAtual.isPresent()) {
					
					var cidadeEncontrada = cidadeAtual.get();
					cidadeEncontrada.setNome(cidad.getNome());
					cidadeEncontrada.setEstado(cidad.getEstado());
					repository.saveAndFlush(cidadeEncontrada);
				}
				
				
		
		return "redirect:/";
	}
	
}
