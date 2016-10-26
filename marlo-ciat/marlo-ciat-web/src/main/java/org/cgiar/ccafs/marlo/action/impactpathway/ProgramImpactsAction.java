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

/**
 * 
 */
package org.cgiar.ccafs.marlo.action.impactpathway;

import org.cgiar.ccafs.marlo.action.BaseAction;
import org.cgiar.ccafs.marlo.config.APConfig;
import org.cgiar.ccafs.marlo.data.model.ResearchArea;
import org.cgiar.ccafs.marlo.data.model.ResearchCenter;
import org.cgiar.ccafs.marlo.data.model.ResearchImpact;
import org.cgiar.ccafs.marlo.data.model.ResearchImpactObjective;
import org.cgiar.ccafs.marlo.data.model.ResearchLeader;
import org.cgiar.ccafs.marlo.data.model.ResearchObjective;
import org.cgiar.ccafs.marlo.data.model.ResearchProgram;
import org.cgiar.ccafs.marlo.data.model.User;
import org.cgiar.ccafs.marlo.data.service.ICenterService;
import org.cgiar.ccafs.marlo.data.service.IProgramService;
import org.cgiar.ccafs.marlo.data.service.IResearchAreaService;
import org.cgiar.ccafs.marlo.data.service.IResearchImpactObjectiveService;
import org.cgiar.ccafs.marlo.data.service.IResearchImpactService;
import org.cgiar.ccafs.marlo.data.service.IResearchLeaderService;
import org.cgiar.ccafs.marlo.data.service.IResearchObjectiveService;
import org.cgiar.ccafs.marlo.data.service.IUserService;
import org.cgiar.ccafs.marlo.security.Permission;
import org.cgiar.ccafs.marlo.utils.APConstants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The action class for handling the Program Impacts
 * Modified by @author nmatovu last on Oct 3, 2016
 */
public class ProgramImpactsAction extends BaseAction {


  private static final long serialVersionUID = -2261790056574973080L;


  private static final Logger LOG = LoggerFactory.getLogger(ProgramImpactsAction.class);


  private ICenterService centerService;


  private IProgramService programService;


  private IResearchAreaService researchAreaService;


  private IUserService userService;


  private IResearchObjectiveService objectiveService;


  private IResearchImpactService impactService;

  private IResearchImpactObjectiveService impactObjectiveService;

  private ResearchCenter loggedCenter;

  private List<ResearchArea> researchAreas;


  private ResearchArea selectedResearchArea;
  private List<ResearchProgram> researchPrograms;
  private List<ResearchObjective> researchObjectives;
  private ResearchProgram selectedProgram;
  private List<ResearchImpact> researchImpacts;
  private long programID;
  private long areaID;

  @Inject
  public ProgramImpactsAction(APConfig config, ICenterService centerService, IProgramService programService,
    IResearchAreaService researchAreaService, IResearchLeaderService researchLeaderService, IUserService userService,
    IResearchObjectiveService objectiveService, IResearchImpactService impactService,
    IResearchImpactObjectiveService impactObjectiveService) {
    super(config);
    this.centerService = centerService;
    this.programService = programService;
    this.researchAreaService = researchAreaService;
    this.userService = userService;
    this.objectiveService = objectiveService;
    this.impactService = impactService;
    this.impactObjectiveService = impactObjectiveService;

  }

  /**
   * @return the areaID
   */
  public Long getAreaID() {
    return areaID;
  }

  /**
   * @return the loggedCenter
   */
  public ResearchCenter getLoggedCenter() {
    return loggedCenter;
  }

  /**
   * @return the programID
   */
  public Long getProgramID() {
    return programID;
  }

  public List<ResearchArea> getResearchAreas() {
    return researchAreas;
  }


  public List<ResearchImpact> getResearchImpacts() {
    return researchImpacts;
  }

  public List<ResearchObjective> getResearchObjectives() {
    return researchObjectives;
  }


  /**
   * @return the researchPrograms
   */
  public List<ResearchProgram> getResearchPrograms() {
    return researchPrograms;
  }


