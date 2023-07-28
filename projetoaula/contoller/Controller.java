package appwebsenai1.projetoaula.contoller;

import appwebsenai1.projetoaula.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

   @Service
   public class Controller {

      private List<Person> persons = new ArrayList<>();
      private int id = 0;

      public Person addperson(String name, String sexo) {
         Person person = new Person();
         person.setName(name);
         person.setSexo(sexo);
         id++;
         person.setId(id);
         persons.add(person);
         return person;
      }

      public Person findPerson (String name) {
         Person person = findPerson(name);
         if(person.getName().equals(name));
         return person;
      }


      public void removePerson(String name) {
         Person person = findPerson(name);
         if (person != null) {
            persons.remove(person);
            }
         }
      public Person editperson(String name, String sexo) {
         Person person = findPerson(name);
         if (person != null) {
            person.setSexo(sexo);

         }
         return person;
      }
   }





