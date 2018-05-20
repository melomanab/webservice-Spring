package gtm.webservice.service;

import java.util.List;
import java.util.Map;

import gtm.webservice.domaine.Transaction;

public interface ITransactionServiceWS {

	/**
	 * Permet d'obtenir la liste complete des transactions de la banque
	 * @return
	 */
	List<Transaction> obtenirTransactions();
	
	//+ decompterTransactions() : Map <String,Integer>
	Map <Integer,Integer> decompterTransactions();



	

}
