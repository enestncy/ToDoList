package com.enestuncay.dao;


import com.enestuncay.entity.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class ItemDAO {

    @Autowired
    private SessionFactory sessionFactory;


    //WRITE

    public Long insert(Item item){
        return (Long) sessionFactory.getCurrentSession().save(item);
    }

    public void update(Item item){
        sessionFactory.getCurrentSession().update(item);
    }

    public void persist(Item item){
        sessionFactory.getCurrentSession().persist(item);
    }

    public void delete(Item item){
        sessionFactory.getCurrentSession().delete(item);
    }


    //READ

    public Item getById(Long id){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Item WHERE id=:id")
                .setLong("id" , id);

        return (Item) query.getSingleResult();
    }


    public ArrayList<Item> getByListId(Long list_id){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Item WHERE list_id=:list_id")
                .setLong("list_id" , list_id );
        return (ArrayList<Item>) query.getResultList();
    }


    public ArrayList<Item> getByUserId(Long user_id){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Item WHERE user_id=:user_id")
                .setLong("user_id" , user_id);
        return (ArrayList<Item>) query.getResultList();
    }


    public ArrayList<Item> getAll(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Item");
        return (ArrayList<Item>) query.getResultList();
    }

}
