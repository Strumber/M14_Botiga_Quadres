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

	public Botiga storeById(Long id) {
		return botiguesDAO.findById(id).get();
	}
	
	public void updateStore(Botiga botiga){
		botiguesDAO.save(botiga);
	}
	
	//no Funciona
	public void borrar(Long id) {
		List<Quadre> it = quadresDAO.findAll();

		for (Quadre li:it) {
			
			if (li.getId().equals(id)) {
				
				it.clear();
			}
			
			
		}
		
	}

	
}