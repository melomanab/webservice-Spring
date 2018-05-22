package gtm.webservice.service.test;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
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

import gtm.webservice.domaine.ClientProxi;
import gtm.webservice.domaine.Compte;
import gtm.webservice.domaine.Conseiller;
import gtm.webservice.domaine.Transaction;
import gtm.webservice.service.ClientServiceWS;
import gtm.webservice.service.CompteServiceWS;
import gtm.webservice.service.ConseillerServiceWS;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(Parameterized.class)
@ContextConfiguration(locations="test-context.xml")
public class TestCompteServiceWS {
	
	@Autowired
	private CompteServiceWS compteService;
	
	@Autowired
	private ClientServiceWS clientService;
	
	@Autowired
	private ConseillerServiceWS conseillerService;

	private Conseiller conseiller;
	private ClientProxi client;
	
	private Compte compteBeneficiaire;
	private Compte compteEmetteur;
	

	Double soldeInitialBeneficiaire;
	Double soldeFinalBeneficiaire;
	Double soldeInitialEmetteur;
	Double soldeFinalEmetteur;
	Double montant;
	
	private Transaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("---beforeClass");
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("---afterClass");
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("--before");
		
		// Instancier conseiller et l'enregistrer en base
		conseiller =new Conseiller (null, "TEST", "TEST", "TEST", "TEST");
		this.conseillerService.creerConseiller(conseiller);
		
		// Instancier client attache a conseiller et l'enregistrer en base		
		client = new ClientProxi(null, "TEST", "TEST", "TEST", "TEST");
		client.setConseiller(conseiller);
		clientService.creerClient(client);
		
		montant = 1000.0;
		
		// Instancier compte beneficiaire
		soldeInitialBeneficiaire = 10000.0;
		soldeFinalBeneficiaire = 11000.0;
		compteBeneficiaire = new Compte(null, "CB_TEST", "Courant", soldeInitialBeneficiaire, -1000.0);
		compteBeneficiaire.setClient(client);
		System.out.println("compteBeneficiaire:" + compteBeneficiaire.getNumCompte());
		
		// Instancier compte emetteur
		soldeInitialEmetteur = 0.0;
		soldeFinalEmetteur = -1000.0;
		compteEmetteur = new Compte(null, "CE_TEST", "Courant", 0.0, -1000.0);
		compteEmetteur.setClient(client);
		System.out.println("compteEmetteur:" + compteEmetteur.getNumCompte());
		
		// Enregistrer en base associes au client: 2
		compteService.creerCompte(compteBeneficiaire);
		compteService.creerCompte(compteEmetteur);	


		// Instancier transaction
		transaction = new Transaction();
		transaction.setIdCompteBeneficiaire(compteBeneficiaire.getIdCompte());
		transaction.setIdCompteEmmetteur(compteEmetteur.getIdCompte());
		transaction.setMontant(montant);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("--after");
		
		compteService.supprimerCompte(compteBeneficiaire.getIdCompte());
		compteService.supprimerCompte(compteEmetteur.getIdCompte());
		clientService.supprimerClient(client.getIdClient());
		conseillerService.supprimerConseiller(conseiller.getIdConseiller());
	}

	@Test
	public void testCrediter() {
		System.out.println("-testCrediter");
		compteService.crediter(compteBeneficiaire, montant);
		assertThat(compteService.obtenirCompte(compteBeneficiaire.getIdCompte()).getSoldeCompte(), IsEqual.equalTo(soldeFinalBeneficiaire));
	}

	@Test
	public void testDebiter() {
		System.out.println("-testDebiter");
		compteService.debiter(compteEmetteur, montant);
		assertThat(compteService.obtenirCompte(compteEmetteur.getIdCompte()).getSoldeCompte(), IsEqual.equalTo(soldeFinalEmetteur));
	}

	@Test
	public void testVirement() {
		System.out.println("-testVirement");
		compteService.virement(transaction);
		assertThat(compteService.obtenirCompte(compteBeneficiaire.getIdCompte()).getSoldeCompte(), IsEqual.equalTo(soldeFinalBeneficiaire));
		assertThat(compteService.obtenirCompte(compteEmetteur.getIdCompte()).getSoldeCompte(), IsEqual.equalTo(soldeFinalEmetteur));
	}

}
