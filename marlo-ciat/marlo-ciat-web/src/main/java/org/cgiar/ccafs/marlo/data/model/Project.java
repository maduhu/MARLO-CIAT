package org.cgiar.ccafs.marlo.data.model;
// Generated Feb 15, 2017 8:49:31 AM by Hibernate Tools 3.4.0.CR1


import org.cgiar.ccafs.marlo.data.IAuditLog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * Project generated by hbm2java
 */
public class Project implements java.io.Serializable, IAuditLog {


  private static final long serialVersionUID = -4480927754617355650L;


  @Expose
  private Long id;


  @Expose
  private User modifiedBy;


  @Expose
  private User contactPerson;

  @Expose
  private User projectLeader;


  @Expose
  private User createdBy;


  @Expose
  private ProjectStatus projectStatus;


  @Expose
  private String name;

  @Expose
  private String shortName;


  @Expose
  private Date startDate;


  @Expose
  private Date endDate;


  @Expose
  private boolean active;


  @Expose
  private Date activeSince;


  @Expose
  private Date dateCreated;


  @Expose
  private String modificationJustification;


  @Expose
  private ResearchProgram researchProgram;


  @Expose
  private ProjectCrosscutingTheme projectCrosscutingTheme;


  @Expose
  private boolean global;


  @Expose
  private boolean region;


  @Expose
  private ProjectType projectType;

  @Expose
  private String ocsCode;


  @Expose
  private String description;

  @Expose
  private Date extensionDate;


  @Expose
  private String originalDonor;

  @Expose
  private String directDonor;

  @Expose
  private Double totalAmount;

  private Set<SectionStatus> sectionStatuses = new HashSet<SectionStatus>(0);

  private Set<ProjectOutput> projectOutputs = new HashSet<ProjectOutput>(0);


  private Set<ProjectFundingSource> projectFundingSources = new HashSet<ProjectFundingSource>(0);


  private Set<Deliverable> deliverables = new HashSet<Deliverable>(0);


  private Set<Submission> submissions = new HashSet<Submission>(0);

  private List<ProjectOutput> outputs;

  private List<ProjectFundingSource> fundingSources;

  private Set<ProjectPartner> projectPartners = new HashSet<ProjectPartner>(0);

  private List<ProjectPartner> partners;

  private Set<ProjectLocation> projectLocations = new HashSet<ProjectLocation>(0);

  private List<ProjectLocation> projectRegions;

  private List<ProjectLocation> projectCountries;

  public Project() {
  }

  public Project(boolean active) {
    this.active = active;
  }

