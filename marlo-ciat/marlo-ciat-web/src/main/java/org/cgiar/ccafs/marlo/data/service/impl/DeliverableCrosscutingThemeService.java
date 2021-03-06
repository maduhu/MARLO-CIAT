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
package org.cgiar.ccafs.marlo.data.service.impl;


import org.cgiar.ccafs.marlo.data.dao.IDeliverableCrosscutingThemeDAO;
import org.cgiar.ccafs.marlo.data.model.DeliverableCrosscutingTheme;
import org.cgiar.ccafs.marlo.data.service.IDeliverableCrosscutingThemeService;

import java.util.List;

import com.google.inject.Inject;

/**
 * @author Christian Garcia
 */
public class DeliverableCrosscutingThemeService implements IDeliverableCrosscutingThemeService {


  private IDeliverableCrosscutingThemeDAO deliverableCrosscutingThemeDAO;

  // Managers


  @Inject
  public DeliverableCrosscutingThemeService(IDeliverableCrosscutingThemeDAO deliverableCrosscutingThemeDAO) {
    this.deliverableCrosscutingThemeDAO = deliverableCrosscutingThemeDAO;


  }

  @Override
  public boolean deleteDeliverableCrosscutingTheme(long deliverableCrosscutingThemeId) {

    return deliverableCrosscutingThemeDAO.deleteDeliverableCrosscutingTheme(deliverableCrosscutingThemeId);
  }

  @Override
  public boolean existDeliverableCrosscutingTheme(long deliverableCrosscutingThemeID) {

    return deliverableCrosscutingThemeDAO.existDeliverableCrosscutingTheme(deliverableCrosscutingThemeID);
  }

  @Override
  public List<DeliverableCrosscutingTheme> findAll() {

    return deliverableCrosscutingThemeDAO.findAll();

  }

  @Override
  public DeliverableCrosscutingTheme getDeliverableCrosscutingThemeById(long deliverableCrosscutingThemeID) {

    return deliverableCrosscutingThemeDAO.find(deliverableCrosscutingThemeID);
  }

  @Override
  public List<DeliverableCrosscutingTheme> getDeliverableCrosscutingThemesByUserId(Long userId) {
    return deliverableCrosscutingThemeDAO.getDeliverableCrosscutingThemesByUserId(userId);
  }

  @Override
  public long saveDeliverableCrosscutingTheme(DeliverableCrosscutingTheme deliverableCrosscutingTheme) {

    return deliverableCrosscutingThemeDAO.save(deliverableCrosscutingTheme);
  }

  @Override
  public long saveDeliverableCrosscutingTheme(DeliverableCrosscutingTheme deliverableCrosscutingTheme, String actionName, List<String> relationsName) {
    return deliverableCrosscutingThemeDAO.save(deliverableCrosscutingTheme, actionName, relationsName);
  }


}
