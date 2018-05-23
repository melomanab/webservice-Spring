package gtm.webservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domaine.ClientProxi;

/**
 * Interface fournissant une dao sophistiquee pour la classe domaine ClientProxi
 * @author Stagiaire
 *
 */
public interface ClientProxiRepository extends JpaRepository<ClientProxi, Integer>  {
	
	List<ClientProxi> findAll();
}
