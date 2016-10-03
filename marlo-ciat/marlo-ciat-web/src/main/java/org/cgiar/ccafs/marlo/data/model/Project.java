/*****************************************************************
 * This file is part of Managing Agricultural Research for Learning &
 * Outcomes Platform (MARLO).
 * MARLO is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * MARLO is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with MARLO. If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************/
package org.cgiar.ccafs.marlo.data.model;

// Generated Jul 13, 2016 11:45:52 AM by Hibernate Tools 4.3.1.Final


import org.cgiar.ccafs.marlo.data.IAuditLog;
import org.cgiar.ccafs.marlo.utils.APConstants;
import org.cgiar.ccafs.marlo.utils.CountryLocationLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.annotations.Expose;

/**
 * Project generated by hbm2java
 */
public class Project implements java.io.Serializable, IAuditLog {


  private static final long serialVersionUID = -5737088425960023585L;


  public static final int STANDAR_IDENTIFIER = 1;


  public static final int PDF_IDENTIFIER_REPORT = 2;


  public static final int EXCEL_IDENTIFIER_REPORT = 3;

  public static final int EMAIL_SUBJECT_IDENTIFIER = 4;


  @Expose
  private Long id;

  @Expose
  private Crp crp;


  @Expose
  private LiaisonInstitution liaisonInstitution;

  @Expose
  private boolean projectEditLeader;
  @Expose
  private Date createDate;

  @Expose
  private LiaisonUser liaisonUser;


  @Expose
  private User createdBy;


  @Expose
  private User modifiedBy;


  @Expose
  private String title;
  @Expose
  private String summary;
  @Expose
  private Date startDate;
  @Expose
  private Date endDate;
  @Expose
  private String type;


  @Expose
  private int scale;


  @Expose
  private boolean cofinancing;

  @Expose
  private String leaderResponsabilities;

  @Expose
  private Boolean requiresWorkplanUpload;

  @Expose
  private FileDB annualReportToDonnor;

  @Expose
  private FileDB bilateralContractName;
  @Expose
  private FileDB workplan;
  @Expose
  private boolean active;
  @Expose
  private Boolean noRegional;

  @Expose
  private Date activeSince;
  @Expose
  private String modificationJustification;

  private Set<Deliverable> deliverables = new HashSet<Deliverable>(0);


  private Set<ProjectFocus> projectFocuses = new HashSet<ProjectFocus>(0);

  private Set<Submission> submissions = new HashSet<Submission>(0);


  private List<CrpProgram> flagships;


  private String flagshipValue;


  private List<CrpProgram> regions;


  private String regionsValue;


  private Set<SectionStatus> sectionStatuses = new HashSet<SectionStatus>(0);
  private Set<ProjectLocation> projectLocations = new HashSet<ProjectLocation>(0);

  private Set<ProjectScope> projectScopes = new HashSet<ProjectScope>(0);

  private Set<ProjectPartner> projectPartners = new HashSet<ProjectPartner>(0);
  private Set<ProjectComponentLesson> projectComponentLessons = new HashSet<ProjectComponentLesson>(0);
  private Set<ProjectClusterActivity> projectClusterActivities = new HashSet<ProjectClusterActivity>(0);

  private Set<ProjectCrpContribution> projectCrpContributions = new HashSet<ProjectCrpContribution>(0);
  private Set<Activity> activities = new HashSet<Activity>(0);
  private List<CrpClusterOfActivity> crpActivities;

  private Set<ProjectBudget> projectBudgetCofinances = new HashSet<ProjectBudget>(0);
  private Set<ProjectBudgetsCluserActvity> projectBudgetsCluserActvities = new HashSet<ProjectBudgetsCluserActvity>(0);


  private List<ProjectBudgetsCluserActvity> budgetsCluserActvities;


  private Set<ProjectBudget> projectBudgets = new HashSet<ProjectBudget>(0);

  private List<ProjectBudget> budgets;
  private List<ProjectBudget> budgetsCofinancing;
  private Set<ProjectOutcome> projectOutcomes = new HashSet<ProjectOutcome>(0);


