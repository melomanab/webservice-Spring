package gtm.webservice.service;

import java.util.List;

import gtm.webservice.domaine.ClientProxi;

public interface IClientServiceWS {
	
//	+ creerClient(ClientProxi) : boolean
	public Boolean creerClient(ClientProxi client);
	
//	+ obtenirClient(Integer) : ClientProxi
	public ClientProxi obtenirClient(Integer idClient);
	
//	+ modifierClient(ClientProxi) : boolean
	public ClientProxi modifierClient(Integer idClient, ClientProxi client);
	
//	+ supprimerClient(ClientProxi) : boolean
	public Boolean supprimerClient(Integer idClient);
	
//	+ obtenirClientsBanque(Conseiller) : List<ClientProxi>
	public List<ClientProxi> obtenirClientsBanque();

}
