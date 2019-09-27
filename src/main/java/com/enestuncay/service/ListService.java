package com.enestuncay.service;


import com.enestuncay.dao.ListDAO;
import com.enestuncay.entity.Item;
import com.enestuncay.entity.List;
import com.enestuncay.security.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
@Transactional
public class ListService {


    @Autowired
    private ListDAO listDAO;

    @Autowired
    private ItemService itemService;

    public Long createList(List list , HttpServletRequest request){

        list.setUser_id(LoginFilter.user.getId());

        Long id = listDAO.insert(list);

        for (Item item : list.getItems()) {

            item.setList_id(list.getId());

            item.setUser_id(list.getUser_id());

            itemService.createItem(item);
        }

        return id;
    }

    public void updateList(List oldList , List list , HttpServletRequest request){

        for (Item item : oldList.getItems()) {

            itemService.deleteItem(item);
        }

        for (Item item : list.getItems()) {

            item.setList_id(list.getId());

            itemService.createItem(item);
        }

        oldList.setTitle(list.getTitle());

        listDAO.update(oldList);
    }

    public void deleteList(List list , HttpServletRequest request){


        for (Item item: list.getItems()) {
            itemService.deleteItem(item);
        }

        listDAO.delete(list);
    }




    public List getListById(Long id){
        return listDAO.getById(id);
    }

    public ArrayList<List> getListByUserId(Long user_id){
        return listDAO.getByUserId(user_id);
    }

    public ArrayList<List> getListAll(Long id){
        return listDAO.getAll(id);
    }
}
