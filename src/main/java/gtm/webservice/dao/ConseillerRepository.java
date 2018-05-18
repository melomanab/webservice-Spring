package gtm.webservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import gtm.webservice.domaine.Conseiller;

public interface ConseillerRepository extends JpaRepository<Conseiller, Integer> {

	List<Conseiller> findAll();
}
