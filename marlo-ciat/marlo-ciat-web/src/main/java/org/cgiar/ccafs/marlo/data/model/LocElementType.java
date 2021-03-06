package org.cgiar.ccafs.marlo.data.model;
// Generated Nov 23, 2016 10:03:29 AM by Hibernate Tools 3.4.0.CR1


import org.cgiar.ccafs.marlo.data.IAuditLog;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * LocElementType generated by hbm2java
 */
public class LocElementType implements java.io.Serializable, IAuditLog {


  private static final long serialVersionUID = 7455963940638912414L;

  @Expose
  private Long id;

  @Expose
  private User modifiedBy;

  @Expose
  private User createdBy;

  @Expose
  private LocElementType locElementType;

  @Expose
  private String name;

  @Expose
  private Boolean hasCoordinates;

  @Expose
  private boolean active;

  @Expose
  private Date activeSince;

  @Expose
  private String modificationJustification;


  private Set<LocElement> locElements = new HashSet<LocElement>(0);
  private Set<LocElementType> locElementTypes = new HashSet<LocElementType>(0);


  public LocElementType() {
  }


  public LocElementType(User modifiedBy, boolean active, Date activeSince, String modificationJustification) {
    this.modifiedBy = modifiedBy;
    this.active = active;
    this.activeSince = activeSince;
    this.modificationJustification = modificationJustification;
  }


  public LocElementType(User modifiedBy, User createdBy, LocElementType locElementType, String name,
    Boolean hasCoordinates, boolean active, Date activeSince, String modificationJustification,
    Set<LocElement> locElements, Set<LocElementType> locElementTypes) {
    this.modifiedBy = modifiedBy;
    this.createdBy = createdBy;
    this.locElementType = locElementType;
    this.name = name;
    this.hasCoordinates = hasCoordinates;
    this.active = active;
    this.activeSince = activeSince;
    this.modificationJustification = modificationJustification;
    this.locElements = locElements;
    this.locElementTypes = locElementTypes;
  }


  public Date getActiveSince() {
    return activeSince;
  }


  public User getCreatedBy() {
    return createdBy;
  }


  public Boolean getHasCoordinates() {
    return hasCoordinates;
  }


  @Override
  public Long getId() {
    return id;
  }


  public Set<LocElement> getLocElements() {
    return locElements;
  }


  public LocElementType getLocElementType() {
    return locElementType;
  }


  public Set<LocElementType> getLocElementTypes() {
    return locElementTypes;
  }

  @Override
  public String getLogDeatil() {
    StringBuilder sb = new StringBuilder();
    sb.append("Id : ").append(this.getId());
    return sb.toString();
  }

  public String getModificationJustification() {
    return modificationJustification;
  }

  @Override
  public User getModifiedBy() {
    return modifiedBy;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setActiveSince(Date activeSince) {
    this.activeSince = activeSince;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public void setHasCoordinates(Boolean hasCoordinates) {
    this.hasCoordinates = hasCoordinates;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setLocElements(Set<LocElement> locElements) {
    this.locElements = locElements;
  }

  public void setLocElementType(LocElementType locElementType) {
    this.locElementType = locElementType;
  }

  public void setLocElementTypes(Set<LocElementType> locElementTypes) {
    this.locElementTypes = locElementTypes;
  }


  public void setModificationJustification(String modificationJustification) {
    this.modificationJustification = modificationJustification;
  }

  public void setModifiedBy(User modifiedBy) {
    this.modifiedBy = modifiedBy;
  }


  public void setName(String name) {
    this.name = name;
  }

}

