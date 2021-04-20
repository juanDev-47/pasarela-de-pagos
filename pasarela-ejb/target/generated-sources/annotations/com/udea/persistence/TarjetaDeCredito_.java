package com.udea.persistence;

import com.udea.persistence.Transaccion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-19T22:10:06")
@StaticMetamodel(TarjetaDeCredito.class)
public class TarjetaDeCredito_ { 

    public static volatile SingularAttribute<TarjetaDeCredito, Date> fechaVen;
    public static volatile SingularAttribute<TarjetaDeCredito, Integer> cvv;
    public static volatile SingularAttribute<TarjetaDeCredito, String> tipoTarjeta;
    public static volatile SingularAttribute<TarjetaDeCredito, String> nombreTitular;
    public static volatile SingularAttribute<TarjetaDeCredito, String> numeroTarjeta;
    public static volatile CollectionAttribute<TarjetaDeCredito, Transaccion> transaccionCollection;

}