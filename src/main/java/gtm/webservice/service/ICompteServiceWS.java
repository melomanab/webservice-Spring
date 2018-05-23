package gtm.webservice.service;

import java.util.List;

import gtm.webservice.domaine.ClientProxi;
import gtm.webservice.domaine.Compte;
import gtm.webservice.domaine.Transaction;

/**
 * Interface permettant de definir les services minimaux associes a un compte bancaire
 * @author Stagiaire
 *
 */
public interface ICompteServiceWS {


	/**
	 * Methode permettant d'obtenir la liste de comptes du client associe a l'id specifie en parametre
	 * @param idClient identifiant du client
	 * @return renvoie la liste de comptes associes au client 
	 */
	public List<Compte> obtenirComptesClient(Integer idClient);


	/**
	 * Methode permettant d'obtenir la liste complete de comptes en banque
	 * @return renvoie une liste de comptes
	 */
	public List<Compte> obtenirComptesBanque();


	/**
	 * Methode permettant d'effectuer un virement compte a compte
	 * @param transaction
	 * @return renvoie true si le virement a ete effectue
	 */
	public Boolean virement(Transaction transaction);


	/**
	 * Methode permettant de debiter un compte
	 * @param compte Compte a debiter
	 * @param montant Montant a prelever du compte
	 * @return
	 */
	Boolean debiter(Compte compte, Double montant);

	
	/**
	 * Methode permettant de crediter un compte
	 * @param compte Compte a crediter
	 * @param montant Montant a crediter dans le compte
	 * @return
	 */
	Boolean crediter(Compte compte, Double montant);


	/**
	 * Methode permettant d'obtenir la liste de comptes a decouvert
	 * @return
	 */
	public List<Compte> obtenirComptesDecouvert();
	

}
