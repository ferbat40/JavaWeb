package br.edu.utfpr.cp.javaweb.crudcidades.entidy.usuarios;


import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository <usuario, Long> {

	public usuario findByNome(String nome);
	
}
