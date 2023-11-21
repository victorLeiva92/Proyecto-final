
package entidad;


import enumeraciones.EstadoTrabajo;
import enumeraciones.Rol;
import enumeraciones.TipoRubro;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Proveedor extends Persona{
    
private String matricula;//
private String descripcion;//
private int puntuacionPromedio;//esto es para las estrellita
private List<Rubro> rubro;
private EstadoTrabajo estadoTrabajo;//visualiza en el perfil del proveedor 
private boolean estadoActual;//Depende del estado actual
private double precioHora;
private int contdTrabajoRealizado;//esto permite scar un promedio de los trabajos realizados
@ElementCollection(targetClass = Rol.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "rol")
    private Set<Rol> roles;


}
