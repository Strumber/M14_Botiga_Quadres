package cat.botiga.main.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<List<Botiga>> getBotiga() {

		List<Botiga> botigues = botiguesDAO.findAll();
		return ResponseEntity.ok(botigues);
	}

	// Lista Quadres
	@GetMapping("/pictures")
	public ResponseEntity<List<Quadre>> getQuadre() {

		List<Quadre> quadres = quadresDAO.findAll();
		return ResponseEntity.ok(quadres);
	}

	// LLegir una botiga
	@RequestMapping(value = "/shops/{botigaId}") // shops/{botiga_id} ---> shops/1
	public ResponseEntity<Botiga> getBotigaById(@PathVariable("botigaId") int botigaId) {
		Optional<Botiga> optionalBotiga = botiguesDAO.findById(botigaId);
		if (optionalBotiga.isPresent()) {
			return ResponseEntity.ok(optionalBotiga.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// LLegir quadres
		@RequestMapping(value = "/pictures/{botigaId}") // pictures/{botiga_id} ---> pictures/1
		public ResponseEntity<Quadre> getQuadreById(@PathVariable("botigaId") int botiga_id) {
			Optional<Quadre> optionalQuadre = quadresDAO.findById(integer id);
			if (optionalQuadre.isPresent()) {
				return ResponseEntity.ok(optionalQuadre.get());
			} else {
				return ResponseEntity.noContent().build();
			}
		}
}