  private List<ProjectClusterActivity> clusterActivities;


  private List<CountryLocationLevel> locationsData;

  private ProjectComponentLesson projectComponentLesson;


  private ProjectComponentLesson projectComponentLessonPreview;

  private String overall;
  private List<ProjectPartner> partners;
  private List<Deliverable> projectDeliverables;

  private List<ProjectOutcome> outcomes;


  private List<ProjectLocation> locations;

  private List<ProjectScope> scopes;

  private List<Activity> openProjectActivities;
  private List<Activity> closedProjectActivities;

  public Project() {
  }

  public Project(Crp crp, LiaisonInstitution liaisonInstitution, LiaisonUser liaisonUser, User usersByCreatedBy,
    User usersByModifiedBy, String title, String summary, Date startDate, Date endDate, String type, boolean isGlobal,
    boolean isCofinancing, String leaderResponsabilities, Boolean requiresWorkplanUpload, FileDB workplanName,
    FileDB bilateralContractName, boolean isActive, Date activeSince, String modificationJustification,
    FileDB annualReportToDornor, Set<ProjectFocus> projectFocuseses, Set<Submission> submissions,
    Set<ProjectLocation> projectLocations, Set<ProjectScope> projectScopes, Set<Deliverable> deliverables,
    Date createDate) {
    this.crp = crp;
    this.liaisonInstitution = liaisonInstitution;
    this.liaisonUser = liaisonUser;
    this.createdBy = usersByCreatedBy;
    this.modifiedBy = usersByModifiedBy;
    this.title = title;
    this.summary = summary;
    this.startDate = startDate;
    this.endDate = endDate;
    this.type = type;

    this.cofinancing = isCofinancing;
    this.leaderResponsabilities = leaderResponsabilities;
    this.requiresWorkplanUpload = requiresWorkplanUpload;
    this.workplan = workplanName;
    this.bilateralContractName = bilateralContractName;
    this.active = isActive;
    this.activeSince = activeSince;
    this.modificationJustification = modificationJustification;
    this.annualReportToDonnor = annualReportToDornor;
    this.projectFocuses = projectFocuseses;
    this.submissions = submissions;
    this.projectLocations = projectLocations;
    this.projectScopes = projectScopes;
    this.deliverables = deliverables;
    this.createDate = createDate;
  }

  public Project(Crp crp, User usersByModifiedBy, boolean isGlobal, boolean isCofinancing, boolean isActive,
    Date activeSince, String modificationJustification) {
    this.crp = crp;
    this.modifiedBy = usersByModifiedBy;

    this.cofinancing = isCofinancing;
    this.active = isActive;
    this.activeSince = activeSince;
    this.modificationJustification = modificationJustification;
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
    return this.activeSince;
  }

  public Set<Activity> getActivities() {
    return activities;
  }

  /**
   * This method calculates all the years between the start date and the end date.
   * 
   * @return a List of numbers representing all the years, or an empty list if nothing found.
   */
  public List<Integer> getAllYears() {
    List<Integer> allYears = new ArrayList<>();
    if (startDate != null && endDate != null) {
      Calendar calendarStart = Calendar.getInstance();
      calendarStart.setTime(startDate);
      Calendar calendarEnd = Calendar.getInstance();
      calendarEnd.setTime(endDate);

      while (calendarStart.get(Calendar.YEAR) <= calendarEnd.get(Calendar.YEAR)) {
        // Adding the year to the list.
        allYears.add(calendarStart.get(Calendar.YEAR));
        // Adding a year (365 days) to the start date.
        calendarStart.add(Calendar.YEAR, 1);
      }
    }

    return allYears;
  }

  public FileDB getAnnualReportToDonnor() {
    return annualReportToDonnor;
  }


  public long getBilateralBudget() {

    long total = 0;
    for (ProjectBudget projectBudget : this.getProjectBudgets().stream()
      .filter(c -> c.isActive() && c.getBudgetType().getId() == 3).collect(Collectors.toList())) {
      if (projectBudget.getAmount() != null) {
        total = total + projectBudget.getAmount();
      }
    }

    return total;
  }

