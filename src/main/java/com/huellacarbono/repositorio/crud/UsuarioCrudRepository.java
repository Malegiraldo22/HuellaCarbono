/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.repositorio.crud;

import com.huellacarbono.modelo.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ale Giraldo
 */
public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{
    
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndContrasena (String email, String contrasena);
}
