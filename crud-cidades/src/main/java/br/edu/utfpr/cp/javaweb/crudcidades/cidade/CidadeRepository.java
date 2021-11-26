package br.edu.utfpr.cp.javaweb.crudcidades.cidade;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.cp.javaweb.crudcidades.entidy.CidadeEntidade;

public interface CidadeRepository extends JpaRepository<CidadeEntidade, Long>{
 
	public Optional<CidadeEntidade> findByNomeAndEstado(String nome, String estado);
	
	
}
