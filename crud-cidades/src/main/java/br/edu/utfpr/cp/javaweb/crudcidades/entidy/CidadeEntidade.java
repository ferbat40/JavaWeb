package br.edu.utfpr.cp.javaweb.crudcidades.entidy;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity(name="cidade")
public class CidadeEntidade implements Serializable {
 
	public CidadeEntidade() {
		super();
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public CidadeEntidade(String nome, String estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}

	private String nome;
	
	private String estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	
	
}
