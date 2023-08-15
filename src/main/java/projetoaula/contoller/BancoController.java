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
public class BancoController extends ContaCorrentePF {
    @Autowired
    private BancoRepository bancoRepository;

    private Long number = 0L;

    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    public Conta criarconta(String name, String accountType) throws Exception {
        ContaCorrentePF contacorrentePF = new ContaCorrentePF(dataAtualizacao) {
            @Override
            public Double sacar(Double quantidade, Conta conta) {
                return null;
            }

            @Override
            public void depositar(Double quantidade, Conta conta) {

            }

            @Override
            public String transferir(Long contaOrigem, Long contaDestino, Double valor) {
                return null;
            }

            @Override
            public Double consultaSaldo(ContaCorrentePF conta) {
                return null;
            }
        };
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
    public ContaCorrentePF consultaconta(String name) {

        List<ContaCorrentePF> contas = (List<ContaCorrentePF>) bancoRepository.findAll();

        for (ContaCorrentePF cc : contas) ;{
            ContaCorrentePF cc = null;
            if (cc.getPerson() != null && cc.getPerson().getName().equals(name)) {
                if(cc.getDataAtualizacao().equals(new Date()))
                    return cc;
            }else{

                cc.setDataAtualizacao( new Date());
                cc.setSaldo(cc.getSaldo() * 1.001);
                bancoRepository.save(cc);
            }
        }

        return null;
    }
    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade;
        conta.setSaldo(total);

    }
    @Override
    public String transferir(Long contaOrigem, Long contaDestino, Double valor) {
        String message ="";
        ContaCorrentePF destino = bancoRepository.findById(contaDestino).get();
        ContaCorrentePF origem = bancoRepository.findById(contaOrigem).get();

            if(origem.getSaldo() >= valor){
                destino.setSaldo(destino.getSaldo()+ valor);
                origem.setSaldo(origem.getSaldo() - valor);
                bancoRepository.save(destino);
                bancoRepository.save(origem);
                message =" A conta da(o)"+ destino.getPerson().getName() + "recebeu a transferência no valor de R$ " + valor;
            }else{
                message = message+ "Saldo insuficiente para a operação";
            }

            return message;

    }

    @Override
    public Double consultaSaldo(ContaCorrentePF conta) {
        return conta.getSaldo();
    }
}