  public FileDB getBilateralContractName() {
    return bilateralContractName;
  }

  public List<ProjectBudget> getBudgets() {
    return budgets;
  }

  public List<ProjectBudgetsCluserActvity> getBudgetsCluserActvities() {
    return budgetsCluserActvities;
  }

  public List<ProjectBudget> getBudgetsCofinancing() {
    return budgetsCofinancing;
  }

  public List<Activity> getClosedProjectActivities() {
    return closedProjectActivities;
  }

  public List<ProjectClusterActivity> getClusterActivities() {
    return clusterActivities;
  }

  public String getComposedName() {
    return "P" + this.id + " - " + this.title;
  }

  /**
   * This method gets all the coordinators working for this project.
   * 
   * @return a list of PartnerPerson with the information requested.
   */
  public List<ProjectPartnerPerson> getCoordinatorPersons() {
    List<ProjectPartnerPerson> projectCoordinators = new ArrayList<>();
    if (partners != null) {
      for (ProjectPartner partner : partners) {
        if (partner.getPartnerPersons() != null) {
          for (ProjectPartnerPerson person : partner.getPartnerPersons()) {
            if (person.getContactType().equals(APConstants.PROJECT_PARTNER_PC)) {
              projectCoordinators.add(person);
            }
          }
        }

      }
    } else {
      for (ProjectPartner partner : projectPartners.stream().filter(c -> c.isActive()).collect(Collectors.toList())) {
        if (partner.getProjectPartnerPersons() != null) {
          for (ProjectPartnerPerson person : partner.getProjectPartnerPersons()) {

            if (person.getContactType().equals(APConstants.PROJECT_PARTNER_PC) && person.isActive()) {
              projectCoordinators.add(person);
            }
          }
        }

      }
    }
    return projectCoordinators;
  }

  public long getCoreBudget() {
    if (id.longValue() == 249) {
      System.out.println("STOP");
    }
    long total = 0;
    for (ProjectBudget projectBudget : this.getProjectBudgets().stream()
      .filter(c -> c.isActive() && c.getBudgetType().getId() == 1).collect(Collectors.toList())) {
      if (projectBudget.getAmount() != null) {
        total = total + projectBudget.getAmount();
      }
    }

    return total;
  }

  public Date getCreateDate() {
    return createDate;
  }


  public User getCreatedBy() {
    return this.createdBy;
  }


  public Crp getCrp() {
    return crp;
  }

  public List<CrpClusterOfActivity> getCrpActivities() {
    return crpActivities;
  }


  public Set<Deliverable> getDeliverables() {
    return deliverables;
  }


  public Date getEndDate() {
    return this.endDate;
  }


  public List<CrpProgram> getFlagships() {
    return flagships;
  }


  public String getFlagshipValue() {
    return flagshipValue;
  }

  @Override
  public Long getId() {
    return this.id;
  }


  public ProjectPartner getLeader() {

    if (partners != null) {
      for (ProjectPartner partner : partners) {
        for (ProjectPartnerPerson person : partner.getPartnerPersons()) {
          if (person.getContactType().equals(APConstants.PROJECT_PARTNER_PL)) {
            return partner;
          }
        }
      }
    } else {
      for (ProjectPartner partner : projectPartners.stream().filter(c -> c.isActive()).collect(Collectors.toList())) {
        for (ProjectPartnerPerson person : partner.getProjectPartnerPersons()) {
          if (person.isActive()) {
            if (person.getContactType().equals(APConstants.PROJECT_PARTNER_PL)) {
              return partner;
            }
          }

        }
      }


    }
    return null;
  }

