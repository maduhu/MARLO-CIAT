package org.cgiar.ccafs.marlo.data.model;
// Generated Nov 23, 2016 11:30:56 AM by Hibernate Tools 3.4.0.CR1


import org.cgiar.ccafs.marlo.data.IAuditLog;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * ResearchOutputPartner generated by hbm2java
 */
public class ResearchOutputPartner implements java.io.Serializable, IAuditLog {


  private static final long serialVersionUID = -6280343872591957393L;

  @Expose
  private Integer id;

  @Expose
  private ResearchOutput researchOutput;

  @Expose
  private User modifiedBy;

  @Expose
  private User createdBy;

  @Expose
  private Institution institution;

  @Expose
  private boolean internal;

  @Expose
  private boolean active;

  @Expose
  private Date activeSince;

  @Expose
  private String modificationJustification;


  private Set<ResearchOutputPartnerPerson> researchOutputPartnerPersons = new HashSet<ResearchOutputPartnerPerson>(0);


  public ResearchOutputPartner() {
  }


  public ResearchOutputPartner(ResearchOutput researchOutput, Institution institution) {
    this.researchOutput = researchOutput;
    this.institution = institution;
  }


  public ResearchOutputPartner(ResearchOutput researchOutput, User modifiedBy, User createdBy, Institution institution,
    boolean internal, boolean active, Date activeSince, String modificationJustification,
    Set<ResearchOutputPartnerPerson> researchOutputPartnerPersons) {
    this.researchOutput = researchOutput;
    this.modifiedBy = modifiedBy;
    this.createdBy = createdBy;
    this.institution = institution;
    this.internal = internal;
    this.active = active;
    this.activeSince = activeSince;
    this.modificationJustification = modificationJustification;
    this.researchOutputPartnerPersons = researchOutputPartnerPersons;
  }


  public Date getActiveSince() {
    return activeSince;
  }


  public User getCreatedBy() {
    return createdBy;
  }


  @Override
  public Integer getId() {
    return id;
  }


  public Institution getInstitution() {
    return institution;
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


  public ResearchOutput getResearchOutput() {
    return researchOutput;
  }

  public Set<ResearchOutputPartnerPerson> getResearchOutputPartnerPersons() {
    return researchOutputPartnerPersons;
  }


  @Override
  public boolean isActive() {
    return active;
  }


  public boolean isInternal() {
    return internal;
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


  public void setId(Integer id) {
    this.id = id;
  }


  public void setInstitution(Institution institution) {
    this.institution = institution;
  }


  public void setInternal(boolean internal) {
    this.internal = internal;
  }


  public void setModificationJustification(String modificationJustification) {
    this.modificationJustification = modificationJustification;
  }


  public void setModifiedBy(User modifiedBy) {
    this.modifiedBy = modifiedBy;
  }


  public void setResearchOutput(ResearchOutput researchOutput) {
    this.researchOutput = researchOutput;
  }


  public void setResearchOutputPartnerPersons(Set<ResearchOutputPartnerPerson> researchOutputPartnerPersons) {
    this.researchOutputPartnerPersons = researchOutputPartnerPersons;
  }


}

