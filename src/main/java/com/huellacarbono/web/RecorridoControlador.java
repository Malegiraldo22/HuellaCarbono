/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.web;

import com.huellacarbono.modelo.Recorrido;
import com.huellacarbono.servicio.RecorridoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("api/recorrido")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RecorridoControlador {
    
    @Autowired
    private RecorridoServicio recorridoServicio;
    
    @GetMapping("/all")
    public List<Recorrido> getAll(){
        return recorridoServicio.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Recorrido save(@RequestBody Recorrido recorrido){
        return recorridoServicio.save(recorrido);
    }
    
    @GetMapping("/{barrio}")
    public List<Recorrido> busquedaBarrio(@PathVariable("barrio") String barrio){
        return recorridoServicio.busquedaBarrio(barrio);
    }
    
}
