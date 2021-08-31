package cat.botiga.main.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.botiga.main.DAO.BotiguesDAO;
import cat.botiga.main.DAO.QuadresDAO;
import cat.botiga.main.models.Botiga;
import cat.botiga.main.models.Quadre;

@Service
public class StoreServiceImpl implements StoreService {

	// Inyeccio de dependencies
		@Autowired
		private BotiguesDAO botiguesDAO;
		@Autowired
		private QuadresDAO quadresDAO;

	@Override
	public List<Botiga> getAllStores() {
		return botiguesDAO.getAllStoresNameAndCapacity();
	}
	
	@Override
	public Botiga addStore(Botiga botiga) {
		return botiguesDAO.save(botiga);
	}

	@Override
	public Quadre addFrame(Long id, Quadre quadre) {
		//TO-DO create relationship between Frame and Store tables
		return quadresDAO.save(quadre);
	}
	@Override
	public Botiga storeById(Long id) {
		return  botiguesDAO.getById(id);
	}
	@Override
	public void updateStore(Botiga botiga){
		botiguesDAO.save(botiga);
	}
	public long mostrarQuadres (Long botiga_id) {
		
		return quadresDAO.getQuadresByBotiga_Id(botiga_id);
	}

	/*public Botiga storeById(Iterable<Long> botiga_id) {
		// TODO Auto-generated method stub
		return null;
	}*/
	

	
}