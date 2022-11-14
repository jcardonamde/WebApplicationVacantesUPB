package com.vacantesupb.empresa;

import com.vacantesupb.empresa.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmpresaApplication.class, args);
	}


	// Clase que hereda de Web Security
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		//Recibiendo solicitudes
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class) //Filtro de autorización
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/login").permitAll() //Accedo por el metodo Post
					.anyRequest().authenticated();
		}
	}
}
