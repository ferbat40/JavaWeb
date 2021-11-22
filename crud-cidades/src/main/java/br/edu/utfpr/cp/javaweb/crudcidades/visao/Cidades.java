package br.edu.utfpr.cp.javaweb.crudcidades.visao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cidades {

	
	@NotBlank(message = "{app.cidades.blank}")
	@Size(min = 5, max = 60, message = "{app.cidades.size}")
	private final String nome;
	
	@NotBlank(message = "{app.estado.blank}")
	@Size(min = 5, max = 60, message = "{app.estado.size}")
	private final String estado;
	
	
	public Cidades(String nome, String estado) {
		this.nome = nome;
		this.estado = estado;
	}


	
	public String getNome() {
		return nome;
	}


	public String getEstado() {
		return estado;
	}
	
	
	
	
}
