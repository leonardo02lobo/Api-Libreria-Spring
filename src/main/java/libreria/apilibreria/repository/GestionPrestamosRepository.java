package libreria.apilibreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libreria.apilibreria.model.GestionPrestamos;

@Repository
public interface GestionPrestamosRepository extends JpaRepository<GestionPrestamos,Long> {

}
