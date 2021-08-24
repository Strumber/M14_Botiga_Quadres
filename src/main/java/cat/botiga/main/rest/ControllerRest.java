package cat.botiga.main.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.botiga.main.models.Botiga;

@RestController			//Indica que aquesta clase sera un servei REST
@RequestMapping ("/")	//URL on s' exposa els serveis d' aquesta clase
public class ControllerRest {
	
	@GetMapping("hello")
	public String hello() {
		return "hello world";
	}
	
	/*@GetMapping ("")
	public ResponseEntity<Botiga> getBotiga(){
		Botiga botiga = new Botiga();
		botiga.setId(1);
		botiga.setName("Botiga 1");
		botiga.setCapacity(10);
		
		return ResponseEntity.ok(botiga);
	}*/

	

}
