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
@Table(name = "CUST", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Cust.findAll", query = "SELECT c FROM Cust c"),
    @NamedQuery(name = "Cust.findByCid", query = "SELECT c FROM Cust c WHERE c.cid = :cid"),
    @NamedQuery(name = "Cust.findByName", query = "SELECT c FROM Cust c WHERE c.name = :name"),
    @NamedQuery(name = "Cust.findByPassword", query = "SELECT c FROM Cust c WHERE c.password = :password"),
    @NamedQuery(name = "Cust.findByContact", query = "SELECT c FROM Cust c WHERE c.contact = :contact"),
    @NamedQuery(name = "Cust.findByLocation", query = "SELECT c FROM Cust c WHERE c.location = :location")})
public class Cust implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CID")
    private String cid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "CONTACT")
    private String contact;
    @Basic(optional = false)
    @Column(name = "LOCATION")
    private String location;

    public Cust() {
    }

    public Cust(String cid) {
        this.cid = cid;
    }

    public Cust(String cid, String name, String password, String contact, String location) {
        this.cid = cid;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.location = location;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        String oldCid = this.cid;
        this.cid = cid;
        changeSupport.firePropertyChange("cid", oldCid, cid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        String oldContact = this.contact;
        this.contact = contact;
        changeSupport.firePropertyChange("contact", oldContact, contact);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
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
        if (!(object instanceof Cust)) {
            return false;
        }
        Cust other = (Cust) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myproject.Cust[ cid=" + cid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
