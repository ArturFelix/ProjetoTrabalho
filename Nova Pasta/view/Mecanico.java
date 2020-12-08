/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Artur Felix
 */
@Entity
@Table(name = "mecanico", catalog = "db_relatoriomecanico", schema = "")

public class Mecanico implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmecanico")
    private Integer idmecanico;
    @Column(name = "nome")
    private String nome;
   
    
    @OneToMany(mappedBy = "mecanico")
    private List<Conserto> consertos = new ArrayList<>();


    public Mecanico() {
    }

    public Mecanico(Integer idmecanico) {
        this.idmecanico = idmecanico;
    }

    public Integer getIdmecanico() {
        return idmecanico;
    }

    public void setIdmecanico(Integer idmecanico) {
        Integer oldIdmecanico = this.idmecanico;
        this.idmecanico = idmecanico;
        changeSupport.firePropertyChange("idmecanico", oldIdmecanico, idmecanico);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public List<Conserto> getConsertos() {
        return consertos;
    }

    public void setConsertos(List<Conserto> consertos) {
        this.consertos = consertos;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmecanico != null ? idmecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecanico)) {
            return false;
        }
        Mecanico other = (Mecanico) object;
        if ((this.idmecanico == null && other.idmecanico != null) || (this.idmecanico != null && !this.idmecanico.equals(other.idmecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
