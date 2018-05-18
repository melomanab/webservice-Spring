package gtm.webservice.service;

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

import gtm.webservice.auxiliare.SimplePojo;
import gtm.webservice.dao.ClientProxiRepository;
import gtm.webservice.domaine.ClientProxi;

@RestController
@RequestMapping("/api/clientWS")
public class ClientServiceWS {

	/**
	 * Declaration logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceWS.class);

	/**
	 * Injection de la dependance repository par Spring
	 */
	@Autowired
	private ClientProxiRepository clientProxiRepo;
	
	
	private SimplePojo auxiliare;
	
	// TO-DO
	// + creerClient(ClientProxi) : boolean
	/**
	 * Methode pour creer un client en base associe a un conseiller
	 * Fonctionnelles (testée avec Postman)
	 * 
	 * @param client
	 * @return
	 */
	@PostMapping(path = "/creerClient")
	SimplePojo creerClient(@RequestBody ClientProxi client) {
		
		// Insertion par defaut: false 
		auxiliare.setBool(false);

		ClientServiceWS.LOGGER.info("Demande creerClient associe a conseiller: {}", client.getIdConseiller());
		ClientProxi clientEnregistre = this.clientProxiRepo.save(client);

		if (!clientEnregistre.equals(null)) {
			
			// Insertion valide 
			auxiliare.setBool(true);
		}
		return auxiliare;
	}


	/**
	 * Methode pour obtenir le client en base correspondant a l'id specifie
	 * Fonctionnelles (testée avec Postman)
	 * @param idClient
	 * @return
	 */
	@GetMapping("/obtenirClient/{clientId}")
	ClientProxi obtenirClient(@PathVariable Integer clientId) {
		
		ClientServiceWS.LOGGER.info("obtenirClient: {}", clientId);
		ClientProxi clientProxi = this.clientProxiRepo.findById(clientId).get();
		
		return clientProxi;
	}
	

	
	// + modifierClient(ClientProxi) : boolean
	@PutMapping("/modifierClient/{clientId}")
	boolean modifierClient(@PathVariable Integer clientId, 
			@RequestBody ClientProxi clientProxi) {
		
		ClientServiceWS.LOGGER.info("modifierClient: {}", clientId);
		boolean modifie=false;
		
		// important: setId
		clientProxi.setIdClient(clientId);
		ClientProxi clientModifie= this.clientProxiRepo.save(clientProxi);
		
		if(!clientModifie.equals(null)) {
			modifie=true;
		}
		
		return modifie;
	}
	// + supprimerClient(ClientProxi) : boolean
	// + obtenirClientsBanque(Conseiller) : List<ClientProxi>

}