  /**
   * @return the selectedProgram
   */
  public ResearchProgram getSelectedProgram() {
    return selectedProgram;
  }


  /**
   * @return the selectedResearchArea
   */
  public ResearchArea getSelectedResearchArea() {
    return selectedResearchArea;
  }

  @Override
  public void prepare() throws Exception {
    areaID = -1;
    programID = -1;

    loggedCenter = (ResearchCenter) this.getSession().get(APConstants.SESSION_CENTER);
    loggedCenter = centerService.getCrpById(loggedCenter.getId());

    researchAreas = new ArrayList<>(
      loggedCenter.getResearchAreas().stream().filter(ra -> ra.isActive()).collect(Collectors.toList()));

    Collections.sort(researchAreas, (ra1, ra2) -> ra1.getId().compareTo(ra2.getId()));

    if (researchAreas != null) {

      try {
        areaID = Long.parseLong(StringUtils.trim(this.getRequest().getParameter(APConstants.CENTER_AREA_ID)));
      } catch (Exception e) {
        try {
          programID = Long.parseLong(StringUtils.trim(this.getRequest().getParameter(APConstants.CENTER_PROGRAM_ID)));
        } catch (Exception ex) {
          User user = userService.getUser(this.getCurrentUser().getId());

          // TODO - Create Enum to Research Leaders Type
          List<ResearchLeader> userLeads = new ArrayList<>(user.getResearchLeaders().stream()
            .filter(rl -> rl.isActive() && rl.getType().getId() == 6).collect(Collectors.toList()));

          if (!userLeads.isEmpty()) {
            programID = userLeads.get(0).getResearchProgram().getId();
          } else {
            if (!researchAreas.isEmpty()) {
              ResearchProgram rp = researchAreas.get(0).getResearchPrograms().stream().filter(r -> r.isActive())
                .collect(Collectors.toList()).get(0);
              programID = rp.getId();
            }
          }
        }
      }

      if (areaID != -1 && programID == -1) {
        selectedResearchArea = researchAreaService.find(areaID);
        researchPrograms = new ArrayList<>(
          selectedResearchArea.getResearchPrograms().stream().filter(rp -> rp.isActive()).collect(Collectors.toList()));
        Collections.sort(researchPrograms, (rp1, rp2) -> rp1.getId().compareTo(rp2.getId()));
        if (researchPrograms != null) {
          try {
            programID = Long.parseLong(StringUtils.trim(this.getRequest().getParameter(APConstants.CENTER_PROGRAM_ID)));
          } catch (Exception e) {
            User user = userService.getUser(this.getCurrentUser().getId());

            // TODO - Create Enum to Research Leaders Type
            List<ResearchLeader> userLeads = new ArrayList<>(user.getResearchLeaders().stream()
              .filter(rl -> rl.isActive() && rl.getType().getId() == 6).collect(Collectors.toList()));

            if (!userLeads.isEmpty()) {
              programID = userLeads.get(0).getResearchProgram().getId();
            } else {
              if (!researchPrograms.isEmpty()) {
                programID = researchPrograms.get(0).getId();
              }
            }
          }
        }

        if (programID != -1) {
          selectedProgram = programService.getProgramById(programID);
        }
      } else {
        if (programID != -1) {
          selectedProgram = programService.getProgramById(programID);
          areaID = selectedProgram.getResearchArea().getId();
          selectedResearchArea = researchAreaService.find(areaID);
        }
      }


      researchImpacts =
        selectedProgram.getResearchImpacts().stream().filter(ri -> ri.isActive()).collect(Collectors.toList());


      if (objectiveService.findAll() != null) {
        researchObjectives =
          new ArrayList<>(objectiveService.findAll().stream().filter(ro -> ro.isActive()).collect(Collectors.toList()));
      }


      if (researchImpacts != null) {
        for (ResearchImpact researchImpact : researchImpacts) {
          researchImpact.setObjectives(new ArrayList<>());
          if (researchImpact.getResearchImpactObjectives() != null) {
            for (ResearchImpactObjective impactObjective : researchImpact.getResearchImpactObjectives().stream()
              .filter(ro -> ro.isActive()).collect(Collectors.toList())) {
              researchImpact.getObjectives().add(impactObjective.getResearchObjective());
            }
          }
          // if (impactObjectiveService.findAll() != null) {
          // for (ResearchImpactObjective impactObjective : impactObjectiveService.findAll().stream()
          // .filter(ro -> ro.isActive() && ro.getResearchImpact().getId() == researchImpact.getId())
          // .collect(Collectors.toList())) {
          // researchImpact.getObjectives().add(impactObjective.getResearchObjective());
          // }
          // }
        }
      }


    }


    String params[] = {loggedCenter.getAcronym(), selectedResearchArea.getId() + "", selectedProgram.getId() + ""};
    this.setBasePermission(this.getText(Permission.RESEARCH_PROGRAM_BASE_PERMISSION, params));

    if (this.isHttpPost()) {
      if (researchAreas != null) {
        researchAreas.clear();
      }
      if (researchPrograms != null) {
        researchPrograms.clear();
      }
      if (researchObjectives != null) {
        researchObjectives.clear();
      }
      if (researchImpacts != null) {
        researchImpacts.clear();
      }
    }

    for (ResearchImpact ri : researchImpacts) {
      System.out.println(ri.getId());
    }
  }

