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
@Table(name = "OLD_CUST", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "OldCust.findAll", query = "SELECT o FROM OldCust o"),
    @NamedQuery(name = "OldCust.findByTcOld", query = "SELECT o FROM OldCust o WHERE o.tcOld = :tcOld"),
    @NamedQuery(name = "OldCust.findByMiktarOld", query = "SELECT o FROM OldCust o WHERE o.miktarOld = :miktarOld"),
    @NamedQuery(name = "OldCust.findByOnayOld", query = "SELECT o FROM OldCust o WHERE o.onayOld = :onayOld"),
    @NamedQuery(name = "OldCust.findByBankCode", query = "SELECT o FROM OldCust o WHERE o.bankCode = :bankCode")})
public class OldCust implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "TC_OLD")
    private String tcOld;
    @Basic(optional = false)
    @Column(name = "MIKTAR_OLD")
    private int miktarOld;
    @Column(name = "ONAY_OLD")
    private String onayOld;
    @Id
    @Basic(optional = false)
    @Column(name = "BANK_CODE")
    private Long bankCode;

    public OldCust() {
    }

    public OldCust(Long bankCode) {
        this.bankCode = bankCode;
    }

    public OldCust(Long bankCode, String tcOld, int miktarOld) {
        this.bankCode = bankCode;
        this.tcOld = tcOld;
        this.miktarOld = miktarOld;
    }

    public String getTcOld() {
        return tcOld;
    }

    public void setTcOld(String tcOld) {
        String oldTcOld = this.tcOld;
        this.tcOld = tcOld;
        changeSupport.firePropertyChange("tcOld", oldTcOld, tcOld);
    }

    public int getMiktarOld() {
        return miktarOld;
    }

    public void setMiktarOld(int miktarOld) {
        int oldMiktarOld = this.miktarOld;
        this.miktarOld = miktarOld;
        changeSupport.firePropertyChange("miktarOld", oldMiktarOld, miktarOld);
    }

    public String getOnayOld() {
        return onayOld;
    }

    public void setOnayOld(String onayOld) {
        String oldOnayOld = this.onayOld;
        this.onayOld = onayOld;
        changeSupport.firePropertyChange("onayOld", oldOnayOld, onayOld);
    }

    public Long getBankCode() {
        return bankCode;
    }

    public void setBankCode(Long bankCode) {
        Long oldBankCode = this.bankCode;
        this.bankCode = bankCode;
        changeSupport.firePropertyChange("bankCode", oldBankCode, bankCode);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankCode != null ? bankCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OldCust)) {
            return false;
        }
        OldCust other = (OldCust) object;
        if ((this.bankCode == null && other.bankCode != null) || (this.bankCode != null && !this.bankCode.equals(other.bankCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nypprojectbank.OldCust[ bankCode=" + bankCode + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
