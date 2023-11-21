package entidad;

import entidad.Administrador;
import enumeraciones.Rol;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Administrador extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Otros campos y anotaciones
    @ManyToMany
    @JoinTable(
            name = "administrador_servicios",
            joinColumns = @JoinColumn(name = "administrador_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private Set<Trabajo> servicios;

    @ElementCollection(targetClass = Rol.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "administrador_roles", joinColumns = @JoinColumn(name = "administrador_id"))
    @Column(name = "rol")
    private Set<Rol> roles;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Trabajo> getServicios() {
        return servicios;
    }

    public void setServicios(Set<Trabajo> servicios) {
        this.servicios = servicios;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    
    
}
