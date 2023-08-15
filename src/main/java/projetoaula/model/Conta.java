package projetoaula.model;

import javax.persistence.Entity;


public abstract class Conta {


    private Long numeroConta;

    private Person pessoa;

    private Double saldo;

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }



    public void setPerson(Person person) {
        this.pessoa = getPessoa();
    }
    public Person getPessoa() {
        return pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }




}
