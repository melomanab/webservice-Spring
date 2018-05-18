package gtm.webservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domaine.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {

	List<Compte> findAll();
}
