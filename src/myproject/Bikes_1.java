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
@Table(name = "BIKES", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Bikes_1.findAll", query = "SELECT b FROM Bikes_1 b"),
    @NamedQuery(name = "Bikes_1.findByBid", query = "SELECT b FROM Bikes_1 b WHERE b.bid = :bid"),
    @NamedQuery(name = "Bikes_1.findByName", query = "SELECT b FROM Bikes_1 b WHERE b.name = :name"),
    @NamedQuery(name = "Bikes_1.findByPrice", query = "SELECT b FROM Bikes_1 b WHERE b.price = :price"),
    @NamedQuery(name = "Bikes_1.findBySpecification", query = "SELECT b FROM Bikes_1 b WHERE b.specification = :specification"),
    @NamedQuery(name = "Bikes_1.findByAvailablity", query = "SELECT b FROM Bikes_1 b WHERE b.availablity = :availablity"),
    @NamedQuery(name = "Bikes_1.findByModelType", query = "SELECT b FROM Bikes_1 b WHERE b.modelType = :modelType")})
public class Bikes_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BID")
    private String bid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private String price;
    @Basic(optional = false)
    @Column(name = "SPECIFICATION")
    private String specification;
    @Basic(optional = false)
    @Column(name = "AVAILABLITY")
    private String availablity;
    @Column(name = "MODEL_TYPE")
    private String modelType;

    public Bikes_1() {
    }

    public Bikes_1(String bid) {
        this.bid = bid;
    }

    public Bikes_1(String bid, String name, String price, String specification, String availablity) {
        this.bid = bid;
        this.name = name;
        this.price = price;
        this.specification = specification;
        this.availablity = availablity;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        String oldBid = this.bid;
        this.bid = bid;
        changeSupport.firePropertyChange("bid", oldBid, bid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        String oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        String oldSpecification = this.specification;
        this.specification = specification;
        changeSupport.firePropertyChange("specification", oldSpecification, specification);
    }

    public String getAvailablity() {
        return availablity;
    }

    public void setAvailablity(String availablity) {
        String oldAvailablity = this.availablity;
        this.availablity = availablity;
        changeSupport.firePropertyChange("availablity", oldAvailablity, availablity);
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        String oldModelType = this.modelType;
        this.modelType = modelType;
        changeSupport.firePropertyChange("modelType", oldModelType, modelType);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bikes_1)) {
            return false;
        }
        Bikes_1 other = (Bikes_1) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myproject.Bikes_1[ bid=" + bid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
