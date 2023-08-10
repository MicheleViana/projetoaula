package projetoaula.contoller;

import projetoaula.model.Conta;

public interface ContaCorrente {

  Double sacar (Double quantidade, Conta conta);

    void depositar (Double quantidade,Conta conta);

    void transferir (Double quantidade,Conta conta);

   Double consultaSaldo (Conta conta);


}
