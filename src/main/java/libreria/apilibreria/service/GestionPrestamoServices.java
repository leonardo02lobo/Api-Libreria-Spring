package libreria.apilibreria.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import libreria.apilibreria.model.GestionPrestamos;
import libreria.apilibreria.repository.GestionPrestamosRepository;

@Service
public class GestionPrestamoServices {
    
    private GestionPrestamosRepository repo;

    public GestionPrestamoServices(GestionPrestamosRepository repo){
        this.repo = repo;
    }

    public String crearPrestamo(GestionPrestamos prestamo){
        repo.save(prestamo);
        return "Prestamo agregado";
    }

    public List<GestionPrestamos> listar(){
        return repo.findAll();
    }
    public String actualizarPrestamo(Long id){
        if(id == 0){
            return "EL id no existe";
        }
        repo.findById(id).stream().filter(l -> l.getId() == id)
        .findFirst()
        .ifPresent(l -> {
            l.setDevuelto(!l.isDevuelto());
        });
        return "Data actualizada con exito";
    }

    public ArrayList<GestionPrestamos> filtrarPrestamos(){
        return repo.findAll().stream()
            .filter(l -> l.isDevuelto())
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public Optional<GestionPrestamos> BuscarLibrosPrestadosByID(Long id){
        return repo.findById(id);
    }

    public ArrayList<GestionPrestamos> filtrarLibrosNoDevueltos(){
        return repo.findAll().stream()
        .filter(l -> !l.isDevuelto())
        .collect(Collectors.toCollection(ArrayList::new));
    }

    public long filtrarPorFechas(Date fechaInicial,Date fechaFinal){
        if(fechaInicial == null || fechaFinal == null){
            return 0;
        }
        return repo.findAll().stream()
        .filter(l -> l.isDevuelto())
        .filter(l -> l.getFechaPrestamo() != null)
        .filter(l -> l.getFechaPrestamo().before(fechaInicial)
                && l.getFechaPrestamo().after(fechaFinal))
        .count();       
    }
}
