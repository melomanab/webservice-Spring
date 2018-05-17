package gtm.webservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domaine.Client;



public interface ClientRepository extends JpaRepository<Client, Integer>  {
	
	List<Client> findAllByNomContaining(String stringWithinNom);
	List<Client> findAll();
	
}
