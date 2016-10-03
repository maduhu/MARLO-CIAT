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

import org.cgiar.ccafs.marlo.data.dao.ICrpDAO;
import org.cgiar.ccafs.marlo.data.model.Crp;

import java.util.List;

import com.google.inject.Inject;

/**
 * @author Hermes Jiménez - CIAT/CCAFS
 * @author Christian Garcia - CIAT/CCAFS
 */
public class CrpDAO implements ICrpDAO {

  private StandardDAO dao;

  @Inject
  public CrpDAO(StandardDAO dao) {
    this.dao = dao;
  }

  @Override
  public boolean deleteCrp(long crpId) {
    Crp crp = this.find(crpId);
    crp.setActive(false);
    return this.save(crp) > 0;
  }

  @Override
  public boolean existCrp(long crpID) {
    Crp crp = this.find(crpID);
    if (crp == null) {
      return false;
    }
    return true;

  }

  @Override
  public Crp find(long id) {
    return dao.find(Crp.class, id);

  }

  @Override
  public List<Crp> findAll() {
    String query = "from " + Crp.class.getName() + " where is_active=1";
    List<Crp> list = dao.findAll(query);
    if (list.size() > 0) {
      return list;
    }
    return null;

  }

  @Override
  public Crp findCrpByAcronym(String acronym) {
    String query = "from " + Crp.class.getName() + " where acronym='" + acronym + "'";
    List<Crp> list = dao.findAll(query);
    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  @Override
  public long save(Crp crp) {
    if (crp.getId() == null) {
      dao.save(crp);
    } else {
      dao.update(crp);
    }
    return crp.getId();
  }
}
