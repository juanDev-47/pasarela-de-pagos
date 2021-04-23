package com.udea.persistence;

import com.udea.persistence.TarjetaDeCredito;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-22T22:06:32")
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, Date> fecha;
    public static volatile SingularAttribute<Transaccion, Integer> valorTransaccion;
    public static volatile SingularAttribute<Transaccion, Integer> id;
    public static volatile SingularAttribute<Transaccion, TarjetaDeCredito> numeroTarjeta;

}