package gtm.webservice.service;

import java.util.List;

import gtm.webservice.domaine.ClientProxi;

/**
 * Interface permettant de definir les services minimaux associes a un client en banque
 * @author Stagiaire
 *
 */
public interface IClientServiceWS {
	

	/**
	 * Methode metier permettant de creer un client en base de donnees
	 * avec les informations passees comme parametre
	 * @param client contient les informations du client a envoyer en base
	 * @return renvoie true si l'enregistrement a ete possible
	 */
	public Boolean creerClient(ClientProxi client);
	

	/**
	 * Methode metier permettant d'obtenir un client a partir de son id
	 * @param idClient contenant l'id du client en base
	 * @return renvoie un objet ClientProxi avec les informations du client en base
	 */
	public ClientProxi obtenirClient(Integer idClient);
	

	/**
	 * Methode permettant de modifier un client en base 
	 * @param idClient contenant l'id du client en base
	 * @param client
	 * @return contient les nouvelles informations du client a envoyer en base
	 */
	public ClientProxi modifierClient(Integer idClient, ClientProxi client);
	

	/**
	 * Methode permettant de supprimer un client en base
	 * @param idClient contenant l'id du client en base
	 * @return renvoie true si la suppression a etee effectuee
	 */
	public Boolean supprimerClient(Integer idClient);
	

	/**
	 * Methode permettant d'obtenir une liste avec la totalite de clients enregistres en base
	 * @return renvoie une liste avec la totalite de clients enregistres en base
	 */
	public List<ClientProxi> obtenirClientsBanque();

}
