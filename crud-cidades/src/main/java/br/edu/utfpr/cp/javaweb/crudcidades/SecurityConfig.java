package br.edu.utfpr.cp.javaweb.crudcidades;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	
	
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").hasAnyAuthority("listar","admin")
		.antMatchers("/criar").hasAuthority("admin")
		.antMatchers("/excluir").hasAuthority("admin")
		.antMatchers("/alterar").hasAnyAuthority("admin","listar")
		.anyRequest().denyAll()
		.and()
		.formLogin()
		.loginPage("/login.html").permitAll()
		.defaultSuccessUrl("/", false)
		.and()
		.logout().permitAll()
		;
		
	}
	
	@Bean
	public PasswordEncoder cifrador() {
		return new BCryptPasswordEncoder();
		
	}
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void printSenhas() {
	
		System.out.println("Porra "+this.cifrador().encode("kamen"));
	}
	
}
