package cat.botiga.main.models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "quadre")
public class Quadre {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "autor", nullable = false, length = 30)
	private String autor;

	@Column(name = "titol", nullable = false, length = 30)
	private String titol;

	@Column(name = "preu")
	private Double preu;

	@Column(name = "data")
	private Date data;

	// Cascade, tots els tipus menys el REMOVE (Eliminar)per a que no puguis
	// eliminar registres del "pare"
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "Botiga_id")
	private Botiga botiga;

	// Constructor per defecte
	public Quadre() {

	}

	// Constructors de tipus data , o Gragorian Calendar ?????
	public Quadre(Date data) {
		this.data = data;
	}

	// Getters & Setters (tots menys DATA)

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Botiga getBotiga() {
		return botiga;
	}

	public void setBotiga(Botiga botiga) {
		this.botiga = botiga;
	}

	// To String Tots el camps menys botiga
	@Override
	public String toString() {
		return "Quadre [id=" + id + ", autor=" + autor + ", titol=" + titol + ", preu=" + preu + ", data=" + data + "]";
	}
}
