/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.persistence.TarjetaDeCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JUAN
 */
@Local
public interface TarjetaDeCreditoManagerLocal {
    
    List<TarjetaDeCredito> getAllTarjetaCredito();

    void InsertTarjetaCredito(TarjetaDeCredito tarjetaCredito);

    
    
}
