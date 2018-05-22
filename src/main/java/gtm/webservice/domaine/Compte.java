package gtm.webservice.domaine;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="compte")
@JsonIgnoreProperties({"client"})
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
	
	@ManyToOne
	//@ManyToOne(targetEntity=ClientProxi.class)
	//@JoinColumn(name = "idClient", referencedColumnName = "idClient")
	private ClientProxi client;

		
	
	public Compte() {
		super();
	}



	public Compte(Integer idCompte, String numCompte, String typeCompte, 
			Double soldeCompte, Double decouvertMaxCompte) {
		super();
		this.idCompte = idCompte;
		this.numCompte = numCompte;
		this.typeCompte = typeCompte;
		this.soldeCompte = soldeCompte;
		this.decouvertMaxCompte = decouvertMaxCompte;
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



	public ClientProxi getClient() {
		return client;
	}



	public void setClient(ClientProxi client) {
		this.client = client;
	}


	
	
	
	
	

}
