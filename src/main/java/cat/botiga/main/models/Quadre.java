package cat.botiga.main.models;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

import org.springframework.web.bind.annotation.Mapping;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quadre")
public class Quadre {

	@Id
	// @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "autor", nullable = false, length = 30)
	private String autor;

	@Column(name = "titol", nullable = false, length = 30)
	private String titol;

	@Column(name = "preu")
	private double preu;

	@Column(name = "data")
	private LocalDateTime data;

	//@JsonIgnore
	//@ManyToOne
	@Column(name = "botiga_id")
	private int botigaId;

	// Getter Setter Botiga
	public int getBotigaId() {
		return botigaId;
	}

	public void setBotigaId(int botigaId) {
		this.botigaId = botigaId;
	}

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

}
