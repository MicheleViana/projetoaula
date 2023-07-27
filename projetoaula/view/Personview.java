package br.org.sesisenai.projetoaula.view;


import br.org.sesisenai.projetoaula.contoller.Controller;
import br.org.sesisenai.projetoaula.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Personview {

    List<Person> persons = new ArrayList<>();
    int id = 0;

    @GetMapping("/person")
    public Person findPerson(@PathParam("id") int id, @PathParam("name") String name) {
        for (Person p : persons) {
            if (p.getName().equals(name)) {
                return p;

            }
        }
        return null;
    }
    @PostMapping("/person")
    public Person addPerson (@PathParam("name") String name, @PathParam("sexo") String sexo){
        Person person = new Person();
        person.setName(name);
        person.setSexo(sexo);
        id++;
        person.setId(id);
        persons.add(person);
        return person;
    }
    @PutMapping("/person")
    public Person updatePerson ( @PathParam("id") int id, @PathParam("name") String name){
        Person p = new Person();
        for (Person person : persons) {
            if (person.getId() == id) {
                person.setName(name);
                p = person;
            }
        }
        return p;
    }
    @DeleteMapping("/person")
    public String deletePerson(@PathParam("name") String name) {
        Person person;
        for (Person p : persons) {
            if (p.getName().equals(name)) {
                person = p;

            }
        }
        persons.remove(persons);

        return "Pessoa com o nome de " + name + " foi deletada";
    }
        @GetMapping("/home")
            public String helloWorld() {
                return "Hello world";
            }

        }


