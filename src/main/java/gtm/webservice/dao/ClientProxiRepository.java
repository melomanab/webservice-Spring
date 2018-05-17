package gtm.webservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domaine.ClientProxi;

public interface ClientProxiRepository extends JpaRepository<ClientProxi, Integer>  {
	
	List<ClientProxi> findAll();
}
