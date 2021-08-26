package cat.botiga.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.botiga.main.models.Botiga;



public interface BotiguesDAO extends JpaRepository<Botiga, Long> {

}
