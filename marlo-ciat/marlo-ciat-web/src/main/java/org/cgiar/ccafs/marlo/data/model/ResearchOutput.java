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

import org.cgiar.ccafs.marlo.data.IAuditLog;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.annotations.Expose;


/**
 * @author nmatovu
 * @author hjimenez
 */
public class ResearchOutput implements Serializable, IAuditLog {


  private static final long serialVersionUID = -185814169741386135L;


  @Expose
  private Long id;

  @Expose
  private String title;


  @Expose
  private Date dateAdded;

  @Expose
  private ResearchOutcome researchOutcome;


  @Expose
  private Date activeSince;

  @Expose
  private boolean active;

  @Expose
  private User createdBy;

  @Expose
  private User modifiedBy;


  @Expose
  private String shortName;

  @Expose
  private String modificationJustification;


  private Set<ResearchOutputPartner> researchOutputPartners = new HashSet<ResearchOutputPartner>(0);

  private Set<SectionStatus> sectionStatuses = new HashSet<SectionStatus>(0);

  private Set<ResearchOutputsNextUser> researchOutputsNextUsers = new HashSet<ResearchOutputsNextUser>(0);

  private Set<ProjectOutput> projectOutputs = new HashSet<ProjectOutput>(0);

  private List<ResearchOutputPartner> partners;

  private List<ResearchOutputsNextUser> nextUsers;


  public ResearchOutput() {
    super();
  }

  /**
   * @param output
   * @param dateAdded
   * @param researchOutcome
   */
  public ResearchOutput(String title, Date dateAdded, ResearchOutcome researchOutcome, Date activeSince) {
    super();
    this.title = title;
    this.dateAdded = dateAdded;
    this.researchOutcome = researchOutcome;
    this.activeSince = activeSince;
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
    ResearchOutput other = (ResearchOutput) obj;
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

  public String getComposedName() {
    return "O" + this.id + "- " + (this.title != null ? this.title : "title not defined");
  }


  public User getCreatedBy() {
    return createdBy;
  }


  /**
   * @return the dateAdded
   */
  public Date getDateAdded() {
    return dateAdded;
  }


  /**
   * @return the id
   */
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

  public List<ResearchOutputsNextUser> getNextUsers() {
    return nextUsers;
  }


  public List<ResearchOutputPartner> getPartners() {
    return partners;
  }

  public Set<ProjectOutput> getProjectOutputs() {
    return projectOutputs;
  }

  /**
   * @return the researchOutcome
   */
  public ResearchOutcome getResearchOutcome() {
    return researchOutcome;
  }


  public Set<ResearchOutputPartner> getResearchOutputPartners() {
    return researchOutputPartners;
  }

  public Set<ResearchOutputsNextUser> getResearchOutputsNextUsers() {
    return researchOutputsNextUsers;
  }

  public Set<SectionStatus> getSectionStatuses() {
    return sectionStatuses;
  }

  public String getShortName() {
    return shortName;
  }

  public String getTitle() {
    return title;
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


  /**
   * @param dateAdded the dateAdded to set
   */
  public void setDateAdded(Date dateAdded) {
    this.dateAdded = dateAdded;
  }


  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  public void setModificationJustification(String modificationJustification) {
    this.modificationJustification = modificationJustification;
  }

  public void setModifiedBy(User modifiedBy) {
    this.modifiedBy = modifiedBy;
  }


  public void setNextUsers(List<ResearchOutputsNextUser> nextUsers) {
    this.nextUsers = nextUsers;
  }


  public void setPartners(List<ResearchOutputPartner> partners) {
    this.partners = partners;
  }

  public void setProjectOutputs(Set<ProjectOutput> projectOutputs) {
    this.projectOutputs = projectOutputs;
  }


  /**
   * @param researchOutcome the researchOutcome to set
   */
  public void setResearchOutcome(ResearchOutcome researchOutcome) {
    this.researchOutcome = researchOutcome;
  }

  public void setResearchOutputPartners(Set<ResearchOutputPartner> researchOutputPartners) {
    this.researchOutputPartners = researchOutputPartners;
  }

  public void setResearchOutputsNextUsers(Set<ResearchOutputsNextUser> researchOutputsNextUsers) {
    this.researchOutputsNextUsers = researchOutputsNextUsers;
  }

  public void setSectionStatuses(Set<SectionStatus> sectionStatuses) {
    this.sectionStatuses = sectionStatuses;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
