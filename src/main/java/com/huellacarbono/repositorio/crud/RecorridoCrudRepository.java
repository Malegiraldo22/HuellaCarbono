/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.repositorio.crud;
import com.huellacarbono.modelo.Recorrido;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Ale Giraldo
 */
public interface RecorridoCrudRepository extends CrudRepository<Recorrido, Integer>{
    
    public List<Recorrido> findAllByBarrio(String barrio);
}
