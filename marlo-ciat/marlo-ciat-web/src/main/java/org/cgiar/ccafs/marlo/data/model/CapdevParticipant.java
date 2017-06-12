package org.cgiar.ccafs.marlo.data.model;
// default package
// Generated Jun 9, 2017 3:40:30 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;

/**
 * CapdevParticipant generated by hbm2java
 */
public class CapdevParticipant implements java.io.Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private Participant participant;
  private User usersByModifiedBy;
  private User usersByCreatedBy;
  private CapacityDevelopment capacityDevelopment;
  private boolean active;
  private Date activeSince;
  private String modificationJustification;

  public CapdevParticipant() {
  }


  public CapdevParticipant(Participant participant, User usersByModifiedBy, User usersByCreatedBy,
    CapacityDevelopment capacityDevelopment, boolean active, Date activeSince, String modificationJustification) {
    this.participant = participant;
    this.usersByModifiedBy = usersByModifiedBy;
    this.usersByCreatedBy = usersByCreatedBy;
    this.capacityDevelopment = capacityDevelopment;
    this.active = active;
    this.activeSince = activeSince;
    this.modificationJustification = modificationJustification;
  }

  public CapdevParticipant(User usersByCreatedBy, boolean active) {
    this.usersByCreatedBy = usersByCreatedBy;
    this.active = active;
  }

  public Date getActiveSince() {
    return this.activeSince;
  }

  public CapacityDevelopment getCapacityDevelopment() {
    return this.capacityDevelopment;
  }

  public Long getId() {
    return this.id;
  }

  public String getModificationJustification() {
    return this.modificationJustification;
  }

  public Participant getParticipant() {
    return this.participant;
  }

  public User getUsersByCreatedBy() {
    return this.usersByCreatedBy;
  }

  public User getUsersByModifiedBy() {
    return this.usersByModifiedBy;
  }

  public boolean isActive() {
    return this.active;
  }

  public void setActive(boolean isActive) {
    this.active = isActive;
  }

  public void setActiveSince(Date activeSince) {
    this.activeSince = activeSince;
  }

  public void setCapacityDevelopment(CapacityDevelopment capacityDevelopment) {
    this.capacityDevelopment = capacityDevelopment;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setModificationJustification(String modificationJustification) {
    this.modificationJustification = modificationJustification;
  }

  public void setParticipant(Participant participant) {
    this.participant = participant;
  }

  public void setUsersByCreatedBy(User usersByCreatedBy) {
    this.usersByCreatedBy = usersByCreatedBy;
  }

  public void setUsersByModifiedBy(User usersByModifiedBy) {
    this.usersByModifiedBy = usersByModifiedBy;
  }


}

