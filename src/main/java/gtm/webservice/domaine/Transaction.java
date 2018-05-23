package gtm.webservice.domaine;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe representant une transaction de la banque ProxiBanque
 * Elle est declaree comme entite JPA et se corresponde avec la table "transaction" dans la base de donnees
 * @author Stagiaire
 *
 */

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@Column(name="idTransaction")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTransaction;
	
	private Date date;
	
	private Integer idCompteEmetteur;
	
	private Integer idCompteBeneficiaire;
	
	private Double montant;

	
	public Transaction() {
		super();
	}


	public Transaction(Integer idTransaction, Date date, Integer idCompteEmmeteur,
			Integer idCompteBeneficiaire, Double montant) {
		super();
		this.idTransaction = idTransaction;
		this.date = date;
		this.idCompteEmetteur = idCompteEmmeteur;
		this.idCompteBeneficiaire = idCompteBeneficiaire;
		this.montant = montant;
	}


	public Integer getIdTransaction() {
		return idTransaction;
	}


	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getIdCompteEmetteur() {
		return idCompteEmetteur;
	}


	public void setIdCompteEmmetteur(Integer idCompteEmmeteur) {
		this.idCompteEmetteur = idCompteEmmeteur;
	}


	public Integer getIdCompteBeneficiaire() {
		return idCompteBeneficiaire;
	}


	public void setIdCompteBeneficiaire(Integer idCompteBeneficiaire) {
		this.idCompteBeneficiaire = idCompteBeneficiaire;
	}


	public Double getMontant() {
		return montant;
	}


	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	

}
