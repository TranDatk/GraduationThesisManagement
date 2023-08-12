/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "council_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CouncilDetail.findAll", query = "SELECT c FROM CouncilDetail c"),
    @NamedQuery(name = "CouncilDetail.findById", query = "SELECT c FROM CouncilDetail c WHERE c.id = :id"),
    @NamedQuery(name = "CouncilDetail.findByPosition", query = "SELECT c FROM CouncilDetail c WHERE c.position = :position")})
public class CouncilDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "position")
    private String position;
    @OneToMany(mappedBy = "councilDetailId")
    private Set<Score> scoreSet;
    @JoinColumn(name = "council_id", referencedColumnName = "id")
    @ManyToOne
    private Council councilId;
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lecturer lecturerId;

    public CouncilDetail() {
    }

    public CouncilDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlTransient
    public Set<Score> getScoreSet() {
        return scoreSet;
    }

    public void setScoreSet(Set<Score> scoreSet) {
        this.scoreSet = scoreSet;
    }

    public Council getCouncilId() {
        return councilId;
    }

    public void setCouncilId(Council councilId) {
        this.councilId = councilId;
    }

    public Lecturer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Lecturer lecturerId) {
        this.lecturerId = lecturerId;
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
        if (!(object instanceof CouncilDetail)) {
            return false;
        }
        CouncilDetail other = (CouncilDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom39.pojo.CouncilDetail[ id=" + id + " ]";
    }
    
}
