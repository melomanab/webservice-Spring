package gtm.webservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.dao.ClientProxiRepository;
import gtm.webservice.domaine.ClientProxi;

@RestController
@RequestMapping("/api/clientWS")
public class ClientServiceWS implements IClientServiceWS {
	// public class ClientServiceWS{

	/**
	 * Declaration logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceWS.class);

	/**
	 * Injection de la dependance repository par Spring
	 */
	@Autowired
	private ClientProxiRepository clientProxiRepo;

	/**
	 * Methode pour creer un client en base associe a un conseiller Fonctionnelles
	 * (testée avec Postman)
	 * 
	 * @param client
	 * @return
	 */
	@PostMapping(path = "/creerClient")
	public Boolean creerClient(@RequestBody ClientProxi client) {

		Boolean insert = false;
		Boolean inBase = false;

		ClientServiceWS.LOGGER.info("Demande creation client associe a conseiller: {}", client.getConseiller().getIdConseiller());

		// Si le client posssede un id
		if (client.getIdClient() != null) {

			Optional<ClientProxi> clientInBdd = this.clientProxiRepo.findById(client.getIdClient());
			if (clientInBdd.isPresent()) {
				inBase = true;
			}

		}

		if (!inBase) {
			ClientProxi clientEnregistre = this.clientProxiRepo.save(client);

			if (!clientEnregistre.equals(null)) {
				// Insertion valide
				insert = true;
			}
		}
		return insert;
	}

	/**
	 * Methode pour obtenir le client en base correspondant a l'id specifie
	 * Fonctionnelles (testée avec Postman)
	 * 
	 * @param idClient
	 * @return
	 */
	@GetMapping("/obtenirClient/{idClient}")
	public ClientProxi obtenirClient(@PathVariable Integer idClient) {

		ClientServiceWS.LOGGER.info("Demande obtention client: {}", idClient);
		Optional<ClientProxi> clientProxi = this.clientProxiRepo.findById(idClient);
		
		if (clientProxi.isPresent()) {
				return clientProxi.get();
		} else {
			return null;
		}
	}

	/**
	 * Methode pour modifier le client en base correspondant a l'id specifie dans
	 * l'url
	 * 
	 * @param idClient
	 * @param clientProxi
	 * @return modifie, true si le client a ete effectivement modifie en base
	 */
	@PutMapping("/modifierClient/{idClient}")
	public ClientProxi modifierClient(@PathVariable Integer idClient, @RequestBody ClientProxi clientProxi) {

		ClientServiceWS.LOGGER.info("Demande modification client: {}", idClient);

		//Boolean modifie = false;

		Optional<ClientProxi> clientInBase = this.clientProxiRepo.findById(idClient);
		ClientProxi clientFromBase = new ClientProxi();

		if (clientInBase.isPresent()) {			
			
			clientProxi.setConseiller(clientInBase.get().getConseiller());	

			// important: associer l'id passe en parametre avec l'objet client
			clientProxi.setIdClient(idClient);

			ClientProxi clientModifie = this.clientProxiRepo.save(clientProxi);
			clientFromBase = this.clientProxiRepo.findById(idClient).get();
			
			if (!clientFromBase.equals(null)) {
				// modifie = true;				
			}
		}
		
		return clientFromBase;
		// return modifie;
	}

	@Override
	@DeleteMapping("supprimerClient/{idClient}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Boolean supprimerClient(@PathVariable Integer idClient) {

		ClientServiceWS.LOGGER.info("Demande suppression client: {}", idClient);

		Boolean inBase = false;
		Boolean delete = false;

		Optional<ClientProxi> clientInBase = this.clientProxiRepo.findById(idClient);

		if (clientInBase.isPresent()) {			
			inBase=true;		
		}
		
		if(inBase==true) {
			this.clientProxiRepo.deleteById(idClient);
			delete=true;			
		}

		return delete;
	}

	/*
	 * @DeleteMapping("/{articleId}")
	 * 
	 * @ResponseStatus(code = HttpStatus.NO_CONTENT) void delete(@PathVariable
	 * Integer articleId) { this.articleRepo.deleteById(articleId); }
	 */

	@Override
	@GetMapping("/obtenirClientsBanque")
	public List<ClientProxi> obtenirClientsBanque() {
		// TODO Auto-generated method stub
		return  this.clientProxiRepo.findAll();
	}

}
