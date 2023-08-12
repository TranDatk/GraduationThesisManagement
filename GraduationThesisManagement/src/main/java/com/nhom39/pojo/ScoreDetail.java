/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "score_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScoreDetail.findAll", query = "SELECT s FROM ScoreDetail s"),
    @NamedQuery(name = "ScoreDetail.findById", query = "SELECT s FROM ScoreDetail s WHERE s.id = :id"),
    @NamedQuery(name = "ScoreDetail.findByScore", query = "SELECT s FROM ScoreDetail s WHERE s.score = :score")})
public class ScoreDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private double score;
    @JoinColumn(name = "score_id", referencedColumnName = "id")
    @ManyToOne
    private Score scoreId;
    @JoinColumn(name = "score_column_id", referencedColumnName = "id")
    @ManyToOne
    private ScoreColumn scoreColumnId;

    public ScoreDetail() {
    }

    public ScoreDetail(Integer id) {
        this.id = id;
    }

    public ScoreDetail(Integer id, double score) {
        this.id = id;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Score getScoreId() {
        return scoreId;
    }

    public void setScoreId(Score scoreId) {
        this.scoreId = scoreId;
    }

    public ScoreColumn getScoreColumnId() {
        return scoreColumnId;
    }

    public void setScoreColumnId(ScoreColumn scoreColumnId) {
        this.scoreColumnId = scoreColumnId;
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
        if (!(object instanceof ScoreDetail)) {
            return false;
        }
        ScoreDetail other = (ScoreDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom39.pojo.ScoreDetail[ id=" + id + " ]";
    }
    
}
