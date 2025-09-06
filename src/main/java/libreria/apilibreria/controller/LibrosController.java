package libreria.apilibreria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import libreria.apilibreria.model.Libros;
import libreria.apilibreria.service.LibrosServices;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {

    private final LibrosServices services;

    public LibrosController(LibrosServices services) {
        this.services = services;
    }

    @GetMapping
    public ResponseEntity<?> getLibros() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(services.getLibros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLibroById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(services.getLibroByID(id));
    }

    @PostMapping
    public ResponseEntity<?> createLibro(@Valid @RequestBody Libros libro) {
        String nuevoLibro = services.crearLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLibro(@PathVariable Long id,@Valid @RequestBody Libros libroNuevo) {
        String actualizado = services.actualizarLibro(id, libroNuevo);
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        String eliminado = services.eliminarLibro(id);
        return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(eliminado);
    }

    @GetMapping("/buscar/autor/{autor}")
    public ResponseEntity<?> getLibroByAutor(@PathVariable String autor) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(services.getLibroByAutor(autor));
    }

    @GetMapping("/buscar/genero/{genero}")
    public ResponseEntity<?> getLibroByGenero(@PathVariable String genero) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(services.getLibroByGenero(genero));
    }

    @GetMapping("/buscar/anio/{anioDesde}/{anioHasta}")
    public ResponseEntity<?> getLibrosByAnio(@PathVariable int anioDesde, @PathVariable int anioHasta) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(services.getLibroByAnio(anioDesde, anioHasta));
    }

}
