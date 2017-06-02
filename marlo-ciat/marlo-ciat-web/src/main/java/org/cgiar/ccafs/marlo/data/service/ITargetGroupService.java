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

import org.cgiar.ccafs.marlo.data.model.TargetGroup;
import org.cgiar.ccafs.marlo.data.service.impl.TargetGroupService;

import java.util.List;

import com.google.inject.ImplementedBy;

/**
 * @author Christian Garcia
 */
@ImplementedBy(TargetGroupService.class)
public interface ITargetGroupService {


  /**
   * This method removes a specific targetGroup value from the database.
   * 
   * @param targetGroupId is the targetGroup identifier.
   * @return true if the targetGroup was successfully deleted, false otherwise.
   */
  public boolean deleteTargetGroup(long targetGroupId);


  /**
   * This method validate if the targetGroup identify with the given id exists in the system.
   * 
   * @param targetGroupID is a targetGroup identifier.
   * @return true if the targetGroup exists, false otherwise.
   */
  public boolean existTargetGroup(long targetGroupID);


  /**
   * This method gets a list of targetGroup that are active
   * 
   * @return a list from TargetGroup null if no exist records
   */
  public List<TargetGroup> findAll();


  /**
   * This method gets a targetGroup object by a given targetGroup identifier.
   * 
   * @param targetGroupID is the targetGroup identifier.
   * @return a TargetGroup object.
   */
  public TargetGroup getTargetGroupById(long targetGroupID);

  /**
   * This method gets a list of targetGroups belongs of the user
   * 
   * @param userId - the user id
   * @return List of TargetGroups or null if the user is invalid or not have roles.
   */
  public List<TargetGroup> getTargetGroupsByUserId(Long userId);

  /**
   * This method saves the information of the given targetGroup
   * 
   * @param targetGroup - is the targetGroup object with the new information to be added/updated.
   * @return a number greater than 0 representing the new ID assigned by the database, 0 if the targetGroup was
   *         updated
   *         or -1 is some error occurred.
   */
  public long saveTargetGroup(TargetGroup targetGroup);

  /**
   * This method saves the information of the given targetGroup
   * 
   * @param targetGroup - is the targetGroup object with the new information to be added/updated.
   * @return a number greater than 0 representing the new ID assigned by the database, 0 if the targetGroup was
   *         updated
   *         or -1 is some error occurred.
   */
  public long saveTargetGroup(TargetGroup targetGroup, String actionName, List<String> relationsName);


}
