
package entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY) especifica que el valor de id se generará
    automáticamente por la base de datos utilizando una estrategia de identidad (autoincremental).
    */
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
  @Column(unique = true) en la columna dni indica que esta columna debe contener valores únicos,
  actuando como una clave única para evitar duplicados.
  */
  @Column(unique = true)
  private Integer dni;//
  private String nombre;
  private String apellido;
  private String domicilio;
  private String telefono;
  private String email;
  private String password;

    public Persona(Integer dni, String nombre, String apellido, String domicilio, String telefono, String email, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

 

    public Persona() {
    }
    
    

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
  
   
}
