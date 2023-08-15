package projetoaula.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="conta")
public abstract class ContaCorrentePF extends Conta {

    @Id
    @Column(name = "numero conta")
    private Long numeroConta;
    @OneToOne
    private Person pessoa;

    private Double saldo;
    @Column(name = "type")
    private AccountType accountType;

    @Transient
    private String error;


    public Date dataAtualizacao;

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountType getAccountType() {
        return accountType;
    }


    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Long getNumeroConta() {
        return numeroConta;
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
    private Person person;

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public abstract Double sacar(Double quantidade, Conta conta);

    public abstract void depositar(Double quantidade, Conta conta);

    public abstract String transferir(Long contaOrigem, Long contaDestino, Double valor);

    public abstract Double consultaSaldo(ContaCorrentePF conta);
}



