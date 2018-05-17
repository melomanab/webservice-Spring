package gtm.webservice.controller;

import java.util.List;

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


import gtm.webservice.domain.Client;
import gtm.webservice.repository.ClientRepository;


@RestController
@RequestMapping("/api/client")
public class ClientWS {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientWS.class);
	
	@Autowired 
	private ClientRepository clientRepo;
	
	// Read all (GET)
	// Test config: OK
	@GetMapping(path= {"","/"})
	List<Client> list(){
		
		ClientWS.LOGGER.info("GET clients");
		List<Client> listeClients = this.clientRepo.findAll();
		ClientWS.LOGGER.info("{} clients existants en base", listeClients.size());
		return listeClients;
	}
	
	// Create (POST)
	@PostMapping(path= {"","/"})
	Client create(@RequestBody Client client) {
		
		ClientWS.LOGGER.info("POST client: {}  {}", client.getNom(), client.getPrenom());
		return this.clientRepo.save(client);
	}

	// Read (GET)
	@GetMapping("/{clientId}")
	Client read(@PathVariable Integer clientId) {
		
		ClientWS.LOGGER.info("GET client: {}", clientId);
		return this.clientRepo.findById(clientId).get();
		
	}
		
	// Update (PUT)
	@PutMapping("/{clientId}")
	Client update(@PathVariable Integer clientId, @RequestBody Client client) {
		client.setId(clientId);
		ClientWS.LOGGER.info("PUT client {} : {}  {}", client.getId(), client.getNom(), client.getPrenom());
		return this.clientRepo.save(client);
		
	}
	
	// Delete (DELETE)
	@DeleteMapping("/{clientId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer clientId) {	
		ClientWS.LOGGER.info("DELETE client {}", clientId);
		this.clientRepo.deleteById(clientId);
	}
	

}
