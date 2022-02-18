/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.hc.repositorio;

import com.huellacarbono.hc.modelo.Recorrido;
import com.huellacarbono.hc.repositorio.crud.RecorridoCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ale Giraldo
 */
@Repository
public class RecorridoRepository {
    
    @Autowired
    private RecorridoCrudRepository recorridoCrudRepository;
    
    public List<Recorrido> getAll(){
        return (List<Recorrido>) recorridoCrudRepository.findAll();
    }
    
    public Optional<Recorrido> getRecorrido(Integer id){
        return recorridoCrudRepository.findById(id);
    }
    
    public Recorrido save(Recorrido recorrido){
        return recorridoCrudRepository.save(recorrido);
    }
    
    public List<Recorrido> busquedaBarrio(String barrio){
        return recorridoCrudRepository.findAllByBarrio(barrio);
    }
    
}
