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

import org.cgiar.ccafs.marlo.data.model.CapdevLocations;
import org.cgiar.ccafs.marlo.data.service.impl.CapdevLocationsService;

import java.util.List;

import com.google.inject.ImplementedBy;

/**
 * @author Christian Garcia
 */
@ImplementedBy(CapdevLocationsService.class)
public interface ICapdevLocationsService {


  /**
   * This method removes a specific capdevLocations value from the database.
   * 
   * @param capdevLocationsId is the capdevLocations identifier.
   * @return true if the capdevLocations was successfully deleted, false otherwise.
   */
  public boolean deleteCapdevLocations(long capdevLocationsId);


  /**
   * This method validate if the capdevLocations identify with the given id exists in the system.
   * 
   * @param capdevLocationsID is a capdevLocations identifier.
   * @return true if the capdevLocations exists, false otherwise.
   */
  public boolean existCapdevLocations(long capdevLocationsID);


  /**
   * This method gets a list of capdevLocations that are active
   * 
   * @return a list from CapdevLocations null if no exist records
   */
  public List<CapdevLocations> findAll();


  /**
   * This method gets a capdevLocations object by a given capdevLocations identifier.
   * 
   * @param capdevLocationsID is the capdevLocations identifier.
   * @return a CapdevLocations object.
   */
  public CapdevLocations getCapdevLocationsById(long capdevLocationsID);

  /**
   * This method gets a list of capdevLocationss belongs of the user
   * 
   * @param userId - the user id
   * @return List of CapdevLocationss or null if the user is invalid or not have roles.
   */
  public List<CapdevLocations> getCapdevLocationssByUserId(Long userId);

  /**
   * This method saves the information of the given capdevLocations
   * 
   * @param capdevLocations - is the capdevLocations object with the new information to be added/updated.
   * @return a number greater than 0 representing the new ID assigned by the database, 0 if the capdevLocations was
   *         updated
   *         or -1 is some error occurred.
   */
  public long saveCapdevLocations(CapdevLocations capdevLocations);

  /**
   * This method saves the information of the given capdevLocations
   * 
   * @param capdevLocations - is the capdevLocations object with the new information to be added/updated.
   * @return a number greater than 0 representing the new ID assigned by the database, 0 if the capdevLocations was
   *         updated
   *         or -1 is some error occurred.
   */
  public long saveCapdevLocations(CapdevLocations capdevLocations, String actionName, List<String> relationsName);


}
