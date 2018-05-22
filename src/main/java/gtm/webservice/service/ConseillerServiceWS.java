package gtm.webservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.dao.ClientProxiRepository;
import gtm.webservice.dao.ConseillerRepository;
import gtm.webservice.domaine.ClientProxi;
import gtm.webservice.domaine.Compte;
import gtm.webservice.domaine.Conseiller;

@RestController
@RequestMapping("/api/conseillerWS")
public class ConseillerServiceWS implements IConseillerServiceWS{

	/**
	 * Declaration logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ConseillerServiceWS.class);

	/**
	 * Injection de la dependance repository par Spring
	 */
	@Autowired
	private ClientProxiRepository clientProxiRepo;
	
	@Autowired
	private ConseillerRepository conseillerRepo;
	
	

	/* (non-Javadoc)
	 * @see gtm.webservice.service.IConseillerServiceWS#obtenirListeClientsConseiller(java.lang.Integer)
	 */
	@GetMapping("/obtenirListeClientsConseiller/{conseillerId}")
	public List<ClientProxi> obtenirListeClientsConseiller(@PathVariable Integer conseillerId) {
		
		ConseillerServiceWS.LOGGER.info("obtenirListeClientsConseiller : {}", conseillerId);
		List<ClientProxi> listeClients = this.clientProxiRepo.findAll();
		
		List<ClientProxi> listeClientsConseiller = new ArrayList<ClientProxi>();
		for (ClientProxi client : listeClients) {
			if (client.getConseiller().getIdConseiller() == conseillerId) {
				listeClientsConseiller.add(client);
			}
		}
		
		return listeClientsConseiller;
	}
	
	@Override
	@PostMapping("/authentification")
	public Conseiller authentification(@RequestBody Conseiller conseillerFromUser) {
		
		Conseiller conseillerSession = new Conseiller();
		
		// Recuperer login et pwd introduits
		String login = conseillerFromUser.getLogin();
		String pwd = conseillerFromUser.getPassword();
	
		ArrayList<Conseiller> listeConseillers = (ArrayList<Conseiller>) this.conseillerRepo.findAll();
		
		for (Conseiller c: listeConseillers) {
			if(c.getLogin().equals(login)) {
				if(c.getPassword().equals(pwd)) {
					
					conseillerSession = c;
					
				}
			}
		}
		return conseillerSession;
	}
	
	
	

	public Boolean creerConseiller(Conseiller conseiller) {

		Boolean insert = false;
		Boolean inBase = false;

		ConseillerServiceWS.LOGGER.info("Demande creation conseiller");

		// Si le conseiller posssede un id
		if (conseiller.getIdConseiller() != null) {

			Optional<Conseiller> conseillerInBdd = this.conseillerRepo.findById(conseiller.getIdConseiller());
			if (conseillerInBdd.isPresent()) {
				inBase = true;
			}

		}

		if (!inBase) {
			Conseiller conseillerEnregistre = this.conseillerRepo.save(conseiller);

			if (!conseillerEnregistre.equals(null)) {
				// Insertion valide
				insert = true;
			}
		}
		return insert;
	}
	
	public Boolean supprimerConseiller(Integer idConseiller) {

		ConseillerServiceWS.LOGGER.info("Demande suppression Conseiller: {}", idConseiller);

		Boolean inBase = false;
		Boolean delete = false;

		Optional<Conseiller> ConseillerInBase = this.conseillerRepo.findById(idConseiller);

		if (ConseillerInBase.isPresent()) {			
			inBase=true;		
		}
		
		if(inBase==true) {
			this.conseillerRepo.deleteById(idConseiller);
			delete=true;			
		}

		return delete;
	}





	
	
	

}
