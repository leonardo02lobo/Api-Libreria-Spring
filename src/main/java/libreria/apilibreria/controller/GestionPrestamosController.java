package libreria.apilibreria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import libreria.apilibreria.model.GestionPrestamos;
import libreria.apilibreria.service.GestionPrestamoServices;

@RestController
@RequestMapping("/api/gestionPrestamos")
public class GestionPrestamosController {
    
    private final GestionPrestamoServices services;

    public GestionPrestamosController(GestionPrestamoServices services){
        this.services = services;
    }

    @PostMapping
    public String crearPrestamo(@RequestBody GestionPrestamos prestamo){
        return services.crearPrestamo(prestamo);
    }

    @GetMapping
    public List<GestionPrestamos> listar(){
        return services.listar();
    }

    @PostMapping("/actualizar")
    public String actualizarPrestamo(@RequestBody Long id){
        return services.actualizarPrestamo(id);
    }

    @GetMapping("/filtrarPrestamos")
    public ArrayList<GestionPrestamos> filtrarPrestamos(){
        return services.filtrarPrestamos();
    }

    @GetMapping("/buscarPrestamosByID/{id}")
    public Optional<GestionPrestamos> BuscarLibrosPrestadosByID(@PathVariable Long id){
        return services.BuscarLibrosPrestadosByID(id);
    }

    @GetMapping("/filtrarLibrosNoDevueltos")
    public ArrayList<GestionPrestamos> filtrarLibroNoDevueltos(){
        return services.filtrarLibrosNoDevueltos();
    }
}
