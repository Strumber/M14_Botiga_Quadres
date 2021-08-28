package cat.botiga.main.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cat.botiga.main.DAO.BotiguesDAO;
import cat.botiga.main.DAO.QuadresDAO;
import cat.botiga.main.models.Botiga;
import cat.botiga.main.models.Quadre;

//@Controller
@RestController // Indica que aquesta clase sera un servei REST
@RequestMapping("/") // URL on s' exposa els serveis d' aquesta clase
public class ControllerRest {

	// Inyeccio de dependencies
	@Autowired
	private BotiguesDAO botiguesDAO;
	@Autowired
	private QuadresDAO quadresDAO;

	// LLista Botigues
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
	public ResponseEntity<Botiga> geBotigalById(@PathVariable("id") int id) {
	    Optional<Botiga> BotigaData = botiguesDAO.findById(id);

	    if (BotigaData.isPresent()) {
	      return new ResponseEntity<>(BotigaData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
}
