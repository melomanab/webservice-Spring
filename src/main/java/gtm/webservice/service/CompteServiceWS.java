package gtm.webservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.dao.CompteRepository;
import gtm.webservice.domaine.ClientProxi;
import gtm.webservice.domaine.Compte;

@RestController
@RequestMapping("api/compteWS")
public class CompteServiceWS implements ICompteServiceWS {
	
	/**
	 * Declaration logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CompteServiceWS.class);
	
	/**
	 * Injection de la dependance repository par Spring
	 */
	@Autowired
	private CompteRepository compteRepo;

	@Override
	@GetMapping(path="/obtenirComptesClient/{idClient}")
	public List<Compte> obtenirComptesClient(@PathVariable Integer idClient) {
		
		CompteServiceWS.LOGGER.info("Demande obtention comptes du client {}", idClient);
		List<Compte> comptesClient = new ArrayList<Compte> ();
		
		List<Compte> comptesBanque = this.compteRepo.findAll();
		
		// Pour chaque compte
		for (Compte c: comptesBanque) {
			// si l'idClient est egal a celui du client
			if(c.getClient().getIdClient() == idClient) {
				// rajouter a comptesClient
				comptesClient.add(c);
			}
		}		
		return comptesClient;
	}
	


	@Override
	public Boolean crediter(Compte compte, Double montant) {
	
		CompteServiceWS.LOGGER.info("Demande debit de {}EUR sur compte numero: {}", montant, compte.getNumCompte());
		CompteServiceWS.LOGGER.info("--Ancien solde: {}", compte.getSoldeCompte());
		
		
		Boolean credit = false;
		
		if (montant > 0) {
			
			credit=true;
			
			// Credit 
			Double nouveauSolde = compte.getSoldeCompte() + montant;
			compte.setSoldeCompte(nouveauSolde);
			
			// Enregistrement en base
			this.compteRepo.save(compte);
			
		}
		CompteServiceWS.LOGGER.info("--Nouveau solde: {}", compte.getSoldeCompte());
						
		return credit;
	}
	
	@Override
	public Boolean debiter(Compte compte, Double montant) {
		
		
		return null;
	}

	@Override
	@GetMapping(path="/obtenirComptesBanque")
	public List<Compte> obtenirComptesBanque() {
		
		CompteServiceWS.LOGGER.info("Demande obtention de la totalite de comptes de la banque");
				
		List<Compte> comptesBanque = this.compteRepo.findAll();
		
		CompteServiceWS.LOGGER.info("{} comptes charges", comptesBanque.size());
		
		return comptesBanque;
	}

	@Override
	public Boolean virement(Compte compteEmeteur, Compte compteDebiteur, Double montant) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Compte> obtenirComptesDecouver() {
		// TODO Auto-generated method stub
		return null;
	}

}
