package libreria.apilibreria.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "GestionPrestamos")
public class GestionPrestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El prestamo tiene que tener un id identificando el usuario")
    private int usuarioId;

    @NotNull(message = "El prestamo tiene que tener un id identificando el libro")
    private int libroId;

    @NotNull(message = "El prestamo tiene que tener una fecha")
    private Date fechaPrestamo;

    @NotNull(message = "El campo es obligatorio")
    private boolean devuelto;

    public GestionPrestamos() {
        this.usuarioId = 0;
        this.libroId = 0;
        this.fechaPrestamo = new Date(1);
        this.devuelto = false;
    }

    public GestionPrestamos(int usuarioId, int libroId, Date fechaPrestamo, boolean devuelto) {
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = devuelto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

}
