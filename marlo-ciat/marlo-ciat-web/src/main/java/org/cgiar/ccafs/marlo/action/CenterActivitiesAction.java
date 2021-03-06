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
package org.cgiar.ccafs.marlo.action;

import org.cgiar.ccafs.marlo.config.APConfig;
import org.cgiar.ccafs.marlo.data.model.ResearchCenter;
import org.cgiar.ccafs.marlo.data.model.ResearchProgram;
import org.cgiar.ccafs.marlo.data.model.Role;
import org.cgiar.ccafs.marlo.data.model.User;
import org.cgiar.ccafs.marlo.data.service.IAuditLogService;
import org.cgiar.ccafs.marlo.data.service.ICenterService;
import org.cgiar.ccafs.marlo.data.service.IProgramService;
import org.cgiar.ccafs.marlo.data.service.IRoleService;
import org.cgiar.ccafs.marlo.data.service.IUserRoleService;
import org.cgiar.ccafs.marlo.data.service.IUserService;
import org.cgiar.ccafs.marlo.utils.APConstants;
import org.cgiar.ccafs.marlo.utils.SendMail;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import com.google.inject.Inject;


/**
 * This action handles the Impact Pathways center activities
 * Modified by @author nmatovu last on Oct 3, 2016
 */
@SuppressWarnings("unused")
public class CenterActivitiesAction extends BaseAction {


  private static final long serialVersionUID = 486231648621207806L;

  private IRoleService roleService;
  private IUserRoleService userRoleService;
  private ICenterService crpService;
  private IUserService userService;
  private IProgramService programService;
  private Role role;
  private long clRol;
  private ResearchProgram selectedProgram;
  private IAuditLogService auditLogService;
  private ResearchCenter loggedCrp;
  private Role roleCl;
  private List<ResearchProgram> programs;
  private long crpProgramID;

  private String transaction;
  // Util
  private SendMail sendMail;


  @Inject
  public CenterActivitiesAction(APConfig config, IRoleService roleManager, IUserRoleService userRoleManager,
    ICenterService crpManager, IUserService userManager, IProgramService crpProgramService,
    IAuditLogService auditLogManager, SendMail sendMail) {
    super(config);
    this.roleService = roleManager;
    this.userRoleService = userRoleManager;
    this.crpService = crpManager;
    this.userService = userManager;
    this.programService = crpProgramService;
    this.auditLogService = auditLogManager;
    this.sendMail = sendMail;
  }

  @Override
  public String cancel() {

    Path path = this.getAutoSaveFilePath();

    if (path.toFile().exists()) {
      path.toFile().delete();
    }

    this.setDraft(false);
    Collection<String> messages = this.getActionMessages();
    if (!messages.isEmpty()) {
      String validationMessage = messages.iterator().next();
      this.setActionMessages(null);
      this.addActionWarning(this.getText("cancel.autoSave") + validationMessage);
    } else {
      this.addActionMessage(this.getText("cancel.autoSave"));
    }
    messages = this.getActionMessages();

    return SUCCESS;
  }

  private Path getAutoSaveFilePath() {
    String composedClassName = selectedProgram.getClass().getSimpleName();
    String actionFile = this.getActionName().replace("/", "_");
    String autoSaveFile = selectedProgram.getId() + "_" + composedClassName + "_" + actionFile + ".json";

    return Paths.get(config.getAutoSaveFolder() + autoSaveFile);
  }


  public long getClRol() {
    return clRol;
  }


  public long getCrpProgramID() {
    return crpProgramID;
  }

  public ResearchCenter getLoggedCrp() {
    return loggedCrp;
  }


  public List<ResearchProgram> getPrograms() {
    return programs;
  }


  public Role getRoleCl() {
    return roleCl;
  }

  public ResearchProgram getSelectedProgram() {
    return selectedProgram;
  }


  public String getTransaction() {
    return transaction;
  }


