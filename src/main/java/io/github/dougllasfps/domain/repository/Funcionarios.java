package io.github.dougllasfps.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.dougllasfps.domain.entity.Funcionario;




public interface Funcionarios  extends  JpaRepository<Funcionario, Integer>{
	
	// Equivalente ao like, mas não precisamos nos preocupar com o sinal de percentual. 
    // Podemos usar também EndingWith, Containing.
    List<Funcionario> findByNomeStartingWith(String nome);
    @Query("from Funcionario where nome like concat(?1, '%')")
    List<Funcionario> pesquisarFuncionarios(String nome);

}
