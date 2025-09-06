package libreria.apilibreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libreria.apilibreria.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
