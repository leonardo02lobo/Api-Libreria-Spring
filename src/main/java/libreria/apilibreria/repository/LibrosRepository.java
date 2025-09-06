package libreria.apilibreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libreria.apilibreria.model.Libros;

@Repository
public interface LibrosRepository extends JpaRepository<Libros,Long>{
    
    List<Libros> findByAutor(String autor);
    List<Libros> findByGenero(String genero);
}
