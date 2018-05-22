package gtm.webservice.service.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gtm.webservice.dao.CompteRepository;
import gtm.webservice.domaine.ClientProxi;
import gtm.webservice.domaine.Compte;
import gtm.webservice.domaine.Transaction;
import gtm.webservice.service.ClientServiceWS;
import gtm.webservice.service.CompteServiceWS;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="test-context.xml")
public class TestCompteServiceWS {
	
	/**
	 * Declaration logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TestCompteServiceWS.class);

	@Autowired
	private CompteServiceWS compteService;
	
	private Compte compte1;
	private Compte compte2;
	
	private Transaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("---beforeClass");
		TestCompteServiceWS.LOGGER.info("Before class");
		
		// Recuperer client de la base sur lequel realiser les tests
		/// ClientProxi client= compteService.obtenirClient();
		//compteService = new CompteServiceWS();
		//System.out.println(compteService.obtenirComptesBanque());
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println(compteService.obtenirComptesBanque());
		
		System.out.println("--before");
		
		// Instancier compte 1
		compte1 =new Compte(null, "C1TEST", "Courant", 10000.0, 1000.0);
		// compte1.setClient(new ClientProxi()).setIdClient(1);
		
		System.out.println("compte1:" + compte1.getNumCompte());
		
		// Instancier compte 2
		compte2 =new Compte(null, "C2TEST", "Courant", 0.0, 0.0);
		//compte2.getClient().setIdClient(1);
		System.out.println("compte2:" + compte2.getNumCompte());
		
		// Enregistrer en base associes au client: 2
		Boolean cree1= compteService.creerCompte(compte1, 2);
		compteService.creerCompte(compte2, 2);		
		
		System.out.println("compte1 cree:" + cree1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrediter() {
		System.out.println("-testCrediter");
		fail("Not yet implemented");
	}

	@Test
	public void testDebiter() {
		fail("Not yet implemented");
	}

	@Test
	public void testVirement() {
		fail("Not yet implemented");
	}

}
