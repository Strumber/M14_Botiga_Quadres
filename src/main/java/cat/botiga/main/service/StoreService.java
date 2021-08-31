package cat.botiga.main.service;

import java.util.List;
import cat.botiga.main.models.Botiga;
import cat.botiga.main.models.Quadre;

public interface StoreService {
	public List<Botiga> getAllStores();
	
	public Botiga addStore(Botiga botiga);
	
	public Quadre addFrame(Long id, Quadre quadre);
	
	public Botiga storeById(Long id);
	
	public void updateStore(Botiga botiga);
	
		
}
