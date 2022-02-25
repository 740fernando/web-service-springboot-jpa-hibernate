package com.web.service.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.service.model.dao.repositories.UserRepository;
import com.web.service.model.entities.User;

/**
 * 
 * Component - Indica que uma classe anotada é um "componente". Essas classes
 *            são consideradas candidatas à detecção automática ao usar
 *            configuração baseada em anotação e varredura de caminho de classe.
 * 
 * Service- Indica que uma classe anotada é um "Serviço", originalmente
 *           definido pelo Domain-DrivenDesign (Evans, 2003) como "uma operação
 *           oferecida como uma interface que fica sozinha no modelo, sem estado
 *           encapsulado".Também pode indicar que uma classe é uma "Fachada de
 *           Serviço de Negócios" (no sentido Core J2EEpatterns), ou algo
 *           semelhante. Essa anotação é um estereótipo de uso geral e equipes
 *           individuais podem restringir sua semântica e usar conforme
 *           apropriado.
 * 
 * Optional- Um objeto container que pode ou não conter um valor não
 *           nulo. Se um valor estiver presente, isPresent() retornará true. Se
 *           nenhum valor estiver presente, o objeto será considerado vazio e
 *           isPresent() retornará false.
 * 
 *           Métodos adicionais que dependem da presença ou ausência de um valor
 *           contido são fornecidos, como orElse() (retorna um valor padrão se
 *           nenhum valor estiver presente) e ifPresent() (executa uma ação se
 *           um valor estiver presente).
 * 
 *           Esta é uma classe baseada em valor; o uso de operações sensíveis à
 *           identidade (incluindo igualdade de referência(==), código de hash
 *           de identidade ou sincronização) em instâncias de Optional pode ter
 *           resultados imprevisíveis e deve ser evitado.
 * 
 * 
 * @author fsouviei
 *
 */

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
