package projetoaula.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Person {

    @Id
    private Integer id;

    private String name;

    private String sexo;

    @Transient
    private String idade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Integer getId () {
            return id;
        }

        public void setId (Integer id){
            this.id = id;
        }
    }





