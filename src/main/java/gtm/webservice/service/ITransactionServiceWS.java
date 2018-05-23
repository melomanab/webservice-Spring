package gtm.webservice.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gtm.webservice.domaine.Transaction;

/**
 * Interface permettant de definir les services minimaux associes aux transactions bancaires
 * @author Stagiaire
 *
 */
public interface ITransactionServiceWS {

	/**
	 * Methode metier permettant d'obtenir la liste complete des transactions de la banque
	 * @return
	 */
	List<Transaction> obtenirTransactions();
	

	/**
	 * Methode metier permettant de regrouper les transactions par jour du mois courant
	 * @return
	 */
	Map <Date,Integer> decompterTransactions();



	

}
