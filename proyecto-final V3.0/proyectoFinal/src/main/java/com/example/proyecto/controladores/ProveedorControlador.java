/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.proyecto.controladores;

import com.example.proyecto.entidades.Proveedor;
import com.example.proyecto.entidades.Rubro;
import com.example.proyecto.excepciones.MiException;
import com.example.proyecto.servicios.ProveedorServicio;
import com.example.proyecto.servicios.RubroServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AMD
 */
@Controller
@RequestMapping("/proveedor")
public class ProveedorControlador {

    @Autowired
    ProveedorServicio proveedorServicio;
    @Autowired
    RubroServicio rubroServicio;

    @GetMapping("/registrar")
    public String registrar( ModelMap modelo) {
        List <Rubro> rubros = rubroServicio.ListaRubros();
        modelo.addAttribute("rubros",rubros);
        
        return "proveedor_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, String apellido, String dni, String telefono,
            String direccion, String email, String password,String matricula,
            String idrubro, double precioHora, String descripcion,
            ModelMap modelo, MultipartFile archivo, String password2, String idRubro) {
      
        try {
            proveedorServicio.crearProveedor(archivo, nombre, apellido, dni, telefono, email,
                    password, password2, matricula, descripcion, precioHora, direccion, idrubro);
                             
                        
            modelo.put("exito", "El Proveedor fue registrado correctamente!");
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            return "proveedor_form.html";
        }

        return "index.html";
    }
    
      @GetMapping("/listar/{rubro}")
    public String listar(@PathVariable String rubro, ModelMap modelo) {
         
        List <Proveedor> proveedores = new ArrayList();
        proveedores= proveedorServicio.listarPorRubro(rubro);
                
        
        modelo.addAttribute("proveedores", proveedores);
       
        
        return "proveedor_list.html";
    }

    @GetMapping("/")
    public String verPagInicio(Model modelo,@Param("palabraClave")String palabraClave){
        List<Proveedor> listProveedors=proveedorServicio.listAll(palabraClave);
        modelo.addAttribute("listProveedors",listProveedors);
        modelo.addAttribute("palabraClave",palabraClave);

    return "index"; 
    
}
}
