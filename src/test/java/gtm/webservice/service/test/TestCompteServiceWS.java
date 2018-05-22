package gtm.webservice.service.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gtm.webservice.dao.CompteRepository;
import gtm.webservice.domaine.Compte;
import gtm.webservice.domaine.Transaction;
import gtm.webservice.service.CompteServiceWS;

public class TestCompteServiceWS {
	
	private static CompteServiceWS compteService;
	private static Compte compte1;
	private static Compte compte2;
	
	private static Transaction transaction;
	
	
	


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("beforeClass");
		
		compteService = new CompteServiceWS ();
		
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
		System.out.println("before");
		
		// Instancier compte 1
		compte1 =new Compte(null, "C1TEST", "Courant", 10000.0, 1000.0);
		//compte1.getClient().setIdClient(1);
		
		System.out.println("compte1:" + compte1.getNumCompte());
		
		
		// Instancier compte 2
		compte2 =new Compte(null, "C2TEST", "Courant", 0.0, 0.0);
		//compte2.getClient().setIdClient(1);
		System.out.println("compte2:" + compte2.getNumCompte());
		
		// Enregistrer en base
		Boolean cree = compteService.creerCompte(compte1, 1);
		compteService.creerCompte(compte2, 1);		
		
		System.out.println("compte1 cree:" + cree);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrediter() {
		System.out.println("testCrediter");
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
