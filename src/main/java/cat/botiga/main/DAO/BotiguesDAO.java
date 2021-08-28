package cat.botiga.main.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.botiga.main.models.Botiga;



public interface BotiguesDAO extends JpaRepository<Botiga, Integer> {
	
	//List <Botiga> findById (int id);
	List <Botiga> findByNameContaining(String name);
	
	//public List<Botiga> getBotiga();
	
	//public Botiga getBotigaById (int id);
	
	//public Optional<Botiga> findById(int id);
	
	//public void salvaBotiga (Botiga botiga);
	
	//public void modificaBotiga (Botiga botiga);
	
	//public void borraBotigaPerId (int id);

}
