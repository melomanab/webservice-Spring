package gtm.webservice.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
	@Column(name="idCompte")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompte;
	
	@Column
	private String numCompte;
	
	@Column
	private String typeCompte;
	
	@Column
	private Double soldeCompte;
	
	@Column
	private Double decouvertMaxCompte;
	
	@Column
	private Integer idClient;

		
	
	public Compte() {
		super();
	}



	public Compte(Integer idCompte, String numCompte, String typeCompte, Double soldeCompte, Double decouvertMaxCompte,
			Integer idClient) {
		super();
		this.idCompte = idCompte;
		this.numCompte = numCompte;
		this.typeCompte = typeCompte;
		this.soldeCompte = soldeCompte;
		this.decouvertMaxCompte = decouvertMaxCompte;
		this.idClient = idClient;
	}



	public Integer getIdCompte() {
		return idCompte;
	}



	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}



	public String getNumCompte() {
		return numCompte;
	}



	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}



	public String getTypeCompte() {
		return typeCompte;
	}



	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}



	public Double getSoldeCompte() {
		return soldeCompte;
	}



	public void setSoldeCompte(Double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}



	public Double getDecouvertMaxCompte() {
		return decouvertMaxCompte;
	}



	public void setDecouvertMaxCompte(Double decouvertMaxCompte) {
		this.decouvertMaxCompte = decouvertMaxCompte;
	}



	public Integer getIdClient() {
		return idClient;
	}



	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	
	
	
	
	
	
	

}