  public Project(User modifiedBy, User contactPerson, User projectLeader, User createdBy, ProjectStatus projectStatus,
    String name, String shortName, Date startDate, Date endDate, boolean active, Date activeSince,
    String modificationJustification, Set<ProjectOutput> projectOutputs) {
    this.modifiedBy = modifiedBy;
    this.contactPerson = contactPerson;
    this.projectLeader = projectLeader;
    this.createdBy = createdBy;
    this.projectStatus = projectStatus;
    this.name = name;
    this.shortName = shortName;
    this.startDate = startDate;
    this.endDate = endDate;
    this.active = active;
    this.activeSince = activeSince;
    this.modificationJustification = modificationJustification;
    this.projectOutputs = projectOutputs;
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
    Project other = (Project) obj;
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

  public User getContactPerson() {
    return contactPerson;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public Set<Deliverable> getDeliverables() {
    return deliverables;
  }

  public String getDescription() {
    return description;
  }


  public String getDirectDonor() {
    return directDonor;
  }

  public Date getEndDate() {
    return endDate;
  }


  public String getEndDateFormat() {
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = "";
    if (this.startDate != null) {
      date = simpleDateFormat.format(this.startDate);
    }
    return date;
  }


  public Date getExtensionDate() {
    return extensionDate;
  }


  public List<ProjectFundingSource> getFundingSources() {
    return fundingSources;
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

  public String getOcsCode() {
    return ocsCode;
  }

  public String getOriginalDonor() {
    return originalDonor;
  }

  public List<ProjectOutput> getOutputs() {
    return outputs;
  }

  public List<ProjectPartner> getPartners() {
    return partners;
  }

  public List<ProjectLocation> getProjectCountries() {
    return projectCountries;
  }

  public ProjectCrosscutingTheme getProjectCrosscutingTheme() {
    return projectCrosscutingTheme;
  }

  public Set<ProjectFundingSource> getProjectFundingSources() {
    return projectFundingSources;
  }

  public User getProjectLeader() {
    return projectLeader;
  }

  public Set<ProjectLocation> getProjectLocations() {
    return projectLocations;
  }

  public Set<ProjectOutput> getProjectOutputs() {
    return projectOutputs;
  }


  public Set<ProjectPartner> getProjectPartners() {
    return projectPartners;
  }


  public List<ProjectLocation> getProjectRegions() {
    return projectRegions;
  }

  public ProjectStatus getProjectStatus() {
    return projectStatus;
  }

  public ProjectType getProjectType() {
    return projectType;
  }

  public ResearchProgram getResearchProgram() {
    return researchProgram;
  }

  public Set<SectionStatus> getSectionStatuses() {
    return sectionStatuses;
  }

  public String getShortName() {
    return shortName;
  }

  public String getStarDateFormat() {
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = "";
    if (this.startDate != null) {
      date = simpleDateFormat.format(this.startDate);
    }
    return date;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Set<Submission> getSubmissions() {
    return submissions;
  }

  public Double getTotalAmount() {
    return totalAmount;
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

  public boolean isGlobal() {
    return global;
  }

  public boolean isRegion() {
    return region;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setActiveSince(Date activeSince) {
    this.activeSince = activeSince;
  }

  public void setContactPerson(User contactPerson) {
    this.contactPerson = contactPerson;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }


  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public void setDeliverables(Set<Deliverable> deliverables) {
    this.deliverables = deliverables;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public void setDirectDonor(String directDonor) {
    this.directDonor = directDonor;
  }


  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }


  public void setExtensionDate(Date extensionDate) {
    this.extensionDate = extensionDate;
  }

  public void setFundingSources(List<ProjectFundingSource> fundingSources) {
    this.fundingSources = fundingSources;
  }


  public void setGlobal(boolean global) {
    this.global = global;
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


  public void setOcsCode(String ocsCode) {
    this.ocsCode = ocsCode;
  }


  public void setOriginalDonor(String originalDonor) {
    this.originalDonor = originalDonor;
  }


  public void setOutputs(List<ProjectOutput> outputs) {
    this.outputs = outputs;
  }


  public void setPartners(List<ProjectPartner> partners) {
    this.partners = partners;
  }

  public void setProjectCountries(List<ProjectLocation> projectCountries) {
    this.projectCountries = projectCountries;
  }

  public void setProjectCrosscutingTheme(ProjectCrosscutingTheme projectCrosscutingTheme) {
    this.projectCrosscutingTheme = projectCrosscutingTheme;
  }

  public void setProjectFundingSources(Set<ProjectFundingSource> projectFundingSources) {
    this.projectFundingSources = projectFundingSources;
  }

  public void setProjectLeader(User projectLeader) {
    this.projectLeader = projectLeader;
  }


  public void setProjectLocations(Set<ProjectLocation> projectLocations) {
    this.projectLocations = projectLocations;
  }

  public void setProjectOutputs(Set<ProjectOutput> projectOutputs) {
    this.projectOutputs = projectOutputs;
  }

  public void setProjectPartners(Set<ProjectPartner> projectPartners) {
    this.projectPartners = projectPartners;
  }

  public void setProjectRegions(List<ProjectLocation> projectRegions) {
    this.projectRegions = projectRegions;
  }

  public void setProjectStatus(ProjectStatus projectStatus) {
    this.projectStatus = projectStatus;
  }

  public void setProjectType(ProjectType projectType) {
    this.projectType = projectType;
  }

  public void setRegion(boolean region) {
    this.region = region;
  }

  public void setResearchProgram(ResearchProgram researchProgram) {
    this.researchProgram = researchProgram;
  }

  public void setSectionStatuses(Set<SectionStatus> sectionStatuses) {
    this.sectionStatuses = sectionStatuses;
  }


  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }


  public void setSubmissions(Set<Submission> submissions) {
    this.submissions = submissions;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }


}

