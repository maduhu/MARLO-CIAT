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

import org.cgiar.ccafs.marlo.data.dao.CrpClusterActivityLeaderDAO;
import org.cgiar.ccafs.marlo.data.model.CrpClusterActivityLeader;

import java.util.List;

import com.google.inject.Inject;

public class CrpClusterActivityLeaderMySQLDAO implements CrpClusterActivityLeaderDAO {

  private StandardDAO dao;

  @Inject
  public CrpClusterActivityLeaderMySQLDAO(StandardDAO dao) {
    this.dao = dao;
  }

  @Override
  public boolean deleteCrpClusterActivityLeader(long crpClusterActivityLeaderId) {
    CrpClusterActivityLeader crpClusterActivityLeader = this.find(crpClusterActivityLeaderId);
    crpClusterActivityLeader.setActive(false);
    return this.save(crpClusterActivityLeader) > 0;
  }

  @Override
  public boolean existCrpClusterActivityLeader(long crpClusterActivityLeaderID) {
    CrpClusterActivityLeader crpClusterActivityLeader = this.find(crpClusterActivityLeaderID);
    if (crpClusterActivityLeader == null) {
      return false;
    }
    return true;

  }

  @Override
  public CrpClusterActivityLeader find(long id) {
    return dao.find(CrpClusterActivityLeader.class, id);

  }

  @Override
  public List<CrpClusterActivityLeader> findAll() {
    String query = "from " + CrpClusterActivityLeader.class.getName() + " where is_active=1";
    List<CrpClusterActivityLeader> list = dao.findAll(query);
    if (list.size() > 0) {
      return list;
    }
    return null;

  }

  @Override
  public long save(CrpClusterActivityLeader crpClusterActivityLeader) {
    if (crpClusterActivityLeader.getId() == null) {
      dao.save(crpClusterActivityLeader);
    } else {
      dao.update(crpClusterActivityLeader);
    }


    return crpClusterActivityLeader.getId();
  }


}