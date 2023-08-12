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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "score_column")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScoreColumn.findAll", query = "SELECT s FROM ScoreColumn s"),
    @NamedQuery(name = "ScoreColumn.findById", query = "SELECT s FROM ScoreColumn s WHERE s.id = :id"),
    @NamedQuery(name = "ScoreColumn.findByName", query = "SELECT s FROM ScoreColumn s WHERE s.name = :name"),
    @NamedQuery(name = "ScoreColumn.findByWeight", query = "SELECT s FROM ScoreColumn s WHERE s.weight = :weight")})
public class ScoreColumn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight")
    private Double weight;
    @JoinColumn(name = "score_component_id", referencedColumnName = "id")
    @ManyToOne
    private ScoreComponent scoreComponentId;
    @OneToMany(mappedBy = "scoreColumnId")
    private Set<ScoreDetail> scoreDetailSet;

    public ScoreColumn() {
    }

    public ScoreColumn(Integer id) {
        this.id = id;
    }

    public ScoreColumn(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public ScoreComponent getScoreComponentId() {
        return scoreComponentId;
    }

    public void setScoreComponentId(ScoreComponent scoreComponentId) {
        this.scoreComponentId = scoreComponentId;
    }

    @XmlTransient
    public Set<ScoreDetail> getScoreDetailSet() {
        return scoreDetailSet;
    }

    public void setScoreDetailSet(Set<ScoreDetail> scoreDetailSet) {
        this.scoreDetailSet = scoreDetailSet;
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
        if (!(object instanceof ScoreColumn)) {
            return false;
        }
        ScoreColumn other = (ScoreColumn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom39.pojo.ScoreColumn[ id=" + id + " ]";
    }
    
}
