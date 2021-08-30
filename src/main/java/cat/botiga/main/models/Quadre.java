package cat.botiga.main.models;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "quadre")
public class Quadre {

	@Id
	//@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "autor", nullable = false, length = 30)
	private String autor;

	@Column(name = "titol", nullable = false, length = 30)
	private String titol;

	@Column(name = "preu")
	private Double preu;

	@Column(name = "data")
	private LocalDateTime data;
	
	
	

	/* Cascade, tots els tipus menys el REMOVE (Eliminar)per a que no puguis
	// eliminar registres del "pare"
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "Botiga_id")
	private Botiga botiga;*/

	// Constructor per defecte
	public Quadre() {

	}

	

	// Getters & Setters (tots menys data)

	public Quadre(String autor, String titol, Double preu) {
		this.autor = autor;
		this.titol = titol;
		this.preu = preu;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public Double getPreu() {
		return preu;
	}

	public void setPreu(Double preu) {
		this.preu = preu;
	}
	
	
	public LocalDateTime getData() {
		return data;
	}

	
	public void setData(LocalDateTime localDateTime) {
		this.data = localDateTime;
	}
	
	@Override
	public String toString() {
		return "Quadre [id=" + id + ", autor=" + autor + ", titol=" + titol + ", preu=" + preu + ", data=" + data + "]";
	}
	

	/*public Botiga getBotiga() {
		return botiga;
	}

	public void setBotiga(Botiga botiga) {
		this.botiga = botiga;
	}

	public int getBotiga_id() {
		return botiga_id;
	}

	public void setBotiga_id(int botiga_id) {
		this.botiga_id = botiga_id;
	}*/

	// To String Tots el camps menys botiga
	
}
