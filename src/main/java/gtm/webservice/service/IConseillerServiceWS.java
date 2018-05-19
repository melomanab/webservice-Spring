package gtm.webservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtm.webservice.domaine.ClientProxi;

public interface IConseillerServiceWS {
	

	public List<ClientProxi> obtenirListeClientsConseiller(@PathVariable Integer conseillerId);

}
