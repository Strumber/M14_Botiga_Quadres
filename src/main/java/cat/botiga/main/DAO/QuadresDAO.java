package cat.botiga.main.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.botiga.main.models.Botiga;
import cat.botiga.main.models.Quadre;



public interface QuadresDAO extends JpaRepository<Quadre, Integer> {
	
	List <Quadre> findByBotigaId (int Botiga_id);
	List <Quadre> findByTitolContaining(String titol);
	
	
	//List<Quadre> findQuadreByBotiga_Id(int botiga_id);
	
	/*void deleteQuadreByBotiga_id(int botiga_id);
	List<Quadre> findQuadreByBotiga (Botiga botiga);*/

}
