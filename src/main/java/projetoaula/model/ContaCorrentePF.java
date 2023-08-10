package projetoaula.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class ContaCorrentePF extends Conta{
    @Id
    private Long numeroConta;
    @OneToOne
    private Person pessoa;

    private Double saldo;

    private AccountType accountType;

    @Transient
    private String error;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

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
    @OneToOne
    private  Person person;
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}