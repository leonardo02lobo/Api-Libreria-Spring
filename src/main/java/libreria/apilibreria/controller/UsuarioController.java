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
import libreria.apilibreria.model.Usuario;
import libreria.apilibreria.service.UsuarioServices;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    private UsuarioServices services;

    public UsuarioController(UsuarioServices services) {
        this.services = services;
    }
    
    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(services.crearUsuario(usuario));
    }
    @GetMapping
    public ResponseEntity<?> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(services.listarUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioByID(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(services.buscarUsuarioByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUsuarioByID(@PathVariable Long id,@Valid @RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(services.modificarUsuarioByID(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuarioByID(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(services.eliminarUsuarioByID(id));
    }
}
