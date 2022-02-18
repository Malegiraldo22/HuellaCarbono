/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.hc.servicio;

import com.huellacarbono.hc.modelo.Usuario;
import com.huellacarbono.hc.repositorio.UsuarioRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ale Giraldo
 */
@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    public List<Usuario> getAll(){
        return usuarioRepositorio.getAll();
    }
    
    public Optional<Usuario> getUsuario(Integer id){
        return usuarioRepositorio.getUsuario(id);
    }
    
    public Boolean existEmail(String email){
        return usuarioRepositorio.existEmail(email);
    }
    
    public Usuario existUsuario(String email, String contrasena){
        Optional<Usuario> usuario = usuarioRepositorio.existUsuario(email, contrasena);
        if(usuario.isEmpty()){
            return new Usuario();
        } else {
            return usuario.get();
        }
    }
    
    public Usuario save(Usuario usuario){
        if(usuario.getId() == null){
            return usuarioRepositorio.save(usuario);
        } else {
            Optional<Usuario> auxUsuario = usuarioRepositorio.getUsuario(usuario.getId());
            if(auxUsuario.isEmpty()){
                return usuarioRepositorio.save(usuario);
            } else {
                return usuario;
            }
        }
    }
    
    public Usuario update(Usuario usuario){
        if (usuario.getId() != null){
            Optional<Usuario> auxUsuario = usuarioRepositorio.getUsuario(usuario.getId());
            if(!auxUsuario.isEmpty()){
                if(usuario.getNombre() != null){
                    auxUsuario.get().setNombre(usuario.getNombre());
                }
                if(usuario.getEmail() != null){
                    auxUsuario.get().setEmail(usuario.getEmail());
                }
                if(usuario.getUsuario() != null){
                    auxUsuario.get().setUsuario(usuario.getUsuario());
                }
                if(usuario.getContrasena() != null){
                    auxUsuario.get().setContrasena(usuario.getContrasena());
                }
                
                usuarioRepositorio.save(auxUsuario.get());
                return auxUsuario.get();
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }
    
    public Usuario borrarUsuario(Usuario usuario){
        if (usuario.getId() != null) {
            Optional<Usuario> borrarUsuario = usuarioRepositorio.getUsuario(usuario.getId());
            if (!borrarUsuario.isEmpty()) {
                if (usuario.getNombre() != null) {
                    borrarUsuario.get().setNombre(usuario.getId().toString());
                }
                if (usuario.getEmail() != null) {
                    borrarUsuario.get().setEmail("");
                }
                if (usuario.getUsuario() != null) {
                    borrarUsuario.get().setUsuario(usuario.getId().toString());
                }
                if (usuario.getContrasena() != null) {
                    borrarUsuario.get().setContrasena("");
                }
                usuarioRepositorio.save(borrarUsuario.get());
                return borrarUsuario.get();
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }
}
