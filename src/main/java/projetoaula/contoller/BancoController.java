package projetoaula.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoaula.model.AccountType;
import projetoaula.model.Conta;
import projetoaula.model.ContaCorrentePF;
import projetoaula.model.Person;
import projetoaula.view.PersonView;

import java.util.Date;
import java.util.List;

@Service
public class BancoController  {
    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private Controller personController;

    private Long number = 0L;


    public ContaCorrentePF criarconta(String name, String accountType) throws Exception {
        ContaCorrentePF contacorrentePF = new ContaCorrentePF();
        StringBuilder message = new StringBuilder();
        if (accountType == null) {
            message.append("\nNecessário informar o tipo da conta");
        }

        switch (accountType) {
            case "POUPANÇA":
                contacorrentePF.setAccountType(AccountType.CONTA_POUPANCA);
                break;
            case "CORRENTE":
                contacorrentePF.setAccountType(AccountType.CONTA_CORRENTE);
            default:
                message.append("\nTipo da conta não é suportado!");
        }

        Person person = personController.findPerson(name);
        if (person != null) {
            number++;
            contacorrentePF.setNumeroConta(number);
            contacorrentePF.setPessoa(person);
            bancoRepository.save(contacorrentePF);
        } else if (contacorrentePF.getError() == null)

            message.append("\nPessoa");
        message.append(name).append("\ninformada não foi cadastrada");
        contacorrentePF.setError(message.toString());

        if (message.isEmpty())
            contacorrentePF.setError(message.toString());

        return contacorrentePF;

    }

    public ContaCorrentePF consultaconta(String name) {

        List<ContaCorrentePF> contas = (List<ContaCorrentePF>) bancoRepository.findAll();

        for (ContaCorrentePF cc : contas) ;
        {
            ContaCorrentePF cc = null;
            if (cc.getPessoa() != null && cc.getPessoa().getName().equals(name)) {
                if (cc.getDataAtualizacao().equals(new Date()))
                    return cc;
            } else {

                cc.setDataAtualizacao(new Date());
                cc.setSaldo(cc.getSaldo() * 1.001);
                bancoRepository.save(cc);
            }
        }

        return null;
    }


    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade;
        conta.setSaldo(total);

    }


    public String transferir(Long contaOrigem, Long contaDestino, Double valor) {
        String message = "";
        ContaCorrentePF destino = bancoRepository.findById(contaDestino).get();
        ContaCorrentePF origem = bancoRepository.findById(contaOrigem).get();

        if (origem.getSaldo() >= valor) {
            destino.setSaldo(destino.getSaldo() + valor);
            origem.setSaldo(origem.getSaldo() - valor);
            bancoRepository.save(destino);
            bancoRepository.save(origem);
            message = " A conta da(o)" + destino.getPessoa().getName() + "recebeu a transferência no valor de R$ " + valor;
        } else {
            message = message + "Saldo insuficiente para a operação";
        }

        return message;

    }


    public Double consultaSaldo(ContaCorrentePF conta) {
        return conta.getSaldo();
    }
}
