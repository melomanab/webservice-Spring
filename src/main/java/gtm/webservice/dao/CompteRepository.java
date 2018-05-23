package gtm.webservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtm.webservice.domaine.Compte;

/**
 * Interface fournissant une dao sophistiquee pour la classe domaine Compte
 * @author Stagiaire
 *
 */
public interface CompteRepository extends JpaRepository<Compte, Integer> {

	List<Compte> findAll();
}
