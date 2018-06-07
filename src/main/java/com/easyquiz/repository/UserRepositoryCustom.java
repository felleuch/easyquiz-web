package com.easyquiz.repository;


import com.easyquiz.model.Role;
import com.easyquiz.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by felleuch on 25/01/2018.
 */
@Component
public interface UserRepositoryCustom {

    UserDetails trouverToutUserAvecUserName(String username);

    User saveNewUser(User user);

    User getUserByUserName(String username);

    User getUserById(Integer id);


    List<User> findAllUsers();

    void updateUser(User userModify);


    List<Role> findAllRoles();

}
