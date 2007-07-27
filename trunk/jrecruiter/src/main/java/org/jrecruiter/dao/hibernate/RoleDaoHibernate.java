/*
*	http://www.jrecruiter.org
*
*	Disclaimer of Warranty.
*
*	Unless required by applicable law or agreed to in writing, Licensor provides
*	the Work (and each Contributor provides its Contributions) on an "AS IS" BASIS,
*	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
*	including, without limitation, any warranties or conditions of TITLE,
*	NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. You are
*	solely responsible for determining the appropriateness of using or
*	redistributing the Work and assume any risks associated with Your exercise of
*	permissions under this License.
*
*/
package org.jrecruiter.dao.hibernate;

import org.jrecruiter.dao.RoleDao;
import org.jrecruiter.model.Role;


/**
 *
 * @author Gunnar Hillert
 * @version @version $Id: SettingsDAOHibernate.java 24 2006-05-18 03:09:15Z ghillert $
 */
public class RoleDaoHibernate extends GenericDaoHibernate< Role, Long>
							  implements RoleDao {

    /**
     * Role Dao.
     */
    private RoleDao roleDao;

    /**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
     * Constructor.
     *
     */
    private RoleDaoHibernate() {
    	super(Role.class);
    }

	/* (non-Javadoc)
	 * @see org.jrecruiter.dao.RoleDao#getRole(java.lang.String)
	 */
	public Role getRole(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

}