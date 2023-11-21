/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import entidad.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long>{
    
@Query("SELECT p FROM ProveedorServ p WHERE"
            + " CONCAT(p.id,p.nombre,p.precio)"
            + " LIKE %?1%")
    public List<Proveedor> findAlllList(String palabraClave);
}
