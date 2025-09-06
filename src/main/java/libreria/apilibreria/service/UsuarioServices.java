package libreria.apilibreria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import libreria.apilibreria.model.Usuario;
import libreria.apilibreria.repository.UsuarioRepository;

@Service
public class UsuarioServices {

    private UsuarioRepository repo;

    public UsuarioServices(UsuarioRepository repo) {
        this.repo = repo;
    }

    public String crearUsuario(Usuario usuario) {
        repo.save(usuario);
        return "Usuario Creado";
    }

    public List<Usuario> listarUsuario() {
        return repo.findAll();
    }

    public Optional<Usuario> buscarUsuarioByID(Long id) {
        return repo.findById(id);
    }

    public String modificarUsuarioByID(Long id, Usuario usuario) {
        Optional<Usuario> existente = repo.findById(id);
        if (existente.isPresent()) {
            Usuario usu = existente.get();
            usu.setActivo(usuario.isActivo());
            usu.setEmail(usuario.getEmail());
            usu.setId(usuario.getId());
            usu.setNombre(usuario.getNombre());
            return "Datos modificados de manera correcta";
        }
        return "No se encontro el usuario";
    }

    public String eliminarUsuarioByID(Long id) {
        repo.deleteById(id);
        return "Usuario Eliminado";
    }
}
