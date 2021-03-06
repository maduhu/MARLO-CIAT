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


import org.cgiar.ccafs.marlo.data.dao.IRoleDAO;
import org.cgiar.ccafs.marlo.data.model.Role;
import org.cgiar.ccafs.marlo.data.service.IRoleService;

import java.util.List;

import com.google.inject.Inject;

/**
 * @author Christian Garcia
 */
public class RoleService implements IRoleService {


  private IRoleDAO roleDAO;

  // Managers


  @Inject
  public RoleService(IRoleDAO roleDAO) {
    this.roleDAO = roleDAO;


  }

  @Override
  public boolean deleteRole(long roleId) {

    return roleDAO.deleteRole(roleId);
  }

  @Override
  public boolean existRole(long roleID) {

    return roleDAO.existRole(roleID);
  }

  @Override
  public List<Role> findAll() {

    return roleDAO.findAll();

  }

  @Override
  public Role getRoleById(long roleID) {

    return roleDAO.find(roleID);
  }

  @Override
  public List<Role> getRolesByUserId(Long userId) {
    return roleDAO.getRolesByUserId(userId);
  }

  @Override
  public long saveRole(Role role) {

    return roleDAO.save(role);
  }

  @Override
  public long saveRole(Role role, String actionName, List<String> relationsName) {
    return roleDAO.save(role, actionName, relationsName);
  }


}
