package projetoaula.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoaula.contoller.BancoController;
import projetoaula.model.AccountType;
import projetoaula.model.Conta;
import projetoaula.model.ContaCorrentePF;

import javax.websocket.server.PathParam;

@RestController
public class BancoView<conta> {

    @Autowired
    private BancoController bancoController;

    @PostMapping("/criarconta")
    public Conta criarconta(@PathParam("name") String name,@PathParam("type") String AccountType) throws Exception {
        String accountType = null;
        return bancoController.criarconta(name, AccountType);

    }

    @GetMapping("/type")
    public String listAccountType() {
        String text = AccountType.CONTA_CORRENTE + "," + AccountType.CONTA_POUPANCA;
        return text;

    }


    @GetMapping("/consultaconta")
    public ContaCorrentePF consultaConta(@PathParam("name") String name ){
        return bancoController.consultaconta(conta);


    }
}



