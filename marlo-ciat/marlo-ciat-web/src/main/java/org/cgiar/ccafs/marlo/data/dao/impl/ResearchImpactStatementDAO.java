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

import org.cgiar.ccafs.marlo.data.dao.IResearchImpactStatementDAO;
import org.cgiar.ccafs.marlo.data.model.ResearchImpactStatement;

import java.util.List;

import com.google.inject.Inject;

public class ResearchImpactStatementDAO implements IResearchImpactStatementDAO {

  private StandardDAO dao;

  @Inject
  public ResearchImpactStatementDAO(StandardDAO dao) {
    this.dao = dao;
  }

  @Override
  public boolean deleteResearchImpactStatement(long researchImpactStatementId) {
    ResearchImpactStatement researchImpactStatement = this.find(researchImpactStatementId);
    researchImpactStatement.setActive(false);
    return this.save(researchImpactStatement) > 0;
  }

  @Override
  public boolean existResearchImpactStatement(long researchImpactStatementID) {
    ResearchImpactStatement researchImpactStatement = this.find(researchImpactStatementID);
    if (researchImpactStatement == null) {
      return false;
    }
    return true;

  }

  @Override
  public ResearchImpactStatement find(long id) {
    return dao.find(ResearchImpactStatement.class, id);

  }

  @Override
  public List<ResearchImpactStatement> findAll() {
    String query = "from " + ResearchImpactStatement.class.getName();
    List<ResearchImpactStatement> list = dao.findAll(query);
    if (list.size() > 0) {
      return list;
    }
    return null;

  }

  @Override
  public List<ResearchImpactStatement> getResearchImpactStatementsByUserId(long userId) {
    String query = "from " + ResearchImpactStatement.class.getName() + " where user_id=" + userId;
    return dao.findAll(query);
  }

  @Override
  public long save(ResearchImpactStatement researchImpactStatement) {
    if (researchImpactStatement.getId() == null) {
      dao.save(researchImpactStatement);
    } else {
      dao.update(researchImpactStatement);
    }
    return researchImpactStatement.getId();
  }

  @Override
  public long save(ResearchImpactStatement researchImpactStatement, String actionName, List<String> relationsName) {
    if (researchImpactStatement.getId() == null) {
      dao.save(researchImpactStatement, actionName, relationsName);
    } else {
      dao.update(researchImpactStatement, actionName, relationsName);
    }
    return researchImpactStatement.getId();
  }


}