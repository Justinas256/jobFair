/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobFair.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author justinas
 */
@Entity
public class Spot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column 
    private String spotNo;

    @Column
    private int tables;
    
    @Column
    private int chairs;
    
    @Column
    private boolean electricity;
    
    @Column
    private String remarks;

    public Spot(Long id, String spotNo, int tables, int chairs, boolean electricity, String remarks) {
        this.id = id;
        this.spotNo = spotNo;
        this.tables = tables;
        this.chairs = chairs;
        this.electricity = electricity;
        this.remarks = remarks;
    }

    public Spot(String spotNo, int tables, int chairs, boolean electricity, String remarks) {
        this.spotNo = spotNo;
        this.tables = tables;
        this.chairs = chairs;
        this.electricity = electricity;
        this.remarks = remarks;
    }

    public String getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(String spotNo) {
        this.spotNo = spotNo;
    }

    public Spot() {
    }

    public int getTables() {
        return tables;
    }

    public int getChairs() {
        return chairs;
    }

    public boolean isElectricity() {
        return electricity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Spot)) {
            return false;
        }
        Spot other = (Spot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jobFair.model.Spot[ id=" + id + " ]";
    }
    
}
