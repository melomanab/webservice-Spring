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
	
	
	

}
