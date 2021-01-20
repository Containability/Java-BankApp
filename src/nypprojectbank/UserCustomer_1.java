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
@Table(name = "USER_CUSTOMER", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "UserCustomer_1.findAll", query = "SELECT u FROM UserCustomer_1 u"),
    @NamedQuery(name = "UserCustomer_1.findByAd", query = "SELECT u FROM UserCustomer_1 u WHERE u.ad = :ad"),
    @NamedQuery(name = "UserCustomer_1.findBySoyad", query = "SELECT u FROM UserCustomer_1 u WHERE u.soyad = :soyad"),
    @NamedQuery(name = "UserCustomer_1.findBySifre", query = "SELECT u FROM UserCustomer_1 u WHERE u.sifre = :sifre"),
    @NamedQuery(name = "UserCustomer_1.findByBakiye", query = "SELECT u FROM UserCustomer_1 u WHERE u.bakiye = :bakiye"),
    @NamedQuery(name = "UserCustomer_1.findByBorc", query = "SELECT u FROM UserCustomer_1 u WHERE u.borc = :borc"),
    @NamedQuery(name = "UserCustomer_1.findByTc", query = "SELECT u FROM UserCustomer_1 u WHERE u.tc = :tc")})
public class UserCustomer_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "AD")
    private String ad;
    @Basic(optional = false)
    @Column(name = "SOYAD")
    private String soyad;
    @Basic(optional = false)
    @Column(name = "SIFRE")
    private String sifre;
    @Basic(optional = false)
    @Column(name = "BAKIYE")
    private int bakiye;
    @Basic(optional = false)
    @Column(name = "BORC")
    private int borc;
    @Id
    @Basic(optional = false)
    @Column(name = "TC")
    private String tc;

    public UserCustomer_1() {
    }

    public UserCustomer_1(String tc) {
        this.tc = tc;
    }

    public UserCustomer_1(String tc, String ad, String soyad, String sifre, int bakiye, int borc) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
        this.bakiye = bakiye;
        this.borc = borc;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        String oldAd = this.ad;
        this.ad = ad;
        changeSupport.firePropertyChange("ad", oldAd, ad);
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        String oldSoyad = this.soyad;
        this.soyad = soyad;
        changeSupport.firePropertyChange("soyad", oldSoyad, soyad);
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        String oldSifre = this.sifre;
        this.sifre = sifre;
        changeSupport.firePropertyChange("sifre", oldSifre, sifre);
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        int oldBakiye = this.bakiye;
        this.bakiye = bakiye;
        changeSupport.firePropertyChange("bakiye", oldBakiye, bakiye);
    }

    public int getBorc() {
        return borc;
    }

    public void setBorc(int borc) {
        int oldBorc = this.borc;
        this.borc = borc;
        changeSupport.firePropertyChange("borc", oldBorc, borc);
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
        if (!(object instanceof UserCustomer_1)) {
            return false;
        }
        UserCustomer_1 other = (UserCustomer_1) object;
        if ((this.tc == null && other.tc != null) || (this.tc != null && !this.tc.equals(other.tc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nypprojectbank.UserCustomer_1[ tc=" + tc + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
