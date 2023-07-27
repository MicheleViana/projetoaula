package br.org.sesisenai.projetoaula.contoller;

import br.org.sesisenai.projetoaula.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

   @Service
   public class Controller {

      private List<Person> persons = new ArrayList<>();
      private int id = 0;

      public Person findPerson(String name) {
         for (Person p : persons) {
            if (p.getName().equals(name)) {
               return p;

            }
         }
         return null;
      }
   }
