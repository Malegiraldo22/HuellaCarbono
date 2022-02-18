/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.hc.web;

import com.huellacarbono.hc.modelo.Usuario;
import com.huellacarbono.hc.servicio.UsuarioServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ale Giraldo
 */
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/all")
    public List<Usuario> getAll(){
        return usuarioServicio.getAll();
    }
    
    @GetMapping("/{email}/{contrasena}")
    public Usuario existUsuario(@PathVariable("email") String email,
            @PathVariable("contrasena") String contrasena){
        return usuarioServicio.existUsuario(email, contrasena);
    }
    
    @GetMapping("/{email}")
    public Boolean existEmail(@PathVariable("email") String email){
        return usuarioServicio.existEmail(email);
    }
    
     @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable("id") int id){
        return usuarioServicio.getUsuario(id);
    }
    
    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioServicio.save(usuario);
    }
    
    @PutMapping("/modificar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioServicio.update(usuario);
    }    
    
    @PutMapping("/eliminar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario borrarUsuario(@RequestBody Usuario usuario){
        return usuarioServicio.borrarUsuario(usuario);
    }
}
