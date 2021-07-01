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
@Table(name = "CANCEL_HISTORY", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "CancelHistory.findAll", query = "SELECT c FROM CancelHistory c"),
    @NamedQuery(name = "CancelHistory.findByCid", query = "SELECT c FROM CancelHistory c WHERE c.cid = :cid"),
    @NamedQuery(name = "CancelHistory.findByBid", query = "SELECT c FROM CancelHistory c WHERE c.bid = :bid"),
    @NamedQuery(name = "CancelHistory.findByTestDrive", query = "SELECT c FROM CancelHistory c WHERE c.testDrive = :testDrive"),
    @NamedQuery(name = "CancelHistory.findByBookingdate", query = "SELECT c FROM CancelHistory c WHERE c.bookingdate = :bookingdate"),
    @NamedQuery(name = "CancelHistory.findByAdvance", query = "SELECT c FROM CancelHistory c WHERE c.advance = :advance"),
    @NamedQuery(name = "CancelHistory.findByReason", query = "SELECT c FROM CancelHistory c WHERE c.reason = :reason"),
    @NamedQuery(name = "CancelHistory.findByAction", query = "SELECT c FROM CancelHistory c WHERE c.action = :action")})
public class CancelHistory implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "BOOKINGDATE")
    private String bookingdate;
    @Basic(optional = false)
    @Column(name = "ADVANCE")
    private short advance;
    @Basic(optional = false)
    @Column(name = "REASON")
    private String reason;
    @Basic(optional = false)
    @Column(name = "ACTION")
    private String action;

    public CancelHistory() {
    }

    public CancelHistory(String cid) {
        this.cid = cid;
    }

    public CancelHistory(String cid, String bid, String bookingdate, short advance, String reason, String action) {
        this.cid = cid;
        this.bid = bid;
        this.bookingdate = bookingdate;
        this.advance = advance;
        this.reason = reason;
        this.action = action;
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

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        String oldBookingdate = this.bookingdate;
        this.bookingdate = bookingdate;
        changeSupport.firePropertyChange("bookingdate", oldBookingdate, bookingdate);
    }

    public short getAdvance() {
        return advance;
    }

    public void setAdvance(short advance) {
        short oldAdvance = this.advance;
        this.advance = advance;
        changeSupport.firePropertyChange("advance", oldAdvance, advance);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        String oldReason = this.reason;
        this.reason = reason;
        changeSupport.firePropertyChange("reason", oldReason, reason);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        String oldAction = this.action;
        this.action = action;
        changeSupport.firePropertyChange("action", oldAction, action);
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
        if (!(object instanceof CancelHistory)) {
            return false;
        }
        CancelHistory other = (CancelHistory) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myproject.CancelHistory[ cid=" + cid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