  /**
   * This method returns the project partner person who is leading the project.
   * 
   * @return a PartnerPerson object with the information requested. Or null if the project doesn't have a leader.
   */
  public ProjectPartnerPerson getLeaderPerson() {

    if (partners != null) {
      for (ProjectPartner partner : partners) {
        for (ProjectPartnerPerson person : partner.getPartnerPersons()) {

          if (person.getContactType().equals(APConstants.PROJECT_PARTNER_PL)) {
            return person;

          }

        }
      }
    } else {
      for (ProjectPartner partner : projectPartners.stream().filter(c -> c.isActive()).collect(Collectors.toList())) {
        for (ProjectPartnerPerson person : partner.getProjectPartnerPersons()) {
          if (person.isActive()) {
            if (person.getContactType().equals(APConstants.PROJECT_PARTNER_PL)) {
              return person;
            }
          }
        }

      }

    }

    return null;
  }


  public String getLeaderResponsabilities() {
    return this.leaderResponsabilities;
  }


  public LiaisonInstitution getLiaisonInstitution() {
    return this.liaisonInstitution;
  }


  public LiaisonUser getLiaisonUser() {
    return this.liaisonUser;
  }

  public List<ProjectLocation> getLocations() {
    return locations;
  }


  public List<CountryLocationLevel> getLocationsData() {
    return locationsData;
  }

  @Override
  public String getLogDeatil() {
    StringBuilder sb = new StringBuilder();

    sb.append("Id : ").append(this.getId());


    return sb.toString();
  }


  public String getModificationJustification() {
    return this.modificationJustification;
  }


  @Override
  public User getModifiedBy() {
    return this.modifiedBy;
  }

  public List<Activity> getOpenProjectActivities() {
    return openProjectActivities;
  }


  public List<ProjectOutcome> getOutcomes() {
    return outcomes;
  }


  public String getOverall() {
    return overall;
  }

  public List<ProjectPartner> getPartners() {
    return partners;
  }


  public Set<ProjectBudget> getProjectBudgetCofinances() {
    return projectBudgetCofinances;
  }

  public Set<ProjectBudget> getProjectBudgets() {
    return projectBudgets;
  }


  public Set<ProjectBudgetsCluserActvity> getProjectBudgetsCluserActvities() {
    return projectBudgetsCluserActvities;
  }

  public Set<ProjectClusterActivity> getProjectClusterActivities() {
    return projectClusterActivities;
  }


  public ProjectComponentLesson getProjectComponentLesson() {
    return projectComponentLesson;
  }


  public ProjectComponentLesson getProjectComponentLessonPreview() {
    return projectComponentLessonPreview;
  }


  public Set<ProjectComponentLesson> getProjectComponentLessons() {
    return projectComponentLessons;
  }


  public Set<ProjectCrpContribution> getProjectCrpContributions() {
    return projectCrpContributions;
  }

  public List<Deliverable> getProjectDeliverables() {
    return projectDeliverables;
  }


  public Set<ProjectFocus> getProjectFocuses() {
    return this.projectFocuses;
  }

  public Set<ProjectLocation> getProjectLocations() {
    return projectLocations;
  }


  public Set<ProjectOutcome> getProjectOutcomes() {
    return projectOutcomes;
  }

  public Set<ProjectPartner> getProjectPartners() {
    return projectPartners;
  }

  public Set<ProjectScope> getProjectScopes() {
    return projectScopes;
  }

  public List<CrpProgram> getRegions() {
    return regions;
  }

  public String getRegionsValue() {
    return regionsValue;
  }

  public Boolean getRequiresWorkplanUpload() {
    return this.requiresWorkplanUpload;
  }


  public int getScale() {
    return scale;
  }

  public List<ProjectScope> getScopes() {
    return scopes;
  }


  public Set<SectionStatus> getSectionStatuses() {
    return sectionStatuses;
  }

  public String getStandardIdentifier(int typeCodification) {
    StringBuilder result = new StringBuilder();

    switch (typeCodification) {
      // Standar identifier
      case Project.EMAIL_SUBJECT_IDENTIFIER:
        result.append("P" + this.getId());
        break;

      default:
        // Do nothing
        break;

    }


    return result.toString();
  }


  public Date getStartDate() {
    return this.startDate;
  }

  public Set<Submission> getSubmissions() {
    return submissions;
  }

