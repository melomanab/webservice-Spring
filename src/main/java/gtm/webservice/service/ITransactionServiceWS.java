package gtm.webservice.service;

import java.util.List;

import gtm.webservice.domaine.Transaction;

public interface ITransactionServiceWS {
	
	List<Transaction> obtenirTransactions();

}
