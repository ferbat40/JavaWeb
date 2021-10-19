package br.edu.utfpr.cp.javaweb.crudcidades.visao;



public class Cidades {

	private final String nome;
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