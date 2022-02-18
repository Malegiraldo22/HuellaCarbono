/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.hc.repositorio;

import com.huellacarbono.hc.modelo.Usuario;
import com.huellacarbono.hc.repositorio.crud.UsuarioCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ale Giraldo
 */
@Repository
public class UsuarioRepositorio {
    
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;
    
    public List<Usuario> getAll(){
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }
    
    public Optional<Usuario> getUsuario(Integer id){
        return usuarioCrudRepository.findById(id);
    }
    
    public Usuario save(Usuario usuario){
        return usuarioCrudRepository.save(usuario);
    }
    
    public Boolean existEmail(String email){
        Optional<Usuario> usuario = usuarioCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    public Optional<Usuario> existUsuario(String email, String contrasena){
        return usuarioCrudRepository.findByEmailAndContrasena(email, contrasena);
    }
    
    public void delete(Usuario usuario){
        usuarioCrudRepository.delete(usuario);
    }
    
}
