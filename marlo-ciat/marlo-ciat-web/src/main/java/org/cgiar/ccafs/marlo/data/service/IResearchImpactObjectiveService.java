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
package org.cgiar.ccafs.marlo.data.service;

import org.cgiar.ccafs.marlo.data.model.ResearchImpactObjective;
import org.cgiar.ccafs.marlo.data.service.impl.ResearchImpactObjectiveService;

import java.util.List;

import com.google.inject.ImplementedBy;

/**
 * @author Christian Garcia
 */
@ImplementedBy(ResearchImpactObjectiveService.class)
public interface IResearchImpactObjectiveService {


  /**
   * This method removes a specific researchImpactObjective value from the database.
   * 
   * @param researchImpactObjectiveId is the researchImpactObjective identifier.
   * @return true if the researchImpactObjective was successfully deleted, false otherwise.
   */
  public boolean deleteResearchImpactObjective(long researchImpactObjectiveId);


  /**
   * This method validate if the researchImpactObjective identify with the given id exists in the system.
   * 
   * @param researchImpactObjectiveID is a researchImpactObjective identifier.
   * @return true if the researchImpactObjective exists, false otherwise.
   */
  public boolean existResearchImpactObjective(long researchImpactObjectiveID);


  /**
   * This method gets a list of researchImpactObjective that are active
   * 
   * @return a list from ResearchImpactObjective null if no exist records
   */
  public List<ResearchImpactObjective> findAll();


  /**
   * This method gets a researchImpactObjective object by a given researchImpactObjective identifier.
   * 
   * @param researchImpactObjectiveID is the researchImpactObjective identifier.
   * @return a ResearchImpactObjective object.
   */
  public ResearchImpactObjective getResearchImpactObjectiveById(long researchImpactObjectiveID);

  /**
   * This method gets a list of researchImpactObjectives belongs of the user
   * 
   * @param userId - the user id
   * @return List of ResearchImpactObjectives or null if the user is invalid or not have roles.
   */
  public List<ResearchImpactObjective> getResearchImpactObjectivesByUserId(Long userId);

  /**
   * This method saves the information of the given researchImpactObjective
   * 
   * @param researchImpactObjective - is the researchImpactObjective object with the new information to be added/updated.
   * @return a number greater than 0 representing the new ID assigned by the database, 0 if the researchImpactObjective was
   *         updated
   *         or -1 is some error occurred.
   */
  public long saveResearchImpactObjective(ResearchImpactObjective researchImpactObjective);


}
