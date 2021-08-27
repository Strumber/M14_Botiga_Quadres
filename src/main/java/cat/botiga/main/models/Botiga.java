package cat.botiga.main.models;

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
@Table(name = "botiga")
public class Botiga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genera camps clau
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "capacity")
	private int capacity;

	// Constructors per defecte
	public Botiga() {
	}

	// Constructor amb parametres sense id que es autonumèric

	public Botiga(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	
	// Getters & Setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
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
		
		 @OneToMany(mappedBy = "botiga",cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
		 private List<Quadre> quadres;
		 
		 //Per poder afegir quadres
		 
		 public void afegirQuadre (Quadre elQuadre) {
			 
			 if (quadres == null) quadres = new ArrayList<>();
			 
			 quadres.add(elQuadre);
			 
			 elQuadre.setBotiga(this);
		 }
		 
		 //Get and Set
		 public List<Quadre> getQuadres() {
				return quadres;
			}

			public void setQuadres(List<Quadre> quadres) {
				this.quadres = quadres;
			}
		 

	
	@Override
	public String toString() {
		return "Botiga [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
	}

	
	
}
