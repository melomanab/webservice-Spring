package gtm.webservice.presentation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


/**
 * Classe controlleur Spring permettant la redirection a la page de bienvenue
 * @author Stagiaire
 *
 */
@Controller
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


	/**
	 * Méthode liée à l'URL "/welcome" pour une requête GET. 
	 *
	 * @return ModelAndView l'objet de Spring contenant les données du modèle (la
	 *         liste des articles) et le nom de la vue à afficher (welcome).
	 */
	@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	ModelAndView displayIndex() {
		
		IndexController.LOGGER.info("Requête HTTP déclenchant la méthode displayIndex()");
		
		ModelAndView mav = new ModelAndView("welcome");		
			
		return mav;
	}


}
