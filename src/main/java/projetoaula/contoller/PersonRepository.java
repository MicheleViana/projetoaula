package projetoaula.contoller;

import org.springframework.data.repository.CrudRepository;
import projetoaula.model.Person;

public interface PersonRepository extends CrudRepository<Person,Integer >{

}
