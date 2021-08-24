package cat.botiga.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.botiga.models.Botiga;

@RestController
@RequestMapping ("/shops")
public class ControllerRest {
	
	@GetMapping
	public ResponseEntity<Botiga> getBotiga(){
		Botiga botiga = new Botiga();
		botiga.setId(1);
		botiga.setName("Botiga 1");
		botiga.setCapacity(10);
		
		return ResponseEntity.ok(botiga);
	}
	/*public String hello() {
		return "hello world";
	}*/

}
