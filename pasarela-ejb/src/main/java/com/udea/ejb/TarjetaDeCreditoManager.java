/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.persistence.TarjetaDeCredito;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JUAN
 */
@Stateless
public class TarjetaDeCreditoManager implements TarjetaDeCreditoManagerLocal {

    @PersistenceContext(unitName = "com.udea_pasarela-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List<TarjetaDeCredito> getAllTarjetaCredito() {
        Query query = em.createNamedQuery("TarjetaDeCredito.findAll");
        return query.getResultList();
    }

    @Override
    public void InsertTarjetaCredito(TarjetaDeCredito tarjetaCredito) {
        
        em.persist(tarjetaCredito);
    }
    
    @Override
    public TarjetaDeCredito BuscarTarjeta(String numerotarjeta) {
        Query query = em.createNamedQuery("Tarjeta.findByNumeroTarjeta");
        query.setParameter("numeroTarjeta", numerotarjeta);

        try {
            return (TarjetaDeCredito) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
    
    @Override
    public boolean comprobarTarjeta(TarjetaDeCredito tarjeta) {
        TarjetaDeCredito tarjetaBD = BuscarTarjeta(tarjeta.getNumeroTarjeta());
        if(tarjetaBD==null) return false; 
        return tarjetaBD.equals(tarjeta);
    }

    @Override
    public String identificarTipo(String nroTarjeta) {

        int a = Integer.parseInt(nroTarjeta.substring(0, 5));
        if ((a >= 11111) && (a <= 22222)) {
            return "AMERCAN EXPRESS";
        }

        if ((a >= 33334) && (a <= 44444)) {
            return "DINERS";
        }

        if ((a >= 55555) && (a <= 66666)) {
            return "VISA";
        }

        if ((a >= 77777) && (a <= 88888)) {
            return "MASTERCARD";
        }

        return "No valido";

    }
   
    
    
    
    

   
    
    
    
}
