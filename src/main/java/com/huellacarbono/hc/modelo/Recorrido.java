/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huellacarbono.hc.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ale Giraldo
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Recorrido")
public class Recorrido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String ciudad;
    private String barrio;
    private String vehiculo;
    private Integer distancia;
    private Double resultado;
    
    @ManyToOne
    @JoinColumn(name="Usuario", nullable=false)
    @JsonIgnoreProperties("recorrido")
    private Usuario usuario;
    
}
