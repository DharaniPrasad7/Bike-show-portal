/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

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
 * @author dhara
 */
@Entity
@Table(name = "BOOKSBIKE", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Booksbike.findAll", query = "SELECT b FROM Booksbike b"),
    @NamedQuery(name = "Booksbike.findByCid", query = "SELECT b FROM Booksbike b WHERE b.cid = :cid"),
    @NamedQuery(name = "Booksbike.findByBid", query = "SELECT b FROM Booksbike b WHERE b.bid = :bid"),
    @NamedQuery(name = "Booksbike.findByTestDrive", query = "SELECT b FROM Booksbike b WHERE b.testDrive = :testDrive")})
public class Booksbike implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CID")
    private String cid;
    @Basic(optional = false)
    @Column(name = "BID")
    private String bid;
    @Column(name = "TEST_DRIVE")
    private Short testDrive;

    public Booksbike() {
    }

    public Booksbike(String cid) {
        this.cid = cid;
    }

    public Booksbike(String cid, String bid) {
        this.cid = cid;
        this.bid = bid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        String oldCid = this.cid;
        this.cid = cid;
        changeSupport.firePropertyChange("cid", oldCid, cid);
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        String oldBid = this.bid;
        this.bid = bid;
        changeSupport.firePropertyChange("bid", oldBid, bid);
    }

    public Short getTestDrive() {
        return testDrive;
    }

    public void setTestDrive(Short testDrive) {
        Short oldTestDrive = this.testDrive;
        this.testDrive = testDrive;
        changeSupport.firePropertyChange("testDrive", oldTestDrive, testDrive);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booksbike)) {
            return false;
        }
        Booksbike other = (Booksbike) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myproject.Booksbike[ cid=" + cid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
