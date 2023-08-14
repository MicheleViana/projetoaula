package projetoaula.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoaula.model.AccountType;
import projetoaula.model.Conta;
import projetoaula.model.ContaCorrentePF;
import projetoaula.model.Person;
import projetoaula.view.PersonView;

import java.util.List;

@Service
public class BancoController  implements ContaCorrente {
    @Autowired
    private BancoRepository bancoRepository;

    private Long number = 0L;

    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    public Conta criarconta(String name, String accountType) throws Exception {
        ContaCorrentePF contacorrentePF = new ContaCorrentePF();
        StringBuilder message = new StringBuilder();
        if (accountType == null) {
            message.append("\nNecessário informar o tipo da conta");
        }

        switch (accountType) {
            case "POUPANÇA":
                ContaCorrentePF.setAccountType(AccountType.CONTA_POUPANCA);
                break;
            case "CORRENTE":
                contacorrentePF.setAccountType(AccountType.CONTA_CORRENTE);
            default:
                message.append("\nTipo da conta não é suportado!");
        }
        PersonView controller = null;
        Person person = controller.findPerson(name);
        if (person != null) {
            number++;
            contacorrentePF.setNumeroConta(number);
            contacorrentePF.setPerson(person);
            bancoRepository.save(contacorrentePF);
        } else if (contacorrentePF.getError() == null)

            message.append("\nPessoa");
        message.append(name).append("\ninformada não foi cadastrada");
        contacorrentePF.setError(message.toString());

        if (message.isEmpty())
            contacorrentePF.setError(message.toString());

        return contacorrentePF;

    }

    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade;
        conta.setSaldo(total);

    }

    @Override
    public void transferir(Double quantidade, Conta conta) {

    }

    public ContaCorrentePF consultaconta(String name) {

        List<ContaCorrentePF> contas = (List<ContaCorrentePF>) bancoRepository.findAll();

        for (ContaCorrentePF cc : contas) ;
        ContaCorrentePF cc;
        if (cc.getPerson() !(null && cc.getPerson().getName().equals(name)) {
            return cc;
        }
    }
}

