package gtm.webservice.domaine;

import gtm.webservice.domaine.ClientProxi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="conseiller")
@JsonIgnoreProperties({"clientsConseiller"})
public class Conseiller {
	
	@Id
	@Column(name="idConseiller")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConseiller;
	
	@Column
	private String nomConseiller;
	
	@Column
	private String prenomConseiller;
	
	@Column
	private String login;
	
	@Column
	private String password;
	
	@OneToMany(mappedBy="conseiller",cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<ClientProxi> clientsConseiller;
	
	

	public Conseiller() {
		super();
	}


	public Conseiller(Integer idConseiller, String nomConseiller, String prenomConseiller, String login,
			String password) {
		super();
		this.idConseiller = idConseiller;
		this.nomConseiller = nomConseiller;
		this.prenomConseiller = prenomConseiller;
		this.login = login;
		this.password = password;
		this.clientsConseiller = new ArrayList<ClientProxi>();
	}


	public Integer getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(Integer idConseiller) {
		this.idConseiller = idConseiller;
	}


	public String getNomConseiller() {
		return nomConseiller;
	}


	public void setNomConseiller(String nomConseiller) {
		this.nomConseiller = nomConseiller;
	}


	public String getPrenomConseiller() {
		return prenomConseiller;
	}


	public void setPrenomConseiller(String prenomConseiller) {
		this.prenomConseiller = prenomConseiller;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<ClientProxi> getClientsConseiller() {
		return clientsConseiller;
	}


	public void setClientsConseiller(List<ClientProxi> clientsConseiller) {
		this.clientsConseiller = clientsConseiller;
	}
	
	
		

}
