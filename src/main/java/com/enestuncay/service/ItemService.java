package com.enestuncay.service;


import com.enestuncay.dao.ItemDAO;
import com.enestuncay.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class ItemService {


    @Autowired
    private ItemDAO itemDAO;


    public Long createItem(Item item){
        return itemDAO.insert(item);
    }


    public void updateItem(Item item){
        itemDAO.update(item);
    }


    public void deleteItem(Item item){
        itemDAO.delete(item);
    }


    public Item getItemById(Long id){

        return itemDAO.getById(id);
    }


    public ArrayList<Item> getItemByListId(Long list_id){

        return itemDAO.getByListId(list_id);
    }


    public ArrayList<Item> getItemByUserId(Long user_id){

        return itemDAO.getByUserId(user_id);
    }


    public ArrayList<Item> getItemAll(){

        return itemDAO.getAll();
    }

}
