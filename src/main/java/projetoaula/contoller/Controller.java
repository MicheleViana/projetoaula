package projetoaula.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import projetoaula.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

   @Service
   public class Controller {
       public List<Person> listAll;
       @Autowired
       private PersonRepository personRepository;
       private List<Person> persons = new ArrayList<>();
       private int id = 0;

       public Person findPerson(String name){
           List<Person> persons = (List<Person>) personRepository.findAll();
           for(Person person : persons){
               if(name.equals(person.getName())){
                   return person;
               }
           }

           return null;
       }

       public Person addPerson(String name, String sexo){
           Person person = new Person();
           person.setName(name);
           person.setSexo(sexo);
           id++;
           person.setId(id);
           personRepository.save(person);
           return person;
       }

       public void removePerson(String name){
           Person person = findPerson(name);
           personRepository.delete(person);
       }

       public Person editPerson(String name, String sexo){
           Person person = findPerson(name);
           person.setSexo(sexo);
           personRepository.save(person);
           return person;
       }

       public List<Person> listAll(){
           return (List<Person>)personRepository.findAll();
       }

       public Person addperson(String name, String sexo) {
           Person person = new Person();
           person.setName(name);
           person.setSexo(sexo);
           id++;
           person.setId(id);
           personRepository.save(person);
           return person;
       }
   }