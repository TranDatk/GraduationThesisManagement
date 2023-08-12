/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "school_year")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolYear.findAll", query = "SELECT s FROM SchoolYear s"),
    @NamedQuery(name = "SchoolYear.findById", query = "SELECT s FROM SchoolYear s WHERE s.id = :id"),
    @NamedQuery(name = "SchoolYear.findByName", query = "SELECT s FROM SchoolYear s WHERE s.name = :name"),
    @NamedQuery(name = "SchoolYear.findByStartDate", query = "SELECT s FROM SchoolYear s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "SchoolYear.findByEndDate", query = "SELECT s FROM SchoolYear s WHERE s.endDate = :endDate")})
public class SchoolYear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(mappedBy = "schoolYearId")
    private Set<Student> studentSet;
    @OneToMany(mappedBy = "schoolYearId")
    private Set<Council> councilSet;
    @OneToMany(mappedBy = "schoolYearId")
    private Set<Thesis> thesisSet;

    public SchoolYear() {
    }

    public SchoolYear(Integer id) {
        this.id = id;
    }

    public SchoolYear(Integer id, String name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    @XmlTransient
    public Set<Council> getCouncilSet() {
        return councilSet;
    }

    public void setCouncilSet(Set<Council> councilSet) {
        this.councilSet = councilSet;
    }

    @XmlTransient
    public Set<Thesis> getThesisSet() {
        return thesisSet;
    }

    public void setThesisSet(Set<Thesis> thesisSet) {
        this.thesisSet = thesisSet;
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
        if (!(object instanceof SchoolYear)) {
            return false;
        }
        SchoolYear other = (SchoolYear) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom39.pojo.SchoolYear[ id=" + id + " ]";
    }
    
}
