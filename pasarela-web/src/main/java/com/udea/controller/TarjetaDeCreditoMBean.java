/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.ejb.TarjetaDeCreditoManager;
import com.udea.ejb.TransaccionManagerLocal;
import com.udea.persistence.TarjetaDeCredito;
import com.udea.persistence.Transaccion;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

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
    private TarjetaDeCredito tarjeta = new TarjetaDeCredito();  //para el insert 
    private List<TarjetaDeCredito> tarjetas; // para mostrar la tabla
    private Transaccion transaccion = new Transaccion();
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

    public TarjetaDeCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDeCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
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
        return "LISTADO";  //poner LIST
    }
    
    public String detalleCompra(){
        return "DETAILS";  //poner LIST
    }
    
    public String back(){
        return "BACK";
    }
    
    public void identificarTipo() {
        String tipoTarjeta = tarjetaDeCreditoManager.identificarTipo(tarjeta.getNumeroTarjeta());
        if ("No valido".equals(tipoTarjeta)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Nro tarjeta erroneo", ""));
            return;
        }
        tarjeta.setTipoTarjeta(tipoTarjeta);
    }
    
    public String pagar() {
        
        identificarTipo();
        tarjetaDeCreditoManager.InsertTarjetaCredito(tarjeta);
            transaccion.setNumeroTarjeta(tarjeta);
            Timestamp date = new Timestamp(System.currentTimeMillis());
            transaccion.setFecha(date);
            transaccionManager.insertarTransaccion(transaccion);
            
            
            
//        System.out.println(tarjeta.getNombreTitular());
//        identificarTipo();
//        
//        if(!tarjetaDeCreditoManager.comprobarTarjeta(tarjeta)){
//            tarjetaDeCreditoManager.InsertTarjetaCredito(tarjeta);
//        }else {
////            tarjeta = tarjetaDeCreditoManager.BuscarTarjeta(tarjeta.getNumeroTarjeta());
//        }
//        
//        
//        transaccion.setNumeroTarjeta(tarjeta);
//        Timestamp date = new Timestamp(System.currentTimeMillis());
//        transaccion.setFecha(date);
//        transaccionManager.insertarTransaccion(transaccion);
//         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "TRANSACCIÓN EXITOSA", ""));
        return "SAVED";
    }
    
    
    
    
    
    public void refresh(){
        tarjetas = tarjetaDeCreditoManager.getAllTarjetaCredito();
        transacciones = transaccionManager.getAllTransacciones();
    }
    
//    public void crearTransaccion(TarjetaDeCredito tarjeta, int valorTransaccion){
//        Timestamp date = new Timestamp(System.currentTimeMillis());
//        Transaccion transaccion = new Transaccion();
//        transaccion.setFecha(date);
//        transaccion.setNumeroTarjeta(tarjeta);
//        transaccion.setValorTransaccion(valorTransaccion);
//        
//        transaccionManager.insertarTransaccion(transaccion);
//    }
//    
//    public TarjetaDeCredito crearTarjeta(String nombre, String numeroTarjeta, int cvv, Date fechaVencimiento){
//        String tipoTarjeta = "DINERS";
//        TarjetaDeCredito tarjeta = new TarjetaDeCredito();
//        tarjeta.setNombreTitular(nombre);
//        tarjeta.setNumeroTarjeta(numeroTarjeta);
//        tarjeta.setTipoTarjeta(tipoTarjeta);
//        tarjeta.setCvv(cvv);
//        tarjeta.setFechaVen(fechaVencimiento);
//        
//        tarjetaDeCreditoManager.InsertTarjetaCredito(tarjeta);
//        
//        return tarjeta;
//    }
    
    
}
