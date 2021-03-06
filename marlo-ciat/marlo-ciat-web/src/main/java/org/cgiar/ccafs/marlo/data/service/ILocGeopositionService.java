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

import org.cgiar.ccafs.marlo.data.model.LocGeoposition;
import org.cgiar.ccafs.marlo.data.service.impl.LocGeopositionService;

import java.util.List;

import com.google.inject.ImplementedBy;

/**
 * @author Christian Garcia
 */
@ImplementedBy(LocGeopositionService.class)
public interface ILocGeopositionService {


  /**
   * This method removes a specific locGeoposition value from the database.
   * 
   * @param locGeopositionId is the locGeoposition identifier.
   * @return true if the locGeoposition was successfully deleted, false otherwise.
   */
  public boolean deleteLocGeoposition(long locGeopositionId);


  /**
   * This method validate if the locGeoposition identify with the given id exists in the system.
   * 
   * @param locGeopositionID is a locGeoposition identifier.
   * @return true if the locGeoposition exists, false otherwise.
   */
  public boolean existLocGeoposition(long locGeopositionID);


  /**
   * This method gets a list of locGeoposition that are active
   * 
   * @return a list from LocGeoposition null if no exist records
   */
  public List<LocGeoposition> findAll();


  /**
   * This method gets a locGeoposition object by a given locGeoposition identifier.
   * 
   * @param locGeopositionID is the locGeoposition identifier.
   * @return a LocGeoposition object.
   */
  public LocGeoposition getLocGeopositionById(long locGeopositionID);

  /**
   * This method gets a list of locGeopositions belongs of the user
   * 
   * @param userId - the user id
   * @return List of LocGeopositions or null if the user is invalid or not have roles.
   */
  public List<LocGeoposition> getLocGeopositionsByUserId(Long userId);

  /**
   * This method saves the information of the given locGeoposition
   * 
   * @param locGeoposition - is the locGeoposition object with the new information to be added/updated.
   * @return a number greater than 0 representing the new ID assigned by the database, 0 if the locGeoposition was
   *         updated
   *         or -1 is some error occurred.
   */
  public long saveLocGeoposition(LocGeoposition locGeoposition);


}
