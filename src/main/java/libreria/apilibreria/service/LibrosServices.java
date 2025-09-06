package libreria.apilibreria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import libreria.apilibreria.model.Libros;
import libreria.apilibreria.repository.LibrosRepository;

@Service
public class LibrosServices {

    private final LibrosRepository librosRepository;

    public LibrosServices(LibrosRepository librosRepository) {
        this.librosRepository = librosRepository;
    }

    public List<Libros> getLibros() {
        return librosRepository.findAll();
    }

    public Libros getLibroByID(Long id) {
        return librosRepository.findById(id).orElse(null);
    }

    public String crearLibro(Libros libro) {
        librosRepository.save(libro);
        return "Libro Guardado";
    }

    public String actualizarLibro(Long id, Libros libroNuevo) {
        Optional<Libros> existente = librosRepository.findById(id);
        if (existente.isPresent()) {
            Libros libro = existente.get();
            libro.setTitulo(libroNuevo.getTitulo());
            libro.setAutor(libroNuevo.getAutor());
            libro.setAnioPublicacion(libroNuevo.getAnioPublicacion());
            libro.setGenero(libroNuevo.getGenero());
            librosRepository.save(libro);
            return "Libro actualizado";
        }
        return "Libro no encontrado";
    }

    public String eliminarLibro(Long id) {
        if (librosRepository.existsById(id)) {
            librosRepository.deleteById(id);
            return "Libro Eliminado";
        }
        return "Libro no eliminado";
    }

    public List<Libros> getLibroByAutor(String autor) {
        return librosRepository.findByAutor(autor);
    }

    public List<Libros> getLibroByGenero(String genero) {
        return librosRepository.findByGenero(genero);
    }

    public List<Libros> getLibroByAnio(int anioDesde, int anioHasta) {
        return librosRepository.findAll().stream()
                .filter(l -> l.getAnioPublicacion() >= anioDesde && l.getAnioPublicacion() <= anioHasta)
                .toList();
    }
}
