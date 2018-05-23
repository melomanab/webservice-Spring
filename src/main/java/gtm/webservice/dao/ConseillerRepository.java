package gtm.webservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import gtm.webservice.domaine.Conseiller;

/**
 * Interface fournissant une dao sophistiquee pour la classe domaine Conseiller
 * @author Stagiaire
 *
 */
public interface ConseillerRepository extends JpaRepository<Conseiller, Integer> {

	List<Conseiller> findAll();
}