  public String getSummary() {
    return this.summary;
  }


  public String getTitle() {
    return this.title;
  }

  public String getType() {
    return this.type;
  }

  public long getW3Budget() {
    long total = 0;
    for (ProjectBudget projectBudget : this.getProjectBudgets().stream()
      .filter(c -> c.isActive() && c.getBudgetType().getId() == 2).collect(Collectors.toList())) {
      if (projectBudget.getAmount() != null) {
        total = total + projectBudget.getAmount();
      }
    }

    return total;
  }


  public FileDB getWorkplan() {
    return workplan;
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


  public boolean isBilateralProject() {
    return (type != null) ? type.equals(APConstants.PROJECT_BILATERAL) : false;
  }


  /**
   * A project is bilateral stand alone if it is bilateral and it is NOT contributing to any Core project.
   * 
   * @return true if the project is bilateral stand alone, false if is bilateral and is contributing to some core
   *         project.
   */
  public boolean isBilateralStandAlone() {
    return (type != null) ? (this.isBilateralProject() && !this.cofinancing) : false;
  }

  public boolean isCofinancing() {
    return cofinancing;
  }


  public boolean isCoFundedProject() {
    return (type != null) ? type.equals(APConstants.PROJECT_CCAFS_COFUNDED) : false;
  }


  public boolean isCoreProject() {
    return (type != null) ? type.equals(APConstants.PROJECT_CORE) : false;
  }

  public Boolean isNoRegional() {
    return noRegional;
  }


  public boolean isProjectEditLeader() {
    return projectEditLeader;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setActiveSince(Date activeSince) {
    this.activeSince = activeSince;
  }

  public void setActivities(Set<Activity> activities) {
    this.activities = activities;
  }


  public void setAnnualReportToDonnor(FileDB annualReportToDonnor) {
    this.annualReportToDonnor = annualReportToDonnor;
  }


  public void setBilateralContractName(FileDB bilateralContractName) {
    this.bilateralContractName = bilateralContractName;
  }

  public void setBudgets(List<ProjectBudget> budgets) {
    this.budgets = budgets;
  }


  public void setBudgetsCluserActvities(List<ProjectBudgetsCluserActvity> budgetsCluserActvities) {
    this.budgetsCluserActvities = budgetsCluserActvities;
  }

  public void setBudgetsCofinancing(List<ProjectBudget> budgetsCofinancing) {
    this.budgetsCofinancing = budgetsCofinancing;
  }

  public void setClosedProjectActivities(List<Activity> closedProjectActivities) {
    this.closedProjectActivities = closedProjectActivities;
  }

  public void setClusterActivities(List<ProjectClusterActivity> clusterActivities) {
    this.clusterActivities = clusterActivities;
  }

  public void setCofinancing(boolean cofinancing) {
    this.cofinancing = cofinancing;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public void setCreatedBy(User usersByCreatedBy) {
    this.createdBy = usersByCreatedBy;
  }

  public void setCrp(Crp crp) {
    this.crp = crp;
  }


  public void setCrpActivities(List<CrpClusterOfActivity> crpActivities) {
    this.crpActivities = crpActivities;
  }


  public void setDeliverables(Set<Deliverable> deliverables) {
    this.deliverables = deliverables;
  }


  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public void setFlagships(List<CrpProgram> flagships) {
    this.flagships = flagships;
  }

  public void setFlagshipValue(String flagshipValue) {
    this.flagshipValue = flagshipValue;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setLeaderResponsabilities(String leaderResponsabilities) {
    this.leaderResponsabilities = leaderResponsabilities;
  }

  public void setLiaisonInstitution(LiaisonInstitution liaisonInstitution) {
    this.liaisonInstitution = liaisonInstitution;
  }

  public void setLiaisonUser(LiaisonUser liaisonUser) {
    this.liaisonUser = liaisonUser;
  }

  public void setLocations(List<ProjectLocation> locations) {
    this.locations = locations;
  }

  public void setLocationsData(List<CountryLocationLevel> locationsData) {
    this.locationsData = locationsData;
  }

  public void setModificationJustification(String modificationJustification) {
    this.modificationJustification = modificationJustification;
  }


  public void setModifiedBy(User usersByModifiedBy) {
    this.modifiedBy = usersByModifiedBy;
  }


  public void setNoRegional(Boolean noRegional) {
    this.noRegional = noRegional;
  }

  public void setOpenProjectActivities(List<Activity> openProjectActivities) {
    this.openProjectActivities = openProjectActivities;
  }

  public void setOutcomes(List<ProjectOutcome> outcomes) {
    this.outcomes = outcomes;
  }

  public void setOverall(String overall) {
    this.overall = overall;
  }

  public void setPartners(List<ProjectPartner> partners) {
    this.partners = partners;
  }

  public void setProjectBudgetCofinances(Set<ProjectBudget> projectBudgetCofinances) {
    this.projectBudgetCofinances = projectBudgetCofinances;
  }

  public void setProjectBudgets(Set<ProjectBudget> projectBudgets) {
    this.projectBudgets = projectBudgets;
  }


  public void setProjectBudgetsCluserActvities(Set<ProjectBudgetsCluserActvity> projectBudgetsCluserActvities) {
    this.projectBudgetsCluserActvities = projectBudgetsCluserActvities;
  }


  public void setProjectClusterActivities(Set<ProjectClusterActivity> projectClusterActivities) {
    this.projectClusterActivities = projectClusterActivities;
  }


  public void setProjectComponentLesson(ProjectComponentLesson projectComponentLesson) {
    this.projectComponentLesson = projectComponentLesson;
  }


  public void setProjectComponentLessonPreview(ProjectComponentLesson projectComponentLessonPreview) {
    this.projectComponentLessonPreview = projectComponentLessonPreview;
  }


  public void setProjectComponentLessons(Set<ProjectComponentLesson> projectComponentLessons) {
    this.projectComponentLessons = projectComponentLessons;
  }


  public void setProjectCrpContributions(Set<ProjectCrpContribution> projectCrpContributions) {
    this.projectCrpContributions = projectCrpContributions;
  }


  public void setProjectDeliverables(List<Deliverable> projectDeliverables) {
    this.projectDeliverables = projectDeliverables;
  }


  public void setProjectEditLeader(boolean projectEditLeader) {
    this.projectEditLeader = projectEditLeader;
  }


  public void setProjectFocuses(Set<ProjectFocus> projectFocuseses) {
    this.projectFocuses = projectFocuseses;
  }


  public void setProjectLocations(Set<ProjectLocation> projectLocations) {
    this.projectLocations = projectLocations;
  }

  public void setProjectOutcomes(Set<ProjectOutcome> projectOutcomes) {
    this.projectOutcomes = projectOutcomes;
  }

  public void setProjectPartners(Set<ProjectPartner> projectPartners) {
    this.projectPartners = projectPartners;
  }

  public void setProjectScopes(Set<ProjectScope> projectScopes) {
    this.projectScopes = projectScopes;
  }


  public void setRegions(List<CrpProgram> regions) {
    this.regions = regions;
  }


  public void setRegionsValue(String regionsValue) {
    this.regionsValue = regionsValue;
  }

  public void setRequiresWorkplanUpload(Boolean requiresWorkplanUpload) {
    this.requiresWorkplanUpload = requiresWorkplanUpload;
  }

  public void setScale(int scale) {
    this.scale = scale;
  }


  public void setScopes(List<ProjectScope> scopes) {
    this.scopes = scopes;
  }


  public void setSectionStatuses(Set<SectionStatus> sectionStatuses) {
    this.sectionStatuses = sectionStatuses;
  }


  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }


  public void setSubmissions(Set<Submission> submissions) {
    this.submissions = submissions;
  }


  public void setSummary(String summary) {
    this.summary = summary;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public void setType(String type) {
    this.type = type;
  }


  public void setWorkplan(FileDB workplan) {
    this.workplan = workplan;
  }

  @Override
  public String toString() {
    return id.toString();
  }
}