  /**
   * @param userAssigned is the user been assigned
   * @param role is the role(Cluster Leader)
   * @param crpClusterPreview is the crpCluster
   */
  private void notifyRoleAssigned(User userAssigned, Role role) {
    String ClusterRole = this.getText("cluster.role");
    String ClusterRoleAcronym = this.getText("cluster.role.acronym");

    userAssigned = userService.getUser(userAssigned.getId());
    StringBuilder message = new StringBuilder();
    // Building the Email message:
    message.append(this.getText("email.dear", new String[] {userAssigned.getFirstName()}));
    // message.append(this.getText("email.cluster.assigned", new String[] {ClusterRole,
    // crpClusterPreview.getCrpProgram().getName(), crpClusterPreview.getCrpProgram().getAcronym()}));
    message.append(this.getText("email.support"));
    message.append(this.getText("email.bye"));

    String toEmail = null;
    String ccEmail = null;
    if (config.isProduction()) {
      // Send email to the new user and the P&R notification email.
      // TO
      toEmail = userAssigned.getEmail();
      // CC will be the user who is making the modification.
      if (this.getCurrentUser() != null) {
        ccEmail = this.getCurrentUser().getEmail();
      }
    }
    // BBC will be our gmail notification email.
    String bbcEmails = this.config.getEmailNotification();
    sendMail.send(toEmail, ccEmail, bbcEmails, "TODO",
      // this.getText("email.cluster.assigned.subject", new String[] {loggedCrp.getName(), ClusterRoleAcronym,
      // crpClusterPreview.getCrpProgram().getAcronym()}),
      message.toString(),

      null, null, null, true

    );
  }


  private void notifyRoleUnassigned(User userAssigned, Role role) {
    String ClusterRole = this.getText("cluster.role");
    String ClusterRoleAcronym = this.getText("cluster.role.acronym");

    userAssigned = userService.getUser(userAssigned.getId());
    StringBuilder message = new StringBuilder();
    // Building the Email message:
    message.append(this.getText("email.dear", new String[] {userAssigned.getFirstName()}));
    // message.append(this.getText("email.cluster.unassigned", new String[] {ClusterRole,
    // crpClusterOfActivity.getCrpProgram().getName(), crpClusterOfActivity.getCrpProgram().getAcronym()}));
    message.append(this.getText("email.support"));
    message.append(this.getText("email.bye"));

    String toEmail = null;
    String ccEmail = null;
    if (config.isProduction()) {
      // Send email to the new user and the P&R notification email.
      // TO
      toEmail = userAssigned.getEmail();
      // CC will be the user who is making the modification.
      if (this.getCurrentUser() != null) {
        ccEmail = this.getCurrentUser().getEmail();
      }
    }
    // BBC will be our gmail notification email.
    String bbcEmails = this.config.getEmailNotification();
    sendMail.send(toEmail, ccEmail, bbcEmails, "Sub"
    // this.getText("email.cluster.unassigned.subject", new String[] {loggedCrp.getName(), ClusterRoleAcronym,
    // crpClusterOfActivity.getCrpProgram().getAcronym()})

      , message.toString(), null, null, null, true);
  }

  @Override
  public void prepare() throws Exception {
    // TODO:Update this method.
    // Get the Users list that have the pmu role in this crp.
    loggedCrp = (ResearchCenter) this.getSession().get(APConstants.SESSION_CENTER);
    loggedCrp = crpService.getCrpById(loggedCrp.getId());

  }

  @Override
  public String save() {

    // TODO: Refactor and Update as required.
    return SUCCESS;


  }

  public void setClRol(long clRol) {
    this.clRol = clRol;
  }


  public void setCrpProgramID(long crpProgramID) {
    this.crpProgramID = crpProgramID;
  }


  public void setLoggedCrp(ResearchCenter loggedCrp) {
    this.loggedCrp = loggedCrp;
  }


  public void setPrograms(List<ResearchProgram> programs) {
    this.programs = programs;
  }


  public void setRoleCl(Role roleCl) {
    this.roleCl = roleCl;
  }


  public void setSelectedProgram(ResearchProgram selectedProgram) {
    this.selectedProgram = selectedProgram;
  }

  public void setTransaction(String transactionID) {
    this.transaction = transactionID;
  }

  @Override
  public void validate() {
    // TODO: Update
  }


}
