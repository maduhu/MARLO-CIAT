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

import org.cgiar.ccafs.marlo.data.dao.IResearchOutputsNextUserDAO;
import org.cgiar.ccafs.marlo.data.model.ResearchOutputsNextUser;

import java.util.List;

import com.google.inject.Inject;

public class ResearchOutputsNextUserDAO implements IResearchOutputsNextUserDAO {

  private StandardDAO dao;

  @Inject
  public ResearchOutputsNextUserDAO(StandardDAO dao) {
    this.dao = dao;
  }

  @Override
  public boolean deleteResearchOutputsNextUser(long researchOutputsNextUserId) {
    ResearchOutputsNextUser researchOutputsNextUser = this.find(researchOutputsNextUserId);
    researchOutputsNextUser.setActive(false);
    return this.save(researchOutputsNextUser) > 0;
  }

  @Override
  public boolean existResearchOutputsNextUser(long researchOutputsNextUserID) {
    ResearchOutputsNextUser researchOutputsNextUser = this.find(researchOutputsNextUserID);
    if (researchOutputsNextUser == null) {
      return false;
    }
    return true;

  }

  @Override
  public ResearchOutputsNextUser find(long id) {
    return dao.find(ResearchOutputsNextUser.class, id);

  }

  @Override
  public List<ResearchOutputsNextUser> findAll() {
    String query = "from " + ResearchOutputsNextUser.class.getName();
    List<ResearchOutputsNextUser> list = dao.findAll(query);
    if (list.size() > 0) {
      return list;
    }
    return null;

  }

  @Override
  public List<ResearchOutputsNextUser> getResearchOutputsNextUsersByUserId(long userId) {
    String query = "from " + ResearchOutputsNextUser.class.getName() + " where user_id=" + userId;
    return dao.findAll(query);
  }

  @Override
  public long save(ResearchOutputsNextUser researchOutputsNextUser) {
    if (researchOutputsNextUser.getId() == null) {
      dao.save(researchOutputsNextUser);
    } else {
      dao.update(researchOutputsNextUser);
    }
    return researchOutputsNextUser.getId();
  }


}