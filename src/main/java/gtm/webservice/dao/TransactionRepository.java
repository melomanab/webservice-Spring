package gtm.webservice.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domaine.Transaction;


/**
 * Interface fournissant une dao sophistiquee pour la classe domaine Transaction
 * @author Stagiaire
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	List<Transaction> findAll();

}
