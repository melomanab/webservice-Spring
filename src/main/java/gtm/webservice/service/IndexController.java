package gtm.webservice.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import gtm.webservice.domaine.Client;



@Controller
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	
	/**
	 * Injection du bean id="client".
	 */
	@Autowired
	private Client client;

	/**
	 * Injection du bean d'implémentation d'ArticleRepository généré par Spring.
	 */
//	@Autowired
//	private ClientRepository clientRepository;
	
//	@Autowired
//	private ServiceClient clientService;


	/**
	 * Méthode liée à l'URL "/welcome" pour une requête GET. Le client contacte
	 * cette page lorsqu'il veut afficher la page d'accueil avec la liste des
	 * articles.
	 *
	 * @return ModelAndView l'objet de Spring contenant les données du modèle (la
	 *         liste des articles) et le nom de la vue à afficher (welcome).
	 */
	@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	ModelAndView displayIndex() {
		
		IndexController.LOGGER.info("Requête HTTP déclenchant la méthode displayIndex().");
		
		ModelAndView mav = new ModelAndView("welcome");
		
		
//		final List<Client> clientsModele = new ArrayList<>();
//		clientsModele.add(this.client);
		
		// --- Pas s'acces directe à la DAO depuis le controlleur!
//		List<Client> clientsBdd = clientService.listeClients();
//		clientsBdd.add(this.client);
//		IndexController.LOGGER.info("Liste clients chagée via clientService");
//		mav.getModel().put("clients", clients);
		
		
		
		return mav;
	}


}
