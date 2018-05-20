package gtm.webservice.service;

import java.util.List;

import gtm.webservice.domaine.ClientProxi;
import gtm.webservice.domaine.Compte;

public interface ICompteServiceWS {

	// + obtenirComptesClient(ClientProxi) : List<Compte>

	/**
	 * Methode pour obtenir la liste de comptes du client specifie en parametre
	 * 
	 * @param idClient
	 * @return
	 */
	public List<Compte> obtenirComptesClient(Integer idClient);

	// + obtenirComptesBanque() : List<Compte>

	/**
	 * Methode pour obtenir la liste de comptes en banque
	 * 
	 * @return
	 */
	public List<Compte> obtenirComptesBanque();

	// + virement(Compte,Compte,Double) : Boolean

	/**
	 * Methode permettant d'effectuer un virement compte a compte
	 * 
	 * @param compteEmeteur
	 * @param compteDebiteur
	 * @param montant
	 * @return
	 */
	public Boolean virement(Compte compteEmeteur, Compte compteDebiteur, Double montant);

	// # debiter (Compte, Double): Boolean
	Boolean debiter(Compte compte, Double montant);

	// # crediter (Compte, Double): Boolean
	Boolean crediter(Compte compte, Double montant);

	// + obtenirComptesDecouvert(): List<Compte>
	/**
	 * Methode permettant d'obtenir la liste de comptes a decourvert
	 * @return
	 */
	public List<Compte> obtenirComptesDecouver();

}
