package gtm.webservice.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domaine.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	List<Transaction> findAll();

}
