package cat.botiga.main.DAO;

import java.util.Iterator;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.botiga.main.models.Quadre;



public interface QuadresDAO extends JpaRepository<Quadre, Long> {

	//Iterator<Quadre> iterator();
	
	/*List <Quadre> getQuadresByBotiga_Id (int botiga_id);
	List <Quadre> findByTitolContaining(String titol);
	
	
	//List<Quadre> findQuadreByBotiga_Id(int botiga_id);
	
	/*void deleteQuadreByBotiga_id(int botiga_id);
	List<Quadre> findQuadreByBotiga (Botiga botiga);*/

}
