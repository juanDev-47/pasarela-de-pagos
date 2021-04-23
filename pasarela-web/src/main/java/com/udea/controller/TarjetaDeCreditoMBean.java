/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.ejb.TransaccionManagerLocal;
import com.udea.persistence.TarjetaDeCredito;
import com.udea.persistence.Transaccion;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author JUAN
 */
public class TarjetaDeCreditoMBean implements Serializable {

    @EJB
    private com.udea.ejb.TransaccionManagerLocal transaccionManager;

    @EJB
    private com.udea.ejb.TarjetaDeCreditoManagerLocal tarjetaDeCreditoManager;

    // propiedades del modelo
    private TarjetaDeCredito tarjeta;  //para el insert 
    private List<TarjetaDeCredito> tarjetas; // para mostrar la tabla
    private Transaccion transaccion;
    private List<Transaccion> transacciones;
    
    /**
     * Creates a new instance of TarjetaDeCreditoMBean
     */
    public TarjetaDeCreditoMBean() {
    }
    
    //retorna una lista de tarjetas para mostrar en el datatables
    public List<TarjetaDeCredito> getTarjetas(){
        if ((tarjetas == null)|| (tarjetas.isEmpty())) 
            refresh();
            
            return tarjetas;        
    }
    
    public List<Transaccion> getTransacciones(){
        if ((transacciones == null)|| (transacciones.isEmpty())) 
            refresh();
            
            return transacciones;        
    }
    
    
    
    //retorno el detalle de cada tarjeta en el formulario
    public TarjetaDeCredito getDetails(){
        return tarjeta;
    }
    
    public Transaccion getDetailsTransaccion(){
        return transaccion;
    }
    
    //Action Handler
    public String showDetails(Transaccion transaccion){
        this.transaccion = transaccion;
        return "DETAILS";        
    }
    
    public String showDetails2(Transaccion transaccion,TarjetaDeCredito tarjeta){
        this.transaccion = transaccion;
        this.tarjeta = tarjeta;
        return "DETAILS";        
    }
    
    //Action Handler - insertar los datos en la base
    public String insertar(){
        tarjetaDeCreditoManager.InsertTarjetaCredito(tarjeta);
        return "SAVED";
        // esto va antes del tarjetaDeCreditoManager OJO  ---> tarjeta = 
        
        // organizar este metodo pronto
    }
    
    public String list(){
        return "DETAILS";  //poner LIST
    }
    
    public void refresh(){
        tarjetas = tarjetaDeCreditoManager.getAllTarjetaCredito();
        transacciones = transaccionManager.getAllTransacciones();
    }
    
    
}
