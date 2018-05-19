package gtm.webservice.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clientProxi")
@JsonIgnoreProperties({"comptesClient"})
public class ClientProxi {
	
	// Proprietées
	@Id
	@Column(name="idClient", unique=true)
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
	
	//@ManyToOne(targetEntity=Conseiller.class)
	//@JoinColumn(name = "idConseiller", referencedColumnName = "idConseiller")
	// @Column
	@ManyToOne
	private Conseiller conseiller;
	
	// Nécessaire pour permettre la suppression d'un client en supprimant les comptes à ForeignKey associés
	// @OneToMany(targetEntity=Compte.class, cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	@OneToMany(mappedBy="client", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	//@JoinColumn(name = "idClient", referencedColumnName = "idClient")
	private List<Compte> comptesClient;

	/**
	 * Constructeur vide
	 */
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
		this.comptesClient = new ArrayList<Compte>();
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

	
	public Conseiller getConseiller() {
		return conseiller;
	}


	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}


	public List<Compte> getComptesClient() {
		return comptesClient;
	}


	public void setComptesClient(List<Compte> comptesClient) {
		this.comptesClient = comptesClient;
	}

	
	
	
	


	
	

}
