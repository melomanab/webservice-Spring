package gtm.webservice.service;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.dao.TransactionRepository;
import gtm.webservice.domaine.Transaction;

/**
 * Classe qui implemente les services definis dans l'interface ITransactionServiceWS et les expose comme webservices
 * @see gtm.webservice.service.ITransactionServiceWS
 * @author Stagiaire
 *
 */
@RestController
@RequestMapping("/api/transactionWS")
public class TransactionServiceWS implements ITransactionServiceWS {

	@Autowired
	TransactionRepository transationRepo;
	
	@Override
	@GetMapping(path="/obtenirTransactions")
	public List<Transaction> obtenirTransactions() {
		
		List<Transaction> transactionsBanque = this.transationRepo.findAll();
		
		return transactionsBanque;
	}

	@Override
	@GetMapping(path="/decompterTransactions")
	public Map<Date, Integer> decompterTransactions() {
		// TODO Auto-generated method stub

		Date today = new Date();
		
		// Initialiser map
		Map<Date,Integer> transactionsParJour = new HashMap<Date,Integer>();
		for (int day=1; day<32; day++) {
			Date jourDate = new Date(today.getYear(),today.getMonth(),day);
			transactionsParJour.put(jourDate,0);
		}
		
		List<Transaction> transactionsBanque = this.obtenirTransactions();
		
		//Rajouter 1 pour le jour de la transaction
		for (Transaction transaction : transactionsBanque) {
			Date transactionDate = transaction.getDate();
			if ((transactionDate.getYear()==today.getYear())&&(transactionDate.getMonth()==today.getMonth())) {
				Date jourDate = new Date(today.getYear(),today.getMonth(),transactionDate.getDate()+1);
				transactionsParJour.put(jourDate,transactionsParJour.get(jourDate)+1);
			}
		}
		
		return transactionsParJour;
	}

}
