package projetoaula.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="conta")
public class ContaCorrentePF {

    @Id
    @Column(name = "numero_conta")
    private Long numeroConta;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person pessoa;

    private Double saldo;
    @Column(name = "type")
    private AccountType accountType;


    @Transient
    private String error;

@Transient
    public Date dataAtualizacao;

    public Long getNumeroConta() {
        return numeroConta;
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

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}



