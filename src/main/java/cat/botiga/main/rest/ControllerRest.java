package cat.botiga.main.rest;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cat.botiga.main.DAO.BotiguesDAO;
import cat.botiga.main.DAO.QuadresDAO;
import cat.botiga.main.models.Botiga;
import cat.botiga.main.models.Quadre;
import cat.botiga.main.service.StoreServiceImpl;

@RestController // Indica que aquesta clase sera un servei REST
@RequestMapping("/") // URL on s' exposa els serveis d' aquesta clase
public class ControllerRest {

	@Autowired
	StoreServiceImpl storeServiceImpl;

	@Autowired
	QuadresDAO quadresDAO;

	@Autowired

	BotiguesDAO botiguesDAO;

	// LListar Botigues (get)
	
	@GetMapping("/shops")
	public List<Botiga> listAllStores() {
		return storeServiceImpl.getAllStores();
	}

	// Crear botiga (post)
	@PostMapping("/shops")
	public Botiga addStore(@RequestBody Botiga botiga) {
		return storeServiceImpl.addStore(botiga);
	}

	
	@GetMapping("/shops/{id}/pictures")
	public List<Quadre> getShopPictures(@PathVariable(name="id") Long id) {
		Botiga store = storeServiceImpl.storeById(id);
		return store.getQuadres();
	}
	
		
	@PostMapping("/shops/{id}/pictures")
	public List <Quadre> addPicture(@PathVariable(name = "id") Long id, @RequestBody Quadre quadre) {
		Botiga botiga = storeServiceImpl.storeById(id);
		quadre.setData(LocalDateTime.now());
		botiga.addQuadre(quadre);
		quadre.setBotiga(botiga);
		
		botiguesDAO.getAllStoresNameAndCapacity();
		storeServiceImpl.updateStore(botiga);
		botiga = storeServiceImpl.storeById(id);
						
		return null; //botiga.getQuadres(id);
	}

	@DeleteMapping("/shops/{id}/pictures")
	@Transactional
	public Botiga purgeShopPictures(@PathVariable(name = "id") Long botiga_id) {
		quadresDAO.deleteByBotiga_id(botiga_id);
		// storeServiceImpl.borrar(botiga_id)

		return storeServiceImpl.storeById(botiga_id);
	}

}
