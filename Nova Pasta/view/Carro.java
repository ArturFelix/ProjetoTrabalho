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
@Table(name = "carro", catalog = "db_relatoriomecanico", schema = "")
public class Carro implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcarro")
    private Integer idcarro;
    @Column(name = "nome")
    private String nome;
    @Column(name = "anoLancamento")
    private Integer anoLancamento;

    public List<Conserto> getConsertos() {
        return consertos;
    }

    public void setConsertos(List<Conserto> consertos) {
        this.consertos = consertos;
    }
    
    
    
    
    @OneToMany(mappedBy = "carro")
    private List<Conserto> consertos = new ArrayList<>();

    public Carro() {
    }

    public Carro(Integer idcarro) {
        this.idcarro = idcarro;
    }

    public Integer getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(Integer idcarro) {
        Integer oldIdcarro = this.idcarro;
        this.idcarro = idcarro;
        changeSupport.firePropertyChange("idcarro", oldIdcarro, idcarro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        Integer oldAnoLancamento = this.anoLancamento;
        this.anoLancamento = anoLancamento;
        changeSupport.firePropertyChange("anoLancamento", oldAnoLancamento, anoLancamento);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarro != null ? idcarro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.idcarro == null && other.idcarro != null) || (this.idcarro != null && !this.idcarro.equals(other.idcarro))) {
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
