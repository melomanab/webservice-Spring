package gtm.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domain.Client;



public interface ClientRepository extends JpaRepository<Client, Integer>  {
	
	List<Client> findAllByNomContaining(String stringWithinNom);
	List<Client> findAll();
	
}
