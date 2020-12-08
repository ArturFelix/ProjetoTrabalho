/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Artur Felix
 */
@Entity
@Table(name = "conserto", catalog = "db_relatoriomecanico", schema = "")

public class Conserto implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConserto")
    private Integer idConserto;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @ManyToOne
    private Carro carro;
    
    @ManyToOne
    private Mecanico mecanico;

    public Conserto() {
    }

    public Conserto(Integer idConserto) {
        this.idConserto = idConserto;
    }

    public Integer getIdConserto() {
        return idConserto;
    }

    public void setIdConserto(Integer idConserto) {
        Integer oldIdConserto = this.idConserto;
        this.idConserto = idConserto;
        changeSupport.firePropertyChange("idConserto", oldIdConserto, idConserto);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        Carro oldCarro = this.carro;
        this.carro = carro;
        changeSupport.firePropertyChange("carro", oldCarro, carro);
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        Mecanico oldMecanico = this.mecanico;
        this.mecanico = mecanico;
        changeSupport.firePropertyChange("mecanico", oldMecanico, mecanico);
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConserto != null ? idConserto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conserto)) {
            return false;
        }
        Conserto other = (Conserto) object;
        if ((this.idConserto == null && other.idConserto != null) || (this.idConserto != null && !this.idConserto.equals(other.idConserto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Conserto[ idConserto=" + idConserto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
