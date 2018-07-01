/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author wesle
 */
@Entity
public class Iluminaçao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long TempoAceso;
    private int numLampada;

    public int getNumLampada() {
        return numLampada;
    }

    public void setNumLampada(int numLampada) {
        this.numLampada = numLampada;
    }

    public long getTempoAceso() {
        return TempoAceso;
    }

    public void setTempoAceso(long TempoAceso) {
        this.TempoAceso = TempoAceso;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iluminaçao)) {
            return false;
        }
        Iluminaçao other = (Iluminaçao) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Banco.ilumina\u00e7ao[ id=" + id + " ]";
    }
    
}
