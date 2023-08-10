package projetoaula.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetoaula.contoller.Controller;
import projetoaula.model.Person;

import javax.websocket.server.PathParam;

@RestController
public class PersonView {
    @Autowired
    private Controller controller;

    @GetMapping("/person")
    public Person findPerson(@PathParam("name") String name) {
        return controller.findPerson(name);
    }

    @PostMapping("/person")
    public Person addPerson(@PathParam("name") String name, @PathParam("sexo") String sexo) {
        return controller.addperson(name, sexo);

    }

    @PutMapping("/person")
    public Person updatePerson(@PathParam("id") int id, @PathParam("name") String name, @PathParam("sexo") String sexo) {
        return controller.addperson(name, sexo);
    }

    @DeleteMapping("/person")
    public String deletePerson(@PathParam("name") String name) {
        controller.removePerson(name);


        return "Pessoa com o nome de " + name + " foi deletada";
    }

    @GetMapping("/home")
    public String helloWorld() {
        return "Hello world";
    }
}
