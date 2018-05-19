package gtm.webservice.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import gtm.webservice.dao.ClientProxiRepository;
import gtm.webservice.domaine.ClientProxi;



@Controller
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	
	/**
	 * Injection du bean id="clientProxi".
//	 */
//	@Autowired
//	private ClientProxi clientProxi;
	
	/**
	 * Injection du bean ClientServiceWS généré par Spring.
//	 */
//	@Autowired
//	private ClientProxiRepository clientProxiRepository;
	


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
//		// Charger la liste de clients
//		List<ClientProxi> listeClients = this.clientProxiRepository.findAll();
		
//		final List<Article> articles = new ArrayList<>();
//		articles.add(this.article);
////		articles.addAll(this.articleRepository.findAll());
//		mav.getModel().put("listeClients", listeClients);
			
		return mav;
	}


}
