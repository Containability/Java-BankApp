/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nypprojectbank;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author msi
 */
@Entity
@Table(name = "KREDILER_CUST", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "KredilerCust.findAll", query = "SELECT k FROM KredilerCust k"),
    @NamedQuery(name = "KredilerCust.findByMiktar", query = "SELECT k FROM KredilerCust k WHERE k.miktar = :miktar"),
    @NamedQuery(name = "KredilerCust.findByOnay", query = "SELECT k FROM KredilerCust k WHERE k.onay = :onay"),
    @NamedQuery(name = "KredilerCust.findByTc", query = "SELECT k FROM KredilerCust k WHERE k.tc = :tc")})
public class KredilerCust implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "MIKTAR")
    private int miktar;
    @Column(name = "ONAY")
    private Boolean onay;
    @Id
    @Basic(optional = false)
    @Column(name = "TC")
    private String tc;

    public KredilerCust() {
    }

    public KredilerCust(String tc) {
        this.tc = tc;
    }

    public KredilerCust(String tc, int miktar) {
        this.tc = tc;
        this.miktar = miktar;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        int oldMiktar = this.miktar;
        this.miktar = miktar;
        changeSupport.firePropertyChange("miktar", oldMiktar, miktar);
    }

    public Boolean getOnay() {
        return onay;
    }

    public void setOnay(Boolean onay) {
        Boolean oldOnay = this.onay;
        this.onay = onay;
        changeSupport.firePropertyChange("onay", oldOnay, onay);
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        String oldTc = this.tc;
        this.tc = tc;
        changeSupport.firePropertyChange("tc", oldTc, tc);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tc != null ? tc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KredilerCust)) {
            return false;
        }
        KredilerCust other = (KredilerCust) object;
        if ((this.tc == null && other.tc != null) || (this.tc != null && !this.tc.equals(other.tc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nypprojectbank.KredilerCust[ tc=" + tc + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
