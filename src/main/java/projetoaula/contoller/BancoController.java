package projetoaula.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoaula.model.Conta;
import projetoaula.model.ContaCorrentePF;

@Service
public class BancoController  implements ContaCorrente{
    @Autowired
    private BancoRepository bancoRepository;

    private Long number = 0L;
    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    public Conta criarconta(String name) {
        ContaCorrentePF contacorrentePF = new ContaCorrentePF();
        number++;
        contacorrentePF.setNumeroConta(number);
        bancoRepository.save(contacorrentePF);
        return contacorrentePF;
    }

    @Override
    public void depositar(Double quantidade,Conta conta) {
       Double total = conta.getSaldo() + quantidade;
       conta.setSaldo(total);

    }

    @Override
    public void transferir(Double quantidade, Conta conta) {

    }

    @Override
    public Double consultaSaldo(Conta conta) {
        return conta.getSaldo();
    }


}
