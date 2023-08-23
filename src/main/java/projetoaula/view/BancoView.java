package projetoaula.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoaula.contoller.BancoController;
import projetoaula.model.AccountType;
import projetoaula.model.Conta;
import projetoaula.model.ContaCorrentePF;
import projetoaula.model.Person;

import javax.websocket.server.PathParam;

@RestController
public class BancoView<conta> {

    @Autowired
    private BancoController bancoController;

    @PostMapping("/criarconta")
    public ContaCorrentePF criarconta(@PathParam("name") String name,@PathParam("type") String type) throws Exception {
        String accountType = null;
        return bancoController.criarconta(name, type);

    }

    @GetMapping("/type")
    public String listAccountType() {
        String text = AccountType.CONTA_CORRENTE + "," + AccountType.CONTA_POUPANCA;
        return text;

    }


    @GetMapping("/consultaconta")
    public ContaCorrentePF consultaConta(@PathParam("name") String name ){
        return bancoController.consultaconta(name);
    }

    @PutMapping("/transferir")
    public  String transferir(@PathParam("contaOrigem") Long contaOrigem, @PathParam("contaDestino") Long contaDestino, @PathParam("valor")Double valor){
    return bancoController.transferir(contaOrigem,contaDestino,valor);
    }
}



