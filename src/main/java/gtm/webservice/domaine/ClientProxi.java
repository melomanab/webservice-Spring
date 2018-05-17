package gtm.webservice.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientProxi")
public class ClientProxi {
	
	// Proprietées
	@Id
	@Column(name="idClient")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
	
	@Column
	private String nomClient;
	
	@Column
	private String prenomClient;
	
	@Column
	private String emailClient;
	
	@Column
	private String adresseClient;
		
	@Column
	private Integer idConseiller;
	
	
	public ClientProxi() {
		super();
	}
	
	
	public ClientProxi(Integer idClient, String nomClient, String prenomClient, String emailClient,
			String adresseClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
		this.idConseiller = 1;
	}




	public Integer getIdClient() {
		return idClient;
	}


	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getPrenomClient() {
		return prenomClient;
	}


	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}


	public String getEmailClient() {
		return emailClient;
	}


	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}


	public String getAdresseClient() {
		return adresseClient;
	}


	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}


	public Integer getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(Integer idConseiller) {
		this.idConseiller = idConseiller;
	}
	
	
	
	
	


	
	

}
