package gtm.webservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.dao.CompteRepository;
import gtm.webservice.dao.TransactionRepository;
import gtm.webservice.domaine.ClientProxi;
import gtm.webservice.domaine.Compte;
import gtm.webservice.domaine.Conseiller;
import gtm.webservice.domaine.Transaction;

/**
 * Classe qui implemente les services definis dans l'interface ICompteServiceWS et les expose comme webservices
 * @see gtm.webservice.service.ICompteServiceWS
 * @author Stagiaire
 *
 */
@RestController
@RequestMapping("api/compteWS")
public class CompteServiceWS implements ICompteServiceWS {

	/**
	 * Declaration logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CompteServiceWS.class);

	/**
	 * Injection de la dependance CompteRepository par Spring
	 */
	@Autowired
	private CompteRepository compteRepo;

	/**
	 * Injection de la dependance repository par Spring
	 */
	@Autowired
	private TransactionRepository transactionRepo;

	
	
	public Boolean creerCompte(Compte compte) {

		Boolean insert = false;
		Boolean inBase = false;

		CompteServiceWS.LOGGER.info("Demande creation compte associe a client: {}", compte.getClient().getIdClient());

		// Si le compte posssede un id
		if (compte.getIdCompte() != null) {

			Optional<Compte> compteInBdd = this.compteRepo.findById(compte.getIdCompte());
			if (compteInBdd.isPresent()) {
				inBase = true;
			}

		}

		if (!inBase) {
			Compte compteEnregistre = this.compteRepo.save(compte);

			if (!compteEnregistre.equals(null)) {
				// Insertion valide
				insert = true;
			}
		}
		return insert;
	}

	public Boolean supprimerCompte(Integer idCompte) {

		CompteServiceWS.LOGGER.info("Demande suppression Compte: {}", idCompte);

		Boolean inBase = false;
		Boolean delete = false;

		Optional<Compte> CompteInBase = this.compteRepo.findById(idCompte);

		if (CompteInBase.isPresent()) {			
			inBase=true;		
		}
		
		if(inBase==true) {
			this.compteRepo.deleteById(idCompte);
			delete=true;			
		}

		return delete;
	}
	
	public Compte obtenirCompte( Integer idCompte) {

		CompteServiceWS.LOGGER.info("Demande obtention Compte: {}", idCompte);
		Optional<Compte> Compte = this.compteRepo.findById(idCompte);
		
		if (Compte.isPresent()) {
				return Compte.get();
		} else {
			return null;
		}
	}
	
	
	@Override
	@GetMapping(path = "/obtenirComptesClient/{idClient}")
	public List<Compte> obtenirComptesClient(@PathVariable Integer idClient) {

		CompteServiceWS.LOGGER.info("Demande obtention comptes du client {}", idClient);
		List<Compte> comptesClient = new ArrayList<Compte>();

		List<Compte> comptesBanque = this.compteRepo.findAll();

		// Pour chaque compte
		for (Compte c : comptesBanque) {
			// si l'idClient est egal a celui du client
			if (c.getClient().getIdClient() == idClient) {
				// rajouter a comptesClient
				comptesClient.add(c);
			}
		}
		return comptesClient;
	}

	@Override
	public Boolean crediter(Compte compte, Double montant) {

		CompteServiceWS.LOGGER.info(">Demande credit de {}EUR sur compte numero: {}", montant, compte.getNumCompte());
		CompteServiceWS.LOGGER.info(">>Ancien solde: {}", compte.getSoldeCompte());

		Boolean credit = false;

		if (montant > 0) {

			// Calcul nouveau montant
			Double nouveauSolde = compte.getSoldeCompte() + montant;

			// Credit et enregistrement en base
			compte.setSoldeCompte(nouveauSolde);
			this.compteRepo.save(compte);
			credit = true;

		} else {
			CompteServiceWS.LOGGER.info("ECHEC TRANSACTION: Le montant introduit doit etre strictement positif");

		}
		CompteServiceWS.LOGGER.info(">>Nouveau solde: {}", compte.getSoldeCompte());

		return credit;
	}

