package br.edu.utfpr.cp.javaweb.crudcidades.visao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cidades {

	
	@NotBlank(message = "Nome da cidade deve ser informado")
	@Size(min = 5, max = 60, message = "O nome da cidade deve ter entre 5 e 60 caracteres")
	private final String nome;
	
	@NotBlank(message = "Sigla do estado deve ser informado")
	@Size(min = 5, max = 60, message = "A Sigla do estado esta limitada a dois caracteres")
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
