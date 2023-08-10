package projetoaula.contoller;

import org.springframework.data.repository.CrudRepository;
import projetoaula.model.ContaCorrentePF;

public interface BancoRepository extends CrudRepository<ContaCorrentePF, Long> {
}
