package projetoaula.model;

import javax.persistence.Entity;


public abstract class Conta {


    private Long numeroConta;

    private Person pessoa;

    private Double saldo;


    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Person getPessoa() {
        return pessoa;
    }

    public void setPessoa(Person pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
