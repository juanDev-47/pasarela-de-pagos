/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JUAN
 */
@Entity
@Table(name = "tarjeta_de_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetaDeCredito.findAll", query = "SELECT t FROM TarjetaDeCredito t")
    , @NamedQuery(name = "TarjetaDeCredito.findByNumeroTarjeta", query = "SELECT t FROM TarjetaDeCredito t WHERE t.numeroTarjeta = :numeroTarjeta")
    , @NamedQuery(name = "TarjetaDeCredito.findByCvv", query = "SELECT t FROM TarjetaDeCredito t WHERE t.cvv = :cvv")
    , @NamedQuery(name = "TarjetaDeCredito.findByFechaVen", query = "SELECT t FROM TarjetaDeCredito t WHERE t.fechaVen = :fechaVen")
    , @NamedQuery(name = "TarjetaDeCredito.findByTipoTarjeta", query = "SELECT t FROM TarjetaDeCredito t WHERE t.tipoTarjeta = :tipoTarjeta")})
    
public class TarjetaDeCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_titular")
    private String nombreTitular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvv")
    private int cvv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ven")
    @Temporal(TemporalType.DATE)
    private Date fechaVen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroTarjeta")
    private Collection<Transaccion> transaccionCollection;

    public TarjetaDeCredito() {
    }

    public TarjetaDeCredito(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public TarjetaDeCredito(String numeroTarjeta, String nombreTitular, int cvv, Date fechaVen, String tipoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.cvv = cvv;
        this.fechaVen = fechaVen;
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        System.out.println(numeroTarjeta);
        return numeroTarjeta;
        
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(Date fechaVen) {
        this.fechaVen = fechaVen;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroTarjeta != null ? numeroTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaDeCredito)) {
            return false;
        }
        TarjetaDeCredito other = (TarjetaDeCredito) object;
        if ((this.numeroTarjeta == null && other.numeroTarjeta != null) || (this.numeroTarjeta != null && !this.numeroTarjeta.equals(other.numeroTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.persistence.TarjetaDeCredito[ numeroTarjeta=" + numeroTarjeta + " ]";
    }
    
}
