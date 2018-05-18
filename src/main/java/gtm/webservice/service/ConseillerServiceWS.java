package gtm.webservice.service;

import java.util.ArrayList;
import java.util.List;

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
import gtm.webservice.domaine.ClientProxi;

@RestController
// @RequestMapping("/api/clientProxi")
@RequestMapping("/api/conseillerWS")
public class ConseillerServiceWS {

	/**
	 * Declaration logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ConseillerServiceWS.class);

	/**
	 * Injection de la dependance repository par Spring
	 */
	@Autowired
	private ClientProxiRepository clientProxiRepo;
	
	
	/**
	 * Methode pour lire la liste de ClientProxi d'un Conseiller en base (GET)
	 * @param conseillerId
	 * @return
	 */
	@GetMapping("/obtenirListeClientsConseiller/{conseillerId}")
	List<ClientProxi> obtenirListeClientsConseiller(@PathVariable Integer conseillerId) {
		
		ConseillerServiceWS.LOGGER.info("obtenirListeClientsConseiller : {}", conseillerId);
		List<ClientProxi> listeClients = this.clientProxiRepo.findAll();
		
		List<ClientProxi> listeClientsConseiller = new ArrayList<ClientProxi>();
		for (ClientProxi client : listeClients) {
			if (client.getIdConseiller() == conseillerId) {
				listeClientsConseiller.add(client);
			}
		}
		
		return listeClientsConseiller;
	}
	
	/**
	 *Methodes pas utilisées
	 */
	

	/**
	 * Methode pour lire la liste de ClientProxi en base (GET)
	 * Fonctionnelle (testée avec Postman)
	 * @return
	 */
	@GetMapping(path = { "", "/" })
	List<ClientProxi> list() {

		ConseillerServiceWS.LOGGER.info("GET clients");
		List<ClientProxi> listeClients = this.clientProxiRepo.findAll();
		ConseillerServiceWS.LOGGER.info("{} clients existants en base", listeClients.size());
		return listeClients;
	}
	
	/**
	 * Methode pour lire un ClientProxi (GET)
	 * @param clientId
	 * @return
	 */
	@GetMapping("/client/{clientProxiId}")
	ClientProxi getClient(@PathVariable Integer clientProxiId) {
		
		ConseillerServiceWS.LOGGER.info("GET client id : {}",clientProxiId);
		ClientProxi clientProxi = this.clientProxiRepo.findById(clientProxiId).get();
		
		return clientProxi;
	}
	
	
	
	/**
	 * Methode pour écrire un ClientProxi en base (POST)
	 * Fonctionnelle (testée avec Postman)
	 * @return
	 */
	@PostMapping(path= {"","/"})		
	ClientProxi create(@RequestBody ClientProxi clientProxi) {
	
		ConseillerServiceWS.LOGGER.info("POST client: {}  {}", clientProxi.getNomClient(), clientProxi.getPrenomClient());
		return this.clientProxiRepo.save(clientProxi);
	
	}
	
	/**
	 * Methode pour modifier un ClientProxi en base (PUT)
	 * Fonctionnelle (testée avec Postman)
	 * @param clientProxiId
	 * @param clientProxi
	 * @return
	 */

	@PutMapping("/{clientProxiId}")
	ClientProxi update(@PathVariable Integer clientProxiId, 
			@RequestBody ClientProxi clientProxi) {
		
		// Important: Set id
		clientProxi.setIdClient(clientProxiId);
		
		ConseillerServiceWS.LOGGER.info("PUT client {} : {}  {}", 
				clientProxi.getIdClient(), clientProxi.getNomClient(), clientProxi.getPrenomClient());
		return this.clientProxiRepo.save(clientProxi);
	}
	
	void delete(@PathVariable Integer clientProxiId) {
		ConseillerServiceWS.LOGGER.info("DELETE client {}", clientProxiId);

	}
	
	
	

}
