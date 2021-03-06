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


package org.cgiar.ccafs.marlo.data.dao.impl;

import org.cgiar.ccafs.marlo.data.dao.IDeliverableDAO;
import org.cgiar.ccafs.marlo.data.model.Deliverable;

import java.util.List;

import com.google.inject.Inject;

public class DeliverableDAO implements IDeliverableDAO {

  private StandardDAO dao;

  @Inject
  public DeliverableDAO(StandardDAO dao) {
    this.dao = dao;
  }

  @Override
  public boolean deleteDeliverable(long deliverableId) {
    Deliverable deliverable = this.find(deliverableId);
    deliverable.setActive(false);
    return this.save(deliverable) > 0;
  }

  @Override
  public boolean existDeliverable(long deliverableID) {
    Deliverable deliverable = this.find(deliverableID);
    if (deliverable == null) {
      return false;
    }
    return true;

  }

  @Override
  public Deliverable find(long id) {
    return dao.find(Deliverable.class, id);

  }

  @Override
  public List<Deliverable> findAll() {
    String query = "from " + Deliverable.class.getName();
    List<Deliverable> list = dao.findAll(query);
    if (list.size() > 0) {
      return list;
    }
    return null;

  }

  @Override
  public List<Deliverable> getDeliverablesByUserId(long userId) {
    String query = "from " + Deliverable.class.getName() + " where user_id=" + userId;
    return dao.findAll(query);
  }

  @Override
  public long save(Deliverable deliverable) {
    if (deliverable.getId() == null) {
      dao.save(deliverable);
    } else {
      dao.update(deliverable);
    }
    return deliverable.getId();
  }

  @Override
  public long save(Deliverable deliverable, String actionName, List<String> relationsName) {
    if (deliverable.getId() == null) {
      dao.save(deliverable, actionName, relationsName);
    } else {
      dao.update(deliverable, actionName, relationsName);
    }
    return deliverable.getId();
  }


}