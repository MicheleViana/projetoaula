package projetoaula.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoaula.contoller.BancoController;
import projetoaula.model.Conta;
import projetoaula.model.ContaCorrentePF;

import javax.websocket.server.PathParam;

@RestController
public class BancoView<conta> {

    @Autowired
    private BancoController bancoController;

    @GetMapping("/consultasaldo")
    public Double consultaSaldo() {
        Conta conta = new ContaCorrentePF();
        conta.setSaldo(100D);
        return bancoController.consultaSaldo(conta);


    }

    @PostMapping("/criarconta")
    public Conta criarconta(@PathParam("name") String name) {
        bancoController.criarconta(name);
        return null;
    }

    @GetMapping("/type")
    public String listAccounttype() {
        return null;
    }
}