  @Override
  public String save() {
    if (this.hasPermission("*")) {

      ResearchProgram programDb = programService.getProgramById(selectedProgram.getId());

      for (ResearchImpact researchImpact : programDb.getResearchImpacts().stream().filter(ri -> ri.isActive())
        .collect(Collectors.toList())) {
        if (!researchImpacts.contains(researchImpact)) {

          if (impactObjectiveService.findAll() != null) {
            for (ResearchImpactObjective impactObjective : impactObjectiveService.findAll().stream()
              .filter(io -> io.isActive() && io.getResearchImpact().getId() == researchImpact.getId())
              .collect(Collectors.toList())) {
              impactObjectiveService.deleteResearchImpactObjective(impactObjective.getId());
            }
          }

          impactService.deleteResearchImpact(researchImpact.getId());
        }
      }

      for (ResearchImpact researchImpact : researchImpacts) {
        if (researchImpact.getId() == null || researchImpact.getId() == -1) {
          ResearchImpact researchImpactNew = new ResearchImpact();
          researchImpactNew.setActive(true);
          researchImpactNew.setActiveSince(new Date());
          researchImpactNew.setCreatedBy(this.getCurrentUser());
          researchImpactNew.setDescription(researchImpact.getDescription());
          researchImpactNew.setResearchProgram(programDb);
          researchImpactNew.setTargetYear(researchImpact.getTargetYear());

          long impactId = impactService.saveResearchImpact(researchImpactNew);

          researchImpactNew = impactService.getResearchImpactById(impactId);

          if (researchImpact.getObjectiveValue() != null && researchImpact.getObjectiveValue().length() > 0) {
            for (String objectiveId : researchImpact.getObjectiveValue().trim().split(",")) {
              ResearchObjective researchObjective =
                objectiveService.getResearchObjectiveById(Long.parseLong(objectiveId));
              ResearchImpactObjective impactObjectiveNew = new ResearchImpactObjective();
              impactObjectiveNew.setActive(true);
              impactObjectiveNew.setActiveSince(new Date());
              impactObjectiveNew.setCreatedBy(this.getCurrentUser());
              impactObjectiveNew.setResearchObjective(researchObjective);
              impactObjectiveNew.setResearchImpact(researchImpactNew);

              impactObjectiveService.saveResearchImpactObjective(impactObjectiveNew);
            }
          }
        } else {
          boolean hasChanges = false;
          ResearchImpact researchImpactRew = impactService.getResearchImpactById(researchImpact.getId());

          if (!researchImpactRew.getDescription().equals(researchImpact.getDescription())) {
            hasChanges = true;
            researchImpactRew.setDescription(researchImpact.getDescription());
          }

          if (!researchImpactRew.getTargetYear().equals(researchImpact.getTargetYear())) {
            hasChanges = true;
            researchImpactRew.setTargetYear(researchImpact.getTargetYear());
          }

          if (hasChanges) {
            long impactId = impactService.saveResearchImpact(researchImpactRew);
            researchImpactRew = impactService.getResearchImpactById(impactId);
          }

          if (researchImpact.getObjectiveValue() != null && researchImpact.getObjectiveValue().length() > 0) {
            for (ResearchImpactObjective impactObjective : researchImpactRew.getResearchImpactObjectives().stream()
              .filter(rio -> rio.isActive()).collect(Collectors.toList())) {
              if (!researchImpact.getObjectiveValue()
                .contains(impactObjective.getResearchObjective().getId().toString())) {
                impactObjectiveService.deleteResearchImpactObjective(impactObjective.getId());
              }
            }

            for (String objectiveId : researchImpact.getObjectiveValue().trim().split(",")) {
              ResearchObjective researchObjective =
                objectiveService.getResearchObjectiveById(Long.parseLong(objectiveId.trim()));
              ResearchImpactObjective impactObjectiveNew = new ResearchImpactObjective();
              impactObjectiveNew.setResearchObjective(researchObjective);
              impactObjectiveNew.setResearchImpact(researchImpactRew);

              List<ResearchImpactObjective> impactObjectives = researchImpactRew.getResearchImpactObjectives().stream()
                .filter(rio -> rio.isActive()).collect(Collectors.toList());

              if (!impactObjectives.contains(impactObjectiveNew)) {
                impactObjectiveNew.setActive(true);
                impactObjectiveNew.setActiveSince(new Date());
                impactObjectiveNew.setCreatedBy(this.getCurrentUser());
                impactObjectiveService.saveResearchImpactObjective(impactObjectiveNew);
              }

            }
          }

        }
      }

      selectedProgram = programService.getProgramById(programDb.getId());
      programService.saveProgram(selectedProgram);

      Collection<String> messages = this.getActionMessages();
      if (!messages.isEmpty()) {
        String validationMessage = messages.iterator().next();
        this.setActionMessages(null);
        this.addActionWarning(this.getText("saving.saved") + validationMessage);
      } else {
        this.addActionMessage(this.getText("saving.saved"));
      }
      messages = this.getActionMessages();

      return SUCCESS;
    } else {
      return NOT_AUTHORIZED;
    }

  }


