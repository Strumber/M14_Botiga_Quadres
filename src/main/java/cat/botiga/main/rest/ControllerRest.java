package cat.botiga.main.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cat.botiga.main.DAO.BotiguesDAO;
import cat.botiga.main.DAO.QuadresDAO;
import cat.botiga.main.models.Botiga;
import cat.botiga.main.models.Quadre;
import cat.botiga.main.service.StoreServiceImpl;


//@Controller
@RestController // Indica que aquesta clase sera un servei REST
@RequestMapping("/") // URL on s' exposa els serveis d' aquesta clase
public class ControllerRest {

	@Autowired
	StoreServiceImpl storeServiceImpl;
	
	@GetMapping("/shops")
	public List<Botiga> listAllStores() {
		return storeServiceImpl.getAllStores();
	}
	
	@PostMapping("/shops")
	public Botiga addStore(@RequestBody Botiga botiga) {
		return storeServiceImpl.addStore(botiga);
	}
	
	@PostMapping("/shops/{id}/pictures")
	public List<Quadre> addPicture(@PathVariable(name="id") Long id, @RequestBody Quadre quadre) {
		Botiga botiga = storeServiceImpl.storeById(id);
		quadre.setData(LocalDateTime.now());
		botiga.addQuadre(quadre);
		storeServiceImpl.updateStore(botiga);
		botiga = storeServiceImpl.storeById(id);
		return botiga.getQuadres();
	}
	
	@GetMapping("/shops/{id}/pictures")
	public List<Quadre> getShopPictures(@PathVariable(name="id") Long id) {
		Botiga store = storeServiceImpl.storeById(id);
		return store.getQuadres();
	}
	
	@DeleteMapping("/shops/{id}/pictures")
	
	
	/*public ResponseEntity<Void> deleteProducto(@PathVariable("botiga_id") Long botiga_id){
		Quadre store = storeServiceImpl.borraQuadresBotiga(botiga_id);
		return ResponseEntity.ok(null);
	}*/
	
	 public Botiga purgeShopPictures(@PathVariable(name="id") Long botiga_id) {
		Botiga botiga = storeServiceImpl.storeById(botiga_id);
		//botiga.borrar(botiga_id);
		botiga.eliminaQuadres(botiga_id);
		//storeServiceImpl.borrar(botiga_id);
		storeServiceImpl.updateStore(botiga);
		return storeServiceImpl.storeById(botiga_id);
	}
	
	/*@GetMapping("/pictures")
	
	 public ResponseEntity<List<Quadre>> getAllQuadres(@RequestParam(required = false) String titol) {
	    try {
	      List<Quadre> quadres = new ArrayList<Quadre>();

	      if (titol == null)
	    	
	        quadresDAO.findAll().forEach(quadres::add);
	      else
	        quadresDAO.findByTitolContaining(titol).forEach(quadres::add);

	      if (quadres.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(quadres, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }*/
	
	
	
	
	
	

	/* LLista Botigues
	@GetMapping("/shops")
	
	 public ResponseEntity<List<Botiga>> getAllBotigues(@RequestParam(required = false) String name) {
	    try {
	      List<Botiga> botigues = new ArrayList<Botiga>();

	      if (name == null)
	    	
	        botiguesDAO.findAll().forEach(botigues::add);
	      else
	        botiguesDAO.findByNameContaining(name).forEach(botigues::add);

	      if (botigues.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(botigues, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/pictures")
	
	 public ResponseEntity<List<Quadre>> getAllQuadres(@RequestParam(required = false) String titol) {
	    try {
	      List<Quadre> quadres = new ArrayList<Quadre>();

	      if (titol == null)
	    	
	        quadresDAO.findAll().forEach(quadres::add);
	      else
	        quadresDAO.findByTitolContaining(titol).forEach(quadres::add);

	      if (quadres.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(quadres, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	

	// LLegir una botiga
	@GetMapping(value = "/shops/{id}") // shops/{id} ---> shops/1
	public ResponseEntity<Botiga> getBotigalById(@PathVariable("id") int id) {
	    Optional<Botiga> botigaData = botiguesDAO.findById(id);

	    if (botigaData.isPresent()) {
	      return new ResponseEntity<>(botigaData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	//Llegit Quadres d' una botiga
	
	/*@GetMapping(value = "/pictures/{botiga_id}") // pictures/{Botiga_id} ---> pictures/1
	
	public ResponseEntity<Quadre> getQuadresByBotiga_Id(@PathVariable("botiga_id") int botiga_id) {
	    List<Quadre> quadreData = quadresDAO.getQuadresByBotiga_Id (botiga_id);

	    if (((Botiga) quadreData).isPresent()) {
	      return new ResponseEntity<>(quadreData.get(botiga_id), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }*/
}
