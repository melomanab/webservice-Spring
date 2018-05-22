package gtm.webservice.service.test;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gtm.webservice.domaine.Conseiller;
import gtm.webservice.service.ConseillerServiceWS;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(Parameterized.class)
@ContextConfiguration(locations="test-context.xml")
public class TestConseillerServiceWS {

	@Autowired
	private ConseillerServiceWS conseillerService;
	
	private Conseiller conseiller;
	
	String loginValide = "monLogin";
	String passwordValide = "monPassword";
	String loginInvalide = "monLapin";
	String passwordInvalide = "monPoussin";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		conseiller = new Conseiller(null,"TEST","TEST",loginValide,passwordValide);
		conseillerService.creerConseiller(conseiller);
	}

	@After
	public void tearDown() throws Exception {
		conseillerService.supprimerConseiller(conseiller.getIdConseiller());
	}

	@Test
	public void testAuthentificationValide() {
		Conseiller conseillerFromUser = new Conseiller(null,null,null,loginValide,passwordValide);
		Conseiller conseillerSession = conseillerService.authentification(conseillerFromUser);
		assertThat(conseillerSession.getIdConseiller(),IsNull.notNullValue());
		assertThat(conseillerSession.getIdConseiller(),IsEqual.equalTo(conseiller.getIdConseiller()));
	}

	@Test
	public void testAuthentificationLoginInvalide() {
		Conseiller conseillerFromUser = new Conseiller(null,null,null,loginInvalide,passwordValide);
		Conseiller conseillerSession = conseillerService.authentification(conseillerFromUser);
		assertThat(conseillerSession.getIdConseiller(),IsNull.nullValue());
	}

	@Test
	public void testAuthentificationPasswordInvalide() {
		Conseiller conseillerFromUser = new Conseiller(null,null,null,loginValide,passwordInvalide);
		Conseiller conseillerSession = conseillerService.authentification(conseillerFromUser);
		assertThat(conseillerSession.getIdConseiller(),IsNull.nullValue());
	}

	@Test
	public void testAuthentificationLoginPasswordInvalides() {
		Conseiller conseillerFromUser = new Conseiller(null,null,null,loginInvalide,passwordInvalide);
		Conseiller conseillerSession = conseillerService.authentification(conseillerFromUser);
		assertThat(conseillerSession.getIdConseiller(),IsNull.nullValue());
	}
}
