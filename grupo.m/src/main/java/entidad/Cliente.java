
package entidad;

import enumeraciones.Rol;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class Cliente extends Persona{
    @ElementCollection(targetClass = Rol.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "rol")
    private Set<Rol> roles;
    
   //@ManyToMany(mappedBy = "usuario", cascade = CascadeType.ALL)//Se deberia de conectar usuario con provedor
  // private List<Proveedor> proveedor;
   
   private List<Trabajo> trabajo;    
    
}
