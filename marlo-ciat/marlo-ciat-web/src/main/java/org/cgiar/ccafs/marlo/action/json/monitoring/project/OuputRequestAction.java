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

package org.cgiar.ccafs.marlo.action.json.monitoring.project;

import org.cgiar.ccafs.marlo.action.BaseAction;
import org.cgiar.ccafs.marlo.config.APConfig;
import org.cgiar.ccafs.marlo.data.model.Project;
import org.cgiar.ccafs.marlo.data.model.ResearchOutcome;
import org.cgiar.ccafs.marlo.data.model.TopicOutcomes;
import org.cgiar.ccafs.marlo.data.service.IProjectService;
import org.cgiar.ccafs.marlo.data.service.IResearchOutcomeService;
import org.cgiar.ccafs.marlo.utils.APConstants;
import org.cgiar.ccafs.marlo.utils.SendMail;

import java.util.Collection;
import java.util.List;

import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Hermes Jiménez - CIAT/CCAFS
 */
public class OuputRequestAction extends BaseAction {


  private static final long serialVersionUID = -1648698670582263338L;


  // Logger
  private static final Logger LOG = LoggerFactory.getLogger(OuputRequestAction.class);


  private SendMail sendMail;
  private IResearchOutcomeService outcomeService;
  private IProjectService projectService;
  private List<TopicOutcomes> outcomes;
  private boolean messageSent;
  private Long outcomeID;
  private String outputName;
  private Long projectID;

  @Inject
  public OuputRequestAction(APConfig config, IResearchOutcomeService outcomeService, IProjectService projectService,
    SendMail sendMail) {
    super(config);
    this.outcomeService = outcomeService;
    this.projectService = projectService;
    this.sendMail = sendMail;
  }

  @Override
  public String execute() throws Exception {
    String subject;
    StringBuilder message = new StringBuilder();

    Project project = projectService.getProjectById(projectID);

    ResearchOutcome outcome = outcomeService.getResearchOutcomeById(outcomeID);

    String outcomeName = outcome.getComposedName();
    String outputName = this.outputName;

    // message subject
    subject =
      "[MARLO -" + this.getCenterSession().toUpperCase() + "] Output verification - " + project.getComposedName();
    // Message content
    message.append(this.getCurrentUser().getFirstName() + " " + this.getCurrentUser().getLastName() + " ");
    message.append("(" + this.getCurrentUser().getEmail() + ") ");
    message.append("is requesting to add the following ouput information:");
    message.append("</br></br>");
    message.append("<b>Program: </b>");
    message.append(project.getResearchProgram().getName());
    message.append("</br></br>");
    message.append("<b>Project: </b>");
    message.append(project.getComposedName());
    message.append("</br></br>");
    message.append("<b>Outcome : </b>");
    message.append(outcomeName);
    message.append("</br></br>");
    message.append("<b>Output Name:</b> ");
    message.append(outputName);
    message.append("</br></br></br>");
    message.append("Best regards,");
    message.append("</br></br></br>");
    message.append("<b> MARLO TEAM </b>");
    message.append("</br></br>");
    message.append("*** Please do not reply to this email as this is an automated notification ***");


    try {
      sendMail.send(config.getEmailNotification(), null, config.getEmailNotification(), subject, message.toString(),
        null, null, null, true);
    } catch (Exception e) {

    }
    Collection<String> messages = this.getActionMessages();
    this.addActionMessage("message:" + this.getText("saving.saved"));
    messages = this.getActionMessages();

    messageSent = true;

    return SUCCESS;
  }


  public Long getOutcomeID() {
    return outcomeID;
  }

  public List<TopicOutcomes> getOutcomes() {
    return outcomes;
  }

  public String getOutputName() {
    return outputName;
  }


  public Long getProjectID() {
    return projectID;
  }


  public boolean isMessageSent() {
    return messageSent;
  }

  @Override
  public void prepare() throws Exception {

    if (this.getRequest().getParameter(APConstants.OUTCOME_ID) != null) {
      outcomeID = Long.parseLong(StringUtils.trim(this.getRequest().getParameter(APConstants.OUTCOME_ID)));
      LOG.info("The user {} load the output request section related to the program (Outcome ID) {}.",
        this.getCurrentUser().getEmail(), outcomeID);
    }

    if (this.getRequest().getParameter(APConstants.PROJECT_ID) != null) {
      projectID = Long.parseLong(StringUtils.trim(this.getRequest().getParameter(APConstants.PROJECT_ID)));
      LOG.info("The user {} load the output request section related to the program (Project ID) {}.",
        this.getCurrentUser().getEmail(), projectID);
    }

    if (this.getRequest().getParameter(APConstants.OUTPUT_NAME) != null) {
      outputName = StringUtils.trim(this.getRequest().getParameter(APConstants.OUTPUT_NAME));
      LOG.info("The user {} load the output request section related to the program {}.",
        this.getCurrentUser().getEmail(), outputName);
    }

  }

  public void setMessageSent(boolean messageSent) {
    this.messageSent = messageSent;
  }

  public void setOutcomeID(Long outcomeID) {
    this.outcomeID = outcomeID;
  }

  public void setOutcomes(List<TopicOutcomes> outcomes) {
    this.outcomes = outcomes;
  }

  public void setOutputName(String outputName) {
    this.outputName = outputName;
  }


  public void setProjectID(Long projectID) {
    this.projectID = projectID;
  }


}
