package cat.botiga.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "botiques")
public class Botiga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genera camps clau
	@Column(name = "id")
	private long id;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "capacity")
	private int capacity;

	// Constructors per defecte
	public Botiga() {
	}

	// Constrintor amb parametres sense id que es autonumèric

	public Botiga(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	// Camps per guardar varis quadres, Relacio One to Many i afegir els permisos en
	// cascada
	@OneToMany(mappedBy = "quadre", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Quadre> quadres;

	// metode per afegir quadres
	public void afegirQuadres(Quadre elQuadre) {
		// si quadres esta buit, crea l' array list
		if (quadres == null)
			quadres = new ArrayList<>();
		// afegim quadre
		quadres.add(elQuadre);
		// afegir el quadre a la botiga corresponent
		elQuadre.setBotiga(this);
	}

	// Getter & Setter de quadres

	public List<Quadre> getQuadres() {
		return quadres;
	}

	public void setQuadres(List<Quadre> quadres) {
		this.quadres = quadres;
	}

	// Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	

	/*
	 * Relacio un a un
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "id") private Quadre quadre;
	 * 
	 * // Getter & Setter Quadre
	 * 
	 * public Quadre getQuadre() { return quadre; }
	 * 
	 * public void setQuadre(Quadre quadre) { this.quadre = quadre; }
	 */

	// to String
	
	@Override
	public String toString() {
		return "Botiga [id=" + id + ", name=" + name + ", capacity=" + capacity + ", quadres=" + quadres + "]";
	}
	
}
