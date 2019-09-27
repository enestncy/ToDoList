package com.enestuncay.dao;


import com.enestuncay.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;

@Repository
public class UserDAO {


    @Autowired
    private SessionFactory sessionFactory;


    //WRITE

    public Long insert(User user)
    {
        return (Long) sessionFactory.getCurrentSession().save(user);
    }


    public void update(User user)
    {
        sessionFactory.getCurrentSession().update(user);
    }


    public void delete(User user){sessionFactory.getCurrentSession().delete(user);}


    //READ

    public User getByUsernameAndPass(String username, String pass){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username AND pass=:pass AND active=:active")
                .setString("username", username)
                .setString("pass", pass)
                .setBoolean("active", true);

        User user = null;
        try{
            user = (User) query.getSingleResult();
        }catch (javax.persistence.NoResultException e) {
            user = null;
        }
        return user;
    }

    public User getByUsername(String username){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username")
                .setString("username", username);

        User user = null;
        try{
            user = (User) query.getSingleResult();
        }catch (javax.persistence.NoResultException e) {
            user = null;
        }
        return user;
    }

    public User getByKey(String key){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE keyreg=:key")
                .setString("key", key);
        User user = null;
        try{
            user = (User) query.getSingleResult();
        }catch (javax.persistence.NoResultException e) {
            user = null;
        }
        return user;
    }


}
