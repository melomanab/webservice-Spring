package gtm.webservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.domaine.ClientProxi;
import gtm.webservice.domaine.Conseiller;

/**
 * Interface permettant de definir les services minimaux associes a un conseiller bancaire
 * @author Stagiaire
 *
 */
public interface IConseillerServiceWS {
	

	/**
	 * Methode permettant de recuperer la liste de clients associe au conseiller specifie
	 * @param conseillerId contenant l'id du conseiller en base
	 * @return la liste d'objets de type ClientProxi associee au conseiller 
	 */
	public List<ClientProxi> obtenirListeClientsConseiller(Integer conseillerId);
	

	/**
	 * Methode permettant de verifier si le login et le password du conseiller passe comme parametre
	 * existent en base.
	 * @param conseillerFromUser
	 * @return Conseiller Objet de type Conseiller avec un idConseiller null si l'authentification echoue, ou
	 * un idConseiller different de null et egal a l'idConseiller du conseiller en base
	 */
	public Conseiller authentification(Conseiller conseillerFromUser);

}
