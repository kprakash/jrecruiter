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
package org.jrecruiter.service;

import java.util.List;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.jrecruiter.model.User;
import org.jrecruiter.service.exceptions.DuplicateUserException;
import org.springframework.dao.DataAccessException;

/**
 * Provides user related methods.
 *
 * @author Dorota Puchala
 * @author Gunnar Hillert
 *
 * @version $Id:UserService.java 128 2007-07-27 03:55:54Z ghillert $
 */
public interface UserService {

    /**
     * Adds a brand new user to the system. If a user
     * with the username already exists a duplicate user exception
     * is thrown.
     *
     * @param user The user to add
     * @throws DuplicateUserException
     */
    User addUser(User user) throws DuplicateUserException;

    /**
     * Load a user by the provided username
     * @param username
     * @return a single user
     */
    User getUser(String username);

    /**
     * Load a user by the provided user id.
     * @param userId
     * @return a single user
     */
    User getUser(Long userId);

    /**
     * Load a user by the provided user id.
     * @param userId
     * @return a single user
     */
    void updateUser(User user);

    /**
     * Get a list of all users.
     * @return List of users
     */
    List<User> getAllUsers();

    /**
     * Delete a user from the system.
     * @param user
     */
    void deleteUser(User user);

    /**
     * The password for the provided user.
     * @param user
     */
    void sendPassword(User user);

    /**
     * This method is used by ACEGI security to load user details for authentication.
     * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     *
     * @param username Username
     * @return Details of the user
     * @throws DataAccessException
     * @throws UsernameNotFoundException Thrown if no user was found in persistence store.
     */
    UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException;
}