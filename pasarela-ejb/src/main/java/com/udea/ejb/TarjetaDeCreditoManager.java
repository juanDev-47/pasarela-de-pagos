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
        TarjetaDeCredito t = tarjetaCredito;
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        
    }

   
    
    
    
}
