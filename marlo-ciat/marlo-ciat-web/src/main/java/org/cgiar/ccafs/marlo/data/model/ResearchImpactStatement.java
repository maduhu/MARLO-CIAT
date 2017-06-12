package org.cgiar.ccafs.marlo.data.model;
// Generated Jun 12, 2017 10:11:04 AM by Hibernate Tools 3.4.0.CR1


import org.cgiar.ccafs.marlo.data.IAuditLog;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * ResearchImpactStatement generated by hbm2java
 */
public class ResearchImpactStatement implements java.io.Serializable, IAuditLog {


  private static final long serialVersionUID = -6127493830233483800L;


  @Expose
  private Long id;


  @Expose
  private User modifiedBy;

  @Expose
  private User createdBy;

  @Expose
  private SrfIdo srfIdo;

  @Expose
  private String name;

  @Expose
  private boolean active;

  @Expose
  private Date activeSince;

  @Expose
  private String modificationJustification;

  private Set<ResearchImpact> researchImpacts = new HashSet<ResearchImpact>(0);

  public ResearchImpactStatement() {
  }

  public ResearchImpactStatement(Long id, User modifiedBy, User createdBy, SrfIdo srfIdo, String name, boolean active,
    Date activeSince, String modificationJustification, Set<ResearchImpact> researchImpacts) {
    super();
    this.id = id;
    this.modifiedBy = modifiedBy;
    this.createdBy = createdBy;
    this.srfIdo = srfIdo;
    this.name = name;
    this.active = active;
    this.activeSince = activeSince;
    this.modificationJustification = modificationJustification;
    this.researchImpacts = researchImpacts;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    ResearchImpactStatement other = (ResearchImpactStatement) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }


  public Date getActiveSince() {
    return activeSince;
  }


  public User getCreatedBy() {
    return createdBy;
  }


  @Override
  public Long getId() {
    return id;
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

  public Set<ResearchImpact> getResearchImpacts() {
    return researchImpacts;
  }

  public SrfIdo getSrfIdo() {
    return srfIdo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
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

  public void setId(Long id) {
    this.id = id;
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

  public void setResearchImpacts(Set<ResearchImpact> researchImpacts) {
    this.researchImpacts = researchImpacts;
  }


  public void setSrfIdo(SrfIdo srfIdo) {
    this.srfIdo = srfIdo;
  }


}

