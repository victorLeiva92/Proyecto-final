
package entidad;

import enumeraciones.TipoRubro;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRubro;
    private String descripcion;//Detalle de los trabajo
    private TipoRubro tipoRubro;
    
    
    
}
