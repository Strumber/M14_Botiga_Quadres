package cat.botiga.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "quadres")
public class Quadre {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "autor", nullable = false, length = 30)
	private String autor;

	@Column(name = "titol", nullable = false, length = 30)
	private String titol;

	private Double preu;

	private Date data;

	// Cascade, tots els tipus menys el REMOVE (Eliminar)per a que no puguis
	// eliminar registres del "pare"
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "botiga_id")
	private Botiga botiga;
	
	//Constructor per defecte
	public Quadre() {
	}

			// Constructors de tipus data , o Gragorian Calendar ?????
	public Quadre(Date data) {
		this.data = data;
	}



	// Getters & Setters (tots menys DATA)
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