  /**
   * @param areaID the areaID to set
   */
  public void setAreaID(long areaID) {
    this.areaID = areaID;
  }


  /**
   * @param areaID the areaID to set
   */
  public void setAreaID(Long areaID) {
    this.areaID = areaID;
  }

  /**
   * @param loggedCenter the loggedCenter to set
   */
  public void setLoggedCenter(ResearchCenter loggedCenter) {
    this.loggedCenter = loggedCenter;
  }


  /**
   * @param programID the programID to set
   */
  public void setProgramID(long programID) {
    this.programID = programID;
  }

  /**
   * @param programID the programID to set
   */
  public void setProgramID(Long programID) {
    this.programID = programID;
  }


  public void setResearchAreas(List<ResearchArea> researchAreas) {
    this.researchAreas = researchAreas;
  }

  public void setResearchImpacts(List<ResearchImpact> researchImpacts) {
    this.researchImpacts = researchImpacts;
  }

  public void setResearchObjectives(List<ResearchObjective> researchObjectives) {
    this.researchObjectives = researchObjectives;
  }


  /**
   * @param researchPrograms the researchPrograms to set
   */
  public void setResearchPrograms(List<ResearchProgram> researchPrograms) {
    this.researchPrograms = researchPrograms;
  }


  /**
   * @param selectedProgram the selectedProgram to set
   */
  public void setSelectedProgram(ResearchProgram selectedProgram) {
    this.selectedProgram = selectedProgram;
  }

  /**
   * @param selectedResearchArea the selectedResearchArea to set
   */
  public void setSelectedResearchArea(ResearchArea selectedResearchArea) {
    this.selectedResearchArea = selectedResearchArea;
  }

}
