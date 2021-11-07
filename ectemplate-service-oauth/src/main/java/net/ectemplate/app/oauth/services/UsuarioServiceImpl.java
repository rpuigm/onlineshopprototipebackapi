package net.ectemplate.app.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.ectemplate.app.oauth.clients.UsuarioFeignClient;
import net.ectemplate.app.oauth.entities.Usuario;

@Service
public class UsuarioServiceImpl implements UserDetailsService{
	
	private Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioFeignClient usuarioFeignClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioFeignClient.findByUsername(username);
		
		if(usuario == null) {
			log.error("Error en el loging");
			throw new UsernameNotFoundException("no usuario" + username);
		}
		
		List<GrantedAuthority> listaGrantedAuthority = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authoriry -> log.info("Role " + authoriry.getAuthority()))
				.collect(Collectors.toList());
		return new User(usuario.getUsername(), usuario.getPassword(), true,true,true,true, listaGrantedAuthority);
	}

}
