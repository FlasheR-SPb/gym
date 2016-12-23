/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gym;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FlasheR
 */
@Entity
@Table(name = "SUBSCRIPTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscriptions.findAll", query = "SELECT s FROM Subscriptions s"),
    @NamedQuery(name = "Subscriptions.findById", query = "SELECT s FROM Subscriptions s WHERE s.id = :id"),
    @NamedQuery(name = "Subscriptions.findByNumOfVisits", query = "SELECT s FROM Subscriptions s WHERE s.numOfVisits = :numOfVisits"),
    @NamedQuery(name = "Subscriptions.findByDateOfCreation", query = "SELECT s FROM Subscriptions s WHERE s.dateOfCreation = :dateOfCreation"),
    @NamedQuery(name = "Subscriptions.findByTimeType", query = "SELECT s FROM Subscriptions s WHERE s.timeType = :timeType"),
    @NamedQuery(name = "Subscriptions.findByValid", query = "SELECT s FROM Subscriptions s WHERE s.valid = :valid"),
    @NamedQuery(name = "Subscriptions.findByTimeOfCreation", query = "SELECT s FROM Subscriptions s WHERE s.timeOfCreation = :timeOfCreation")})
public class Subscriptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "NUM_OF_VISITS")
    private Integer numOfVisits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_OF_CREATION")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;
    @Column(name = "TIME_TYPE")
    private Integer timeType;
    @Column(name = "VALID")
    private Integer valid;
    @Column(name = "TIME_OF_CREATION")
    @Temporal(TemporalType.TIME)
    private Date timeOfCreation;

    public Subscriptions() {
    }

    public Subscriptions(Integer id) {
        this.id = id;
    }

    public Subscriptions(Integer id, Date dateOfCreation) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumOfVisits() {
        return numOfVisits;
    }

    public void setNumOfVisits(Integer numOfVisits) {
        this.numOfVisits = numOfVisits;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscriptions)) {
            return false;
        }
        Subscriptions other = (Subscriptions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gym.Subscriptions[ id=" + id + " ]";
    }
    
}
