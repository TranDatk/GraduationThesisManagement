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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "notification_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationUser.findAll", query = "SELECT n FROM NotificationUser n"),
    @NamedQuery(name = "NotificationUser.findById", query = "SELECT n FROM NotificationUser n WHERE n.id = :id"),
    @NamedQuery(name = "NotificationUser.findByActive", query = "SELECT n FROM NotificationUser n WHERE n.active = :active")})
public class NotificationUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "notification_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Notification notificationId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public NotificationUser() {
    }

    public NotificationUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Notification getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Notification notificationId) {
        this.notificationId = notificationId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof NotificationUser)) {
            return false;
        }
        NotificationUser other = (NotificationUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom39.pojo.NotificationUser[ id=" + id + " ]";
    }
    
}
