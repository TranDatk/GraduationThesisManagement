/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom39.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "thesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thesis.findAll", query = "SELECT t FROM Thesis t"),
    @NamedQuery(name = "Thesis.findById", query = "SELECT t FROM Thesis t WHERE t.id = :id"),
    @NamedQuery(name = "Thesis.findByCode", query = "SELECT t FROM Thesis t WHERE t.code = :code"),
    @NamedQuery(name = "Thesis.findByStartDate", query = "SELECT t FROM Thesis t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "Thesis.findByComplateDate", query = "SELECT t FROM Thesis t WHERE t.complateDate = :complateDate"),
    @NamedQuery(name = "Thesis.findByThesisStartDate", query = "SELECT t FROM Thesis t WHERE t.thesisStartDate = :thesisStartDate"),
    @NamedQuery(name = "Thesis.findByThesisEndDate", query = "SELECT t FROM Thesis t WHERE t.thesisEndDate = :thesisEndDate"),
    @NamedQuery(name = "Thesis.findByReportFile", query = "SELECT t FROM Thesis t WHERE t.reportFile = :reportFile"),
    @NamedQuery(name = "Thesis.findByTotalScore", query = "SELECT t FROM Thesis t WHERE t.totalScore = :totalScore"),
    @NamedQuery(name = "Thesis.findByResult", query = "SELECT t FROM Thesis t WHERE t.result = :result")})
public class Thesis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "complate_date")
    @Temporal(TemporalType.DATE)
    private Date complateDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thesis_start_date")
    @Temporal(TemporalType.DATE)
    private Date thesisStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thesis_end_date")
    @Temporal(TemporalType.DATE)
    private Date thesisEndDate;
    @Size(max = 300)
    @Column(name = "report_file")
    private String reportFile;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comment")
    private String comment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_score")
    private Double totalScore;
    @Column(name = "result")
    private Integer result;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisId")
    private Set<ThesisRegistration> thesisRegistrationSet;
    @OneToMany(mappedBy = "thesisId")
    private Set<Score> scoreSet;
    @JoinColumn(name = "council_id", referencedColumnName = "id")
    @ManyToOne
    private Council councilId;
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    @ManyToOne
    private Major majorId;
    @JoinColumn(name = "school_year_id", referencedColumnName = "id")
    @ManyToOne
    private SchoolYear schoolYearId;
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    @ManyToOne
    private Topic topicId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisId")
    private Set<Guide> guideSet;

    public Thesis() {
    }

    public Thesis(Integer id) {
        this.id = id;
    }

    public Thesis(Integer id, String code, Date startDate, Date complateDate, Date thesisStartDate, Date thesisEndDate) {
        this.id = id;
        this.code = code;
        this.startDate = startDate;
        this.complateDate = complateDate;
        this.thesisStartDate = thesisStartDate;
        this.thesisEndDate = thesisEndDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getComplateDate() {
        return complateDate;
    }

    public void setComplateDate(Date complateDate) {
        this.complateDate = complateDate;
    }

    public Date getThesisStartDate() {
        return thesisStartDate;
    }

    public void setThesisStartDate(Date thesisStartDate) {
        this.thesisStartDate = thesisStartDate;
    }

    public Date getThesisEndDate() {
        return thesisEndDate;
    }

    public void setThesisEndDate(Date thesisEndDate) {
        this.thesisEndDate = thesisEndDate;
    }

    public String getReportFile() {
        return reportFile;
    }

    public void setReportFile(String reportFile) {
        this.reportFile = reportFile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @XmlTransient
    public Set<ThesisRegistration> getThesisRegistrationSet() {
        return thesisRegistrationSet;
    }

    public void setThesisRegistrationSet(Set<ThesisRegistration> thesisRegistrationSet) {
        this.thesisRegistrationSet = thesisRegistrationSet;
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

    public Major getMajorId() {
        return majorId;
    }

    public void setMajorId(Major majorId) {
        this.majorId = majorId;
    }

    public SchoolYear getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(SchoolYear schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    @XmlTransient
    public Set<Guide> getGuideSet() {
        return guideSet;
    }

    public void setGuideSet(Set<Guide> guideSet) {
        this.guideSet = guideSet;
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
        if (!(object instanceof Thesis)) {
            return false;
        }
        Thesis other = (Thesis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom39.pojo.Thesis[ id=" + id + " ]";
    }
    
}
