package com.enestuncay.dao;


import com.enestuncay.entity.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;


@Repository
public class ListDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ItemDAO itemDAO;



    //WRITE

    public Long insert(List list){
        return (Long) sessionFactory.getCurrentSession().save(list);
    }

    public void update(List list){ sessionFactory.getCurrentSession().update(list); }

    public void persist(List list){
        sessionFactory.getCurrentSession().persist(list);
    }

    public void delete(List list){
        sessionFactory.getCurrentSession().delete(list);
    }



    //READ

    public List getById(Long id){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM List WHERE id=:id")
                .setLong("id" , id);

        List list = (List) query.getSingleResult();
        list.setItems(itemDAO.getByListId(list.getId()));
        return list;
    }

    public ArrayList<List> getByUserId(Long user_id){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM List WHERE user_id=:user_id order by id desc")
                .setLong("user_id" , user_id );

        ArrayList<List> lists = (ArrayList<List>) query.getResultList();
        for (List e : lists) {
            e.setItems(itemDAO.getByListId(e.getId()));
        }

        return lists;
    }


    public ArrayList<List> getAll(Long user_id){

        Query query = sessionFactory.getCurrentSession().createQuery("From List WHERE user_id=:user_id order by id desc")
                .setLong("user_id", user_id);
        ArrayList<List> lists = (ArrayList<List>) query.getResultList();

        for (List e : lists) {
            e.setItems(itemDAO.getByListId(e.getId()));
        }

        return lists;
    }

}
