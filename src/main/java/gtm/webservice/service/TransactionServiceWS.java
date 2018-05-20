package gtm.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.dao.TransactionRepository;
import gtm.webservice.domaine.Transaction;

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

}
