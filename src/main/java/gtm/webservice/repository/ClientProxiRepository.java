package gtm.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domain.ClientProxi;

public interface ClientProxiRepository extends JpaRepository<ClientProxi, Integer>  {
	
	List<ClientProxi> findAll();
}
