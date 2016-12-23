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
@Table(name = "VISITS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visits.findAll", query = "SELECT v FROM Visits v"),
    @NamedQuery(name = "Visits.findById", query = "SELECT v FROM Visits v WHERE v.id = :id"),
    @NamedQuery(name = "Visits.findByIdSub", query = "SELECT v FROM Visits v WHERE v.idSub = :idSub"),
    @NamedQuery(name = "Visits.findByDate", query = "SELECT v FROM Visits v WHERE v.date = :date"),
    @NamedQuery(name = "Visits.findByTime", query = "SELECT v FROM Visits v WHERE v.time = :time")})
public class Visits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue    
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUB")
    private int idSub;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;

    public Visits() {
    }

    public Visits(Integer id) {
        this.id = id;
    }

    public Visits(Integer id, int idSub, Date date, Date time) {
        this.id = id;
        this.idSub = idSub;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdSub() {
        return idSub;
    }

    public void setIdSub(int idSub) {
        this.idSub = idSub;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        if (!(object instanceof Visits)) {
            return false;
        }
        Visits other = (Visits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gym.Visits[ id=" + id + " ]";
    }
    
}
