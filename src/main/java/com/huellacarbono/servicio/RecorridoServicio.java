/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.servicio;

import com.huellacarbono.modelo.Recorrido;
import com.huellacarbono.repositorio.RecorridoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ale Giraldo
 */
@Service
public class RecorridoServicio {
    private RecorridoRepository recorridoRepository;
    
    public List<Recorrido> getAll(){
        return recorridoRepository.getAll();
    }
    
    public Optional<Recorrido> getRecorrido(Integer id){
        return recorridoRepository.getRecorrido(id);
    }
    
    public Recorrido save(Recorrido recorrido){
        if(recorrido.getId() == null){
            return recorridoRepository.save(recorrido);
        } else {
            Optional<Recorrido> recorridoAux = recorridoRepository.getRecorrido(recorrido.getId());
            if (recorridoAux.isEmpty()){
                return recorridoRepository.save(recorrido);
            } else {
                return recorrido;
            }
        }
    }
    
    public List<Recorrido> busquedaBarrio(String barrio){
        return recorridoRepository.busquedaBarrio(barrio);
    }
}
