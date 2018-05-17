package gtm.webservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.domain.Client;
import gtm.webservice.domain.ClientProxi;
import gtm.webservice.repository.ClientProxiRepository;
import gtm.webservice.repository.ClientRepository;

@RestController
@RequestMapping("/api/clientProxi")
public class ClientProxiWS {

	/**
	 * Declaration logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientProxiWS.class);

	/**
	 * Injection repository
	 */
	@Autowired
	private ClientProxiRepository clientProxiRepo;

	/**
	 * Methode pour lire la liste de ClientProxi en base (GET)
	 * Fonctionnelle
	 * @return
	 */
	@GetMapping(path = { "", "/" })
	List<ClientProxi> list() {

		ClientProxiWS.LOGGER.info("GET clients");
		List<ClientProxi> listeClients = this.clientProxiRepo.findAll();
		ClientProxiWS.LOGGER.info("{} clients existants en base", listeClients.size());
		return listeClients;
	}
	
	/**
	 * Methode pour écrire un ClientProxi en base (POST)
	 * Fonctionnelle
	 * @return
	 */
	@PostMapping(path= {"","/"})		
	ClientProxi create(@RequestBody ClientProxi clientProxi) {
	
		ClientProxiWS.LOGGER.info("POST client: {}  {}", clientProxi.getNomClient(), clientProxi.getPrenomClient());
		return this.clientProxiRepo.save(clientProxi);
	
	}
	
	ClientProxi update(@PathVariable Integer clientProxiId, 
			@RequestBody ClientProxi clientProxi) {
		clientProxi.setIdClient(clientProxiId);
		
		// ClientProxiWS.LOGGER.info("PUT client {} : {}  {}", clientProxi.getId(), client.getNom(), client.getPrenom());
		return this.clientProxiRepo.save(clientProxi);
	}
	

}
