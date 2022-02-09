package com.web.service.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.web.service.entities.User;
import com.web.service.repositories.UserRepository;

/**
 * 
 * Classe de configuração para o perfil de teste
 * 
 * 
 * CommandLineRunner - Interface responsável por permite que o testeConfig seja
 * executado no momento da execução.
 * 
 * @author fsouviei
 *
 */

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	// Tudo que for colocado dentro desse método, vai ser iniciado na execução da
	// aplicação
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2));

	}

}
