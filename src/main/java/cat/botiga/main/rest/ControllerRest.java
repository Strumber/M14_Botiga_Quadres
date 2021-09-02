package cat.botiga.main.rest;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	// 2. LListar Botigues (get)
	@GetMapping("/shops")
	public List<Botiga> listAllStores() {
		return storeServiceImpl.getAllStores();
	}

	// 1. Crear botiga (post)
	@PostMapping("/shops")
	public Botiga addStore(@RequestBody Botiga botiga) {
		return storeServiceImpl.addStore(botiga);
	}

	//4) Llistar els quadres de la botiga (GET /shops/{ID}/pictures). 
	@GetMapping("/shops/{id}/pictures")
	public List<Quadre> getShopPictures(@PathVariable(name="id") Integer id) {
		//Botiga store = storeServiceImpl.storeById(id);
		return quadresDAO.findQuadreByBotigaId(id);
	}
	
	// 3. Afegir quadre: li donarem el nom del quadre i el del autor (POST /shops/{ID}/pictures) 
	@PostMapping("/shops/{id}/pictures")
	public ResponseEntity<Quadre> addPicture( @PathVariable(name = "id") Integer id, 
			                         @RequestBody Quadre quadre) {
		//Botiga botiga = storeServiceImpl.storeById(id);		
		//botiga.addQuadre(quadre);
		//quadre.setBotiga(botiga);		
		//botiguesDAO.getAllStoresNameAndCapacity();
		//storeServiceImpl.updateStore(botiga);
		//botiga = storeServiceImpl.storeById(id);
		quadre.setBotigaId(id);
		quadre.setData(LocalDateTime.now());
		Quadre newProducto = quadresDAO.save(quadre);
		return ResponseEntity.ok(newProducto); 
	}
				

	@DeleteMapping("/shops/{id}/pictures")
	@Transactional
	public void purgeShopPictures(@PathVariable(name = "id") Integer botiga_id) {
		quadresDAO.deleteByBotigaId(botiga_id);
		return;
	}

	
	//public ResponseEntity<Void> deleteProductos(@PathVariable("shopid") Integer shopid) {
	//	productosDAO.deleteAllByShopid(shopid);
	//	return ResponseEntity.ok(null);
	//}
}
