/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

/**
 *
 * @author Vasanth Pranavan
 */
@MappedSuperclass
public class AbstractIdentifiedEntity {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     *
     */
    @Version
    protected Long version;

    /**
     *
     */
    @Column(updatable = false, insertable = true)
    protected LocalDateTime createdDateTime;

    /**
     *
     */
    @Column(updatable = true, insertable = true)
    protected LocalDateTime updatedDateTime;

    /**
     *
     */
    public AbstractIdentifiedEntity() {
    }

    /**
     *
     */
    @PrePersist
    public void prePersist() {
        createdDateTime = LocalDateTime.now();
    }

    /**
     *
     */
    @PreUpdate
    public void preUpdate() {
        updatedDateTime = LocalDateTime.now();
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getVersion() {
        return version;
    }

    /**
     *
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     *
     * @param createdDateTime
     */
    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    /**
     *
     * @param updatedDateTime
     */
    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

}
