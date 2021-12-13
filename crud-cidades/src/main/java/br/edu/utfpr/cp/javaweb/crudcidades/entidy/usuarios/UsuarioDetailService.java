package br.edu.utfpr.cp.javaweb.crudcidades.entidy.usuarios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailService implements UserDetailsService {

	
	private final usuarioRepository usuarios;
	
	
	public UsuarioDetailService(final usuarioRepository usuarios) {
		this.usuarios = usuarios;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		var usuario = usuarios.findByNome(username);
		
		if (usuario == null)
			throw new UsernameNotFoundException("usuario não encontrado");
		
		return usuario;
	}

}
