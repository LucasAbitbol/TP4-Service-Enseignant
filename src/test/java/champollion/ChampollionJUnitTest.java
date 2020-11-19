package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Intervention CM,TD,TP;
        Salle s;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                s = new Salle ("B222", 40);
                CM = new Intervention(s, uml, untel, new Date(), 2, TypeIntervention.CM);
                TD = new Intervention(s, java, untel, new Date(), 4, TypeIntervention.TD);
                TP = new Intervention(s, java, untel, new Date(), 3, TypeIntervention.TP);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        public void testAjouteHeureCM() {
            untel.ajouteEnseignement(java, 10, 0, 0);
            
            assertEquals(10*1.5, untel.heuresPrevues(), "L'enseignant doit avoir 15 heures prévues");
        }
        
        public void testSousService() {
            untel.ajouteEnseignement(uml, 0, 10, 0);
            assertEquals(true, untel.enSousService(), "L'enseignant est en sous service");
            untel.ajouteEnseignement(uml, 0, 202, 0);
            assertEquals(false, untel.enSousService(), "L'enseignant n'est pas en sous service");
        }

}
