package com.easyquiz.repository;

import com.easyquiz.model.Role;
import com.easyquiz.model.User;
import com.easyquiz.security.GrantedAuthorityImpl;
import com.easyquiz.security.UserDetailsImpl;

import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by felleuch on 25/01/2018.
 */
@Component
public class UserRepositoryCustomImpl implements UserRepositoryCustom {


    @Override
    public UserDetails trouverToutUserAvecUserName(String username){

        Query query = entityManager.createQuery("select u from User u where u.username= :username ");
        query.setParameter("username", username );
        User    user= (User)query.getSingleResult()  ;

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Role r:user.getRoles()){
            GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(r.getName());
            authorities.add(grantedAuthority);
        }
        UserDetails userDetails  = new UserDetailsImpl(username,user.getPassword(), authorities);
        return userDetails;
    }

    @Transactional
    public User saveNewUser(User user) {
        Query queryRole = entityManager.createQuery("select r from Role r where r.name= :name ");
        queryRole.setParameter("name", "NORMAL" );
        Role    roleNormal = (Role)queryRole.getSingleResult()  ;

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleNormal);
        user.setRoles(roles);
        user.setEnabled(false);
        entityManager.persist(user);
        Query query = entityManager.createQuery("select u from User u where u.username= :username ");
        query.setParameter("username", user.getUsername() );
        User    userCreated= (User)query.getSingleResult()  ;
        return userCreated;
    }

    @Transactional
    public User getUserByUserName(String username){
        Query query = entityManager.createQuery("select u from User u where u.username= :username ");
        query.setParameter("username", username );
        User    user= (User)query.getSingleResult()  ;

        Hibernate.initialize(user.getTests());
        return user;
    }


    public User getUserById(Integer id){
        Query query = entityManager.createQuery("select u from User u where u.id= :id ");
        query.setParameter("id", id );
        User    user= (User)query.getSingleResult()  ;

        return user;
    }


    @Override
    public List<User> findAllUsers() {
        Query query = entityManager.createQuery("select u from User u ");
        return query.getResultList();
    }

    @Transactional
    public void updateUser(User u){

        entityManager.merge(u);
    }

    @Override
    public List<Role> findAllRoles() {
        Query query = entityManager.createQuery("select r from Role r ");
        return query.getResultList();
    }


    @PersistenceContext
    EntityManager entityManager;




}
