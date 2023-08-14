package projetoaula.model;

import javax.persistence.*;

@Entity
@Table(name ="conta")
public class ContaCorrentePF extends Conta{
    @Id
    @Column(name = "numero conta")
    private Long numeroConta;
    @OneToOne
    private Person pessoa;

    private Double saldo;
    @Column(name ="type")
    private AccountType accountType;

    @Transient
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public AccountType getAccountType() {
        return accountType;
    }

    public static void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Person getPerson() {
        return pessoa;
    }

    public void setPerson(Person pessoa) {
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

}