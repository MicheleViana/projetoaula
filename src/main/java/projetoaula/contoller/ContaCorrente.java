package projetoaula.contoller;

import projetoaula.model.AccountType;
import projetoaula.model.Conta;
import projetoaula.model.ContaCorrentePF;
import projetoaula.model.Person;

import javax.persistence.*;
import java.util.Date;


public interface ContaCorrente{
    Double sacar(Double quantidade, Conta conta);

    void depositar(Double quantidade, Conta conta);

    String transferir(Long contaOrigem, Long contaDestino, Double valor);

    Double consultaSaldo(ContaCorrentePF conta);

}