	@Override
	public Boolean debiter(Compte compte, Double montant) {

		CompteServiceWS.LOGGER.info(">Demande debit de {}EUR sur compte numero: {}", montant, compte.getNumCompte());
		CompteServiceWS.LOGGER.info(">>Ancien solde: {}", compte.getSoldeCompte());

		Boolean debit = false;

		if (montant > 0) {

			// Calcul nouveau solde
			Double nouveauSolde = compte.getSoldeCompte() - montant;

			// Autorisation debit que si nouveau solde superieur ou egal a decourvert max
			if (nouveauSolde >= compte.getDecouvertMaxCompte()) {

				// Debit
				compte.setSoldeCompte(nouveauSolde);
				this.compteRepo.save(compte);
				debit = true;
			} else {
				CompteServiceWS.LOGGER.info("ECHEC TRANSACTION: Solde insuffisant");
			}
		} else {
			CompteServiceWS.LOGGER.info("ECHEC TRANSACTION: Le montant introduit doit etre strictement positif");
		}
		CompteServiceWS.LOGGER.info(">>Nouveau solde: {}", compte.getSoldeCompte());

		return debit;
	}

	@Override
	@GetMapping(path = "/obtenirComptesBanque")
	public List<Compte> obtenirComptesBanque() {

		CompteServiceWS.LOGGER.info("Demande obtention de la totalite de comptes de la banque");

		List<Compte> comptesBanque = this.compteRepo.findAll();

		CompteServiceWS.LOGGER.info("{} comptes charges", comptesBanque.size());

		return comptesBanque;
	}

	@Override
	@PostMapping(path = "/virement")
	public Boolean virement(@RequestBody Transaction transaction) {

		CompteServiceWS.LOGGER.info("Demande de virement");

		Boolean succes = false;

		// Recuperer bjets transaction
		Compte cEmetteur = new Compte();
		Compte cBeneficiaire = new Compte();
		Double montant = transaction.getMontant();

		Optional<Compte> cEmetteurInBase = this.compteRepo.findById(transaction.getIdCompteEmetteur());
		Optional<Compte> cBeneficiaireInBase = this.compteRepo.findById(transaction.getIdCompteBeneficiaire());

		if (cEmetteurInBase.isPresent() & cBeneficiaireInBase.isPresent()) {

			// Comptes emetteur et beneficiaire valides
			cEmetteur = cEmetteurInBase.get();
			cBeneficiaire = cBeneficiaireInBase.get();

			if (cEmetteur.getIdCompte() == cBeneficiaire.getIdCompte()) {

				CompteServiceWS.LOGGER.info("ECHEC: Le compte emetteur doit etre different du compte beneficiaire");
				return false;
			}

			// Si authorization debit
			Boolean debit = this.debiter(cEmetteur, montant);
			if (debit) {

				// Realiser credit
				this.crediter(cBeneficiaire, montant);

				// Enregistrement de transaction avec la date courante
				Date today = new Date();
				transaction.setDate(today);

				this.transactionRepo.save(transaction);
				succes = true;

				CompteServiceWS.LOGGER.info("SUCCES TRANSACTION: Operation enregistree le {}", today);

			}

		} else {
			CompteServiceWS.LOGGER.info("ECHEC: Compte emetteur ou beneficiaire inexistant");
		}

		return succes;
	}

	@Override
	@GetMapping(path="/obtenirComptesDecouvert")
	public List<Compte> obtenirComptesDecouvert() {

		CompteServiceWS.LOGGER.info("Demande obtention comptes a decouvert");

		List<Compte> comptesDecouvert = new ArrayList<Compte>();

		// Obtenir comptes banque
		List<Compte> comptesBanque = this.obtenirComptesBanque();

		// Pour chaque compte de la banque
		for (Compte c : comptesBanque) {
			// Si le solde est inferieur a 0
			if (c.getSoldeCompte() < 0) {
				// Ajouter a liste de comptes a decourvert
				comptesDecouvert.add(c);
			}

		}

		CompteServiceWS.LOGGER.info("{} comptes a decouvert trouvees", comptesDecouvert.size());

		return comptesDecouvert;
	}

}
