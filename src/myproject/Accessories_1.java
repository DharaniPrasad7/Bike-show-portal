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
@Table(name = "ACCESSORIES", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Accessories_1.findAll", query = "SELECT a FROM Accessories_1 a"),
    @NamedQuery(name = "Accessories_1.findByAid", query = "SELECT a FROM Accessories_1 a WHERE a.aid = :aid"),
    @NamedQuery(name = "Accessories_1.findByType", query = "SELECT a FROM Accessories_1 a WHERE a.type = :type"),
    @NamedQuery(name = "Accessories_1.findByPrice", query = "SELECT a FROM Accessories_1 a WHERE a.price = :price"),
    @NamedQuery(name = "Accessories_1.findByDescription", query = "SELECT a FROM Accessories_1 a WHERE a.description = :description"),
    @NamedQuery(name = "Accessories_1.findByAvailablity", query = "SELECT a FROM Accessories_1 a WHERE a.availablity = :availablity")})
public class Accessories_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AID")
    private String aid;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private String price;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "AVAILABLITY")
    private String availablity;

    public Accessories_1() {
    }

    public Accessories_1(String aid) {
        this.aid = aid;
    }

    public Accessories_1(String aid, String type, String price, String description, String availablity) {
        this.aid = aid;
        this.type = type;
        this.price = price;
        this.description = description;
        this.availablity = availablity;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        String oldAid = this.aid;
        this.aid = aid;
        changeSupport.firePropertyChange("aid", oldAid, aid);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        String oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public String getAvailablity() {
        return availablity;
    }

    public void setAvailablity(String availablity) {
        String oldAvailablity = this.availablity;
        this.availablity = availablity;
        changeSupport.firePropertyChange("availablity", oldAvailablity, availablity);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessories_1)) {
            return false;
        }
        Accessories_1 other = (Accessories_1) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myproject.Accessories_1[ aid=" + aid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
